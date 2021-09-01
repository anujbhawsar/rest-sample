package com.venom.crud.repository;

import com.venom.crud.model.Employee;
import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

}
