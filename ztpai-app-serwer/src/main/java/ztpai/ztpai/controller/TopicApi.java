package ztpai.ztpai.controller;

import java.util.List;
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
import ztpai.ztpai.models.Topic;
import ztpai.ztpai.services.TopicService;

@RestController
@RequestMapping("/api/topic")
public class TopicApi {

  private TopicService topicService;

    public TopicApi(TopicService topicService) {
        this.topicService = topicService;
    }
    @GetMapping("/getTopic")
    public Iterable<Topic> getAll() {
        return topicService.findAll();
    }

    @GetMapping("/getTopic/{id}")
    public Optional<Topic> getById(@PathVariable Long id) {
        return topicService.findById(id);
    }

    @PostMapping("/addTopic")
    public Topic save(@RequestBody Topic topic){
        return this.topicService.save(topic);
    }

    @PutMapping("/updateTopic")
    public Topic updateTopic(@RequestBody Topic topic){
        return this.topicService.save(topic);
    }

    @DeleteMapping("/deleteTopic/{id}")
    public void deleteTopic(@PathVariable Long id) {
        topicService.deleteById(id);
    }

    @GetMapping("/getTopic/postList/{id}")
    public List<Post> getPostList(@PathVariable Long id) {
        return topicService.getPostList(id);
    }
  
}
