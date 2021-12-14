package com.lbs0912.springboot.app.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
    private String name;
    private int age;

}