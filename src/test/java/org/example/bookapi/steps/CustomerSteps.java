package org.example.bookapi.steps;

import org.example.bookapi.clients.CustomerClient;
import org.example.bookapi.support.ScenarioContext;

public class CustomerSteps {

    private final CustomerClient customerClient;
    private final ScenarioContext scenarioContext;

    public CustomerSteps(CustomerClient customerClient, ScenarioContext scenarioContext) {
        this.customerClient = customerClient;
        this.scenarioContext = scenarioContext;
    }
}
