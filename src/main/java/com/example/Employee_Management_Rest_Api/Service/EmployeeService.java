package com.example.Employee_Management_Rest_Api.Service;

import com.example.Employee_Management_Rest_Api.Entity.Employee;
import com.example.Employee_Management_Rest_Api.Repository.EmployeeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    public final EmployeeRepository repo;

    public EmployeeService(EmployeeRepository repo){
        this.repo = repo;
    }

    public Employee addEmployee(Employee emp){
        return repo.save(emp);
    }

    public List<Employee> getAll(){
     return  repo.findAll();
    }

    public Employee getById(Integer id){
        return repo.findById(id).orElse(null);
    }

    public Employee update(Integer id ,Employee emp){
    Employee old = repo.findById(id).orElse(null);

    if(old == null) return null;

    old.setName(emp.getName());
    old.setSalary(emp.getSalary());
    old.setDepartment(emp.getDepartment());

    return repo.save(old);
    }

    public boolean delete(Integer id){
        if(!repo.existsById(id))return false;
        repo.deleteById(id);
        return true;
    }

    //search by name
    public List<Employee> findByName(String name){
        return repo.findByNameContaining(name);
    }

    //search by department
    public List<Employee> findByDepartment(String department){
        return repo.findByDepartment(department);
    }

    //salary range filter
    public List<Employee> salaryRange(double min,double max){
        return repo.findBySalaryBetween(min,max);
    }

    //sorting
    public List<Employee> sortBySalary(String order){
        Sort sort = order.equalsIgnoreCase("desc")?
            Sort.by("salary").descending():
            Sort.by("salary").ascending();

        return repo.findAll(sort);

    }

    //pagination
    public Page<Employee> getPaginated(int page,int size){
        Pageable pageable = PageRequest.of(page,size);
        return repo.findAll(pageable);
    }



}
