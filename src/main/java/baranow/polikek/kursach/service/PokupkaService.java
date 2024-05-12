package baranow.polikek.kursach.service;

import baranow.polikek.kursach.model.Employee;
import baranow.polikek.kursach.model.Pokupka;

import java.util.List;
import java.util.Optional;

public interface PokupkaService {


    void addPokupka(Pokupka pokupka);

    List<Pokupka> getAllPokupkas();

    Optional<Pokupka> getPokupkaById(Long id);

    Optional<Pokupka> putPokupkaById(Long id, Pokupka updatedPokupka);

    void deletePokupkaById(Long id);

}
