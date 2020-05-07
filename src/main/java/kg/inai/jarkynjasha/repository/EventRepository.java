package kg.inai.jarkynjasha.repository;

import kg.inai.jarkynjasha.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
