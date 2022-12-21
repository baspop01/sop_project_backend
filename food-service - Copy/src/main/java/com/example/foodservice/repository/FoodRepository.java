package com.example.foodservice.repository;

import com.example.foodservice.pojo.Food;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends MongoRepository<Food, String> {
    @Query(value="{'name':'?0'}")
    public Food findByName(String name);

}
