package ztpai.ztpai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ztpai.ztpai.models.Token;

public interface TokenRepository extends JpaRepository <Token,Long> {

    Token findByValue(String value);
}
