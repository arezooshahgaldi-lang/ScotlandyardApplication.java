package mu.scotlandyard.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameResponse {
    private Integer id;
    private String status;
    private Integer MapId;
    private String MapName;
    private Integer hostPlayerId;
    private String hostPlayerRole;
    private Integer requiredPlayers;
    private String message;

}
