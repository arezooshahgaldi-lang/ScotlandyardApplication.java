package mu.scotlandyard.controller;

import mu.scotlandyard.entity.Clue;
import mu.scotlandyard.service.ClueService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clues")
public class ClueController {
    private final ClueService clueService;

    public ClueController(ClueService clueService) {
        this.clueService = clueService;
    }

    @GetMapping
    public List<Clue> getClues() {
        return clueService.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Clue> getClueById(@PathVariable Integer id) {
        Optional<Clue> clue = clueService.findById(id);
        if (clue.isPresent()) {
            return ResponseEntity.ok(clue.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping
    public Clue createClue(@RequestBody Clue clue){
            return clueService.saveClue(clue);
        }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClueById(@PathVariable Integer id){
        Optional<Clue> clue = clueService.findById(id);
        if (clue.isPresent()) {
            clueService.deleteById(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

}
