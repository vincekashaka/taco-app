package com.example.tacocloud.controller;

import com.example.tacocloud.model.Taco;
import com.example.tacocloud.model.TacoOrder;
import com.example.tacocloud.repository.IngredientRepository;
import com.example.tacocloud.repository.TacoRepository;
import com.example.tacocloud.service.TacoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/tacos",
                   produces = {"application/json", "text/xml"})
@CrossOrigin(origins = "http://tacocloud:8080")
public class TacoController {

    @Autowired
    private TacoService tacoService;


    @GetMapping(params = "recent")
    public Iterable<Taco> recentTacos() {
        return tacoService.getTacos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Taco> tacoById(@PathVariable("id") Long id) {
        Optional<Taco> optTaco = tacoService.getTacoById(id);
        if (optTaco.isPresent()) {
            return new ResponseEntity<>(optTaco.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping(consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Taco postTaco(@RequestBody Taco taco) {
        return tacoService.saveTaco(taco);
    }

    @PutMapping(path="/{name}", consumes="application/json")
    public Taco putTaco(
            @PathVariable("name") Long id,
            @RequestBody Taco taco) {
        return tacoService.saveTaco(taco);


//    @PatchMapping(path="/{orderId}", consumes="application/json")
//    public TacoOrder patchOrder(@PathVariable("orderId") Long orderId,
//                                @RequestBody TacoOrder patch) {
//        TacoOrder order = ingredientRepository.findById(orderId).get();
//        if (patch.getDeliveryName() != null) {
//            order.setDeliveryName(patch.getDeliveryName());
//        }
//        if (patch.getDeliveryStreet() != null) {
//            order.setDeliveryStreet(patch.getDeliveryStreet());
//        }
//        if (patch.getDeliveryCity() != null) {
//            order.setDeliveryCity(patch.getDeliveryCity());
//        }
//        if (patch.getDeliveryState() != null) {
//            order.setDeliveryState(patch.getDeliveryState());
//        }
//        if (patch.getDeliveryZip() != null) {
//            order.setDeliveryZip(patch.getDeliveryZip());
//        }
//        if (patch.getCcNumber() != null) {
//            order.setCcNumber(patch.getCcNumber());
//        }
//        if (patch.getCcExpiration() != null) {
//            order.setCcExpiration(patch.getCcExpiration());
//        }
//        if (patch.getCcCVV() != null) {
//            order.setCcCVV(patch.getCcCVV());
//        }
//        return ingredientRepository.save(order);
  }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder(@PathVariable("id") Long id) {
        try {
             tacoService.deleteTaco(id);
        } catch (EmptyResultDataAccessException e) {}
    }

}
