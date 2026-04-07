package mu.scotlandyard.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mu.scotlandyard.enoms.PlayerRole;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import java.time.LocalDateTime;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String email;
    private String passwordHash;

    @Enumerated(EnumType.STRING)
    private PlayerRole role;

    @CreationTimestamp
    private LocalDateTime createdAt;
    private LocalDateTime lastLogin;

}