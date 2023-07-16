package rp.cqrswriter.model;

import rp.cqrswriter.dto.CommandDto;

public class CommandFactory {

    public static Object create(CommandDto command) {
        if (command.getMethod() == Method.CREATE_ITEM && command.getParams().getDefinition() == Definition.user) {
            return new CreateUserCommand(
                    command.getParams().getValues().get("email"),
                    command.getParams().getValues().get("first-name"),
                    command.getParams().getValues().get("last-name")
            );
        }
        throw new IllegalArgumentException("Unknown method: " + command.getMethod());
    }
}
