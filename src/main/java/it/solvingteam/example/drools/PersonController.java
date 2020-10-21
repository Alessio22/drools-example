package it.solvingteam.example.drools;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.regex.Pattern;

@RestController
@RequestMapping("person")
public class PersonController {

    @Autowired
    private KieContainer kieContainer;

    @PostMapping
    public RuleEngineResponse validate(@RequestBody Person person) {
        RuleEngineResponse response = new RuleEngineResponse();
        KieSession session = kieContainer.newKieSession();
        session.insert(response);
        session.insert(person);
        session.fireAllRules();
        return response;
    }

}
