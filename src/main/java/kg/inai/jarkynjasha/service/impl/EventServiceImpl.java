package kg.inai.jarkynjasha.service.impl;

import kg.inai.jarkynjasha.entity.Event;
import kg.inai.jarkynjasha.exception.RecordNotFoundException;
import kg.inai.jarkynjasha.repository.EventRepository;
import kg.inai.jarkynjasha.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {
    @Autowired
    private EventRepository eventRepository;

    @Override
    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    @Override
    public Event getEventById(Long id) {
        return eventRepository.findById(id).orElseThrow(() ->
                new RecordNotFoundException("Record not found with id:" + id));
    }

    @Override
    public void putById(Long id, Event event) {
        eventRepository.findById(id)
                .map(newNews -> {
                    newNews.setTitle(event.getTitle());
                    newNews.setDescription(event.getDescription());
                    newNews.setImage(event.getImage());
                    newNews.setEventDate(event.getEventDate());
                    return eventRepository.save(newNews);
                })
                .orElseThrow(() ->
                        new RecordNotFoundException("Record not found with id:" + id));
    }

    @Override
    public void create(Event event) {
        eventRepository.save(event);
    }

    @Override
    public String deleteById(Long id) {
        eventRepository.deleteById(id);
        return "Organization number " + id + " has been deleted!";
    }
}
