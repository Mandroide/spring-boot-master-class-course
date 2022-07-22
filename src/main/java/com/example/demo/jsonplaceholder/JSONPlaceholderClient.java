package com.example.demo.jsonplaceholder;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Fetch posts
 */
@FeignClient(value = "jsonplaceholder", url = "https://jsonplaceholder.typicode.com/")
public interface JSONPlaceholderClient {

    @GetMapping("posts")
    List<Post> getPosts();
    @GetMapping("posts/{postId}")
    Post getPost(@PathVariable("postId") Long postId);
}
