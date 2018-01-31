package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    PostRepository postRepository;

    @RequestMapping("/")
    public String listPosts(Model model){
        model.addAttribute("posts", postRepository.findAll());
        return "homepage";
    }

    @GetMapping("/add")
    public String postForm(Model model){
        model.addAttribute("postList", new Posts());
        return "post";
    }

    @PostMapping("/process")
    public String processForm(@Valid Posts postList, BindingResult result){
        if (result.hasErrors()){
            return "post";
        }
        postRepository.save(postList);
        return "redirect:/";
    }

    @PostMapping("/search")
    public String searchPosts(@RequestParam("searchUser") String searchUser, Model model){

        model.addAttribute("posts",postRepository.findByUser(searchUser));
        return "userpage";
    }


}
