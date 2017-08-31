package com.hx.newyiwu.net.Api;




import com.hx.newyiwu.beans.User;

import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by hx on 2017/8/1 0001.
 * email:362970502@qq.com
 * des:登录接口
 */

public interface LoginApi {
    @POST("login.do/{tel}/{password}")
    Observable<User> login(@Path("tel") String tel, @Path("password") String password);
}
