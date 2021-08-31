package ztpai.ztpai.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ztpai.ztpai.models.Forum;
import ztpai.ztpai.models.Topic;
import ztpai.ztpai.repository.ForumRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ForumService {
    private ForumRepository forumRepository;

    @Autowired
    public ForumService(ForumRepository forumRepository) {
        this.forumRepository = forumRepository;
    }

    public Optional<Forum> findById(Long forumId){
        return forumRepository.findById(forumId);
    }

    public Iterable<Forum> findAll(){
        return forumRepository.findAll();
    }

    public Forum save(Forum forum) {
        return forumRepository.save(forum);
    }

    public void deleteById(Long id) {
        forumRepository.deleteById(id);
    }

    public List<Topic> getTopicList(Long forumId){
        return  findAndGetForumObject(forumId).getTopicList();
    }

    public String getTitle(Long forumId){
        return findAndGetForumObject(forumId).getTitle();
    }

    public String getGameAbout(Long forumId){
        return findAndGetForumObject(forumId).getGameAbout();
    }

    private Forum findAndGetForumObject(Long forumId){
        return forumRepository.getForumByForumId(forumId);
    }

  

}
