package in.reqres.crud;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class Crud {
    static final String BASE_URL = "https://reqres.in/api";

    @Test
    public void createUser() {
        RestAssured
                .given()
                .body("{\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"leader\"\n" +
                        "}")
                .when()
                .post(BASE_URL + "/users")
                .prettyPeek()
                .then()
                .statusCode(201)
                .contentType("application/json; charset=utf-8")
                .headers("Content-Length", "51",
                        "Connection", "keep-alive",
                        "CF-Cache-Status", "DYNAMIC",
                        "Server", "cloudflare",
                        "Via", "1.1 vegur",
                        "CF-RAY", containsString("SOF"));
    }

    @Test
    public void updateUserWithPut() {
        RestAssured
                .given()
                .body("{\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"zion resident\"\n" +
                        "}")
                .pathParams("ep", "users",
                        "id", "2")
                .when()
                .put(BASE_URL + "/{ep}/{id}")
                .prettyPeek()
                .then()
                .statusCode(200)
                .headers("Via", "1.1 vegur",
                        "CF-Cache-Status", "DYNAMIC",
                        "Vary", "Accept-Encoding",
                        "Server", "cloudflare",
                        "CF-RAY", containsString("SOF"))
                .body(containsString("updatedAt"));
    }

    @Test
    public void updateUserWithPatch() {
        RestAssured
                .given()
                .body("{\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"zion resident\"\n" +
                        "}")
                .pathParams("ep", "users",
                        "id", "2")
                .when()
                .patch(BASE_URL + "/{ep}/{id}")
                .prettyPeek()
                .then()
                .statusCode(200)
                .headers("Via", "1.1 vegur",
                        "CF-Cache-Status", "DYNAMIC",
                        "Access-Control-Allow-Origin", "*",
                        "Server", "cloudflare",
                        "CF-RAY", containsString("SOF"))
                .body(containsString("updatedAt"));
    }

    @Test
    public void deleteUser() {
        RestAssured
                .given()
                .pathParams("ep", "users",
                        "id", "2")
                .when()
                .delete(BASE_URL + "/{ep}/{id}")
                .prettyPeek()
                .then()
                .statusCode(204)
                .body(emptyOrNullString())
                .headers("Content-Length", "0",
                        "Connection", "keep-alive",
                        "X-Powered-By", "Express",
                        "Access-Control-Allow-Origin", "*",
                        "Etag", "W/\"2-vyGp6PvFo4RvsFtPoIWeCReyIC8\"",
                        "Via", "1.1 vegur",
                        "CF-Cache-Status", "DYNAMIC",
                        "Server", "cloudflare",
                        "CF-RAY", containsString("-SOF"));
    }
}
