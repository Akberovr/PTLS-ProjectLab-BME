package com.projectlab.bme.ptl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.projectlab.bme.ptl.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUserName(String userName);
}
