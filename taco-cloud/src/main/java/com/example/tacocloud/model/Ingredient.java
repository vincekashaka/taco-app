package com.example.tacocloud.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "INGREDIENT_TBL")
public class Ingredient {

    @Id
    private   Long id;
    private   String name;
    private   Type type;

     public enum Type {
         WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
     }
}
