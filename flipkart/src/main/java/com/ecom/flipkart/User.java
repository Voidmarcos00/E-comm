package com.ecom.flipkart;

import lombok.Data;

// @Data --> Used to expose fields(alternative for using of getters and setters)
@Data
public class User{

    private Long id;
    private String name;
    private int age;

}
