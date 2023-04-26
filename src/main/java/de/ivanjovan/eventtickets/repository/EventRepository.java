package de.ivanjovan.eventtickets.repository;

import de.ivanjovan.eventtickets.model.Event;
import org.springframework.data.repository.ListCrudRepository;

public interface EventRepository extends ListCrudRepository<Event, Integer> {

}
