package mu.scotlandyard.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mu.scotlandyard.enoms.Transport;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Move {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer gameId;
    private Integer playerId;
    private Integer fromLoc;
    private Integer toLoc;
    private Integer turnNumber;
    private java.sql.Timestamp movedAt;

   @Enumerated(EnumType.STRING)
    private Transport transport;



}
