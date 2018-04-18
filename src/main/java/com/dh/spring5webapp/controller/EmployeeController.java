/**
 * @author: edson
 */

package com.dh.spring5webapp.controller;

import com.dh.spring5webapp.command.EmployeeCommand;
import com.dh.spring5webapp.model.Employee;
import com.dh.spring5webapp.services.EmployeeService;
import org.springframework.stereotype.Controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/employees")
@Produces("application/json")
@Controller
public class EmployeeController {
    private EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GET
    public Response getEmployees() {
        List<EmployeeCommand> employeeList = new ArrayList<>();
        service.findAll().forEach(employee -> {
            employeeList.add(new EmployeeCommand(employee));
        });
        return Response.ok(employeeList).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public EmployeeCommand getEmployeeById(@PathParam("id") long id) {
        Employee employee = service.findById(id);
        return new EmployeeCommand(employee);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public EmployeeCommand addEmployee(EmployeeCommand employeeCommand) {
        Employee employee = service.save(employeeCommand.toEmployee());
        return new EmployeeCommand(employee);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public EmployeeCommand updateEmployee(EmployeeCommand employeeCommand) {
        Employee employee = service.save(employeeCommand.toEmployee());
        return new EmployeeCommand(employee);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteEmployee(@PathParam("id") long id) {
        service.deleteById(id);

    }
}