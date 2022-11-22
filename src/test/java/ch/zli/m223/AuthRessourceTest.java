package ch.zli.m223;

import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import org.gradle.internal.impldep.javax.annotation.meta.When;

public class AuthRessourceTest {
    @Test
    public void testPostLogin() {
        given()
                .contentType(ContentType.JSON)
                .when()
                .post("http://localhost:8080/login?mdaughtrey1@jigsy.com&password=CZZUwUxDS2c")
                .then()
                .statusCode(404);
    }

    @Test
    public void testPostRegister() {
        given()
                .body("{\"firstname\":\"Missy\",\"lastname\":\"Daughtrey\", \"email\":\"mdaughtrey1@jigsy.com\", \"passwort\":\"admin123\",\"isAdmin\":\"CZZUwUxDS2c\"}")
                .contentType(ContentType.JSON)
                .when()
                .post("http://localhost:8080/auth/register")
                .then()
                .statusCode(200);
    }
}