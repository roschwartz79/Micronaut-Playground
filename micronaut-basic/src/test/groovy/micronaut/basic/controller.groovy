package micronaut.basic

import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.http.uri.UriMatchTemplate
import io.micronaut.runtime.server.EmbeddedServer
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import spock.lang.Specification

@MicronautTest
class controller extends Specification {

    @Inject
    EmbeddedServer server

    @Inject
    @Client("/")
    HttpClient client

    void "I can hit my endpoints!"() {
        given:
        String uri = "hello"

        when:
        String response = client.toBlocking().retrieve(uri)

        then:
        assert response == "Hi there!"
    }

}
