package com.example.springbootdemo;

import com.example.vo.user.Product;
import com.example.vo.user.User;

import java.util.ArrayList;
import java.util.List;

public class TestParalle {

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Product product = new Product();
            products.add(product);
        }
        List<User> users = new ArrayList<>();
        products.stream().parallel().forEach(x->{
                User user = new User();
            user.setAddress("asdf");
            user.setName("dddd");
            users.add(user);
        });
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i) == null){
                System.out.println("hello world");
            }
        }
    }
}
