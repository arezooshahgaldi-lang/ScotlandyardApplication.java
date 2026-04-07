package mu.scotlandyard.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Clue {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private Integer gameId;
    private Integer locationId;
    private Integer foundBy;
    private String description;
    private Boolean isFound=false;
    private LocalDateTime foundAt;
    private LocalDateTime createdAt;


    public Clue(Integer gameId, Integer locationId, Integer foundBy, String description,LocalDateTime createdAt,LocalDateTime foundAt) {
        this.gameId = gameId;
        this.locationId = locationId;
        this.foundBy = foundBy;
        this.description = description;
        this.isFound=true;
        this.foundAt = foundAt;
        this.createdAt= createdAt;
    }

    @PrePersist
    public void prePersist(){
        if(createdAt==null){
            createdAt = LocalDateTime.now();
        }
        if (isFound==null){
            isFound=false;
        }
    }


}
