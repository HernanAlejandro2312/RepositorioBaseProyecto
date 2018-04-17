/**
 * @author: edson
 */

package com.dh.spring5webapp.repositories;

import com.dh.spring5webapp.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
