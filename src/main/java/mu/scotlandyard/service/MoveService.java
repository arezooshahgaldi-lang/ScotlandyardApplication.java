package mu.scotlandyard.service;

import mu.scotlandyard.enoms.Transport;
import mu.scotlandyard.entity.Move;
import mu.scotlandyard.repository.MoveRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MoveService{
    private final MoveRepository moveRepository;
    public MoveService(MoveRepository moveRepository, MoveRepository moveRepository1) {
        this.moveRepository = moveRepository1;
    }

    public Move saveMove(Move move) {
        return moveRepository.save(move);
    }

    public List<Move> findByTransport(Transport transport) {
        return moveRepository.findByTransport(transport);
    }

    public Optional<Move> findById(Integer id) {
        return moveRepository.findById(id);
    }

    public void deleteById(Integer id) {
     moveRepository.deleteById(id);
    }

    public List<Move> findAll() {
        return moveRepository.findAll();
    }
    public List<Move> findMovesByGameAndPlayerOrdered(Integer gameId, Integer playerId) {
        return moveRepository.findByGameIdAndPlayerIdOrderByMovedAtDesc(gameId, playerId);
    }
}
