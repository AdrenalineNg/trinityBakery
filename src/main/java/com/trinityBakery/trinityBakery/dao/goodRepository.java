package com.trinityBakery.trinityBakery.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.trinityBakery.trinityBakery.model.good;

public interface goodRepository  extends JpaRepository<good,String> {

}