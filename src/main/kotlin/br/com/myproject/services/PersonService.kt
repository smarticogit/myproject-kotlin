package br.com.myproject.services

import br.com.myproject.data.vo.v1.PersonVO
import br.com.myproject.exceptions.ResourceNotFoundException
import br.com.myproject.mapper.DozerMapper
import br.com.myproject.model.Person
import br.com.myproject.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong
import java.util.logging.Logger

@Service
class PersonService {

    @Autowired
    private lateinit var repository: PersonRepository

    private val logger = Logger.getLogger(PersonService::class.java.name)

    fun findAll(): List<PersonVO> {
        logger.info("finding all people")
        val persons = repository.findAll()
        return DozerMapper.parseListObjects(persons, PersonVO::class.java)
    }

    fun findById(id: Long) : PersonVO {
        logger.info("finding one person")
        var person = repository.findById(id) .orElseThrow({ResourceNotFoundException("No records found for this ID")})
        return DozerMapper.parseObject(person, PersonVO::class.java)
    }

    fun create(person: PersonVO) : PersonVO {
        logger.info("Creating one person with name ${person.firstName}")
        var entity: Person = DozerMapper.parseObject(person, Person::class.java)
        return DozerMapper.parseObject(repository.save(entity), PersonVO::class.java)
    }

    fun update(person: PersonVO) : PersonVO {
        logger.info("Updating one person with id ${person.id}")
        val entity = repository.findById(person.id) .orElseThrow({ResourceNotFoundException("No records found for this ID")})
        entity.firstName = person.firstName
        entity.lastName = person.lastName
        entity.address = person.address
        entity.gender = person.gender
        return DozerMapper.parseObject(repository.save(entity), PersonVO::class.java)
    }

    fun delete(id: Long) {
        logger.info("Deleting one person with ID ${id}")
        val entity = repository.findById(id) .orElseThrow({ResourceNotFoundException("No records found for this ID")})
        repository.delete(entity)
    }

}