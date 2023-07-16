package rp.cqrswriter.command;

import java.util.logging.Logger;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;
import rp.cqrswriter.model.CreateUserCommand;
import rp.cqrswriter.model.UserCreatedEvent;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
@NoArgsConstructor
public class User {

    private static final Logger log = Logger.getLogger(User.class.getName());

    @AggregateIdentifier
    private String email;
    private String firstName;
    private String lastName;

    @CommandHandler
    public User(CreateUserCommand command) {
        log.info("User created " + command.toString());
        apply(new UserCreatedEvent(command.getEmail(), command.getFirstName(), command.getLastName()));
    }

    @EventSourcingHandler
    public void on(UserCreatedEvent event) {
        email = event.getEmail();
        firstName = event.getFirstName();
        lastName = event.getLastName();
    }
}
