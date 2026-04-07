package mu.scotlandyard.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mu.scotlandyard.enoms.Transport;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer mapId;
    private Integer FromLocation;
    private Integer ToLocation;
    private Integer Distance;

    @Enumerated(EnumType.STRING)
    private Transport transport;
}
