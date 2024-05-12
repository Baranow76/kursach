package baranow.polikek.kursach.repository;

import baranow.polikek.kursach.model.Tovar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TovarRepository extends JpaRepository<Tovar, Long> {
}
