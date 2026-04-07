package mu.scotlandyard.service;

import mu.scotlandyard.dto.*;
import mu.scotlandyard.enoms.GameStatus;
import mu.scotlandyard.enoms.PlayerRole;
import mu.scotlandyard.entity.Game;
import mu.scotlandyard.entity.GameMap;
import mu.scotlandyard.entity.GamePlayer;
import mu.scotlandyard.entity.Player;
import mu.scotlandyard.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class GameService {

    private final GameRepository gameRepository;
    private final GameMapService gameMapService;
    private final PlayerService playerService;
    private final GamePlayerService gamePlayerService;

    public GameService(GameRepository gameRepository, GameMapService gameMapService,
                       PlayerService playerService, GamePlayerService gamePlayerService){
        this.gameRepository=gameRepository;
        this.gameMapService = gameMapService;
        this.playerService = playerService;
        this.gamePlayerService = gamePlayerService;
    }

    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }
    public List<GameListResponse> getAllGamesForList() {
        List<Game>games=gameRepository.findAll();
        return games.stream().map(game -> {
            GameListResponse dto=new GameListResponse();
            dto.setId(game.getId());
            dto.setStatus(game.getStatus().name());
            if (game.getMap()!=null){
                dto.setMapId(game.getMap().getId());
                dto.setMapName(game.getMap().getName());
            }
            if (game.getHostPlayer()!=null){
                dto.setHostPlayerId(game.getHostPlayer().getId());
                dto.setHostPlayerName(game.getHostPlayer().getUsername());
            }
             dto.setCreatedAt(game.getCreatedAt());
             dto.setStartedAt(game.getStartedAt());
             return dto;
        }).toList();
    }

    public Game getGameById(Integer id) {
        return gameRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Game not found"));
    }

    public Game createGame(Game game) {
        return gameRepository.save(game);
    }

    public void deleteGame(Integer id) {
        gameRepository.deleteById(id);
    }

    public GameResponse createGame(CreateGameRequest request) {

        GameMap gameMap = gameMapService.getGameMapById(request.getMapId());
        Player hostPlayer = playerService.getPlayerById(request.getHostPlayerId());
        Game game = new Game();
        game.setMap(gameMap);
        game.setStatus(GameStatus.waiting);
        game.setHostPlayer(hostPlayer);
        game.setCreatedAt(LocalDateTime.now());
        game=gameRepository.save(game);

        Integer requiredPlayers= calculateRequiredPlayers(gameMap);

        GameResponse response = new GameResponse();
        response.setId(game.getId());
        response.setStatus(game.getStatus().name());

        response.setMapId(gameMap.getId());
        response.setMapName(gameMap.getName());
        response.setHostPlayerId(hostPlayer.getId());
        response.setHostPlayerRole("Host");
        response .setRequiredPlayers(requiredPlayers);
        response.setMessage("Suggested number of players for "+gameMap.getName()+" is "+requiredPlayers);
        return response;
    }

    private Integer calculateRequiredPlayers(GameMap gameMap){
        int area=gameMap.getGridWidth()*gameMap.getGridHeight();

        if (area<=25){
            return 2;
        }else if (area<=50){
            return 3;
        }else if (area<=100){
            return 4;
        }else{
            return 5;
        }
    }

    public JoinGameResponse joinGame(JoinGameRequest request) {
        Game game = getGameById(request.getGameId());
        Player player = playerService.getPlayerById(request.getPlayerId());

        if (game.getStatus() != GameStatus.waiting) {
            return new JoinGameResponse(
                    game.getId(),
                    game.getStatus().name(),
                    player.getUsername(),
                    "Game is already active. Cannot join."
            );
        }
        if (player.getRole() == PlayerRole.npc) {
            return new JoinGameResponse(
                    game.getId(),
                    game.getStatus().name(),
                    player.getUsername(),
                    "NPC cannot join the game"
            );
        }
        boolean alreadyJoined = gamePlayerService
                .existsByGameIdAndPlayerId(request.getGameId(), request.getPlayerId());

        if (alreadyJoined) {
            return new JoinGameResponse(
                    game.getId(),
                    game.getStatus().name(),
                    player.getUsername(),
                    "Player already joined this game"
            );
        }
        GamePlayer gamePlayer = new GamePlayer();
        gamePlayer.setGame(game);
        gamePlayer.setPlayer(player);
        gamePlayer.setRole(player.getRole());
        gamePlayer.setIsCaught(false);
        gamePlayer.setJoinedAt(LocalDateTime.now());

       gamePlayerService.saveGamePlayer(gamePlayer);

        return new JoinGameResponse(
                game.getId(),
                game.getStatus().name(),
                player.getUsername(),
                "Player joined successfully"
        );
    }


    public StartGameResponse startGame(StartGameRequest request) {
        Game game = getGameById(request.getGameId());
        if (game.getStatus() != GameStatus.waiting) {
            return new StartGameResponse(
                    game.getId(),
                    game.getStatus().name(),
                    "Game canNot be started because it is not in waiting"
            );
        }
        game.setStatus(GameStatus.active);
        game.setStartedAt(LocalDateTime.now());
        game = gameRepository.save(game);

        return new StartGameResponse(
                game.getId(),
                game.getStatus().name(),
                "Game started successfully"
        );
    }
}


