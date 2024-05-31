package baranow.polikek.kursach.service;

import baranow.polikek.kursach.model.Purchase;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Optional;

public interface PurchaseService {


    void addPurchase(@Valid Purchase purchase);

    List<Purchase> getAllPurchase();

    Optional<Purchase> getPurchaseById(Long id);

    Optional<Purchase> putPurchaseById(Long id, Purchase updatedPurchase, BindingResult result);

    void deletePurchaseById(Long id);

}
