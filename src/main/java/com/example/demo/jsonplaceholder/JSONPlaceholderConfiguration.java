package com.example.demo.jsonplaceholder;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JSONPlaceholderConfiguration {

    @Bean
    CommandLineRunner runner(JSONPlaceholderClient jsonPlaceholderClient){
        return args -> {
            System.out.println(
                    "https://jsonplaceholder.typicode.com/posts");
            System.out.println("# of posts: " + jsonPlaceholderClient.getPosts().size());
            long postId = 1L;
            System.out.println(
                    "https://jsonplaceholder.typicode.com/posts/" + postId);
            System.out.println(jsonPlaceholderClient.getPost(postId));
        };
    }
}
