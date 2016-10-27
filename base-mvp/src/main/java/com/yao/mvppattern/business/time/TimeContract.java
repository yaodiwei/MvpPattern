package com.yao.mvppattern.business.time;

import com.yao.mvppattern.BasePresenter;
import com.yao.mvppattern.BaseView;

/**
 * Created by Administrator on 2016/10/27.
 */

public interface TimeContract {

    interface View extends BaseView {

        void showTime(String time);

        void showError(String error);

        void showProgress();

        void hideProgress();
    }

    interface Presenter extends BasePresenter {

        void downloadTime();

        void saveTime(String time);

        String getTime();
    }

}
