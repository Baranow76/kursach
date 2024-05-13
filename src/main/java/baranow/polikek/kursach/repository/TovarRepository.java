package baranow.polikek.kursach.repository;

import baranow.polikek.kursach.model.Pokupka;
import baranow.polikek.kursach.model.Tovar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TovarRepository extends JpaRepository<Tovar, Long>, PagingAndSortingRepository<Tovar, Long> {
}
