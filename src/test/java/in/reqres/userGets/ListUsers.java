package in.reqres.userGets;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static org.testng.AssertJUnit.assertEquals;

public class ListUsers {
    static final String BASE_URL = "https://reqres.in/api";

    @Test
    void basicPeek() {
        RestAssured.get(BASE_URL + "/users").peek();
    }

    @Test
    void basicAssertPeek() {
        Response response = RestAssured.get(BASE_URL + "/users");
        assertEquals(response.getStatusCode(), 200);
        assertEquals(response.getHeader("access-control-allow-origin"), "*");
        assertEquals(response.getHeader("cache-control"), "max-age=14400");
        assertEquals(response.getHeader("cf-cache-status"), "HIT");
        assertEquals(response.getHeader("content-encoding"), "gzip");
        assertEquals(response.getContentType(), "application/json; charset=utf-8");
        // etc
    }

    @Test
    public void hardParams() {
        RestAssured.get(BASE_URL + "/users?page=2&per_page=2")
                .peek()
                .then()
                .statusCode(200)
                .headers(
                        "Transfer-Encoding", "chunked",
                        "Connection", "keep-alive",
                        "X-Powered-By", "Express",
                        "Server", "cloudflare"
                );

    }

    @Test
    public void paramsWithMap() {
        Map<String, String> myMap = Map.of("Transfer-Encoding", "chunked",
        "Connection", "keep-alive",
        "X-Powered-By", "Express");
        RestAssured
                .given()
                .param("page", "2")
                .param("per_page", "3")
                .get(BASE_URL + "/users")
                .then()
                .statusCode(200)
                .headers(myMap);
    }

}
