package com.example.blogdemo.modal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by IntelliJ IDEA.
 * User: mshaikh4
 * Date: 14-07-2021
 * Time: 17:17
 * Year: 2021
 * Project: blog-demo
 * Package: com.example.blogdemo.modal
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ViewResponse {

    private int userId;
    private String username;
    private int postCount;
    private boolean activelyPosting = false;
}
