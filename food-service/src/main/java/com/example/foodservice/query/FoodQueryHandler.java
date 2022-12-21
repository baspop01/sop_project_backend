package com.example.foodservice.query;

import com.example.foodservice.core.FoodEntity;
import com.example.foodservice.query.rest.FoodRestModel;
import com.example.foodservice.core.data.FoodRepository;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FoodQueryHandler {
    private final FoodRepository foodRepository;

    public FoodQueryHandler(FoodRepository foodRepository){
        this.foodRepository = foodRepository;
    }

    @QueryHandler
    List<FoodRestModel> findFood(FindFoodQuery query){
        List<FoodRestModel> foodsRest = new ArrayList<>();
        List<FoodEntity> storedFoods = foodRepository.findAll();
        for (FoodEntity productEntity : storedFoods){
            FoodRestModel productRestModel = new FoodRestModel();
            BeanUtils.copyProperties(productEntity, productRestModel);
            foodsRest.add(productRestModel);
        }
        return foodsRest;
    }
}
