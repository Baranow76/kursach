package baranow.polikek.kursach.service;

import baranow.polikek.kursach.model.Buyer;
import baranow.polikek.kursach.repository.BuyerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class BuyerServiceImpl implements BuyerService {

    private final BuyerRepository buyerRepository;

    @Override
    public void addBuyer(Buyer buyer) {
        buyerRepository.save(buyer);
    }

    @Override
    public List<Buyer> getAllBuyers() {
        return buyerRepository.findAll();
    }

    @Override
    public Optional<Buyer> getBuyerById(Long id) {
        return buyerRepository.findById(id);
    }

    @Override
    public Optional<Buyer> putBuyerById(Long id, Buyer updatedBuyer) {
        Optional<Buyer> existingBuyer = buyerRepository.findById(id);
        if (existingBuyer.isPresent()) {
            Buyer buyerToUpdate = existingBuyer.get();
            if (updatedBuyer.getName() != null) {
                buyerToUpdate.setName(updatedBuyer.getName());
            }
            if (updatedBuyer.getSurname() != null) {
                buyerToUpdate.setSurname(updatedBuyer.getSurname());
            }
            if (updatedBuyer.getTelNumber() != null) {
                buyerToUpdate.setTelNumber(updatedBuyer.getTelNumber());
            }
            buyerRepository.save(buyerToUpdate);
        }
        return existingBuyer;
    }


    @Override
    public void deleteBuyerById(Long id) {
        buyerRepository.deleteById(id);
    }
}
