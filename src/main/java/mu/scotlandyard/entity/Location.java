package mu.scotlandyard.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mu.scotlandyard.enoms.LocationType;
import jakarta.persistence.*;
import jakarta.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private int coordinateX;
    private int coordinateY;

    @Enumerated(EnumType.STRING)
    private LocationType type;

    @ManyToOne
    private GameMap map;


}
