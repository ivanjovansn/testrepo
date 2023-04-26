package de.ivanjovan.eventtickets.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(value = "et")
public record EventTicketsProperties(String welcomeMessage, String about) {

}
