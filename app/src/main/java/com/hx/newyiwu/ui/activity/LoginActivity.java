package com.hx.newyiwu.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
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
    @BindView(R.id.delete_password)
    TextView mDeletePassword;
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

    @OnClick({R.id.login,R.id.delete_password,R.id.forget_password,R.id.user_register,R.id.login_service,R.id.tel,R.id.password})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.login://登录按钮
                String tel=mTel.getText().toString().trim();
                String password=mPassword.getText().toString().trim();
                if (!TextUtils.isEmpty(tel)&&!TextUtils.isEmpty(password)){
                    mLoginPresenter=new LoginPresenter(this,tel,password);
                    mLoginPresenter.getData();
                }else {
                    Toast.makeText(this, "密码或者用户名不能为空", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.delete_password:
                mPassword.setText("");
                mDeletePassword.setVisibility(View.GONE);
                break;

            case R.id.forget_password://忘记密码

                break;

            case R.id.user_register://注册
                Intent intent=new Intent(this,RegisterActivity.class);
                startActivity(intent);
                break;

            case R.id.login_service://服务

                break;

            case R.id.tel://当删除账号的时候，密码置为空
                mTel.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        mPassword.setText("");//删除账号，密码设置为空
                        mDeletePassword.setVisibility(View.GONE);
                    }

                    @Override
                    public void afterTextChanged(Editable editable) {

                    }
                });
                break;
            case R.id.password:
               mPassword.addTextChangedListener(new TextWatcher() {
                   @Override
                   public void beforeTextChanged(CharSequence charSequence, int start, int before, int count) {

                   }

                   @Override
                   public void onTextChanged(CharSequence charSequence, int start, int count, int after) {
                        Log.i(TAG,"在变化");
                        mDeletePassword.setVisibility(View.VISIBLE);
                   }

                   @Override
                   public void afterTextChanged(Editable editable) {

                   }
               });

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

    //键盘收回
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction()==MotionEvent.ACTION_DOWN){
            View v=getCurrentFocus();
            if (isShouldHideInput(v,ev)){
                InputMethodManager inputMethodManager= (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                if (inputMethodManager!=null){
                    //键盘消失
                    inputMethodManager.hideSoftInputFromWindow(v.getWindowToken(),0);
                }
            }
            return super.dispatchTouchEvent(ev);
        }
        //必不可少，不然所有的组件都会失去TouchEvent
        if (getWindow().superDispatchTouchEvent(ev)){
            return  true;
        }
        return onTouchEvent(ev);
    }

    private boolean isShouldHideInput(View view,MotionEvent motionEvent){
       if (view!=null&&(view instanceof EditText)){
           int[] leftTop={0,0};
            //获取输出框当前的位置
           view.getLocationInWindow(leftTop);
           int left=leftTop[0];
           int top=leftTop[1];
           int bottom=top+view.getHeight();
           int right=left+view.getWidth();
           if (motionEvent.getX()>left&&motionEvent.getX()<right&&motionEvent.getY()>top&&motionEvent.getY()<bottom){
               //点击是editText范围内保留editText状态
               return  false;
           }else{
               return  true;
           }
       }
        return false;
    }
}
