package com.pm.cache.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pm.cache.model.User;

public interface UserRepository extends JpaRepository<User,Integer> {

}
