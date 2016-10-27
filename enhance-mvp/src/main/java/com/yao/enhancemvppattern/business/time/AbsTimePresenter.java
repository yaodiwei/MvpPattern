package com.yao.enhancemvppattern.business.time;


import com.yao.enhancemvppattern.BasePresenter;

/**
 * Created by Administrator on 2016/10/28.
 */

public abstract class AbsTimePresenter extends BasePresenter {

    public abstract void downloadTime();

    public abstract void saveTime(String time);

    public abstract String getTime();
}
