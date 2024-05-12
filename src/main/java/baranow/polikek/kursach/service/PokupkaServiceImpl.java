package baranow.polikek.kursach.service;

import baranow.polikek.kursach.model.Employee;
import baranow.polikek.kursach.model.Pokupka;
import baranow.polikek.kursach.repository.PokupkaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class PokupkaServiceImpl implements PokupkaService{

    private final PokupkaRepository pokupkaRepository;
    @Override
    public void addPokupka(Pokupka pokupka) {
        pokupkaRepository.save(pokupka);
    }

    @Override
    public List<Pokupka> getAllPokupkas() {
        return pokupkaRepository.findAll();
    }

    @Override
    public Optional<Pokupka> getPokupkaById(Long id) {
        return pokupkaRepository.findById(id);
    }

    @Override
    public Optional<Pokupka> putPokupkaById(Long id, Pokupka updatedPokupka) {
        Optional<Pokupka> existingPokupka = pokupkaRepository.findById(id);
        if(existingPokupka.isPresent()){
            Pokupka pokupkaToUpdete = existingPokupka.get();
            pokupkaToUpdete.setTovar(updatedPokupka.getTovar());
            pokupkaRepository.save(pokupkaToUpdete);
        }
        return existingPokupka;
    }



    @Override
    public void deletePokupkaById(Long id) {
        pokupkaRepository.deleteById(id);

    }
}
