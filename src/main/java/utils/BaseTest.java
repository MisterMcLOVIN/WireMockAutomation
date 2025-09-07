package utils;

import com.github.tomakehurst.wiremock.WireMockServer;
import io.restassured.RestAssured;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import static com.github.tomakehurst.wiremock.client.WireMock.configureFor;


public class BaseTest {
    protected WireMockServer wireMockServer;
    protected String baseUri;

    @BeforeClass
    public void setupServer() {
        wireMockServer = new WireMockServer(8080);
        wireMockServer.start();
        configureFor("localhost", 8080);
        baseUri = "http://localhost:8080";
        RestAssured.baseURI = baseUri;
    }

    @AfterClass
    public void stopServer() {
        if (wireMockServer != null) {
            wireMockServer.stop();
        }
    }

    @BeforeMethod
    public void resetStubs() {
        wireMockServer.resetAll();
    }
}
