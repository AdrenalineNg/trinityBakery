package com.trinityBakery.trinityBakery.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trinityBakery.trinityBakery.model.order;

public interface orderRepository extends JpaRepository<order,String> {

}