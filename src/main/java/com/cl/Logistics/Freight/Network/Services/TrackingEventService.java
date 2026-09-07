package com.cl.Logistics.Freight.Network.Services;

import com.cl.Logistics.Freight.Network.Repositories.TrackingEventRepositories;
import com.cl.Logistics.Freight.Network.entities.TrackingEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackingEventService {

    TrackingEventRepositories trackingEventRepository;

    @Autowired
    public TrackingEventService(TrackingEventRepositories trackingEventRepository) {
        this.trackingEventRepository = trackingEventRepository;
    }

    public Long addTrackingEvent(String location,
                                 String status,
                                 String note) {

        TrackingEvent trackingEvent = new TrackingEvent();

        trackingEvent.setLocation(location);
        trackingEvent.setStatus(status);
        trackingEvent.setNote(note);
        trackingEvent.setIsActive(true);

        return trackingEventRepository.save(trackingEvent).getId();
    }

    public List<TrackingEvent> getAllTrackingEvents() {
        return trackingEventRepository.findAll();
    }

    public TrackingEvent getById(Long id) {

        Optional<TrackingEvent> trackingEvent =
                trackingEventRepository.findById(id);

        if (trackingEvent.isPresent()
                && trackingEvent.get().getIsActive()) {

            return trackingEvent.get();
        }

        return new TrackingEvent();
    }

    public TrackingEvent updateTrackingEvent(Long id,
                                             String location,
                                             String status,
                                             String note) {

        TrackingEvent trackingEvent =
                trackingEventRepository.findById(id).orElse(null);

        if (trackingEvent == null
                || !trackingEvent.getIsActive()) {

            return new TrackingEvent();
        }

        trackingEvent.setLocation(location);
        trackingEvent.setStatus(status);
        trackingEvent.setNote(note);

        return trackingEventRepository.save(trackingEvent);
    }

    public Boolean deleteById(Long id) {

        TrackingEvent trackingEvent =
                trackingEventRepository.findById(id).orElse(null);

        if (trackingEvent == null
                || !trackingEvent.getIsActive()) {

            return false;
        }

        trackingEvent.setIsActive(false);

        trackingEventRepository.save(trackingEvent);

        return true;
    }
}