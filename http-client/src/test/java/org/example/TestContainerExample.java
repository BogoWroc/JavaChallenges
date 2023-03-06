package org.example;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.mockserver.client.MockServerClient;
import org.testcontainers.containers.MockServerContainer;
import org.testcontainers.utility.DockerImageName;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;


class TestContainerExample {

    public static final DockerImageName MOCKSERVER_IMAGE = DockerImageName
            .parse("mockserver/mockserver")
            .withTag(MockServerClient.class.getPackage().getImplementationVersion());

    @Rule
    public MockServerContainer mockServer = new MockServerContainer(MOCKSERVER_IMAGE);


    @Test
    public void shouldCallActualMockserverVersion() throws Exception {
        try (MockServerContainer mockServer = new MockServerContainer(MOCKSERVER_IMAGE)) {
            mockServer.start();

            String expectedBody = "Hello World!";

            try (MockServerClient client = new MockServerClient(mockServer.getHost(), mockServer.getServerPort())) {
                assertThat(client.hasStarted()).as("Mockserver running").isTrue();

                client.when(request().withPath("/hello")).respond(response().withBody(expectedBody));

                assertThat(SimpleHttpClient.responseFromServer(mockServer.getEndpoint() + "/hello"))
                        .as("MockServer returns correct result")
                        .isEqualTo(expectedBody);
            }
        }
    }

    @Test
    public void newVersionStartsWithDefaultWaitStrategy() {
        try (MockServerContainer mockServer = new MockServerContainer(MOCKSERVER_IMAGE)) {
            mockServer.start();
        }
    }


    @Test
    void should_execute_http_request_via_simple_http_client() throws URISyntaxException, IOException, InterruptedException {

        try (MockServerContainer mockServer = new MockServerContainer(MOCKSERVER_IMAGE)) {
            mockServer.start();
            try (
                    MockServerClient mockServerClient = new MockServerClient(mockServer.getHost(), mockServer.getServerPort())
            ) {
                mockServerClient
                        .when(request().withPath("/person").withQueryStringParameter("name", "peter"))
                        .respond(response().withBody("Peter the person!"));

                // ...a GET request to '/person?name=peter' returns "Peter the person!"
                //new URL(mockServer.getEndpoint() + path)
                assertThat(SimpleHttpClient.responseFromServer(mockServer.getEndpoint() + "/person?name=peter").body())
                        .as("Expectation returns expected response body")
                        .contains("Peter the person");
            }
        }

    }

}
