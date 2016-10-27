package com.yao.enhancemvppattern;

/**
 * Created by Administrator on 2016/10/27.
 */

public abstract class BasePresenter<V extends BaseView> {

    protected V view;

    public void attachView(V view) {
        this.view = view;
    }

    public boolean isViewAttached(){
        return view != null;
    }

    public void detachView() {
        if (view != null) {
            view = null;
        }
    }

}
