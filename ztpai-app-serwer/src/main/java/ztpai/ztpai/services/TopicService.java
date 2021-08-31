package ztpai.ztpai.services;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ztpai.ztpai.models.Post;
import ztpai.ztpai.models.Topic;
import ztpai.ztpai.repository.TopicRepository;

@Service 
public class TopicService {
  private TopicRepository topicRepository;

    @Autowired
    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    public Optional<Topic> findById(Long topicId){
        return topicRepository.findById(topicId);
    }
    
    public Iterable<Topic> findAll(){
        return topicRepository.findAll();
    }

    public Topic save(Topic topic) {
        return topicRepository.save(topic);
    }

    public void deleteById(Long topicId) {
        topicRepository.deleteById(topicId);
    }

    public List<Post> getPostList(Long topicId){
        return findAndGetTopicObject(topicId).getPostList();
    }

    public String getTitle(Long topicId){
        return findAndGetTopicObject(topicId).getTitle();
    }

    public Long getForumId(Long topicId){
        return findAndGetTopicObject(topicId).getForumId();
    }

    private Topic findAndGetTopicObject(Long topicId){
        return topicRepository.getTopicByTopicId(topicId);
    }
  
}
