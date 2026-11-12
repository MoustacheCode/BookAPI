package org.example.bookapi.clients;

import io.restassured.response.Response;
import org.example.bookapi.config.EnvironmentManager;
import org.springframework.stereotype.Component;

import static io.restassured.RestAssured.given;

@Component
public class CustomerClient {

    private final EnvironmentManager environmentManager;

    public CustomerClient(EnvironmentManager environmentManager) {
        this.environmentManager = environmentManager;
    }

    public Response getCustomers() {

        return given()
                .baseUri(environmentManager.baseUrl())
                .when()
                .get("/api/customers");
    }





    public Response getCustomerById(int customerId) {

        return given()
                .baseUri(environmentManager.baseUrl())
                .pathParam("id", customerId)
                .when()
                .get("/api/customers/{id}");

    }




}
