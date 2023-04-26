package de.ivanjovan.eventtickets;

import de.ivanjovan.eventtickets.config.EventTicketsProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(EventTicketsProperties.class)
@SpringBootApplication
public class EventticketsApplication {

  public static void main(String[] args) {
    SpringApplication.run(EventticketsApplication.class, args);
  }
}
