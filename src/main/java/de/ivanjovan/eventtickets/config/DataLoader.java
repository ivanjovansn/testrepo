package de.ivanjovan.eventtickets.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.ivanjovan.eventtickets.model.Event;
import de.ivanjovan.eventtickets.repository.EventRepository;
import java.io.InputStream;
import java.util.List;
import org.springframework.asm.TypeReference;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

  private final EventRepository repository;
  private final ObjectMapper mapper;

  public DataLoader(EventRepository repository, ObjectMapper mapper) {
    this.repository = repository;
    this.mapper = mapper;
  }

  @Override
  public void run(String... args) throws Exception {
    try (InputStream inputStream = TypeReference.class.getResourceAsStream("/data/event.json")) {
      repository.saveAll(mapper.readValue(inputStream,
          new com.fasterxml.jackson.core.type.TypeReference<List<Event>>() {
          }));
    }
  }
}
