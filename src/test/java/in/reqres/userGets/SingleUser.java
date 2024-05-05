package in.reqres.userGets;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class SingleUser {
    static final String BASE_URL = "https://reqres.in/api";

    @Test
    public void basicPeek() {
        RestAssured.get(BASE_URL + "/users/1").prettyPeek();
    }

    @Test
    public void validateSomeHeaders() { // not all headers, no need
        RestAssured.get(BASE_URL + "/users/1")
                .prettyPeek()
                .then()
                .statusCode(200)
                .headers("Content-Type", "application/json; charset=utf-8",
                        "Transfer-Encoding", "chunked",
                        "Connection", "keep-alive",
                        "Report-To", "{\"group\":\"heroku-nel\",\"max_age\":3600,\"endpoints\":[{\"url\":\"https://nel.heroku.com/reports?ts=1714673524&sid=c4c9725f-1ab0-44d8-820f-430df2718e11&s=CVFvLB%2B6T154DFpy%2Bp4Hgoga9yOsFhIuZiM%2B2FAbiv8%3D\"}]}",
                        "Reporting-Endpoints", "heroku-nel=https://nel.heroku.com/reports?ts=1714673524&sid=c4c9725f-1ab0-44d8-820f-430df2718e11&s=CVFvLB%2B6T154DFpy%2Bp4Hgoga9yOsFhIuZiM%2B2FAbiv8%3D",
                        "X-Powered-By", "Express",
                        "Access-Control-Allow-Origin", "*",
                        "Via", "1.1 vegur")
                .contentType("application/json; charset=utf-8"); // duplicated above, just for test

    }
}
