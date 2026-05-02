package com.ecom.flipkart;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// @Data --> Used to expose fields(alternative for using of getters and setters)
@Data
//@Entity --> JPA entities
@Entity(name = "user_table")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;

    // alternatie make use of annotations like
    // @AllArgsConstructor
    public User(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    //@NoArgsConstructor
    public User() {}  //Needed to create the instance while retrieving the data
}
