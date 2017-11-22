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
    public Employee getEmployeeByName(String str);
    public void  updateEmployee(Employee employee);
    public boolean deleteEmployeeByByName (String str);
    public List<Employee> getAllEmployee();

}
