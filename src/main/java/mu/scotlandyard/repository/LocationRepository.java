package mu.scotlandyard.repository;

import mu.scotlandyard.dto.LocationDto;
import mu.scotlandyard.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location,Integer> {
    @Query("select new mu.scotlandyard.dto.LocationDto(l.id, l.name, l.type) from Location l")
    List<LocationDto> findAllLocationDto();
}
