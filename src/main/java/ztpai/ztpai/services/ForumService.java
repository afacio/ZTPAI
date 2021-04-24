package ztpai.ztpai.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ztpai.ztpai.models.Forum;
import ztpai.ztpai.repository.ForumRepository;

import java.util.Optional;

@Service
public class ForumService {
    private ForumRepository forumRepository;

    @Autowired
    public ForumService(ForumRepository forumRepository) {
        this.forumRepository = forumRepository;
    }

    public Optional<Forum> findById(Long id){
        return forumRepository.findById(id);
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

}
