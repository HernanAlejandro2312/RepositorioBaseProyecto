/**
 * (C) 2017 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.dh.spring5webapp.command;

import com.dh.spring5webapp.model.Contract;
import com.dh.spring5webapp.model.Employee;
import com.dh.spring5webapp.model.ModelBase;

public class EmployeeCommand extends ModelBase {

    private String firstName;
    private String lastName;
    private String name;
    private String image;
    private String jobPosition;
    private String jobCode;
    private Boolean featured;
    private String jobDescription;

    public EmployeeCommand() {
    }

    public EmployeeCommand(String firstName, String lastName, String name, String image, String jobPosition,
                           String jobCode, Boolean featured, String jobDescription) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.name = name;
        this.image = image;
        this.jobPosition = jobPosition;
        this.jobCode = jobCode;
        this.featured = featured;
        this.jobDescription = jobDescription;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public EmployeeCommand(Employee employee) {
        setId(employee.getId());
        setVersion(employee.getVersion());
        setCreatedOn(employee.getCreatedOn());
        setUpdatedOn(employee.getUpdatedOn());
        firstName = employee.getFirstName();
        lastName = employee.getLastName();
        for (Contract contract : employee.getContracts()) {
            jobPosition = contract.getPosition().getName();
            jobCode = contract.getPosition().getName();
        }
        featured = true;
        image = "/assets/images/valentin.jpg"; // todo arreglo de bits
        jobDescription = "Descripcion de job";
    }

    public String getName() {
        return getFirstName() + " " + getLastName();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }

    public String getJobCode() {
        return jobCode;
    }

    public void setJobCode(String jobCode) {
        this.jobCode = jobCode;
    }

    public Boolean getFeatured() {
        return featured;
    }

    public void setFeatured(Boolean featured) {
        this.featured = featured;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public Employee toEmployee() {
        Employee employee = new Employee();
        employee.setFirstName(getFirstName());
        employee.setLastName(getLastName());
        employee.setId(getId());
        employee.setVersion(getVersion());
        employee.setCreatedOn(getCreatedOn());
        employee.setUpdatedOn(getUpdatedOn());
        return employee;
    }
}
