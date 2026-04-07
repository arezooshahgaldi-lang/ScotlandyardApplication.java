package mu.scotlandyard.controller;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import mu.scotlandyard.entity.Move;
import mu.scotlandyard.service.MoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/moves")

public class MoveController {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final MoveService moveService;
    @Autowired
    public MoveController(MoveService moveService) {
        this.moveService = moveService;
    }

    @GetMapping
    public List<Move> findAll() {
        return moveService.findAll();
    }
    @GetMapping("/id")
    public ResponseEntity<Move> findById(@RequestParam Integer id) {
        Optional<Move> move = moveService.findById(id);
        if (move.isPresent()) {
            return ResponseEntity.ok(move.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping
    public Move creatMove(@RequestBody Move move) {
        return moveService.saveMove(move);
    }
    @DeleteMapping("/{id}")
   public ResponseEntity<?> deleteById(@PathVariable Integer id) {
        Optional<Move> move = moveService.findById(id);
        if (move.isPresent()) {
            moveService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
