package baranow.polikek.kursach.service;

import baranow.polikek.kursach.model.Buyer;
import baranow.polikek.kursach.model.Employee;
import baranow.polikek.kursach.model.Pokupka;
import baranow.polikek.kursach.model.Tovar;
import baranow.polikek.kursach.repository.BuyerRepository;
import baranow.polikek.kursach.repository.EmployeeRepository;
import baranow.polikek.kursach.repository.PokupkaRepository;
import baranow.polikek.kursach.repository.TovarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class PokupkaServiceImpl implements PokupkaService{

    private final PokupkaRepository pokupkaRepository;
    private final TovarRepository tovarRepository;
    private final BuyerRepository buyerRepository;
    private final EmployeeRepository employeeRepository;

    @Override
    public void addPokupka(Pokupka pokupka) {
        Tovar tovar = pokupka.getTovar();
        Buyer buyer = pokupka.getBuyer();
        Employee employee = pokupka.getEmployee();

        if (tovar != null && tovar.getIdTovar() != null) {
            tovar = tovarRepository.findById(tovar.getIdTovar()).orElse(null);
        }
        if (buyer != null && buyer.getIdBuyer() != null) {
            buyer = buyerRepository.findById(buyer.getIdBuyer()).orElse(null);
        }
        if (employee != null && employee.getIdEmployee() != null) {
            employee = employeeRepository.findById(employee.getIdEmployee()).orElse(null);
        }

        pokupka.setTovar(tovar);
        pokupka.setBuyer(buyer);
        pokupka.setEmployee(employee);

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

            Pokupka pokupkaToUpdate = existingPokupka.get();
            if(updatedPokupka.getTovar() != null && updatedPokupka.getTovar().getIdTovar() != null) {
                Tovar tovar = tovarRepository.findById(updatedPokupka.getTovar().getIdTovar()).orElse(null);
                pokupkaToUpdate.setTovar(tovar);
            }

            if(updatedPokupka.getCountTovarInPokupka() != null) {
                pokupkaToUpdate.setCountTovarInPokupka(updatedPokupka.getCountTovarInPokupka());
            }

            if(updatedPokupka.getBuyer() != null && updatedPokupka.getBuyer().getIdBuyer() != null) {
                Buyer buyer = buyerRepository.findById(updatedPokupka.getBuyer().getIdBuyer()).orElse(null);
                pokupkaToUpdate.setBuyer(buyer);
            }

            if(updatedPokupka.getEmployee() != null && updatedPokupka.getEmployee().getIdEmployee() != null) {
                Employee employee = employeeRepository.findById(updatedPokupka.getEmployee().getIdEmployee()).orElse(null);
                pokupkaToUpdate.setEmployee(employee);
            }

            pokupkaRepository.save(pokupkaToUpdate);
        }
        return existingPokupka;
    }

    @Override
    public void deletePokupkaById(Long id) {
        pokupkaRepository.deleteById(id);

    }
}
