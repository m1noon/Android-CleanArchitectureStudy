package com.minoon.architecture.study.data.account;

/**
 * Created by a13587 on 15/09/27.
 */
public class Account {
    public String id;
    public String name;
    public String address;

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
