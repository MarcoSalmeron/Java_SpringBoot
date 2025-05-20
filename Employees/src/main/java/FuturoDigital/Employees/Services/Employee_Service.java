package FuturoDigital.Employees.Services;

import FuturoDigital.Employees.Models.Employees;
import FuturoDigital.Employees.Repositories.Repo_Employee;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Employee_Service {

    @Autowired
    private final Repo_Employee repoEmployee;

    public List<Employees> getAll(){
        return repoEmployee.findAll();
    }

    public Employees saveEmployee(Employees employees){
        return repoEmployee.save(employees);
    }

    public String deleteEmployee(Long ID){
        repoEmployee.deleteById(ID);
        return "Employee Deleted";
    }

    public Employees findEmployee(Long ID){
        return repoEmployee.findById(ID)
                .orElseThrow(()->new EntityNotFoundException("ID Inexistente!! ["+ID+"]"));
    }
}
