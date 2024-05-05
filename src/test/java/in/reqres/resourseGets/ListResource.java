package in.reqres.resourseGets;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class ListResource {
    static final String BASE_URL = "https://reqres.in/api";

    @Test
    public void listResourceVerifySomeHeaders() {
        RestAssured
                .given()
                .pathParam("endpoint", "unknown")
                .get(BASE_URL + "/{endpoint}")
                .prettyPeek()
                .then()
                .statusCode(200)
                .headers("Content-Type", "application/json; charset=utf-8",
                        "Transfer-Encoding", "chunked",
                        "Connection", "keep-alive",
                        "Nel", "{\"report_to\":\"heroku-nel\",\"max_age\":3600,\"success_fraction\":0.005,\"failure_fraction\":0.05,\"response_headers\":[\"Via\"]}",
                        "Access-Control-Allow-Origin", "*",
                        "CF-Cache-Status", "HIT",
                        "Server", "cloudflare");
    }
}
