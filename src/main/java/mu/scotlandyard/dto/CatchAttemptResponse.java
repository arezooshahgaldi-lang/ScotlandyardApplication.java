package mu.scotlandyard.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CatchAttemptResponse {
    private Integer gameId;
    private String mapName;
    private Boolean successful;
    private String message;
}
