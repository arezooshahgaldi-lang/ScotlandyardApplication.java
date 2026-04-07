package mu.scotlandyard.service;

import mu.scotlandyard.entity.Clue;
import mu.scotlandyard.repository.ClueRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClueService {

    private final ClueRepository clueRepository;

    public ClueService(ClueRepository clueRepository) {
        this.clueRepository = clueRepository;
    }


    public Clue saveClue(Clue clue) {
        return clueRepository.save(clue);
    }


    public List<Clue> findAll() {
        return clueRepository.findAll();
    }


    public Optional<Clue> findById(Integer id) {
        return clueRepository.findById(id);
    }


    public void deleteById(Integer id) {
     clueRepository.deleteById(id);
    }
}
