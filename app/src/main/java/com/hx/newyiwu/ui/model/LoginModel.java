package com.hx.newyiwu.ui.model;


import android.util.Log;

import com.hx.newyiwu.beans.User;
import com.hx.newyiwu.net.HttpCallBack;
import com.hx.newyiwu.net.NetWork;
import com.hx.newyiwu.ui.contract.ILoginModel;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

import retrofit2.adapter.rxjava.HttpException;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by hx on 2017/8/1 0001.
 * email:362970502@qq.com
 * des:登录的请求网络
 */

public class LoginModel implements ILoginModel {
    @Override
    public void login(String tel, String password, final HttpCallBack<User.UserInfo> callBack) {

        NetWork.getLoginApi().login(tel,password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<User>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        if (e instanceof HttpException){
                            HttpException httpException= (HttpException) e;
                            int code=httpException.code();
                            if (code==404||code==500){
                                callBack.onFail("服务器出错");
                            }else if (e instanceof ConnectException){
                                callBack.onFail("网络连接错误，请打开网络");
                            }else if(e instanceof SocketTimeoutException){
                                callBack.onFail("网络连接超时");
                            }else{
                                callBack.onFail("发生未知错误："+e.getMessage());
                            }
                        }
                    }

                    @Override
                    public void onNext(User user) {
                       int code=user.getCode();
                        if (code==200){
                            callBack.onSuccessful(user.getData());
                        }else if (code==201){
                            callBack.onFail("密码错误");
                        }else if (code==202){
                            callBack.onFail("用户不存在");
                        }else if (code==203){
                            callBack.onFail("输入错误");
                        }
                    }
                });
    }
}
