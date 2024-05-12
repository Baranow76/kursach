package baranow.polikek.kursach.controller;

import baranow.polikek.kursach.model.Tovar;
import baranow.polikek.kursach.service.TovarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tovar")
public class TovarController {

    private final TovarService tovarService;

    @PostMapping
    ResponseEntity<Void> addTovar(@RequestBody Tovar tovar){
        tovarService.addTovar(tovar);
        return ResponseEntity.ok().build();

    }


    @GetMapping
    ResponseEntity<List<Tovar>> getAllTovars(){
        return ResponseEntity.ok(tovarService.getAllTovars());

    }


    @GetMapping("/{id}")
    ResponseEntity<Tovar> getTovarById(@PathVariable Long id){
        Optional<Tovar> tovarOptional = tovarService.getTovarById(id);
        return tovarOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PutMapping("/{id}")
    ResponseEntity<Tovar> updateTovarById(@PathVariable Long id, @RequestBody Tovar updatedTovar) {
        Optional<Tovar> updatedTovarOptional = tovarService.putTovarById(id, updatedTovar);
        return updatedTovarOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteTovarById(@PathVariable Long id){
        tovarService.deleteTovarById(id);
        return ResponseEntity.ok().build();
    }
}
