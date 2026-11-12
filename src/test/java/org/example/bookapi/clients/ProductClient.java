package org.example.bookapi.clients;

import io.restassured.response.Response;
import org.example.bookapi.config.EnvironmentManager;
import org.springframework.stereotype.Component;

import static io.restassured.RestAssured.given;


// The ProductClient depends on EnvironmentManager,
// so I use constructor injection to have Spring provide that dependency when the client is created.
// I store it in a final field so the client can access configuration such as the base URL
// without creating or managing the EnvironmentManager itself.
@Component
public class ProductClient {

    private final EnvironmentManager environmentManager;

    public ProductClient(EnvironmentManager environmentManager) {
        this.environmentManager = environmentManager;
    }

    public Response getProducts() {

        return given()
                .baseUri(environmentManager.baseUrl())
                .when()
                .get("/api/products");
    }

    public Response getProductById(int productId) {

        return given()
                .baseUri(environmentManager.baseUrl())
                .pathParam("id", productId)
                .when()
                .get("api/products/{id}");
    }




}
