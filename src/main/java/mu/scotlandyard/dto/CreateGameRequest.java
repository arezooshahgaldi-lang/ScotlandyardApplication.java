package mu.scotlandyard.dto;

public class CreateGameRequest {
    private Integer mapId;
    private Integer hostPlayerId;

    public CreateGameRequest() {

    }
    public Integer getMapId() {
        return mapId;
    }
    public void setMapId(Integer mapId) {
        this.mapId = mapId;
    }
    public Integer getHostPlayerId() {
        return hostPlayerId;
    }
    public void setHostPlayerId(Integer hostPlayerId) {
        this.hostPlayerId = hostPlayerId;
    }

}
