package wiremock;

import com.github.tomakehurst.wiremock.WireMockServer;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class WireMockStubs {
    public static void stubUsers200(WireMockServer wireMockServer) {
        wireMockServer.stubFor(get(urlEqualTo("/users"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"message\":\"User list retrieved successfully\"}")));
    }

    public static void stubUsers500(WireMockServer wireMockServer) {
        wireMockServer.stubFor(get(urlEqualTo("/users"))
                .willReturn(aResponse()
                        .withStatus(500)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"error\":\"Internal Server Error\"}")));
    }
}
