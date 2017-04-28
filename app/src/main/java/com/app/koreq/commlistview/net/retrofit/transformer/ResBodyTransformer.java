package com.app.koreq.commlistview.net.retrofit.transformer;

import android.util.Log;

import com.app.koreq.commlistview.net.frame.bean.BaseHttpResponse;
import com.app.koreq.commlistview.net.retrofit.HttpApiException;
import com.app.koreq.commlistview.net.retrofit.HttpConstant;
import com.app.koreq.commlistview.utils.AESUtils;
import com.app.koreq.commlistview.utils.GsonUtils;

import okhttp3.ResponseBody;
import retrofit2.Response;
import rx.Observable;
import rx.functions.Func1;

/**
 * project : CommListView
 * author : YanBin on 4/21/17
 * version : v3.2
 * description :
 */
public class ResBodyTransformer<T> implements Observable.Transformer<T, ResponseBody> {
    @Override
    public Observable<ResponseBody> call(Observable<T> tObservable) {
        return tObservable.compose(new SchedulerTransformer<>())    //线程切换
                .compose(new ErrorBodyTransformer<T>());            //错误处理，并返回ResponseBody对象
    }
}

/**
 * 错误处理、解密、转换成ResponseBody
 *
 * @param <T>
 */
class ErrorBodyTransformer<T> implements Observable.Transformer<T, ResponseBody> {

    @Override
    public Observable<ResponseBody> call(Observable<T> responseObservable) {
        return responseObservable.map(new Func1<T, ResponseBody>() {
            @Override
            public ResponseBody call(T t) {
                Log.d(HttpConstant.TAG, "ErrorTransformer - currentThread = " + Thread.currentThread().getName());  //main

                Response response = null;
                ResponseBody body = null;
                if (t instanceof Response) {
                    response = (Response) t;
                    int code = response.code();
                    String message = response.message();
                    if (!response.isSuccessful()) {
                        throw new HttpApiException(code, message);
                    } else {

                        Object object = response.body();
                        if (object instanceof ResponseBody) {
                            body = (ResponseBody) object;
                        }
                        if (body == null) return null;
                        BaseHttpResponse baseHttpResponse = null;
                        try {
                            String decrypt = AESUtils.decryptFormTr(AESUtils.AESKey, body.string());    //解密
                            baseHttpResponse = GsonUtils.getGson().fromJson(decrypt, BaseHttpResponse.class);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        if (baseHttpResponse != null) {
                            int serverCode = baseHttpResponse.getCode();
                            dealServerError(serverCode);
                        }
                    }
                }
                return body;    //TODO kore 此处传递ResponseBody对象，在subscriber中处理时，content为null，暂时未找到原因
            }
        });
    }

    /**
     * 处理与服务端约定好的错误类型
     *
     * @param serverCode 服务端返回的错误类型
     */
    private void dealServerError(int serverCode) {
        Log.d(HttpConstant.TAG, "serverCode = " + serverCode);
        //TODO kore 处理公共错误
        switch (serverCode) {

            default:    //默认不处理
                break;
        }
    }
}
