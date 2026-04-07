package mu.scotlandyard.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CatchAttemptRequest {
    private Integer gameId;
    private Integer detectiveId;
    private Integer thiefId;
    private Integer locationId;
}
