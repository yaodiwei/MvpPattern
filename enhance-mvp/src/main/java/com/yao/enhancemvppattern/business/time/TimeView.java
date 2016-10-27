package com.yao.enhancemvppattern.business.time;

import com.yao.enhancemvppattern.BaseView;

/**
 * Created by Administrator on 2016/10/27.
 */

public interface TimeView extends BaseView {

    void showTime(String time);

    void showError(String error);

    void showProgress();

    void hideProgress();
}
