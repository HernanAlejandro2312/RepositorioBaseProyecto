/**
 * @author: Edson A. Terceros T.
 */

package com.dh.spring5webapp.services;

import com.dh.spring5webapp.model.Employee;
import com.dh.spring5webapp.repositories.EmployeeRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends GenericServiceImpl<Employee> implements EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository EmployeeRepository) {
        this.employeeRepository = EmployeeRepository;
    }

    @Override
    protected CrudRepository<Employee, Long> getRepository() {
        return employeeRepository;
    }
}