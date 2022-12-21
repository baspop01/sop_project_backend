package com.example.foodservice.command.rest;

import lombok.Data;

@Data
public class CreateFoodRestModel {

    private String image;
    private String name;
    private String main;
    private int price;
    private String ingredient;
}
