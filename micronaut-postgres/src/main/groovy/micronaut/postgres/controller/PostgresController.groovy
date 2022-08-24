package micronaut.postgres.controller

import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import io.micronaut.context.annotation.Parameter
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*
import io.micronaut.scheduling.TaskExecutors
import io.micronaut.scheduling.annotation.ExecuteOn
import jakarta.inject.Inject
import micronaut.postgres.dto.Person
import micronaut.postgres.repository.PeopleRepository

@Controller("/postgres")
@CompileStatic
@ExecuteOn(TaskExecutors.IO) // Any IO operations are offloaded to a separate thread pool to not block the event loop
@Slf4j
class PostgresController {

    protected final PeopleRepository peopleRepository

    @Inject
    PostgresController(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository
    }

    @Get("/{name}")
    Optional<Person> getPerson(@PathVariable String name) {
        return peopleRepository.findById(name)
    }

    @Get("/age")
    Optional<List<Person>> getPeopleByAge(@Parameter Integer age) {
        return Optional.of(peopleRepository.findAllByAge(age))
    }

    @Get("/age/greater")
    Optional<List<Person>> getPeopleByAgeGreaterThan(@Parameter Integer age) {
        return Optional.of(peopleRepository.findByAgeGreaterThan(age))
    }

    @Get("/age/ordered")
    Optional<List<Person>> getPeopleOrdered() {
        return Optional.of(peopleRepository.listOrderByAgeDesc())
    }

    @Get("/names/greater")
    Optional<List<String>> getNamesOfPeopleOlderThanAge(@Parameter Integer age) {
        return Optional.of(peopleRepository.findNameByAgeGreaterThan(age))
    }

    @Get("/people/explicit")
    Optional<List<Person>> getPeopleFromExplicitQuery(@Parameter String name) {
        return Optional.of(peopleRepository.listPeopleWithName(name))
    }

    @Put
    HttpResponse updatePerson(@Body Person person) {
        peopleRepository.update(person)

        HttpResponse.ok(person)
    }

    @Get('/list')
    List<Person> list() {
        peopleRepository.findAll()
    }

    @Post
    HttpResponse<Person> savePerson(@Body Person person) {
        Person personAdded = peopleRepository.save(person)

        HttpResponse.created(personAdded)
    }

}
