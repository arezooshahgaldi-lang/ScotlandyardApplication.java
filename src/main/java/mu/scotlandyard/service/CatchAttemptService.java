package mu.scotlandyard.service;

import mu.scotlandyard.dto.CatchAttemptProjection;
import mu.scotlandyard.dto.CatchAttemptRequest;
import mu.scotlandyard.dto.CatchAttemptResponse;
import mu.scotlandyard.entity.*;
import mu.scotlandyard.repository.CatchAttemptRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class CatchAttemptService  {
    private final CatchAttemptRepository repository;
    private final MoveService moveService;

    public CatchAttemptService(CatchAttemptRepository repository, MoveService moveService) {
        this.repository = repository;
        this.moveService = moveService;
    }
    public List<CatchAttempt> getAllAttempt() {
        return repository.findAll();
    }
    public CatchAttempt getAttemptById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("CatchAttempt not found"));
    }
    public CatchAttempt createAttempt(CatchAttempt attempt) {

        if (attempt.getAttemptedAt() == null) {
            attempt.setAttemptedAt(LocalDateTime.now());
            attempt.setSuccessful(false);
        }
        return repository.save(attempt);
    }
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public CatchAttemptResponse attemptCatch(CatchAttemptRequest request) {

        List<Move> detectiveMoves = moveService.findMovesByGameAndPlayerOrdered(request.getGameId(), request.getDetectiveId());
        List<Move> thiefMoves = moveService.findMovesByGameAndPlayerOrdered(request.getGameId(), request.getThiefId());

        if (detectiveMoves.isEmpty() ){
            throw new RuntimeException("Detective move not found");
        }
        if (thiefMoves.isEmpty() ){
            throw new RuntimeException("Thief move not found");
        }
        Move detectiveLastMove=detectiveMoves.getLast();
        Move thiefLastMove=thiefMoves.getLast();

        boolean successful =
                detectiveLastMove.getToLoc().equals(request.getLocationId()) &&
                        thiefLastMove.getToLoc().equals(request.getLocationId());

        CatchAttempt attempt = new CatchAttempt();
        attempt.setGameId(request.getGameId());
        attempt.setDetectiveId(request.getDetectiveId());
        attempt.setThiefId(request.getThiefId());
        attempt.setLocationId(request.getLocationId());
        attempt.setSuccessful(successful);
        attempt.setAttemptedAt(LocalDateTime.now());

        boolean alreadyAttempted = repository
                .existsByGameIdAndDetectiveIdAndThiefIdAndLocationId(
                        request.getGameId(),
                        request.getDetectiveId(),
                        request.getThiefId(),
                        request.getLocationId()
                );
        if (alreadyAttempted) {
            return new CatchAttemptResponse(
                    request.getGameId(),
                    null,
                    false,
                    "This catch attempt already exists"
            );
        }
        repository.save(attempt);

        CatchAttemptProjection projection = repository.findProjectionByGameId(request.getGameId())
                .stream()
                .findFirst()
                .orElse(null);

        if (projection == null) {
            return new CatchAttemptResponse(
                    request.getGameId(),
                    null,
                    successful,
                    "No catch attempts found for this game"
            );
        }

        String message = Boolean.TRUE.equals(successful)
                ? "Detective successfully caught the thief"
                : "Detective failed to catch the thief";

        return new CatchAttemptResponse(
                projection.getGameId(),
                projection.getMapName(),
                successful,
                message
        );
    }

}
