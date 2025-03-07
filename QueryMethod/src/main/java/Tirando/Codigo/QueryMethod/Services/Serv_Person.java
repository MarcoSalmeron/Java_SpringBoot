package Tirando.Codigo.QueryMethod.Services;

import Tirando.Codigo.QueryMethod.DTOs.Person_EmployeeDTO;
import Tirando.Codigo.QueryMethod.Models.Employee;
import Tirando.Codigo.QueryMethod.Models.Person;
import Tirando.Codigo.QueryMethod.Repositories.Repo_Employee;
import Tirando.Codigo.QueryMethod.Repositories.Repo_Person;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//Servicio con CRUD de Personas//
@Service
public class Serv_Person implements Serv_Person_Interface{

    //Inyectar Dependencias//
    @Autowired
    private Repo_Person repoPerson;

    @Autowired
    private Repo_Employee repoEmployee;

    //Mostrar//
    @Override
    public List<Person> getPersons() {
        return repoPerson.findAll();
    }

    //Buscar//
    @Override
    public Person findPerson(Long ID) {
        return repoPerson.findById(ID).orElseThrow(() -> new EntityNotFoundException("Persona con ID Inexistente: "+ID));
    }

    //Guardar//
    @Override
    public Person savePerson(Person_EmployeeDTO personDTO) {
        Person person = new Person();
        person.setFirst_name(personDTO.getFirst_name());
        person.setLast_name(personDTO.getLast_name());
        person.setNumber(personDTO.getNumber());
        person.setAddress(personDTO.getAddress());
        person.setEmail(personDTO.getEmail());
        repoPerson.save(person);

        Employee emp = new Employee();
        emp.setRole(personDTO.getRole());
        emp.setUser(personDTO.getUser());
        emp.setPassword(personDTO.getPassword());
        emp.setSalary(personDTO.getSalary());
        emp.setPerson(person);
        repoEmployee.save(emp);

        return person;
    }

    //Editar Persona//
    @Override
    public Person editPerson(Person person) {
        return repoPerson.save(person);
    }

    //Editar Empleado//
    @Override
    public Employee editEmployee(Employee employee) {
        // Busca el empleado existente con su relación cargada
        Employee existingEmployee = repoEmployee.findById(employee.getID())
                .orElseThrow(() -> new EntityNotFoundException("Empleado no encontrado con ID: " + employee.getID()));

        // Mantén la relación con Person existente
        if (existingEmployee.getPerson() != null) {
            employee.setPerson(existingEmployee.getPerson());
        }

        // Actualiza los demás campos
        existingEmployee.setRole(employee.getRole());
        existingEmployee.setUser(employee.getUser());
        existingEmployee.setPassword(employee.getPassword());
        existingEmployee.setSalary(employee.getSalary());

        // Guarda los cambios
        return repoEmployee.save(existingEmployee);
    }


    //Borrar//
    @Override
    public void deletePerson(Long ID) {
        repoPerson.deleteById(ID);
    }

    //Buscar por Email//
    @Override
    public Person findByEmail(String email) {
        return repoPerson.findByEmail(email);
    }

    //Buscar por Numero//
    @Override
    public Person findByNumber(Long number) {
        return repoPerson.findByNumber(number);
    }

    //Buscar por Rol//
    @Override
    public List<Employee> findEmployeeByRole(String role) {
        return repoEmployee.findByRole(role);
    }

    //Buscar por Usuario
    @Override
    public Employee findEmployeeByUser(String user) {
        return repoEmployee.findByUser(user);
    }
}
