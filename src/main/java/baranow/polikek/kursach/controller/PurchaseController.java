package baranow.polikek.kursach.controller;

import baranow.polikek.kursach.model.Purchase;
import baranow.polikek.kursach.service.PurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/purchase")

public class PurchaseController {
    private final PurchaseService purchaseService;

    @PostMapping
    ResponseEntity<Void> addPurchase(@RequestBody Purchase purchase){
        purchaseService.addPurchase(purchase);
        return ResponseEntity.ok().build();

    }


    @GetMapping
    ResponseEntity<List<Purchase>> getAllPurchase(){
        return ResponseEntity.ok(purchaseService.getAllPurchase());

    }


    @GetMapping("/{id}")
    ResponseEntity<Purchase> getPurchaseById(@PathVariable Long id){
        Optional<Purchase> purchaseOptional = purchaseService.getPurchaseById(id);
        return purchaseOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PutMapping("/{id}")
    ResponseEntity<Purchase> updatePurchaseById(@PathVariable Long id, @RequestBody @Validated Purchase updatedPurchase, BindingResult result) {
        Optional<Purchase> updatedPurchaseOptional = purchaseService.putPurchaseById(id, updatedPurchase, result);
        return updatedPurchaseOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deletePurchaseById(@PathVariable Long id){
        purchaseService.deletePurchaseById(id);
        return ResponseEntity.ok().build();
    }


}
