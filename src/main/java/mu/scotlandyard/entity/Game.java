package mu.scotlandyard.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mu.scotlandyard.enoms.GameStatus;
import mu.scotlandyard.enoms.PlayerRole;
import jakarta.persistence.*;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Enumerated(EnumType.STRING)
    private GameStatus status;

    @ManyToOne
    @JoinColumn(name = "mapId")
    private GameMap map;

    private LocalDateTime startedAt;

    private LocalDateTime endedAt;

    @Enumerated(EnumType.STRING)
    private PlayerRole winnerRole;

    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "hostPlayerId")
    private Player hostPlayer;
}
