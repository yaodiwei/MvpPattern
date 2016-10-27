package com.yao.enhancemvppattern.business.time;

import android.os.SystemClock;

import com.yao.enhancemvppattern.util.SP;

import java.text.SimpleDateFormat;
import java.util.Date;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2016/10/27.
 */

public class TimePresenter extends AbsTimePresenter {

    public static final String TIME = "time";

    private TimeView view;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public TimePresenter(TimeView view) {
        this.view = view;
    }

    @Override
    public void downloadTime() {
        view.showProgress();
        Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                SystemClock.sleep(1000);
                subscriber.onNext("");
            }
        })
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<String>() {

            @Override
            public void onNext(String s) {
                view.hideProgress();
                view.showTime(sdf.format(new Date()));
            }

            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                view.hideProgress();
                view.showError("网络错误");
            }
        });

    }

    @Override
    public void saveTime(String time) {
        SP.put(TIME, time);
    }

    @Override
    public String getTime() {
        return SP.getString(TIME, "");
    }
}
