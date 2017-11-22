package com.kysylytsia.controller;

import com.kysylytsia.dao.entity.Employee;
import com.kysylytsia.service.ServiceEmployee;
import com.kysylytsia.service.ServiceMenu;
import com.kysylytsia.view.Console;
import com.kysylytsia.view.Show;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SERAFIM on 15.11.2017.
 */
public class Controller {

    ServiceEmployee employee = new ServiceEmployee();
    ServiceMenu serviceMenu = new ServiceMenu();
    ServiceEmployee serviceEmployee = new ServiceEmployee();

    public void listener() {

        int comandID = 0;

        do{
            switch (comandID){
                case 0 :
                    comandID = serviceMenu.welcom();
                    break;
                case 1 :
                    serviceEmployee.addNewEmployee();
                    comandID = 0;
                    break;
                case 2 :
                    String employeeInformation = serviceEmployee.getEmployeeByNameFL().toString();
                    Logic.fileWriter(employeeInformation, "detailed information.txt");
                    System.out.println( employeeInformation );
                    System.out.println();
                    comandID = 0;
                    break;
                case 3 :
                    serviceEmployee.updateEmployee();
                    comandID = 0;
                    break;
                case 4 :
                    serviceEmployee.deleteEmployee();
                    comandID = 0;
                    break;
                case 5 :
                    List<Employee> allEmployee = serviceEmployee.getAllEmployee();
                    String head = Console.getHead();
                    String all = Console.showOnTheDisplay(allEmployee);
                    String res = (head + all);
                    System.out.println(res);
                    Logic.fileWriter(res, "all information.txt");
                    comandID = 0;
                    break;
            }

        }while(true);

    }

}
