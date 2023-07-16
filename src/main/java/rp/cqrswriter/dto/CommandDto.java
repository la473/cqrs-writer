package rp.cqrswriter.dto;

import lombok.Data;
import rp.cqrswriter.model.Method;
import rp.cqrswriter.model.CommandParams;

@Data
public class CommandDto {
    private Method method;
    private CommandParams params;
}
