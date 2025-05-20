package FuturoDigital.Employees.Services;

import FuturoDigital.Employees.Models.Person;
import FuturoDigital.Employees.Repositories.Repo_Person;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Person_Service {

    private final Repo_Person repoPerson;

    public List<Person> getAll(){
        return repoPerson.findAll();
    }

    public Person findPerson(Long ID){
        return repoPerson.findById(ID)
                .orElseThrow(()->new EntityNotFoundException("ID Inexistente!!! ["+ID+"]"));
    }

    public Person savePerson(Person person){
        return repoPerson.save(person);
    }

    public String deletePerson(Long ID){
        repoPerson.deleteById(ID);
        return "Person Deleted";
    }
}
