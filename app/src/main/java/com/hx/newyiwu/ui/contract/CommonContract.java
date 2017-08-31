package com.hx.newyiwu.ui.contract;

/**
 * Created by hx on 2017/8/1 0001.
 * email:362970502@qq.com
 * des:定义视图、展示
 * abstract是必须实现的方法
 * 而其他的方法可以根据需求可覆盖原来的方法
 */

public  interface CommonContract {

     interface  ICommonContractView<T>{
         void showProgress();
         void hideProgress();
         void showMessage(String message);
         void showData(T data);
         void showBottom();
         void showBottomText();
    }

     abstract class ICommontractPresenter{
        public  void clearAll(){};
        public abstract void getData();
        public  void loadMore(){};
    }

}
