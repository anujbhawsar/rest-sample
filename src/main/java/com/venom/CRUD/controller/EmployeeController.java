package com.venom.CRUD.controller;

import com.venom.CRUD.model.Employee;
import com.venom.CRUD.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepo employeeRepo;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeRepo.findAll();
    }
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeRepo.save(employee);
    }
    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployeeByID(@PathVariable(name = "id") long id) throws Exception {
        Employee employee = employeeRepo.findById(id).orElseThrow(()->new Exception());
        return ResponseEntity.ok().body(employee);
    }
    @PutMapping("/employee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(name = "id") long id, @RequestBody Employee empDetails) throws Exception{
        Employee employee = employeeRepo.findById(id).orElseThrow(()->new Exception());
        employee.setName(empDetails.getName());
        employee.setMob(empDetails.getMob());
        employee.setSurname(empDetails.getSurname());
        employeeRepo.save(employee);
        return ResponseEntity.ok().body(employee);
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable(name = "id") long id) throws Exception{
        employeeRepo.findById(id).orElseThrow(()->new Exception());
        employeeRepo.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
