package it.solvingteam.example.drools;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class RuleEngineResponse {
    private List<String> errors;

    public RuleEngineResponse() {
        errors = new ArrayList<>();
    }
}
