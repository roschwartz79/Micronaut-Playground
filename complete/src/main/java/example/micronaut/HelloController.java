package example.micronaut;

import io.micronaut.context.BeanContext;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;

@Controller
public class HelloController {
    @Get("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String index() {
        return "Hello World";
    }

    // This is an example of dependecy injection within micronaut
    @Get("/vehicle")
    @Produces(MediaType.TEXT_PLAIN)
    public String vehicle() {

        // Micronaut automatically discovers the dependency we want to inject. We simply look up the bean we want to get using getBean
        // and it returns it for us!
        final BeanContext context = BeanContext.run();
        Vehicle vehicle = context.getBean(Vehicle.class);
        System.out.println(vehicle.start());

        return vehicle.start();
    }

}
