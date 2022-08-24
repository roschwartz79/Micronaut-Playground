## In this module I'll be experimenting with making HTTP calls from Micronaut to another application.

To create this app I ran `mn create-app micronaut-http -b gradle --test spock --lang groovy --features http-client`

This App is configured to run on port 8081.

In order to successfully run this module, you also need to run the `micronaut-basic` app in a separate terminal.
Then you can make the HTTP calls to this module, which in turn the service will call the micronaut basic endpoints.

## Micronaut 3.6.0 Documentation

- [User Guide](https://docs.micronaut.io/3.6.0/guide/index.html)
- [API Reference](https://docs.micronaut.io/3.6.0/api/index.html)
- [Configuration Reference](https://docs.micronaut.io/3.6.0/guide/configurationreference.html)
- [Micronaut Guides](https://guides.micronaut.io/index.html)
---

- [Shadow Gradle Plugin](https://plugins.gradle.org/plugin/com.github.johnrengelman.shadow)
## Feature http-client documentation

- [Micronaut HTTP Client documentation](https://docs.micronaut.io/latest/guide/index.html#httpClient)


