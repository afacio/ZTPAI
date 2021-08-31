package ztpai.ztpai.controller;


import org.springframework.web.bind.annotation.*;
import ztpai.ztpai.models.Forum;
import ztpai.ztpai.models.Topic;
import ztpai.ztpai.services.ForumService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/forum")
public class ForumApi {

    private ForumService forumService;

    public ForumApi(ForumService forumService) {
        this.forumService = forumService;
    }
    @GetMapping("/getForum")
    public Iterable<Forum> getAll() {
        return forumService.findAll();
    }

    @GetMapping("/getForum/{id}")
    public Optional<Forum> getById(@PathVariable Long id) {
        return forumService.findById(id);
    }

    @PostMapping("/addForum")
    public Forum save(@RequestBody Forum forum){
        return this.forumService.save(forum);
    }

    @PutMapping("/updateForum")
    public Forum updateForum(@RequestBody Forum forum){
        return this.forumService.save(forum);
    }

    @DeleteMapping("/deleteForum/{id}")
    public void deleteForum(@PathVariable Long id) {
        forumService.deleteById(id);
    }

    @GetMapping("/getForum/topicList/{id}")
    public List<Topic> getTopicList(@PathVariable Long id) {
        return forumService.getTopicList(id);
    }

}
