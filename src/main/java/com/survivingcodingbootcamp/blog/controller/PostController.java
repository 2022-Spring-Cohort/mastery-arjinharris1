package com.survivingcodingbootcamp.blog.controller;

import com.survivingcodingbootcamp.blog.model.Hashtag;
import com.survivingcodingbootcamp.blog.model.Post;
import com.survivingcodingbootcamp.blog.repository.HashtagRepo;
import com.survivingcodingbootcamp.blog.repository.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/posts")
public class PostController {
    private PostRepository postRepo;
    private HashtagRepo hashtagRepo;

    public PostController(PostRepository postRepo, HashtagRepo hashtagRepo) {
        this.postRepo = postRepo;
        this.hashtagRepo = hashtagRepo;
    }

    @GetMapping("/{id}")
    public String displaySinglePost(@PathVariable long id, Model model) {
        model.addAttribute("post", postRepo.findById(id).get());
        return "single-post-template";
    }
    @PostMapping("/{id}")
    public String addHashtag(@PathVariable long id, @RequestParam String addHashtag, @RequestParam String desc, Model model){
        Post post = postRepo.findById(id).get();
        Hashtag hashtag = new Hashtag(addHashtag,desc,post);
        post.addHashtag(hashtag);
        hashtagRepo.save(hashtag);
        postRepo.save(post);
        return "redirect:/posts/"+ id;
    }

}
