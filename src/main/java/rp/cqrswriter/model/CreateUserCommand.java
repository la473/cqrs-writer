package rp.cqrswriter.model;

import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
public class CreateUserCommand{
    @TargetAggregateIdentifier private final  String email;
    private final String firstName;
    private final String lastName;
}
