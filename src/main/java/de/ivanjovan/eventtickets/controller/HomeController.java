package de.ivanjovan.eventtickets.controller;

import de.ivanjovan.eventtickets.config.EventTicketsProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

  private final EventTicketsProperties properties;

  public HomeController(EventTicketsProperties properties) {
    this.properties = properties;
  }

  @GetMapping("/")
  public EventTicketsProperties home() {
    return properties;
  }
}
