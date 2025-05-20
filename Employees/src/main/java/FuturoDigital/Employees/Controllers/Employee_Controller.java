package FuturoDigital.Employees.Controllers;

import FuturoDigital.Employees.Models.Employees;
import FuturoDigital.Employees.Services.Employee_Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/employees")
@RequiredArgsConstructor
public class Employee_Controller {

    private final Employee_Service employeeService;

    @GetMapping("/all")
    public ResponseEntity<List<Employees>> all(){
        return ResponseEntity.ok(employeeService.getAll());
    }

    @PutMapping("/save")
    public ResponseEntity<Employees> save(@RequestBody Employees employee){
        return ResponseEntity.ok(employeeService.saveEmployee(employee));
    }

    @PostMapping("/find/{ID}")
    public ResponseEntity<Employees> find(@PathVariable Long ID){
        return ResponseEntity.ok(employeeService.findEmployee(ID));
    }

    @DeleteMapping("/delete/{ID}")
    public ResponseEntity<String> delete(@PathVariable Long ID){
        return ResponseEntity.ok(employeeService.deleteEmployee(ID));
    }
}
