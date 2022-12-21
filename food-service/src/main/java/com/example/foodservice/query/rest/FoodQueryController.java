package com.example.foodservice.query.rest;

import com.example.foodservice.query.FindFoodQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FoodQueryController {
    @Autowired
    QueryGateway queryGateway;

    @RequestMapping(value = "/food", method = RequestMethod.GET)
    public List<FoodRestModel> getFood(){
        FindFoodQuery findFoodQuery = new FindFoodQuery();
        List<FoodRestModel> foods = queryGateway
                .query(findFoodQuery, ResponseTypes.multipleInstancesOf(FoodRestModel.class)).join();
        return foods;
    }
}
