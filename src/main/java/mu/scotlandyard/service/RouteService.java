package mu.scotlandyard.service;

import mu.scotlandyard.entity.Route;
import mu.scotlandyard.repository.RouteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteService{


    private final RouteRepository routeRepository;

    public RouteService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }



    public List<Route> getAllRoutes() {
        return routeRepository.findAll();
    }


    public Route getRouteById(Integer id) {
        return routeRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Route not found"));
    }


    public Route createRoute(Route route) {
        return routeRepository.save(route);
    }


    public void deleteRoute(Integer id){
        Route existingRoute = routeRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Route not found"));

        routeRepository.delete(existingRoute);
    }


    public Route updateRoute(Integer id ,Route route) {
        Route existingRoute=routeRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Route not found"));

        existingRoute.setMapId(route.getMapId());
        existingRoute.setFromLocation(route.getFromLocation());
        existingRoute.setToLocation(route.getToLocation());
        existingRoute.setTransport(route.getTransport());
        existingRoute.setDistance(route.getDistance());
        return routeRepository.save(existingRoute);
    }
}
