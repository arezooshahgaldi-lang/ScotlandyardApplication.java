package mu.scotlandyard.dto;

public class StartGameResponse {
     private Integer gameId;
     private String gameStatus;
     private String message;

    public Integer getGameId() {
        return gameId;
    }

    public String getGameStatus() {
        return gameStatus;
    }

    public String getMessage() {
        return message;
    }

    public StartGameResponse(Integer gameId, String gameStatus, String message) {
        this.gameId = gameId;
        this.gameStatus = gameStatus;
        this.message = message;

    }
}
