package com.hx.newyiwu.ui.contract;


import com.hx.newyiwu.beans.User;
import com.hx.newyiwu.net.HttpCallBack;

/**
 * Created by hx on 2017/8/1 0001.
 * email:362970502@qq.com
 * des:
 */

public interface ILoginModel {

    void login(String tel, String password, HttpCallBack<User.UserInfo> callBack);
}
