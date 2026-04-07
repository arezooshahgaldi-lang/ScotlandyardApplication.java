package mu.scotlandyard.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameListResponse {
    private Integer id;
    private String status;
    private Integer mapId;
    private String mapName;
    private Integer hostPlayerId;
    private String hostPlayerName;
    private LocalDateTime createdAt;
    private LocalDateTime startedAt;


}
