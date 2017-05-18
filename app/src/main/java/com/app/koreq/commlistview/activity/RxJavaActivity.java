package com.app.koreq.commlistview.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.app.koreq.commlistview.R;
import com.app.koreq.commlistview.net.retrofit.RetrofitDemoUtils;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class RxJavaActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String TAG = RxJavaActivity.class.getSimpleName();
    private TextView mTvShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java);

        initView();
        initData();
    }

    public static void launchAct(Context context) {
        Intent intent = new Intent(context, RxJavaActivity.class);
        context.startActivity(intent);
    }

    private void initView() {
        Button btnDemo1 = (Button) findViewById(R.id.rx_demo_1);
        Button rx_http_1 = (Button) findViewById(R.id.rx_http_1);
        mTvShow = (TextView) findViewById(R.id.rx_text);

        btnDemo1.setOnClickListener(this);
        rx_http_1.setOnClickListener(this);
    }

    private void initData() {

    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.rx_demo_1:    //点击 Demo1 按钮
                rxDemo4();
                break;
            case R.id.rx_http_1:    //点击 http Demo1 按钮
                rxDemo5();
                break;
        }
    }

    /**
     * 使用from创建Observable
     */
    private void rxDemo1() {
        List<String> list = new ArrayList<>();
        list.add("aaaa");
        list.add("bbbb");
        list.add("cccc");
        list.add("dddd");
        Observable.from(list)
                .map(new Func1<String, String>() {
                    @Override
                    public String call(String str) {
                        return str + "_" + str;
                    }
                })
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String str) {
                        mTvShow.setText(mTvShow.getText() + "; \n" + Thread.currentThread().getName() + "_" + str);
                    }
                });
    }

    /**
     * 使用just创建Observable
     */
    private void rxDemo2() {
        Observable<String> stringObservable = Observable.just("111", "222", "333", "444");
        stringObservable
                .map(new Func1<String, Integer>() {
                    @Override
                    public Integer call(String s) {
                        return Integer.parseInt(s);
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Integer>() {
                               @Override
                               public void call(Integer integer) {
                                   Log.d(TAG, "demo2 - onNext = " + integer);
                                   mTvShow.setText(mTvShow.getText() + "; \n" + Thread.currentThread().getName() + "_" + integer);
                               }
                           }
                        , new Action1<Throwable>() {
                            @Override
                            public void call(Throwable throwable) {
                                throwable.printStackTrace();
                                Log.d(TAG, "demo2 - throwable");
                            }
                        }
                        , new Action0() {
                            @Override
                            public void call() {
                                Log.d(TAG, "demo2 - completed");
                            }
                        });
    }

    /**
     * 使用create创建Observable
     */
    private void rxDemo3() {
        Observable<String> stringObservable = Observable
                .create(new Observable.OnSubscribe<String>() {
                    @Override
                    public void call(Subscriber<? super String> subscriber) {
                        Log.d(TAG, "===" + subscriber.toString());
                        subscriber.onNext("rxDemo3_1");     //onNext的作用感觉是"执行下一步"，而不是执行最后面subscribe()中的oNext方法
                        subscriber.onNext("rxDemo3_2");
                        subscriber.onNext("rxDemo3_3");
                        subscriber.onNext("rxDemo3_4");
                        subscriber.onNext("rxDemo3_5");
                    }
                });

        stringObservable
                .map(new Func1<String, String>() {
                    @Override
                    public String call(String s) {
                        return "___" + s;       //此步正常执行
                    }
                })
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<String>() {
                               @Override
                               public void call(String s) {
                                   Log.d(TAG, "demo3 - onNext = " + s);
                                   mTvShow.setText(mTvShow.getText() + "; \n" + Thread.currentThread().getName() + "_" + s);
                               }
                           }
                        , new Action1<Throwable>() {
                            @Override
                            public void call(Throwable throwable) {
                                throwable.printStackTrace();
                                Log.d(TAG, "demo3 - throwable");
                            }
                        });

    }


    /**
     * 使用create创建Observable 并使用 lambda 表达式
     */
    private void rxDemo4() {
        Observable<String> stringObservable = Observable
                .create(new Observable.OnSubscribe<String>() {
                    @Override
                    public void call(Subscriber<? super String> subscriber) {
                        Log.d(TAG, "===" + subscriber.toString());
                        subscriber.onNext("rxDemo3_1");     //onNext的作用感觉是"执行下一步"，而不是执行最后面subscribe()中的oNext方法
                        subscriber.onNext("rxDemo3_2");
                        subscriber.onNext("rxDemo3_3");
                        subscriber.onNext("rxDemo3_4");
                        subscriber.onNext("rxDemo3_5");
                    }
                });

        stringObservable
                .map(new Func1<String, String>() {
                    @Override
                    public String call(String s) {
                        return "===" + s;
                    }
                })        //此步正常执行
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        Log.d(TAG, "demo3 - throwable");
                    }

                    @Override
                    public void onNext(String s) {
                        Log.d(TAG, "demo3 - onNext = " + s);
                        mTvShow.setText(mTvShow.getText() + "; \n" + Thread.currentThread().getName() + "_" + s);
                    }
                });

    }

    /**
     *
     */
    private void rxDemo5() {
        RetrofitDemoUtils.sendRequest();
    }
}
