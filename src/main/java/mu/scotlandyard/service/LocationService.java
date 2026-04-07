package mu.scotlandyard.service;

import mu.scotlandyard.dto.LocationDto;
import mu.scotlandyard.entity.Location;
import mu.scotlandyard.repository.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LocationService {
    private final LocationRepository locationRepository;
    public LocationService(LocationRepository locationRepository) {
        this.locationRepository= locationRepository;
    }



    public List<LocationDto> getAllLocationDto() {
        return locationRepository.findAllLocationDto();
    }
    public Location getLocationById(Integer id) {
        return locationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Location not found"));
    }
}
