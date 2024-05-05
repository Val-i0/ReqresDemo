package in.reqres.userGets;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.util.Map;

import static org.hamcrest.Matchers.equalTo;

public class SingleUserNotFound {
    static final String BASE_URL = "https://reqres.in/api";

    @Test
    public void checkSomeSingleUserHeader() { // not all headers
        Map<String, String> myMap = Map.of("Content-Type", "application/json; charset=utf-8",
                "Content-Length", "2",
                "Connection", "keep-alive",
                "X-Powered-By", "Express",
                "Vary", "Accept-Encoding",
                "Server", "cloudflare");
        RestAssured
                .given()
                .pathParams("endpoint", "users", "id", "23")
                .get(BASE_URL + "/{endpoint}/{id}")
                .prettyPeek()
                .then()
                .statusCode(404)
                .headers(myMap)
                .body(equalTo("{}"));
    }
}
