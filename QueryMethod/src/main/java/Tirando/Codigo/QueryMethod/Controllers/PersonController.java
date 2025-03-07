package Tirando.Codigo.QueryMethod.Controllers;

import Tirando.Codigo.QueryMethod.DTOs.Person_EmployeeDTO;
import Tirando.Codigo.QueryMethod.Models.Employee;
import Tirando.Codigo.QueryMethod.Models.Person;
import Tirando.Codigo.QueryMethod.Services.Serv_Person_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Controlar Peticiones http//
@RestController
@RequestMapping(path = "/api/persons")
public class PersonController {

    //Inyectar Dependencias//
    @Autowired
    private Serv_Person_Interface servPerson;

    @RequestMapping(path = "/All", method = RequestMethod.GET)
    public List<Person> All(){
        return servPerson.getPersons();
    }

    @RequestMapping(path = "/Find/{ID}", method = RequestMethod.GET)
    public Person Find(@PathVariable Long ID){
        return servPerson.findPerson(ID);
    }

    @RequestMapping(path = "/Save", method = RequestMethod.PUT)
    public Person Save(@RequestBody Person_EmployeeDTO personDTO){
        return servPerson.savePerson(personDTO);
    }

    @RequestMapping(path = "/Edit/Person", method = RequestMethod.PUT)
    public Person EditPerson(@RequestBody Person person){
        return servPerson.editPerson(person);
    }

    @RequestMapping(path = "/Edit/Employee", method = RequestMethod.PUT)
    public Employee EditEmployee(@RequestBody Employee employee){
        return servPerson.editEmployee(employee);
    }

    @RequestMapping(path = "/Delete/{ID}", method = RequestMethod.DELETE)
    public String Delete(@PathVariable Long ID){
        servPerson.deletePerson(ID);
        return "Persona Borrada";
    }

    @RequestMapping(path = "/Find/Email/{email}", method = RequestMethod.GET)
    public Person FindEmail(@PathVariable String email){
        return servPerson.findByEmail(email);
    }

    @RequestMapping(path = "/Find/Number/{number}", method = RequestMethod.GET)
    public Person FindNumber(@PathVariable Long number){
        return servPerson.findByNumber(number);
    }

    @RequestMapping(path = "/Find/Role/{role}", method = RequestMethod.GET)
    public List<Employee> FindRole(@PathVariable String role){
        return servPerson.findEmployeeByRole(role);
    }

    @RequestMapping(path = "/Find/User/{user}", method = RequestMethod.GET)
    public Employee FindUser(@PathVariable String user){
        return servPerson.findEmployeeByUser(user);
    }

}
