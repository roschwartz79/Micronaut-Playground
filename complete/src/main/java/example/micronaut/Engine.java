/**
 * This interface and local classes represent dependency injection. The singleton annotation means there will only ever be 1 instance of each of the classes.
 * So when a new Vehicle instance is created, it will get the single engine instance we setup. So in our controller when we create a new Vehicle
 * in our HelloController, we get a single instance of vehicle which in turn gets a single instance of our V8Engine.
 */

package example.micronaut;

import javax.inject.Singleton;

public interface Engine {
    int getCylinders();
    String start();
}

@Singleton
class V8Engine implements Engine {

    @Override
    public int getCylinders() {
        return cylinders;
    }

    @Override
    public String start() {
        return "Starting V8";
    }

    private int cylinders = 8;
}

@Singleton
class Vehicle {
    private final Engine engine;

    public Vehicle(Engine engine){
        this.engine = engine;
    }

    public String start() {
        return engine.start();
    }


}
