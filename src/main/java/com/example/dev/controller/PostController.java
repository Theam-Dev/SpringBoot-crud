package com.example.dev.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.dev.model.Post;
import com.example.dev.service.PostService;


@Controller
public class PostController {

	@Autowired
	private PostService postService;

	@GetMapping("/")
	public String Index(Model model) {
		Iterable<Post> post = postService.getAll();
		model.addAttribute("post",post);
		return "index";
	}
	
	@GetMapping("/create")
    public String Create(Model model) {
		Post post = new Post();
		model.addAttribute("post",post);
		 model.addAttribute("formtitle","Create Post");
		 model.addAttribute("button","Create");
       return "form";
    }
	 @GetMapping("/edit/{id}")
	    public String Edit(@PathVariable Long id, Model model) {
	      Post post = postService.getById(id);
	      model.addAttribute("post", post);
	      model.addAttribute("formtitle","Update Post");
	      model.addAttribute("button","Update");
	      return "form"; 
	    }

    @PostMapping("/save")
    public String Save(@Valid @ModelAttribute("post") Post post, BindingResult result) {
    	if (result.hasErrors()) {
    	    return "form";
    	}
        postService.saveData(post);
        
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteInvoice(@PathVariable (value = "id") Long id) {
        try {
        	postService.deleteById(id);
       
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }
    
}
