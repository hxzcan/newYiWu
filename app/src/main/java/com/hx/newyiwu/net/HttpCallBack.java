package com.hx.newyiwu.net;

/**
 * Created by hx on 2017/8/1 0001.
 * email:362970502@qq.com
 * des:网络回调
 */

public interface HttpCallBack<T> {

    /**
     * 成功的回调
     * @param data 数据
     */
    void onSuccessful(T data);

    /**
     * 失败的回调
     * @param msg 失败的信息
     */
    void onFail(String msg);
}
