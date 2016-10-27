package com.yao.enhancemvppattern.business.time;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.yao.enhancemvppattern.BaseActivity;
import com.yao.enhancemvppattern.R;
import com.yao.enhancemvppattern.util.T;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.content.ContentValues.TAG;

/**
 * Created by Administrator on 2016/10/27.
 */

public class TimeActivity extends BaseActivity implements TimeView {

    @BindView(R.id.etTime)
    EditText etTime;
    @BindView(R.id.btnDownload)
    Button btnDownload;
    @BindView(R.id.btnSave)
    Button btnSave;
    @BindView(R.id.btnGet)
    Button btnGet;
    private AbsTimePresenter presenter;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        ButterKnife.bind(this);
    }

    @Override
    protected AbsTimePresenter createPresenter() {
        presenter = new TimePresenter(this);
        return presenter;
    }

    @OnClick({R.id.btnDownload, R.id.btnSave, R.id.btnGet})
    public void click(Button btn) {
        switch (btn.getId()) {
            case R.id.btnDownload:
                Log.e(TAG, "TimeActivity.java - click() ---------- btnDownload");
                presenter.downloadTime();
                break;
            case R.id.btnSave:
                presenter.saveTime(etTime.getText().toString());
                break;
            case R.id.btnGet:
                String time = presenter.getTime();
                etTime.setText(time);
                break;
        }
    }

    @Override
    public void showTime(String time) {
        etTime.setText(time);
    }

    @Override
    public void showError(final String error) {
        final Snackbar snackbar = Snackbar.make(etTime, "服务器错误", Snackbar.LENGTH_SHORT);
        snackbar.setAction("关闭", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                T.t(error);
            }
        });
        snackbar.show();
    }

    @Override
    public void showProgress() {
        if (progressDialog != null && progressDialog.isShowing()) {
            return;
        }
        progressDialog = ProgressDialog.show(this, "", "假装正在联网");
        progressDialog.setCancelable(false);
    }

    @Override
    public void hideProgress() {
        if (progressDialog != null) {
            progressDialog.cancel();
        }
    }
}
