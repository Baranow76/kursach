package baranow.polikek.kursach.service;

import baranow.polikek.kursach.exceptions.ExceptionHandler;
import baranow.polikek.kursach.model.Buyer;
import baranow.polikek.kursach.model.Employee;
import baranow.polikek.kursach.model.Purchase;
import baranow.polikek.kursach.model.Product;
import baranow.polikek.kursach.repository.BuyerRepository;
import baranow.polikek.kursach.repository.EmployeeRepository;
import baranow.polikek.kursach.repository.PurchaseRepository;
import baranow.polikek.kursach.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class PurchaseServiceImpl implements PurchaseService {

    private final ExceptionHandler exceptionHandler;
    private final PurchaseRepository purchaseRepository;
    private final ProductRepository productRepository;
    private final BuyerRepository buyerRepository;
    private final EmployeeRepository employeeRepository;

    @Override
    @Transactional
    public void addPurchase(@Valid Purchase purchase) {
        // Получаем идентификаторы сущностей из покупки
        Long productId = purchase.getProduct().getIdProduct();
        Long buyerId = purchase.getBuyer().getIdBuyer();
        Long employeeId = purchase.getEmployee().getIdEmployee();

        // Проверяем существование сущностей в базе данных
        Product tovar = productRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("Продукт с id " + productId + " не найден"));
        Buyer buyer = buyerRepository.findById(buyerId)
                .orElseThrow(() -> new EntityNotFoundException("Покупатель с id " + buyerId + " не найден"));
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EntityNotFoundException("Сотрудник с id " + employeeId + " не найден"));


        purchase.setProduct(tovar);
        purchase.setBuyer(buyer);
        purchase.setEmployee(employee);

        purchaseRepository.save(purchase);

    }

    @Override
    public List<Purchase> getAllPurchase() {
        return purchaseRepository.findAll();
    }

    @Override
    public Optional<Purchase> getPurchaseById(Long id) {
        return purchaseRepository.findById(id);
    }

    @Override
    public Optional<Purchase> putPurchaseById(Long id, @Valid Purchase updatedPurchase, BindingResult result) {
        Optional<Purchase> existingPokupka = purchaseRepository.findById(id);
        if(existingPokupka.isPresent()){
            Purchase purchaseToUpdate = existingPokupka.get();

            BeanUtils.copyProperties(updatedPurchase, purchaseToUpdate, "idPokupki");

            purchaseRepository.save(purchaseToUpdate);
        }
        return existingPokupka;
    }



    @Override
    public void deletePurchaseById(Long id) {
        purchaseRepository.deleteById(id);

    }
}
