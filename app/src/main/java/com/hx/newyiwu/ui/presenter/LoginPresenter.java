package com.hx.newyiwu.ui.presenter;


import android.util.Log;

import com.hx.newyiwu.beans.User;
import com.hx.newyiwu.net.HttpCallBack;
import com.hx.newyiwu.ui.contract.CommonContract;
import com.hx.newyiwu.ui.contract.ILoginModel;
import com.hx.newyiwu.ui.model.LoginModel;

/**
 * Created by hx on 2017/8/1 0001.
 * email:362970502@qq.com
 * des:P层展示数据
 */

public class LoginPresenter extends CommonContract.ICommontractPresenter {

    private CommonContract.ICommonContractView loginView;
    private ILoginModel loginModel;
    private String tel;
    private String password;
    public LoginPresenter(CommonContract.ICommonContractView loginView,String tel,String password){
        this.loginView=loginView;
        this.tel=tel;
        this.password=password;
        loginModel=new LoginModel();
    }

    @Override
    public void getData() {

        loginModel.login(tel, password, new HttpCallBack<User.UserInfo>() {
            @Override
            public void onSuccessful(User.UserInfo data) {
                if (data!=null){
                    loginView.showData(data);
                }else {
                    loginView.showMessage("没有数据");
                }
            }

            @Override
            public void onFail(String msg) {
                loginView.showMessage(msg);
            }
        });
    }

}
