package mu.scotlandyard.controller;

import mu.scotlandyard.dto.CatchAttemptRequest;
import mu.scotlandyard.dto.CatchAttemptResponse;
import mu.scotlandyard.entity.CatchAttempt;
import mu.scotlandyard.service.CatchAttemptService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catchAttempts")
public class CatchAttemptController {
    
    private final CatchAttemptService service;

    public CatchAttemptController(CatchAttemptService service) {
        this.service = service;
    }
    
    @GetMapping
    public List<CatchAttempt> getAllAttempt() {
        return service.getAllAttempt();
    }
    @GetMapping("/{id}")
    public CatchAttempt getAttemptById(@PathVariable Integer id) {
        return service.getAttemptById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteAttemptById(@PathVariable Integer id) {
        service.deleteById(id);
    }
    @PostMapping
    public CatchAttemptResponse attemptCatch (@RequestBody CatchAttemptRequest request) {
        return service.attemptCatch(request);
    }
}
