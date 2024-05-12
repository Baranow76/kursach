package baranow.polikek.kursach.service;


import baranow.polikek.kursach.model.Tovar;

import java.util.List;
import java.util.Optional;

public interface TovarService {

    void addTovar(Tovar tovars);

    List<Tovar> getAllTovars();

    Optional<Tovar> getTovarById(Long id);

    Optional<Tovar> putTovarById(Long id, Tovar updatedTovar);

    void deleteTovarById(Long id);

}
