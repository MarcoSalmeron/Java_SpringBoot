package Tirando.Codigo.QueryMethod.Repositories;

import Tirando.Codigo.QueryMethod.Models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Repo con Acceso a Datos//
@Repository
public interface Repo_Person extends JpaRepository<Person,Long> {

    //Query Methods//

    //Buscar por Email//
    public Person findByEmail(String email);

    //Buscar por Numero de Telefono//
    public Person findByNumber(Long number);
}
