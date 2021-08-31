package ztpai.ztpai.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ztpai.ztpai.models.Forum;


@Repository
public interface ForumRepository extends JpaRepository<Forum, Long> {

  Forum getForumByForumId(Long forumId);
}
