/**
 * @author: edson
 */

package com.dh.spring5webapp.services;

import com.dh.spring5webapp.model.Employee;
import com.dh.spring5webapp.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository EmployeeRepository) {
        this.employeeRepository = EmployeeRepository;
    }

    @Override
    public List<Employee> getEmployees() {
        List<Employee> employees = new ArrayList<>();
        employeeRepository.findAll().forEach(employees::add);
        return employees;
    }
}