package com.example.blogdemo.modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by IntelliJ IDEA.
 * User: mshaikh4
 * Date: 14-07-2021
 * Time: 17:11
 * Year: 2021
 * Project: blog-demo
 * Package: com.example.blogdemo.modal
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Post {
    private int userId;
    private int id;
    private String title;
    private String body;
}
