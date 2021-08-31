package ztpai.ztpai.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ztpai.ztpai.models.Post;
import ztpai.ztpai.repository.PostRepository;


@Service 
public class PostService {
  private PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Optional<Post> findById(Long postId){
        return postRepository.findById(postId);
    }
    
    public Iterable<Post> findAll(){
        return postRepository.findAll();
    }

    public Post save(Post post) {
        return postRepository.save(post);
    }

    public void deleteById(Long postId) {
        postRepository.deleteById(postId);
    }

    public String getContent(Long postId){
      return findAndGetPostObject(postId).getContent();
    }

    public int getLikes(Long postId){
      return findAndGetPostObject(postId).getLikes();
    }

    public int getDislikes(Long postId){
      return findAndGetPostObject(postId).getDislikes();
    }

    private Post findAndGetPostObject(Long postId){
      return postRepository.getPostByPostId(postId);
    }
  
}
