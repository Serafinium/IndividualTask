package com.kysylytsia.service;

import com.kysylytsia.controller.Controller;
import com.kysylytsia.controller.Logic;
import com.kysylytsia.dao.entity.Employee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by SERAFIM on 15.11.2017.
 */
public class ServiceMenu {

    public int welcom() {

        {
            System.out.println("Виберіть дію яку ви хочете виконати:");
            System.out.println("1: Додати нового працівника");
            System.out.println("2: Переглянути данні працівника");
            System.out.println("3: Редагувати існуючого працівника");
            System.out.println("4: Видалити існуючого працівника");
            System.out.println("5: Згенерувати звіт");
            System.out.println();
            return Logic.makeChoice();
        }

    }

    public static boolean delete() {

        System.out.println("Ви дійсно хочете видалити цього працівника?");
        System.out.println("1: так");
        System.out.println("2: ні");

        if (Logic.readInt(2) == 1){
            return true;
        } else {
            return false;
        }
    }

    public static Employee chooseDelete(List<Employee> employeeList){
        System.out.println("Виберіть працівника якого ви хочете видалити:");

        for(int i=0; i<employeeList.size(); i++){
            System.out.println(i+1 + ":  " + employeeList.get(i));
        }

        System.out.println();
        System.out.print("Введіть номер: ");

        int choose = Logic.readInt(employeeList.size());
        choose --; //корекція.
        Employee e = employeeList.get(choose);
        return e;
    }


    public static Employee chooseUpdate(List<Employee> employeeList){
        System.out.println("Виберіть працівника якого ви хочете редагувати:");

        for(int i=0; i<employeeList.size(); i++){
            System.out.println(i+1 + ":  " + employeeList.get(i));
        }

        System.out.println();
        System.out.print("Введіть номер: ");

        int choose = Logic.readInt(employeeList.size());
        choose --; //корекція.
        Employee e = employeeList.get(choose);
        return e;
    }

}
