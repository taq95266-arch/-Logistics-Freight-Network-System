package com.cl.Logistics.Freight.Network.Controllers;

import com.cl.Logistics.Freight.Network.Services.RouteService;
import com.cl.Logistics.Freight.Network.entities.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("routes")
public class RouteController {

    RouteService routeService;

    @Autowired
    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @PostMapping
    public Long addRoute(@RequestParam LocalDate routeDate,
                         @RequestParam String origin,
                         @RequestParam String destination,
                         @RequestParam String status) {

        return routeService.addRoute(
                routeDate,
                origin,
                destination,
                status
        );
    }

    @GetMapping
    public List<Route> getAllRoutes() {
        return routeService.getAllRoute();
    }

    @GetMapping("/{id}")
    public Route getById(@PathVariable Long id) {
        return routeService.getById(id);
    }

    @PutMapping("/{id}")
    public Route updateRoute(@PathVariable Long id,
                             @RequestParam LocalDate routeDate,
                             @RequestParam String origin,
                             @RequestParam String destination,
                             @RequestParam String status) {

        return routeService.updateRoute(
                id,
                routeDate,
                origin,
                destination,
                status
        );
    }

    @DeleteMapping("/{id}")
    public Boolean deleteRoute(@PathVariable Long id) {
        return routeService.deleteById(id);
    }
}