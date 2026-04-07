package mu.scotlandyard.controller;

import mu.scotlandyard.dto.LocationDto;

import mu.scotlandyard.service.LocationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/locations")
public class LocationController {

    private  final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }
    @GetMapping
    public List<LocationDto> getAllLocationDto() {
        return locationService.getAllLocationDto();
    }
}
