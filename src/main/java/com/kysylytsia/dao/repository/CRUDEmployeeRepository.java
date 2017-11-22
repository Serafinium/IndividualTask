package com.kysylytsia.dao.repository;

import com.kysylytsia.dao.entity.Employee;
import java.security.Permission;
import java.util.List;

/**
 * Created by SERAFIM on 15.11.2017.
 */
public interface CRUDEmployeeRepository {

    public void addEmployee(Employee employee);
    public boolean isPresentEmployeeByName(String str);
    public List<Employee> getEmployeeByName(String str);
    public void  updateEmployee(Employee employee);
    public boolean deleteEmployeeByID (Employee employee);
    public List<Employee> getAllEmployee();
    public List<Employee> getAllEmployeeByName(String name);

}
