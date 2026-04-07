package mu.scotlandyard.controller;

import mu.scotlandyard.entity.Route;

import mu.scotlandyard.service.RouteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/routes")
public class RouteController {

    private final RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping
    public List<Route> getAllRoutes() {
        return routeService.getAllRoutes();
    }
    @GetMapping("/{id}")
    public Route getRoute(@PathVariable Integer id) {
        return routeService.getRouteById(id);
    }
    @PostMapping
    public Route createRoute(@RequestBody Route route) {
        return routeService.createRoute(route);
    }
    @PutMapping("/{id}")
    public Route updateRoute(@PathVariable Integer id,@RequestBody Route route) {
        return routeService.updateRoute(id, route);
    }
    @DeleteMapping("/{id}")
    public void deleteRoute(@PathVariable Integer id) {
        routeService.deleteRoute(id);
    }
}
