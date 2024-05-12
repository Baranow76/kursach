package baranow.polikek.kursach.repository;

import baranow.polikek.kursach.model.Tovars;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TovarsRepository extends JpaRepository<Tovars, Long> {
}
