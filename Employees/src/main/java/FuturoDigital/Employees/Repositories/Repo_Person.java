package FuturoDigital.Employees.Repositories;

import FuturoDigital.Employees.Models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo_Person extends JpaRepository<Person,Long> {

}
