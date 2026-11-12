package org.example.bookapi.support;

import io.restassured.response.Response;
import org.springframework.stereotype.Component;

@Component
public class ScenarioContext {

    private Response response;

    public void setResponse(Response response) {
        this.response = response;
    }

    public Response getResponse() {
        return response;
    }
}
