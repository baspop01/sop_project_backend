package com.example.foodservice.อันเก่า.controller;

import com.example.foodservice.อันเก่า.pojo.Food;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin("*")
public class FoodController {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping(value = "/food", method = RequestMethod.GET)
    public ArrayList getFood(){
        System.out.println("getFood");
        Object food = rabbitTemplate.convertSendAndReceive("Direct", "food", "");
        return (ArrayList) food;
    }

    @RequestMapping(value = "/food/{name}", method = RequestMethod.GET)
    public Food getFoodByName(@PathVariable("name") String name){
        Object food = rabbitTemplate.convertSendAndReceive("Direct", "foodbyname", name);
        return (Food) food;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addFood(@RequestParam("image") String image, @RequestParam("name") String n, @RequestParam("main") String m,
                        @RequestParam("ingredient") String i, @RequestParam("price") int p){
        String url = null;
        if(image.isEmpty()){
            System.out.println("It's empty!");
            url = "https://cdn.discordapp.com/attachments/921293798884134923/1054750817443393556/cute-corgi-dog-waiting-for-food-cartoon-illustration-vector.jpg";
        }else{
            url = image;
        }
        Food f = new Food(null, url, n, m, p, i);
        rabbitTemplate.convertSendAndReceive("Direct", "addfood", f);
        return "Add food success";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String updateFood(@RequestParam("id") String id, @RequestParam("image") String image, @RequestParam("name") String n, @RequestParam("main") String m,
                        @RequestParam("ingredient") String i, @RequestParam("price") int p){
        Food f = new Food(id, image, n, m, p, i);
        rabbitTemplate.convertSendAndReceive("Direct", "updatefood", f);
        return "Update food success";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteFood(@RequestParam("name") String name){
        Object f = rabbitTemplate.convertSendAndReceive("Direct", "foodbyname", name);
        rabbitTemplate.convertSendAndReceive("Direct", "delete", f);
        return "Delete Food success";

    }
}
