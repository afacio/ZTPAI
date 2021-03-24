package ztpai.ztpai.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ztpai.ztpai.models.Topic;

@Repository
public interface TopicRepository extends CrudRepository<Topic, Long> {
}
