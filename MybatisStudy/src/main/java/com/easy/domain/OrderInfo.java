package com.easy.domain;

import java.io.Serializable;

public class OrderInfo implements Serializable {
    //用户名
    private String userName;
    //描述
    private String desc;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "OrderInfo{" +
                "userName='" + userName + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
