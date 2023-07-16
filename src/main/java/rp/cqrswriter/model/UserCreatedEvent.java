package rp.cqrswriter.model;

import lombok.Data;

@Data
public class UserCreatedEvent{
    private final String email;
    private final String firstName;
    private final String lastName;
}
