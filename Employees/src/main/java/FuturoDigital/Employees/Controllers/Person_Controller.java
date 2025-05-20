package FuturoDigital.Employees.Controllers;

import FuturoDigital.Employees.Models.Person;
import FuturoDigital.Employees.Services.Person_Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/persons")
@RequiredArgsConstructor
public class Person_Controller {

    private final Person_Service personService;

    @GetMapping("/all")
    public ResponseEntity<List<Person>> all (){
        return ResponseEntity.ok(personService.getAll());
    }

    @PutMapping("/save")
    public ResponseEntity<Person> save(@RequestBody Person person){
        return ResponseEntity.ok(personService.savePerson(person));
    }

    @PostMapping("/find/{ID}")
    public ResponseEntity<Person> find(@PathVariable Long ID){
        return ResponseEntity.ok(personService.findPerson(ID));
    }

    @DeleteMapping("/delete/{ID}")
    public ResponseEntity<String> delete(@PathVariable Long ID){
        return ResponseEntity.ok(personService.deletePerson(ID));
    }
}
