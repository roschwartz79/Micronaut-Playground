package micronaut.basic.controller

import io.micronaut.context.annotation.Parameter
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/hello")
class HelloController {

    @Get(produces = MediaType.TEXT_PLAIN)
    public String sayHello() {
        return "Hi there!"
    }

    @Get(value = "/name", produces = MediaType.TEXT_PLAIN)
    public String sayHi(@Parameter String name) {
        return "Hi, ${name}"
    }

    @Get(value = "/{name}", produces = MediaType.TEXT_PLAIN)
    String hello(String name) {
        return "Hello $name!"
    }

}
