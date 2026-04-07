package mu.scotlandyard.dto;

public class JoinGameResponse {
    private Integer gameId;
    private String gameStatus;
    private String playerName;
    private String massage;

    public JoinGameResponse(Integer gameId, String gameStatus, String playerName, String massage){
      this.gameId=gameId;
      this.gameStatus=gameStatus;
      this.playerName=playerName;
        this.massage = massage;
    }

    public Integer getGameId() {
        return gameId;
    }

    public String getGameStatus() {
        return gameStatus;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getMassage() {
        return massage;
    }


}
