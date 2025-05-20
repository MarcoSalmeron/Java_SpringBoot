package FuturoDigital.Employees.Repositories;

import FuturoDigital.Employees.Models.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo_Employee extends JpaRepository<Employees,Long> {

    Employees findByUsername(String username);
}
