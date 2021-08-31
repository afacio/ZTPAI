package ztpai.ztpai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ztpai.ztpai.models.Topic;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {
  Topic getTopicByTopicId(Long topicId);
}
