package com.cl.Logistics.Freight.Network.Controllers;

import com.cl.Logistics.Freight.Network.Services.TrackingEventService;
import com.cl.Logistics.Freight.Network.entities.TrackingEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tracking-events")
public class TrackingEventController {

    TrackingEventService trackingEventService;

    @Autowired
    public TrackingEventController(TrackingEventService trackingEventService) {
        this.trackingEventService = trackingEventService;
    }

    @PostMapping
    public Long addTrackingEvent(@RequestParam String location,
                                 @RequestParam String status,
                                 @RequestParam String note) {

        return trackingEventService.addTrackingEvent(
                location,
                status,
                note
        );
    }

    @GetMapping
    public List<TrackingEvent> getAllTrackingEvents() {
        return trackingEventService.getAllTrackingEvents();
    }

    @GetMapping("/{id}")
    public TrackingEvent getById(@PathVariable Long id) {
        return trackingEventService.getById(id);
    }

    @PutMapping("/{id}")
    public TrackingEvent updateTrackingEvent(@PathVariable Long id,
                                             @RequestParam String location,
                                             @RequestParam String status,
                                             @RequestParam String note) {

        return trackingEventService.updateTrackingEvent(
                id,
                location,
                status,
                note
        );
    }

    @DeleteMapping("/{id}")
    public Boolean deleteTrackingEvent(@PathVariable Long id) {
        return trackingEventService.deleteById(id);
    }
}