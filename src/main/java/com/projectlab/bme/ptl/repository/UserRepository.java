package com.projectlab.bme.ptl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.projectlab.bme.ptl.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {

    Optional<User> findByUserName(String userName);

}
