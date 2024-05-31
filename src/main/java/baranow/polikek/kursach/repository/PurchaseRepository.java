package baranow.polikek.kursach.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import baranow.polikek.kursach.model.Purchase;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> , PagingAndSortingRepository<Purchase, Long> {
}
