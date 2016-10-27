package com.yao.enhancemvppattern;

/**
 * Created by Administrator on 2016/10/28.
 */

import android.app.Fragment;
import android.os.Bundle;

public abstract class BaseFragment<V extends BaseView, P extends BasePresenter<V>> extends Fragment implements BaseView {

    protected P presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = createPresenter();
        presenter.attachView((V) this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter != null)
            presenter.detachView();
    }


    protected abstract P createPresenter();

}
