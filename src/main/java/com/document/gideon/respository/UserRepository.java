package com.document.gideon.respository;

import com.document.gideon.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {


    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);
}
