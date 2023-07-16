package rp.cqrswriter.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Command {
    private Method method;
    private CommandParams params;
}
