package baranow.polikek.kursach.controller;

import baranow.polikek.kursach.model.Pokupka;
import baranow.polikek.kursach.model.Tovar;
import baranow.polikek.kursach.service.PokupkaService;
import baranow.polikek.kursach.service.TovarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pokupka")

public class PokupkaController {
    private final PokupkaService pokupkaService;

    @PostMapping
    ResponseEntity<Void> addPokupka(@RequestBody Pokupka pokupka){
        pokupkaService.addPokupka(pokupka);
        return ResponseEntity.ok().build();

    }


    @GetMapping
    ResponseEntity<List<Pokupka>> getAllPokupkas(){
        return ResponseEntity.ok(pokupkaService.getAllPokupkas());

    }


    @GetMapping("/{id}")
    ResponseEntity<Pokupka> getPokupkaById(@PathVariable Long id){
        Optional<Pokupka> pokupkaOptional = pokupkaService.getPokupkaById(id);
        return pokupkaOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PutMapping("/{id}")
    ResponseEntity<Pokupka> updatePokupkaById(@PathVariable Long id, @RequestBody Pokupka updatedPokupka) {
        Optional<Pokupka> updatedPokupkaOptional = pokupkaService.putPokupkaById(id, updatedPokupka);
        return updatedPokupkaOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteTovarById(@PathVariable Long id){
        pokupkaService.deletePokupkaById(id);
        return ResponseEntity.ok().build();
    }
}
