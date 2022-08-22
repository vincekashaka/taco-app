package com.example.tacocloud.controller;

import com.example.tacocloud.model.Ingredient;
import com.example.tacocloud.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/api/ingredients", produces="application/json")
@CrossOrigin(origins="http://localhost:8080")
public class IngredientController {

    @Autowired
    private IngredientService ingredientService;


    @GetMapping
    public Iterable<Ingredient> allIngredients() {
     return ingredientService.getIngredients();
}

    public Optional<Ingredient> getIngredientById(Long id){
        return ingredientService.getIngredientById(id);
    }

    @GetMapping
    public Optional<Ingredient> getIngredientByName(String name) {
        return ingredientService.getIngredeintByName(name);
    }
    @PostMapping("/ingredient")
    @ResponseStatus(HttpStatus.CREATED)
    public Ingredient saveIngredient(@RequestBody Ingredient ingredient) {
        return ingredientService.saveIngredient(ingredient);
    }

    @PostMapping("/ingredients")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Ingredient> saveIngredients(@RequestBody List<Ingredient> ingredientList) {
        return ingredientService.saveIngredients(ingredientList);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteIngredient(@PathVariable("id") Long  id) {
        ingredientService.deleteProduct(id);
    }

    @PutMapping("/update")
    public Ingredient updateIngredient(@RequestBody Ingredient ingredient){
        return ingredientService.updateIngredient(ingredient);
    }

}
