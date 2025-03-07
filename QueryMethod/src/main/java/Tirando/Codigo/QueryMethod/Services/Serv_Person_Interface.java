package Tirando.Codigo.QueryMethod.Services;

import Tirando.Codigo.QueryMethod.DTOs.Person_EmployeeDTO;
import Tirando.Codigo.QueryMethod.Models.Employee;
import Tirando.Codigo.QueryMethod.Models.Person;

import java.util.List;

//Interfaz a Implementar Metodos//
public interface Serv_Person_Interface {

    //Mostrar//
    public List<Person> getPersons();

    //Buscar//
    public Person findPerson(Long ID);

    //Guardar//
    public Person savePerson(Person_EmployeeDTO personDTO);

    //Editar Persona//
    public Person editPerson(Person person);

    //Editar Empleado//
    public Employee editEmployee(Employee employee);

    //Borrar//
    public void deletePerson(Long ID);

    //QuertMethods//
    public Person findByEmail(String email);

    public Person findByNumber(Long number);

    public List<Employee> findEmployeeByRole(String role);

    public Employee findEmployeeByUser(String user);
}
