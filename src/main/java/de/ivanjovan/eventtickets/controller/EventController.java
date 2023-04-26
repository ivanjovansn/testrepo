package de.ivanjovan.eventtickets.controller;

import de.ivanjovan.eventtickets.model.Event;
import de.ivanjovan.eventtickets.repository.EventRepository;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/event")
public class EventController {

  private final EventRepository repository;

  public EventController(EventRepository repository) {
    this.repository = repository;
  }

  @GetMapping("")
  public List<Event> findAll() {
    return this.repository.findAll();
  }

  @GetMapping("/{id}")
  public Event findById(@PathVariable Integer id) {
    return this.repository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found!"));
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping("")
  public void create(@Valid @RequestBody Event event) {
    this.repository.save(event);
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PutMapping("/{id}")
  public void update(@RequestBody Event event, @PathVariable Integer id) {
    if (!this.repository.existsById(id)) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found!");
    }
    this.repository.save(event);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Integer id) {
    if (!this.repository.existsById(id)) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found!");
    }
    this.repository.deleteById(id);
  }


}
