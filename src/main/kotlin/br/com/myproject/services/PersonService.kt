package br.com.myproject.services

import br.com.myproject.model.Person
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong
import java.util.logging.Logger

@Service
class PersonService {

    private val counter: AtomicLong = AtomicLong()

    private val logger = Logger.getLogger(PersonService::class.java.name)

    fun findAll(): List<Person> {
        logger.info("finding all people")

        val persons: MutableList<Person> = ArrayList()
        for (i in 0 .. 7 ) {
            val person = mockPerson(i)
            persons.add(person)
        }
        return persons
    }

    fun findById(id: Long): Person {
        logger.info("finding one person")

        val person = Person()
        person.id = counter.incrementAndGet()
        person.firstName = "Leandro"
        person.lastName = "Silveira"
        person.address = "Ferraz - SP"
        person.gender = "Male"
        return person
    }

    fun create(person: Person): Person {
        logger.info("Creating person")
        return person
    }


    fun update(person: Person) = person

    fun delete(id: Long) {}


    private fun mockPerson(i: Int): Person {
        val person = Person()
        person.id = counter.incrementAndGet()
        person.firstName = "Person Name $i"
        person.lastName = "Last Name $i"
        person.address = "Ferraz - SP"
        person.gender = "Male"
        return person
    }
}