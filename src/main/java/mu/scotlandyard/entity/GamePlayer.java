package mu.scotlandyard.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mu.scotlandyard.enoms.PlayerRole;
import mu.scotlandyard.enoms.WinnerRole;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GamePlayer {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name="gameId",nullable = false)
    private Game game;

    @ManyToOne
    @JoinColumn(name="playerId",nullable = false)
    private Player player;

    @Enumerated(EnumType.STRING)
    @Column(name="role")
    private PlayerRole role;
    private Boolean isCaught;
    private LocalDateTime joinedAt;

}
