package com.yao.enhancemvppattern;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Administrator on 2016/10/28.
 */

public abstract class BaseActivity<V extends BaseView, P extends BasePresenter<V>> extends Activity implements BaseView {

    protected P presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = createPresenter();
        if (presenter != null) {
            presenter.attachView((V) this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.detachView();
        }
    }

    protected abstract P createPresenter();
}
