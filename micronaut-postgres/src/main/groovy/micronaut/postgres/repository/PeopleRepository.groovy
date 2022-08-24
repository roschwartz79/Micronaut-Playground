package micronaut.postgres.repository

import io.micronaut.core.annotation.NonNull
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.Query
import io.micronaut.data.jdbc.annotation.JdbcRepository
import io.micronaut.data.model.query.builder.sql.Dialect
import io.micronaut.data.repository.CrudRepository
import jakarta.annotation.Nonnull
import micronaut.postgres.dto.Person

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
/**
 * Check the docs!!! https://micronaut-projects.github.io/micronaut-data/latest/guide/#querying
 */

@JdbcRepository(dialect = Dialect.POSTGRES)
interface PeopleRepository extends CrudRepository<Person, String> {

    // Inserting - idk which one is best practice yet
    Person save(@NonNull @NotBlank String name, @NonNull Integer age)

    Person save(@NotNull Person person)

    // Updating - since name is the ID the name won't get changed but everything else will
    void update(@Id String name, @Nonnull Integer age)

    // Reading - this is where things are super cool

    // Get a Person where the name matches
    Person find(String name)

    // Get all people of a specific age
    List<Person> findAllByAge(Integer age)

    // Get all people that have an age greater than the given age
    List<Person> findByAgeGreaterThan(Integer age)

    // Get all the people
    List<Person> findAll()

    // Get a list of people Ordered by age in descending order
    List<Person> listOrderByAgeDesc()

    // Only get a list of names of entries that have an age greater than the given age
    List<String> findNameByAgeGreaterThan(int age)

    // Oh- you want an explicit query? FINE WE CAN DO THAT TOO
    // NOTE: specify params with : in front of ur param
    @Query("SELECT * FROM people p WHERE p.name = :name ORDER BY p.age")
    List<Person> listPeopleWithName(String name)

}
