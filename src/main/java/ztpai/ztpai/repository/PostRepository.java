package ztpai.ztpai.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ztpai.ztpai.models.Post;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
}
