package com.example.dockerDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dockerDemo.domain.User;

public interface UserRepository extends JpaRepository <User,Long> {

}
