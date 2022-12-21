//package com.example.foodservice.อันเก่า.repository;
//
//import com.example.foodservice.core.data.FoodRepository;
//import com.example.foodservice.อันเก่า.pojo.Food;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class FoodService {
//    @Autowired
//    private FoodRepository foodRepository;
//
//    @RabbitListener(queues = "GetFoodQueue")
//    public List foods(){
//        return foodRepository.findAll();
//    }
//
//
//    @RabbitListener(queues = "GetFoodByNameQueue")
//    public Food foodByName(String s){
//        return foodRepository.findByName(s);
//    }
//
//    @RabbitListener(queues = "AddFoodQueue")
//    public void addFood(Food f){
//        foodRepository.insert(f);
//    }
//
//    @RabbitListener(queues = "UpdateFoodQueue")
//    public void updateFood(Food f){
//        foodRepository.save(f);
//    }
//
//    @RabbitListener(queues = "DeleteFoodQueue")
//    public void deleteFood(Food f){
//        foodRepository.delete(f);
//    }
//}
