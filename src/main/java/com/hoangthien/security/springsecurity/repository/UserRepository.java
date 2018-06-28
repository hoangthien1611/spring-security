package com.hoangthien.security.springsecurity.repository;

import com.hoangthien.security.springsecurity.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

    Optional<Users> findByFirstName(String username);

}
