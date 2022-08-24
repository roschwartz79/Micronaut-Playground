package micronaut.http.service

import com.micronaut.playground.client.Client
import jakarta.inject.Inject
import jakarta.inject.Singleton

@Singleton
class MyService {

    @Inject
    Client client

    String callHello() {
        return client.sayHello().execute().body()
    }

    String callHiWithName(String name) {
        return client.sayHiToName(name).execute().body()
    }

    String callHiWithNameInPath(String name) {
        return client.sayHiToNameWithPath(name).execute().body()
    }
}
