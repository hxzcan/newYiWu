package com.hx.newyiwu.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hx.newyiwu.MainActivity;
import com.hx.newyiwu.R;
import com.hx.newyiwu.beans.User;
import com.hx.newyiwu.ui.contract.CommonContract;
import com.hx.newyiwu.ui.presenter.LoginPresenter;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity  implements CommonContract.ICommonContractView<User.UserInfo> {
   public static  final String TAG="LoginActivity";
    @BindView(R.id.tel)
    EditText mTel;
    @BindView(R.id.password)
    EditText mPassword;
    @BindView(R.id.login)
    Button mLogin;
    @BindView(R.id.forget_password)
    TextView mForgetPassword;
    @BindView(R.id.user_register)
    TextView mRegister;
    @BindView(R.id.login_service)
    TextView mLoginService;
    private CommonContract.ICommontractPresenter mLoginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.login,R.id.user_register})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.login:
                String tel=mTel.getText().toString().trim();
                String password=mPassword.getText().toString().trim();

                if (!TextUtils.isEmpty(tel)&&!TextUtils.isEmpty(password)){
                    mLoginPresenter=new LoginPresenter(this,tel,password);
                    mLoginPresenter.getData();
                }else {
                    Toast.makeText(this, "密码或者用户名不能为空", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.user_register:
                Intent intent=new Intent(this,RegisterActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showData(User.UserInfo data) {
        if (data!=null){
            User.UserInfo userInfo=data;
            Intent intent=new Intent(this,MainActivity.class);
            intent.putExtra("userInfo",userInfo);
            startActivity(intent);
        }
    }


    @Override
    public void showBottom() {

    }

    @Override
    public void showBottomText() {

    }
}
