import org.testng.annotations.Test;
import utils.BaseTest;
import wiremock.WireMockStubs;

import static io.restassured.RestAssured.given;

public class UsersTest extends BaseTest {
    @Test
    public void testUsersReturns200() {
        WireMockStubs.stubUsers200(wireMockServer);

        given()
                .when()
                .get("/users")
                .then()
                .statusCode(200);
    }

    @Test
    public void testUsersReturns500() {
        WireMockStubs.stubUsers500(wireMockServer);

        given()
                .when()
                .get("/users")
                .then()
                .statusCode(500);
    }
}
