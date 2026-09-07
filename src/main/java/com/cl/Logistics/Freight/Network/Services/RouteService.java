package com.cl.Logistics.Freight.Network.Services;

import com.cl.Logistics.Freight.Network.Repositories.RouteRepositories;
import com.cl.Logistics.Freight.Network.entities.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class RouteService {

    RouteRepositories routeRepository;

    @Autowired
    public RouteService(RouteRepositories routeRepository) {
        this.routeRepository = routeRepository;
    }

    public Long addRoute(LocalDate routeDate,
                         String origin,
                         String destination,
                         String status) {

        if (routeDate == null) {
            return null;
        }

        Route route = new Route();

        route.setRouteDate(routeDate);
        route.setOrigin(origin);
        route.setDestination(destination);
        route.setStatus(status);
        route.setIsActive(true);

        return routeRepository.save(route).getId();
    }

    public List<Route> getAllRoute() {
        return routeRepository.findAll();
    }

    public Route getById(Long id) {

        Optional<Route> route =
                routeRepository.findById(id);

        if (route.isPresent()
                && route.get().getIsActive()) {

            return route.get();
        }

        return new Route();
    }

    public Route updateRoute(Long id,
                             LocalDate routeDate,
                             String origin,
                             String destination,
                             String status) {

        Route route =
                routeRepository.findById(id).orElse(null);

        if (route == null
                || !route.getIsActive()) {

            return new Route();
        }

        route.setRouteDate(routeDate);
        route.setOrigin(origin);
        route.setDestination(destination);
        route.setStatus(status);

        return routeRepository.save(route);
    }

    public Boolean deleteById(Long id) {

        Route route =
                routeRepository.findById(id).orElse(null);

        if (route == null
                || !route.getIsActive()) {

            return false;
        }

        route.setIsActive(false);

        routeRepository.save(route);

        return true;
    }
}