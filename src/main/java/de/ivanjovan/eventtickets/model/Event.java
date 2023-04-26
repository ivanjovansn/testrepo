package de.ivanjovan.eventtickets.model;

import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;
import org.springframework.data.annotation.Id;

public record Event(
    @Id
    Integer id,
    @NotBlank
    String name,
    String description,
    LocalDate heldOn,
    Status status

) {

}
