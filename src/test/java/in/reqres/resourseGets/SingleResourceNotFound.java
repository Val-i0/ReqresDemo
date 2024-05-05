package in.reqres.resourseGets;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class SingleResourceNotFound {
    static final String BASE_URL = "https://reqres.in/api";

    @Test
    public void someHeadersSingleResourceNotFound() {
        RestAssured.get(BASE_URL + "/unknown/23")
                .prettyPeek()
                .then()
                .statusCode(404)
                .headers("Content-Type", "application/json; charset=utf-8",
                        "Content-Length", "2",
                        "Connection", "keep-alive",
                        "Nel", "{\"report_to\":\"heroku-nel\",\"max_age\":3600,\"success_fraction\":0.005,\"failure_fraction\":0.05,\"response_headers\":[\"Via\"]}",
                        "Access-Control-Allow-Origin", "*",
                        "CF-Cache-Status", "HIT",
                        "Server", "cloudflare",
                        "Via", "1.1 vegur")
                .body(equalTo("{}"));
    }
}
