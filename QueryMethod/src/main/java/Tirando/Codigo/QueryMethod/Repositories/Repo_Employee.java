package Tirando.Codigo.QueryMethod.Repositories;


import Tirando.Codigo.QueryMethod.Models.Employee;
import Tirando.Codigo.QueryMethod.Models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//Repo con Acceso a datos//
@Repository
public interface Repo_Employee extends JpaRepository<Employee,Long> {

    //Query Methods//

    //Buscar mediante Rol de Empleado//
    public List<Employee> findByRole(String role);

    //Buscar Empleado mediante Usuario//
    public Employee findByUser(String user);
}
