package mu.scotlandyard.dto;

public class CatchAttemptProjection {
    private Integer gameId;
    private String mapName;
    private Boolean successful;

    public CatchAttemptProjection(Integer gameId, String mapName, Boolean successful) {
        this.gameId = gameId;
        this.mapName = mapName;
        this.successful = successful;
    }
    public Integer getGameId(){
            return gameId;
    }
    public String getMapName(){
        return mapName;
    }
    public Boolean getSuccessful(){
        return successful;
    }

}
