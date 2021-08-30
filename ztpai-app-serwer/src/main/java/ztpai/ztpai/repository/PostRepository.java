package ztpai.ztpai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ztpai.ztpai.models.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
