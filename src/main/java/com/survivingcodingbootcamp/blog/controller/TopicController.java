package com.survivingcodingbootcamp.blog.controller;

import com.survivingcodingbootcamp.blog.model.Post;
import com.survivingcodingbootcamp.blog.model.Topic;
import com.survivingcodingbootcamp.blog.repository.PostRepository;
import com.survivingcodingbootcamp.blog.repository.TopicRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TopicController {

    private TopicRepository topicRepo;
    private PostRepository postRepository;


    public TopicController(TopicRepository topicRepo, PostRepository postRepository) {

        this.topicRepo = topicRepo;
        this.postRepository = postRepository;
    }
    @RequestMapping("/topics/{id}")
    public String displaySingleTopic(@PathVariable long id, Model model) {
        model.addAttribute("topic", topicRepo.findById(id).get());
        return "single-topic-template";
    }

@PostMapping("/topics/{id}")
    public String addNewPost(@PathVariable long id, @RequestParam String title, @RequestParam String content, @RequestParam String author,Model model){
    Topic topic = topicRepo.findById(id).get();
    Post post = new Post(title,topic,content,author);
    postRepository.save(post);

        return "redirect:/topics/"+ id;
}
}
