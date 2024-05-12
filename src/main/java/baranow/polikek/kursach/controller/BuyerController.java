package baranow.polikek.kursach.controller;


import baranow.polikek.kursach.model.Buyer;
import baranow.polikek.kursach.service.BuyerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/buyer")

public class BuyerController {

    private final BuyerService buyerService;


    @PostMapping
    ResponseEntity<Void> addBuyer(@RequestBody Buyer buyer){
        buyerService.addBuyer(buyer);
        return ResponseEntity.ok().build();

    }


    @GetMapping
    ResponseEntity<List<Buyer>> getAllBuyers(){
        return ResponseEntity.ok(buyerService.getAllBuyers());

    }


    @GetMapping("/{id}")
    ResponseEntity<Buyer> getBuyerById(@PathVariable Long id){
        Optional<Buyer> buyerOptional = buyerService.getBuyerById(id);
        return buyerOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PutMapping("/{id}")
    ResponseEntity<Buyer> updateBuyerById(@PathVariable Long id, @RequestBody Buyer updatedBuyer) {
        Optional<Buyer> updatedBuyerOptional = buyerService.putBuyerById(id, updatedBuyer);
        return updatedBuyerOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteBuyerById(@PathVariable Long id){
        buyerService.deleteBuyerById(id);
        return ResponseEntity.ok().build();
    }
}