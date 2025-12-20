package com.openmrs.qa.api;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class OpenMRSApiTest {

    @Test
    public void testSessionEndpoint() {
        // Test the session endpoint - this should return 401 (unauthorized) or session info
        given()
                .baseUri("https://demo.openmrs.org/openmrs/ws/rest/v1")
                .when()
                .get("/session")
                .then()
                .statusCode(anyOf(is(200), is(401)))
                .time(lessThan(10000L));
    }

    @Test
    public void testSystemInfoEndpoint() {
        // Test a public endpoint that doesn't require authentication
        given()
                .baseUri("https://demo.openmrs.org/openmrs/ws/rest/v1")
                .when()
                .get("/systemsetting")
                .then()
                .statusCode(anyOf(is(200), is(401)))
                .time(lessThan(10000L));
    }

    @Test
    public void testApiRootEndpoint() {
        // Test the root API endpoint - usually returns API info
        given()
                .baseUri("https://demo.openmrs.org/openmrs/ws/rest/v1")
                .when()
                .get("/")
                .then()
                .statusCode(200)
                .time(lessThan(10000L));
    }
}