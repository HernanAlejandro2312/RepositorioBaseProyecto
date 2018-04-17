/**
 * @author: edson
 */

package com.dh.spring5webapp.services;

import com.dh.spring5webapp.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployees();
}
