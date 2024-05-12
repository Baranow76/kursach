package baranow.polikek.kursach.service;

import baranow.polikek.kursach.model.Buyer;

import java.util.List;
import java.util.Optional;

public interface BuyerService {
    void addBuyer(Buyer buyer);

    List<Buyer> getAllBuyers();

    Optional<Buyer> getBuyerById(Long id);

    Optional<Buyer> putBuyerById(Long id, Buyer updatedBuyer);

    void deleteBuyerById(Long id);

}
