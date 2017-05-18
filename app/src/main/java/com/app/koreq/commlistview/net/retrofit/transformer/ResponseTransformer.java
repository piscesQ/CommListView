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
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * project : CommListView
 * author : YanBin on 4/21/17
 * version : v3.2
 * description :
 */
public class ResponseTransformer<T> implements Observable.Transformer<T, T> {
    @Override
    public Observable<T> call(Observable<T> tObservable) {
        return tObservable.compose(new SchedulerTransformer<T>())
                .compose(new ErrorTransformer<T>());
    }
}

class SchedulerTransformer<T> implements Observable.Transformer<T, T> {
    @Override
    public Observable<T> call(Observable<T> tObservable) {
        return tObservable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}

/**
 * 错误处理、返回Response对象
 *
 * @param <T>
 */
class ErrorTransformer<T> implements Observable.Transformer<T, T> {

    @Override
    public Observable<T> call(Observable<T> tObservable) {
        return tObservable.map(new Func1<T, T>() {
            @Override
            public T call(T t) {

                Log.d(HttpConstant.TAG, "ErrorTransformer - currentThread = " + Thread.currentThread().getName()); //main
                Response response = null;
                if (t instanceof Response) {
                    response = (Response) t;
                    int code = response.code();
                    String message = response.message();
                    if (!response.isSuccessful()) {
                        throw new HttpApiException(code, message);
                    } else {
                        ResponseBody body = null;
                        Object object = response.body();
                        if (object instanceof ResponseBody) {
                            body = (ResponseBody) object;
                        }
                        if (body == null) return null;
                        BaseHttpResponse baseHttpResponse = null;
                        try {
                            String decrypt = AESUtils.decryptFromTr(AESUtils.AESKey, body.string());    //解密
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

                return t;
            }
        });
    }

    private void dealServerError(int serverCode) {
        //TODO kore deal server code
    }
}
