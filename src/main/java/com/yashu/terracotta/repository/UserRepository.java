package com.yashu.terracotta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yashu.terracotta.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

User findByEmail(String email);

}