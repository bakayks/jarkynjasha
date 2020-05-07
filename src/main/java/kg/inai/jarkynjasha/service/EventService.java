package kg.inai.jarkynjasha.service;
import kg.inai.jarkynjasha.entity.Event;

import java.util.List;

public interface EventService {
    List<Event> findAll();

    Event getEventById(Long id);

    void putById(Long id, Event event);

    void create(Event event);

    String deleteById(Long id);
}
