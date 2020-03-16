package com.trinityBakery.trinityBakery.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.trinityBakery.trinityBakery.model.user;

public interface userRepository extends JpaRepository<user,String> {

}

