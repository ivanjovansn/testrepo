package de.ivanjovan.eventtickets.repository;

import de.ivanjovan.eventtickets.model.Event;
import de.ivanjovan.eventtickets.model.Status;
import jakarta.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class EventCollectionRepository {

  private final List<Event> eventList = new ArrayList<>();

  public EventCollectionRepository() {
    // default constructor
  }

  public List<Event> findAll() {
    return this.eventList;
  }

  public Optional<Event> findById(Integer id) {
    return this.eventList.stream().filter(event -> event.id().equals(id)).findFirst();
  }

  public void save(Event event) {
    this.eventList.removeIf(e -> e.id().equals(event.id()));
    this.eventList.add(event);
  }


  @PostConstruct
  private void init() {
    Event e = new Event(
        1,
        "Test Event 1",
        "Description of Test Event 1",
        LocalDate.now(),
        Status.AVAILABLE);

    this.eventList.add(e);
  }

  public boolean existsById(Integer id) {
    return this.eventList.stream().filter(event -> event.id().equals(id)).count() == 1;
  }

  public void delete(Integer id) {
    this.eventList.removeIf(e -> e.id().equals(id));
  }
}
