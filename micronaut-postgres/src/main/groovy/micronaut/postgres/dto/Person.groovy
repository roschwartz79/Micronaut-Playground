package micronaut.postgres.dto

import groovy.transform.CompileStatic
import io.micronaut.core.annotation.Introspected
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity

import javax.validation.constraints.NotNull

@CompileStatic
@Introspected // This is needed for micronaut to know the right return type at compile time
@MappedEntity(value = "people") // My object name is a Person, but the table name is actually people
class Person {

    @NotNull
    @Id
    String name

    @NotNull
    Integer age

    Person(String name, Integer age) {
        this.name = name
        this.age = age
    }

    Person() {

    }

    String getName(){
        return this.name
    }

    Integer getAge(){
        return this.age
    }
}
