package baranow.polikek.kursach.service;

import baranow.polikek.kursach.model.Pokupka;
import baranow.polikek.kursach.model.Tovar;
import baranow.polikek.kursach.repository.TovarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor

public class TovarServiceImpl implements TovarService {

    private final TovarRepository tovarRepository;


    @Override
    public void addTovar(Tovar tovar) {
        tovarRepository.save(tovar);
    }

    @Override
    public List<Tovar> getAllTovars() {
        return tovarRepository.findAll();
    }

    @Override
    public Optional<Tovar> getTovarById(Long id) {
        return tovarRepository.findById(id);
    }

    @Override
    public Optional<Tovar> putTovarById(Long id, Tovar updatedTovar) {
        return Optional.empty();
    }

    @Override
    public void deleteTovarById(Long id) {
        tovarRepository.deleteById(id);

    }
}
