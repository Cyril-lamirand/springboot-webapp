package com.springboot.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.webapp.model.Employee;
import com.springboot.webapp.repository.EmployeeProxy;

import lombok.Data;

@Data
@Service
public class EmployeeService {

    @Autowired
    private EmployeeProxy employeeProxy;

    public Employee getEmployee(final int id) {
        return employeeProxy.getEmployee(id);
    }

    public Iterable<Employee> getEmployees() {
        return employeeProxy.getEmployees();
    }

    public void deleteEmployee(final int id) {
        employeeProxy.deleteEmployee(id);;
    }

    public Employee saveEmployee(Employee employee) {
        Employee savedEmployee;

        // Règle de gestion : Le nom de famille doit être mis en majuscule.
        employee.setLastname(employee.getLastname().toUpperCase());

        if(employee.getId() == null) {
            // Si l'id est nul, alors c'est un nouvel employé.
            savedEmployee = employeeProxy.createEmployee(employee);
        } else {
            savedEmployee = employeeProxy.updateEmployee(employee);
        }

        return savedEmployee;
    }

}
