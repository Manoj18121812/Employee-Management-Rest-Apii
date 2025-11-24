package com.example.Employee_Management_Rest_Api.Controller;

import com.example.Employee_Management_Rest_Api.Entity.Employee;
import com.example.Employee_Management_Rest_Api.Service.EmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {


    public final EmployeeService service;

    public EmployeeController(EmployeeService service){
        this.service = service;
    }

    @PostMapping
    public Employee add(Employee employee){
        return service.addEmployee(employee);
    }

    @GetMapping
    public List<Employee> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable Integer id){
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Employee update(@PathVariable Integer id,@RequestBody Employee employee){
        return service.update(id,employee);
    }

    @DeleteMapping("/{id}")
    public String delete(Integer id){
        return service.delete(id) ? "Employee deletd" : "Employee not deletd";
    }

    //extra

    @GetMapping("/search/{name}")
    public List<Employee> searchByName(@PathVariable String name){
        return service.findByName(name);
    }

    @GetMapping("/department/{department}")
    public List<Employee> getByDepartment(@PathVariable String department){
    return service.findByDepartment(department);
    }

    @GetMapping("/salary/{min}/{max}")
    public List<Employee> sortBySalary(double min,double max){
    return service.salaryRange(min,max);
    }

    @GetMapping("/sort/{order}")
    public List<Employee> sortBySalary(@PathVariable String order) {
        return service.sortBySalary(order);
    }

    @GetMapping("/page/{page}/{size}")
    public Page<Employee> pagination(@PathVariable int page, @PathVariable int size) {
        return service.getPaginated(page, size);
    }
}
