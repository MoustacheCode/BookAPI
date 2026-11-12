package org.example.bookapi.clients;

import io.restassured.http.ContentType;
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

    public Response createCustomer(String customerJson) {

        return given()
                .baseUri(environmentManager.baseUrl())
                .contentType(ContentType.JSON)
                .body(customerJson)
                .when()
                .post("/api/createcustomer");
    }

    public Response updateCustomer(int customerId, String customerJson) {

        return given()
                .baseUri(environmentManager.baseUrl())
                .pathParam("id", customerId)
                .contentType(ContentType.JSON)
                .body(customerJson)
                .when()
                .put("/api/customers/{id}");
    }

    public Response deleteCustomer(int customerId) {

        return given()
                .baseUri(environmentManager.baseUrl())
                .pathParam("id", customerId)
                .when()
                .delete("/api/customers/{id}");
    }




}
