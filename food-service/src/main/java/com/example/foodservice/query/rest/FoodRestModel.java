package com.example.foodservice.query.rest;

import lombok.Data;

@Data
public class FoodRestModel {
    private String image;
    private String name;
    private String main;
    private int price;
    private String ingredient;
}
