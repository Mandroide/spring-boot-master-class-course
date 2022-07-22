package com.example.demo.jsonplaceholder;

import java.util.Objects;

public class Post {
    private final Long userId;
    private final Long id;
    private final String title;
    private final String body;

    public Post(Long userId,
                Long id,
                String title,
                String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    @Override
    public String toString() {
        return "Post{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return userId.equals(post.userId) && id.equals(post.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, id);
    }

}
