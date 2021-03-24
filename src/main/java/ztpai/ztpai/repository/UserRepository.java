package ztpai.ztpai.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ztpai.ztpai.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
