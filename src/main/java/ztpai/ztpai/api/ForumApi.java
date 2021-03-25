package ztpai.ztpai.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ztpai.ztpai.models.Forum;
import ztpai.ztpai.repository.ForumRepository;

import java.util.Optional;

@RestController
@RequestMapping("/api/forum")
public class ForumApi {

    private ForumRepository forumRepository;

    @Autowired
    public ForumApi(ForumRepository forumRepository) {
        this.forumRepository = forumRepository;
    }
    @GetMapping("/all")
    public Iterable<Forum> getAll() {
        return forumRepository.findAll();
    }

    @GetMapping
    public Optional<Forum> getById(@RequestParam Long index) {
        return forumRepository.findById(index);
    }

    @PostMapping
    public Forum save(@RequestBody Forum forum){
        return this.forumRepository.save(forum);
    }

    @PutMapping
    public Forum updateForum(@RequestBody Forum forum){
        return this.forumRepository.save(forum);
    }

    @DeleteMapping
    public void deleteForum(@RequestParam Long index) {
        forumRepository.deleteById(index);
    }
}