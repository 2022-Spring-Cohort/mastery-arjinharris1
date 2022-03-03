package com.survivingcodingbootcamp.blog.controller;


import com.survivingcodingbootcamp.blog.repository.HashtagRepo;
import com.survivingcodingbootcamp.blog.repository.PostRepository;
import com.survivingcodingbootcamp.blog.repository.TopicRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HashtagController {
    private PostRepository postRepository;
    private HashtagRepo hashtagRepo;
    private TopicRepository topicRepository;


    public HashtagController(PostRepository postRepository, HashtagRepo hashtagRepo, TopicRepository topicRepository) {
        this.postRepository = postRepository;
        this.hashtagRepo = hashtagRepo;
        this.topicRepository = topicRepository;
    }

    @RequestMapping("/hashtags")
    public String showAllHashtags(Model model){
        model.addAttribute("hashtags",hashtagRepo.findAll());
        return "all";
    }

//    @PostMapping("hashtags")
//    public String makeNewHashtag(Model model, ){
//        return "redirect:/hashtags/" + id;
//    }

    @RequestMapping("/hashtags/{id}")
    public String showSingleHashtag(@PathVariable long id, Model model){
        model.addAttribute("hashtag",hashtagRepo.findById(id).get());
        model.addAttribute("post",hashtagRepo.findById(id).get().getPosts());
        return "single-hashtag-template";
    }
}
