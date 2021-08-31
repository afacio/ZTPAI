package ztpai.ztpai.controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ztpai.ztpai.models.Post;
import ztpai.ztpai.services.PostService;

@RestController
@RequestMapping("/api/post")
public class PostApi {

  private PostService  postService;

    public PostApi(PostService postService) {
        this.postService = postService;
    }
    @GetMapping("/getPost")
    public Iterable<Post> getAll() {
        return postService.findAll();
    }

    @GetMapping("/getPost/{id}")
    public Optional<Post> getById(@PathVariable Long id) {
        return postService.findById(id);
    }

    @PostMapping("/addPost")
    public Post save(@RequestBody Post post){
        return this.postService.save(post);
    }

    @PutMapping("/updatePost")
    public Post updatePost(@RequestBody Post post){
        return this.postService.save(post);
    }

    @DeleteMapping("/deletePost/{id}")
    public void deletePost(@PathVariable Long id) {
        postService.deleteById(id);
    }

  
}
