package mu.scotlandyard.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameMap {
    @Id
    @GeneratedValue (strategy= GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer gridWidth;
    private Integer gridHeight;
    private String description;

}
