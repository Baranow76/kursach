package baranow.polikek.kursach.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import baranow.polikek.kursach.model.Pokupka;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PokupkaRepository extends JpaRepository<Pokupka, Long> , PagingAndSortingRepository<Pokupka, Long> {
}
