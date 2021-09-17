package com.example.blogdemo.controller;

import com.example.blogdemo.modal.Post;
import com.example.blogdemo.modal.User;
import com.example.blogdemo.modal.ViewResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * User: mshaikh4
 * Date: 14-07-2021
 * Time: 17:12
 * Year: 2021
 * Project: blog-demo
 * Package: com.example.blogdemo.controller
 */
@RestController
public class MainController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping(value = "/api/posts/active")
    public ResponseEntity<List<ViewResponse>> getActivePostingData(){

        ResponseEntity<User[]> listResponseEntity = restTemplate.getForEntity("https://jsonplaceholder.typicode.com/users", User[].class);
        ResponseEntity<Post[]> listPostResponseEntity = restTemplate.getForEntity("https://jsonplaceholder.typicode.com/posts", Post[].class);

        Map<Integer, List<Post>> postByUsers = new HashMap<>();
        Map<Integer, User> usersMap = new HashMap<>();
        User[] userArray = listResponseEntity.getBody();
        List<User> users = Arrays.stream(userArray)
                .collect(Collectors.toList());
        List<Post> posts =Arrays.stream(listPostResponseEntity.getBody())
                .collect(Collectors.toList());

      //  System.out.println(users);
      //  System.out.println(posts);
        usersMap = users.stream()
                .collect(Collectors.toMap(User::getId, user -> user));

        postByUsers = posts.stream()
                .collect(Collectors.groupingBy(Post::getUserId, Collectors.mapping(post -> post, Collectors.toList())));

        //System.out.println(postByUsers);
        List<ViewResponse> responses = new ArrayList<>();
        for (Map.Entry<Integer, List<Post>> entry : postByUsers.entrySet()){
            responses.add(ViewResponse.builder()
                    .userId(entry.getKey())
                    .username(usersMap.get(entry.getKey()).getUsername())
                    .activelyPosting((entry.getValue() != null && entry.getValue().size() > 0))
                    .postCount(entry.getValue() != null ? entry.getValue().size() : 0)
                    .build());
        }
        return ResponseEntity.ok(responses);
    }
}
