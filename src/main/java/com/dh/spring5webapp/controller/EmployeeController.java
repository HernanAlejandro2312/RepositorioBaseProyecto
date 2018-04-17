/**
 * @author: edson
 */

package com.dh.spring5webapp.controller;

import com.dh.spring5webapp.services.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    
    @RequestMapping("/employees")
    public String getEmployees(Model model) {
        model.addAttribute("employee", employeeService.getEmployees());
        return "employees";
    }
}
