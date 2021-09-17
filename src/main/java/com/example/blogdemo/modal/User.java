package com.example.blogdemo.modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by IntelliJ IDEA.
 * User: mshaikh4
 * Date: 14-07-2021
 * Time: 17:04
 * Year: 2021
 * Project: blog-demo
 * Package: com.example.blogdemo.modal
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    private int id;
    private String name;
    private String username;
    private String email;
    private Address address;
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geo geo;
    private String phone;
    private String website;
    private Company company;


}
