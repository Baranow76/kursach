package baranow.polikek.kursach.service;

import baranow.polikek.kursach.exceptions.ExceptionHandler;
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

    private final ExceptionHandler exceptionHandler;

    @Override
    public void addTovar(Tovar tovar) {
        try {
            tovarRepository.save(tovar);
        } catch (Exception e) {
            exceptionHandler.handleException(e);
        }
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
        Optional<Tovar> existingTovar = tovarRepository.findById(id);
        if (existingTovar.isPresent()) {
            Tovar tovarToUpdate = existingTovar.get();

            if (updatedTovar.getTovarName() != null) {
                tovarToUpdate.setTovarName(updatedTovar.getTovarName());
            }
            if (updatedTovar.getDiscount() != null) {
                tovarToUpdate.setDiscount(updatedTovar.getDiscount());
            }
            if (updatedTovar.getPrice() != null) {
                tovarToUpdate.setPrice(updatedTovar.getPrice());
            }
            if (updatedTovar.getCountAvailable() != null) {
                tovarToUpdate.setCountAvailable(updatedTovar.getCountAvailable());
            }

            try {
                tovarRepository.save(tovarToUpdate);
            } catch (Exception e) {
                exceptionHandler.handleException(e);
            }
        }
        return existingTovar;
    }

    @Override
    public void deleteTovarById(Long id) {
        tovarRepository.deleteById(id);

    }
}
