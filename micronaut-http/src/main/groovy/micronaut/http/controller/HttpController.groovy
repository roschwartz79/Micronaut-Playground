package micronaut.http.controller

import io.micronaut.context.annotation.Parameter
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import jakarta.inject.Inject
import micronaut.http.service.MyService

@Controller("/do")
class HttpController {

    MyService myService

    @Inject
    HttpController(MyService myService) {
        this.myService = myService
    }

    @Get(uri = "callHello", produces = MediaType.TEXT_PLAIN)
    public String callHello() {
        return myService.callHello()
    }

    @Get(uri = "callHiWithName", produces = MediaType.TEXT_PLAIN)
    public String callHiWithName(@Parameter String name) {
        return myService.callHiWithName(name)
    }

    @Get(uri = "callHiWithName/{name}", produces = MediaType.TEXT_PLAIN)
    public String callHiWithNameInPath(@PathVariable String name) {
        return myService.callHiWithNameInPath(name)
    }
}
