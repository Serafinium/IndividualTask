package com.kysylytsia.dao.repository;


import com.kysylytsia.dao.entity.Employee;
import com.kysylytsia.service.ServiceMenu;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SERAFIM on 15.11.2017.
 */
public class CRUDEmployeeImpl implements CRUDEmployeeRepository, SettingAccessToDB {

    //**********************************************************************************************************//

    @Override
    public void addEmployee(Employee employee) {
        try (
                Connection connection = DriverManager.getConnection(DB_URL, loginDB, passwordDB);
                Statement statement = connection.createStatement();
        ) {
            statement.executeUpdate("INSERT INTO employee (lastName, firstName, middleName, birthday, position, department, roomNumber, officialTelephone, officialEmail, monthlySalary, recruitmentDate, fieldForNotes)" +
                    "VALUES ('" + employee.getLastName() + "' , '" + employee.getFirstName() + "' , '" + employee.getMiddleName() + "' , '" + employee.getBirthday() + "' , '" + employee.getPosition() + "' , '" + employee.getDepartment() + "' ,'" +
                    employee.getRoomNumber() + "' , '" + employee.getOfficialTelephone() + "' , '" + employee.getOfficialEmail() + "' , '" + employee.getMonthlySalary() + "' , '" + employee.getRecruitmentDate() + "' , '" + employee.getFieldForNotes() + "')");


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //**********************************************************************************************************//

    @Override
    public boolean isPresentEmployeeByName(String str) {

        String name[] = str.split(" ");
        String lastName = name[0].toLowerCase();
        String firstName = name[1].toLowerCase();

        String query = "SELECT * FROM employee WHERE lastName = \'" + lastName + "\' AND firstName = \'" + firstName + "\'";

        try (
                Connection connection = DriverManager.getConnection(DB_URL, loginDB, passwordDB);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
        ) {

            if( resultSet.first() ){
                return true;
            };

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;

    }

    //**********************************************************************************************************//

    @Override
    public List<Employee> getEmployeeByName(String str) {

        String name[] = str.split(" ");
        String lastName = name[0].toLowerCase();
        String firstName = name[1].toLowerCase();

        List<Employee> employees = new ArrayList<>();

        Employee employeeFromDB;

        String query = "SELECT * FROM employee WHERE lastName = \'" + lastName + "\' AND firstName = \'" + firstName + "\'";




        try (
                Connection connection = DriverManager.getConnection(DB_URL, loginDB, passwordDB);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
        ) {
            while (resultSet.next()) {
                employeeFromDB = new Employee();

                employeeFromDB.setID(resultSet.getInt(1));
                employeeFromDB.setLastName(resultSet.getString(2));
                employeeFromDB.setFirstName(resultSet.getString(3));
                employeeFromDB.setMiddleName(resultSet.getString(4));
                employeeFromDB.setBirthday(resultSet.getDate(5));
                employeeFromDB.setPosition(resultSet.getString(6));
                employeeFromDB.setDepartment(resultSet.getString(7));
                employeeFromDB.setRoomNumber(resultSet.getInt(8));
                employeeFromDB.setOfficialTelephone(resultSet.getString(9));
                employeeFromDB.setOfficialEmail(resultSet.getString(10));
                employeeFromDB.setMonthlySalary(resultSet.getInt(11));
                employeeFromDB.setRecruitmentDate(resultSet.getDate(12));
                employeeFromDB.setFieldForNotes(resultSet.getString(13));
                employees.add(employeeFromDB);
                System.out.println();
            };

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employees;
    }

    //**********************************************************************************************************//

    @Override
    public void updateEmployee(Employee employee) {

        int ID = employee.getID();

        try (
                Connection connection = DriverManager.getConnection(DB_URL, loginDB, passwordDB);
                Statement preparedStatement =  connection.createStatement();
        ){
            preparedStatement.executeUpdate("UPDATE employee SET lastName = \'" + employee.getLastName() + "\', firstName = \'" + employee.getFirstName()+ "\', middleName = \'" + employee.getMiddleName() + "\', birthday = \'" + employee.getBirthday() + "\', position = \'" + employee.getPosition() +"\', department = \'" + employee.getDepartment() + "\', roomNumber = " + employee.getRoomNumber() + ", officialTelephone = \'" + employee.getOfficialTelephone() + "\', officialEmail = \'" + employee.getOfficialEmail() + "\', monthlySalary = " + employee.getMonthlySalary() + ", recruitmentDate = \'" + employee.getRecruitmentDate() + "\', fieldForNotes = \'" + employee.getFieldForNotes() + "\'   WHERE ID = " + employee.getID());
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //**********************************************************************************************************//

    @Override
    public boolean deleteEmployeeByID(Employee employee) {

        try (
                Connection connection = DriverManager.getConnection(DB_URL, loginDB, passwordDB);
                Statement statement = connection.createStatement();
        ) {
            statement.executeUpdate("DELETE FROM employee WHERE ID = " + employee.getID());

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }

    //**********************************************************************************************************//

    @Override
    public List<Employee> getAllEmployee() {

        List<Employee> employees = new ArrayList<>();

        String query = "SELECT * FROM employee";

        Employee employeeFromDB;

        try (
                Connection connection = DriverManager.getConnection(DB_URL, loginDB, passwordDB);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);

        ) {
            while ( resultSet.next() ){

                employeeFromDB = new Employee();

                employeeFromDB.setID(resultSet.getInt(1));
                employeeFromDB.setLastName(resultSet.getString(2));
                employeeFromDB.setFirstName(resultSet.getString(3));
                employeeFromDB.setMiddleName(resultSet.getString(4));
                employeeFromDB.setBirthday(resultSet.getDate(5));
                employeeFromDB.setPosition(resultSet.getString(6));
                employeeFromDB.setDepartment(resultSet.getString(7));
                employeeFromDB.setRoomNumber(resultSet.getInt(8));
                employeeFromDB.setOfficialTelephone(resultSet.getString(9));
                employeeFromDB.setOfficialEmail(resultSet.getString(10));
                employeeFromDB.setMonthlySalary(resultSet.getInt(11));
                employeeFromDB.setRecruitmentDate(resultSet.getDate(12));
                employeeFromDB.setFieldForNotes(resultSet.getString(13));
                employees.add(employeeFromDB);
                System.out.println();
            };

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employees;
    }


    @Override
    public List<Employee> getAllEmployeeByName(String name) {

        List<Employee> employees = new ArrayList<>();

        String names[] = name.split(" ");
        String lastName = names[0].toLowerCase();
        String firstName = names[1].toLowerCase();


        Employee employeeFromDB;

        String query = "SELECT * FROM employee WHERE lastName = \'" + lastName + "\' AND firstName = \'" + firstName + "\'";

        try (
                Connection connection = DriverManager.getConnection(DB_URL, loginDB, passwordDB);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
        ) {
            while ( resultSet.next() ){

                employeeFromDB = new Employee();

                employeeFromDB.setID(resultSet.getInt(1));
                employeeFromDB.setLastName(resultSet.getString(2));
                employeeFromDB.setFirstName(resultSet.getString(3));
                employeeFromDB.setMiddleName(resultSet.getString(4));
                employeeFromDB.setBirthday(resultSet.getDate(5));
                employeeFromDB.setPosition(resultSet.getString(6));
                employeeFromDB.setDepartment(resultSet.getString(7));
                employeeFromDB.setRoomNumber(resultSet.getInt(8));
                employeeFromDB.setOfficialTelephone(resultSet.getString(9));
                employeeFromDB.setOfficialEmail(resultSet.getString(10));
                employeeFromDB.setMonthlySalary(resultSet.getInt(11));
                employeeFromDB.setRecruitmentDate(resultSet.getDate(12));
                employeeFromDB.setFieldForNotes(resultSet.getString(13));
                employees.add(employeeFromDB);

            };

        } catch (SQLException e) {
            e.printStackTrace();
        }



        return employees;

    }

    //**********************************************************************************************************//

}