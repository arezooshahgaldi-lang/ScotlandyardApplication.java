package mu.scotlandyard.dto;

public class JoinGameRequest {
    private Integer gameId;
    private Integer playerId;

    public JoinGameRequest(){

    }
    public Integer getGameId() {
        return gameId;
    }
    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }
    public Integer getPlayerId() {
        return playerId;
    }
    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }
}
