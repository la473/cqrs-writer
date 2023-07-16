package rp.cqrswriter.model;

import java.util.Map;
import lombok.Data;

@Data
public class CommandParams {
    private Definition definition;
    private Map<String, String> values;
}
