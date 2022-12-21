package com.example.foodservice.core.data;

import com.example.foodservice.core.FoodEntity;
import com.example.foodservice.อันเก่า.pojo.Food;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends MongoRepository<FoodEntity, String> {
    @Query(value="{'name':'?0'}")
    public Food findByName(String name);

}
