package com.hx.newyiwu.beans;

import java.io.Serializable;

/**
 * Created by hx on 2017/8/1 0001.
 * email:362970502@qq.com
 * des:
 */

public class User implements Serializable {
    private int code;
    private String msg;
    private UserInfo data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public UserInfo getData() {
        return data;
    }

    public void setData(UserInfo data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "User{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    public static class UserInfo implements Serializable{
        private int id;
        private String tel;
        private String password;
        private String email;
        private String neckName;
        private String address;
        private String sex;
        private String des;
        private String avater;//头像

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getNeckName() {
            return neckName;
        }

        public void setNeckName(String neckName) {
            this.neckName = neckName;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getDes() {
            return des;
        }

        public void setDes(String des) {
            this.des = des;
        }

        public String getAvater() {
            return avater;
        }

        public void setAvater(String avater) {
            this.avater = avater;
        }

        @Override
        public String toString() {
            return "UserInfo{" +
                    "id=" + id +
                    ", tel='" + tel + '\'' +
                    ", password='" + password + '\'' +
                    ", email='" + email + '\'' +
                    ", neckName='" + neckName + '\'' +
                    ", address='" + address + '\'' +
                    ", sex='" + sex + '\'' +
                    ", des='" + des + '\'' +
                    ", avater='" + avater + '\'' +
                    '}';
        }
    }
}
