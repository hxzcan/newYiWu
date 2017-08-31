package com.hx.newyiwu.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;


/**
 * Created by hx on 2017/8/1 0001.
 * email:362970502@qq.com
 * des:
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(bindContentViewId());
        //直接绑定布局
        ButterKnife.bind(this);
    }

    protected abstract int bindContentViewId();

    public void initView(){

    };

    public void initListener(){

    };

    protected  abstract void initData();


}
