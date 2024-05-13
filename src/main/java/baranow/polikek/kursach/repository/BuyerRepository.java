package baranow.polikek.kursach.repository;

import baranow.polikek.kursach.model.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BuyerRepository extends JpaRepository<Buyer, Long> , PagingAndSortingRepository<Buyer, Long> {

}
