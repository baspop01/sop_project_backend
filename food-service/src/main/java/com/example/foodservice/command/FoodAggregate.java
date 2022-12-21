package com.example.foodservice.command;

import com.example.foodservice.core.event.FoodCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
public class FoodAggregate {
    @AggregateIdentifier
    private String _id;
    private String image;
    private String name;
    private String main;
    private int price;
    private String ingredient;

    public FoodAggregate(){}

    @CommandHandler
    public FoodAggregate(CreateFoodCommand createFoodCommand){

        FoodCreatedEvent foodCreatedEvent = new FoodCreatedEvent();
        BeanUtils.copyProperties(createFoodCommand, foodCreatedEvent);
        AggregateLifecycle.apply(foodCreatedEvent);
    }
    @EventSourcingHandler
    public void on(FoodCreatedEvent foodCreatedEvent){
        this._id = foodCreatedEvent.get_id();
        this.image = foodCreatedEvent.getImage();
        this.name = foodCreatedEvent.getName();
        this.main = foodCreatedEvent.getMain();
        this.price = foodCreatedEvent.getPrice();
        this.ingredient = foodCreatedEvent.getIngredient();
    }
}
