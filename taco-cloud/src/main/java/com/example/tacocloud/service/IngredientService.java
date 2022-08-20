package com.example.tacocloud.service;


import com.example.tacocloud.model.Ingredient;
import com.example.tacocloud.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientService {

    @Autowired
    private IngredientRepository ingredientRepository;

    public Ingredient saveIngredient(Ingredient ingredient){
        return ingredientRepository.save(ingredient);

    }

    public List<Ingredient> saveIngredients(List<Ingredient> ingredientList){
        return ingredientRepository.saveAll(ingredientList);
    }

    //get methods
    public List<Ingredient> getIngredients(){
        return ingredientRepository.findAll();
    }

    public Optional<Ingredient> getIngredientById(Long id){
        return ingredientRepository.findById(id);
    }

    // customized
    public Optional<Ingredient> getIngredeintByName(String name){
        return ingredientRepository.findByName(name);
    }

    //delete
    public String deleteProduct(Long id){
        ingredientRepository.deleteById(id);
        return "Ingredient removed" + id;
    }

//    //update ingredients
    public Ingredient updateIngredient(Ingredient ingredient){
        Ingredient existingIngredient = ingredientRepository.findById(ingredient.getId()).orElse(null);
        existingIngredient.setName(ingredient.getName());
        existingIngredient.setType(ingredient.getType());
        return ingredientRepository.save(existingIngredient);
    }

}
