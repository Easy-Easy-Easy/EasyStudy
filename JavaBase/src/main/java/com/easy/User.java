package com.easy;

import java.util.HashSet;
import java.util.Objects;

/**
 * @ClassName User
 * @Description TODO
 * @Author zheng
 * @Date 2021/7/21 15:37
 * @Version 1.0
 **/
public class User {
    /**
     * 用户名
     **/
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public static void main(String[] args) {
        User user1 = new User();
        user1.setName("A");
        User user2 = new User();
        user2.setName("A");
        HashSet<User> hashSet = new HashSet<User>();
        hashSet.add(user1);
        hashSet.add(user2);
        System.out.println("hashset 的长度为："+ hashSet.size());
    }
}
