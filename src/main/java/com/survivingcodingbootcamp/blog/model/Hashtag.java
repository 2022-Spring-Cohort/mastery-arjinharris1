package com.survivingcodingbootcamp.blog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@Entity
public class Hashtag {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String details;

    @ManyToMany(mappedBy = "hashtags")
    private Collection<Post> posts;

    public Hashtag(String name, String details, Post...posts) {
        this.name = name;
        this.details = details;
        this.posts = Arrays.asList(posts);
    }
    public Hashtag(){

    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDetails() {
        return details;
    }

    public Collection<Post> getPosts() {
        return posts;
    }

    public void addPost(Post post) {
    posts.add(post);
    }
}

