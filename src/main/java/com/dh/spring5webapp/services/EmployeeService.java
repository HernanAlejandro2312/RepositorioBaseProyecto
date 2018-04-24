/**
 * @author: Edson A. Terceros T.
 */

package com.dh.spring5webapp.services;

import com.dh.spring5webapp.model.Employee;

import java.io.InputStream;

public interface EmployeeService extends GenericService<Employee> {
    void saveImage(Long id, InputStream inputStream);
}