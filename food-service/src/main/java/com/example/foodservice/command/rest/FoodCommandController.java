package com.example.foodservice.command.rest;

import com.example.foodservice.command.CreateFoodCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class FoodCommandController {

    private final CommandGateway commandGateway;

    @Autowired
    public FoodCommandController(CommandGateway commandGateway){this.commandGateway = commandGateway;}

    @RequestMapping("/update")
    public String createFood(@RequestBody CreateFoodRestModel model){

        CreateFoodCommand command = CreateFoodCommand.builder()
                ._id(UUID.randomUUID().toString())
                .image(model.getImage())
                .name(model.getName())
                .main(model.getMain())
                .price(model.getPrice())
                .ingredient(model.getIngredient())
                .build();
        String result;
        try{
            result = commandGateway.sendAndWait(command);
        }catch (Exception e){
            result = e.getLocalizedMessage();
        }

        return result;
    }
}
