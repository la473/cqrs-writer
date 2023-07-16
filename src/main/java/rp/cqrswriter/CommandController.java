package rp.cqrswriter;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rp.cqrswriter.dto.CommandDto;
import rp.cqrswriter.model.CommandFactory;

@RestController
@RequestMapping("/command")
public class CommandController {

    private final CommandGateway commandGateway;

    public CommandController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping
    public void create(@RequestBody CommandDto dto) {
        commandGateway.sendAndWait(CommandFactory.create(dto));
    }
}
