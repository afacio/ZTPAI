package ztpai.ztpai.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ztpai.ztpai.models.Forum;

@Repository
public interface ForumRepository extends CrudRepository<Forum, Long> {
}
