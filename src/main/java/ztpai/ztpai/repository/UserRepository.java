package ztpai.ztpai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ztpai.ztpai.models.UserModel;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

    Optional<UserModel> findByEmail(String email);

    Optional<UserModel> findByUsername(String username);

    UserModel getByUsername(String username);

    Optional<UserModel> findByUserId(Long id);

    UserModel getByUserId(Long id);



}
