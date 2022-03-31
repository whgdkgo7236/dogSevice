package com.icia.dogsevice.repository;

import com.icia.dogsevice.entity.FoodEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<FoodEntity, Long> {
}
