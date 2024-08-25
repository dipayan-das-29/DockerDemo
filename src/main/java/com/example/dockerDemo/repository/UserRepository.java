package com.example.dockerDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dockerDemo.domain.User;

@Repository
public interface UserRepository extends JpaRepository <User,Long> {

}
