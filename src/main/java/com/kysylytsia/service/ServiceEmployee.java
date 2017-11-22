package com.kysylytsia.service;


import com.kysylytsia.controller.Logic;
import com.kysylytsia.dao.entity.Employee;
import com.kysylytsia.dao.repository.CRUDEmployeeImpl;


import java.io.IOException;
import java.sql.Date;
import java.util.List;


/**
 * Created by SERAFIM on 15.11.2017.
 */
public class ServiceEmployee {

    Logic logic = new Logic();
    CRUDEmployeeImpl crudEmployee = new CRUDEmployeeImpl();

    public void addNewEmployee (){

        System.out.println("Додаємо нового працівника: ");

        System.out.print("Прізвище: ");
        String lastName = logic.readString();

        System.out.print("Ім'я: ");
        String firstName = logic.readString();

        System.out.print("По-батькові: ");
        String meddleName = logic.readString();

        System.out.println("Дата народження: ");
        String dataBirthday = "";
        System.out.print("Рік: ");
        dataBirthday += logic.readString() + "-";

        System.out.print("місяць: ");
        dataBirthday += logic.readString() + "-";

        System.out.print("день: ");
        dataBirthday += logic.readString();

        Date birthday = Date.valueOf(dataBirthday);

        System.out.print("Посада: ");
        String position = logic.readString();

        System.out.print("Підрозділ (Відділ): ");
        String department = logic.readString();

        System.out.print("Номер кімнати: ");
        int roomNumber = logic.readInt(999); // Офіс то не резиновий!

        System.out.print("Службовий телефон: ");
        String officialTelephone = logic.readString();

        System.out.print("Службовий e-mail: ");
        String officialEmail = logic.readEmail();

        System.out.print("місячний оклад: ");
        int monthlySalary = logic.readInt(1000000); // Ну не буває у працівника такої зарплати...

        System.out.println("дата прийняття на роботу: ");
        String dateJobPlacement = "";
        System.out.print("Рік: ");
        dateJobPlacement += logic.readString() + "-";

        System.out.print("місяць: ");
        dateJobPlacement += logic.readString() + "-";

        System.out.print("день: ");
        dateJobPlacement += logic.readString();
        Date recruitmentDate = Date.valueOf(dateJobPlacement);

        System.out.print("Поле для приміток: ");
        String fieldForNotes = logic.readString();
        System.out.println();

        Employee employee = new Employee(lastName, firstName, meddleName, birthday, position, department, roomNumber,
                                officialTelephone, officialEmail, monthlySalary, recruitmentDate, fieldForNotes);

        crudEmployee.addEmployee(employee);
    }


    public String getEmployeeByNameFL(){

        String res = Logic.inputNameFL();
        String str="";
        if (crudEmployee.isPresentEmployeeByName(res)){
            List<Employee> employees = crudEmployee.getEmployeeByName(res);
            for (Employee e: employees){
                str += e.toString() + "\n";
            }
            return str;
        }else{
            System.out.println("Працівника з даним Іменем/Фамілією не існує!");
            return getEmployeeByNameFL();
        }

    }


    public void updateEmployee (){

        String res = Logic.inputNameFL (); //Повертає строку з фамілії та ім'я

        Employee employee = null;

        List <Employee> employees = crudEmployee.getEmployeeByName(res);



        if (crudEmployee.isPresentEmployeeByName(res)){
            employee = ServiceMenu.chooseUpdate(employees);
        }else{
            System.out.println("Працівника з даним Іменем/Фамілією не існує!");
            updateEmployee();
        }

        System.out.println("Працівника виявленно! ");

        int choose = Logic.showEmployeeAndCommand(employee);


        try {
            Logic.serializableEmploye(employee);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        Employee updateEmployee = null;
        
        try {
            updateEmployee = Logic.deSerializableEmploye();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (updateEmployee != null | updateEmployee != employee){
            boolean closeUpdate = false;

            while (!closeUpdate)
            switch (choose){
                case 1:
                    System.out.print("Нова фамілія: ");
                    updateEmployee.setLastName( Logic.readString() );
                    System.out.println("Зміни зафіксовані!");
                    System.out.println();
                    choose = Logic.showEmployeeAndCommand(updateEmployee);
                    break;
                case 2:
                    System.out.print("Нове ім'я: ");
                    updateEmployee.setFirstName( Logic.readString());
                    System.out.println("Зміни зафіксовані!");
                    System.out.println();
                    choose = Logic.showEmployeeAndCommand(updateEmployee);
                    break;
                case 3:
                    System.out.print("Нове по батькові: ");
                    updateEmployee.setMiddleName( Logic.readString());
                    System.out.println("Зміни зафіксовані!");
                    System.out.println();
                    choose = Logic.showEmployeeAndCommand(updateEmployee);
                    break;
                case 4:
                    System.out.print("Нова дата народження: ");

                    String dataBirthday = "";
                    System.out.print("Рік: ");
                    dataBirthday += logic.readString() + "-";

                    System.out.print("місяць: ");
                    dataBirthday += logic.readString() + "-";

                    System.out.print("день: ");
                    dataBirthday += logic.readString();

                    updateEmployee.setBirthday(Date.valueOf(dataBirthday));
                    System.out.println("Зміни зафіксовані!");
                    System.out.println();
                    choose = Logic.showEmployeeAndCommand(updateEmployee);
                    break;
                case 5:
                    System.out.print("Нова посада: ");
                    updateEmployee.setPosition(Logic.readString());
                    System.out.println("Зміни зафіксовані!");
                    System.out.println();
                    choose = Logic.showEmployeeAndCommand(updateEmployee);
                    break;
                case 6:
                    System.out.print("Новий відділ: ");
                    updateEmployee.setDepartment(Logic.readString());
                    System.out.println("Зміни зафіксовані!");
                    System.out.println();
                    choose = Logic.showEmployeeAndCommand(updateEmployee);
                    break;
                case 7:
                    System.out.print("Новий номер кімнати");
                    updateEmployee.setRoomNumber(Logic.readInt(999));
                    System.out.println("Зміни зафіксовані!");
                    System.out.println();
                    choose = Logic.showEmployeeAndCommand(updateEmployee);
                    break;
                case 8:
                    System.out.print("Новий номер телефону: ");
                    updateEmployee.setOfficialTelephone(Logic.readString());
                    System.out.println("Зміни зафіксовані!");
                    System.out.println();
                    choose = Logic.showEmployeeAndCommand(updateEmployee);
                    break;
                case 9:
                    System.out.print("Новий Email: ");
                    updateEmployee.setOfficialEmail(Logic.readEmail());
                    System.out.println("Зміни зафіксовані!");
                    System.out.println();
                    choose = Logic.showEmployeeAndCommand(updateEmployee);
                    break;
                case 10:
                    System.out.print("Нова зарплата: ");
                    updateEmployee.setMonthlySalary(Logic.readInt(1000000));
                    System.out.println("Зміни зафіксовані!");
                    System.out.println();
                    choose = Logic.showEmployeeAndCommand(updateEmployee);
                    break;
                case 11:
                    System.out.print("Нова дата трудовлаштування: ");

                    String recruitmentDate = "";
                    System.out.print("Рік: ");
                    recruitmentDate += logic.readString() + "-";

                    System.out.print("місяць: ");
                    recruitmentDate += logic.readString() + "-";

                    System.out.print("день: ");
                    recruitmentDate += logic.readString();

                    updateEmployee.setRecruitmentDate(Date.valueOf(recruitmentDate));
                    System.out.println("Зміни зафіксовані!");
                    System.out.println();
                    choose = Logic.showEmployeeAndCommand(updateEmployee);
                    break;
                case 12:
                    System.out.println("Нова примітка: ");
                    updateEmployee.setFieldForNotes(Logic.readString());
                    System.out.println("Зміни зафіксовані!");
                    System.out.println();
                    choose = Logic.showEmployeeAndCommand(updateEmployee);
                    break;
                case 13:
                    String indeficationEmployee = (employee.getLastName() + " " + employee.getFirstName());
                    System.out.println( indeficationEmployee);
                    crudEmployee.updateEmployee(updateEmployee);
                    System.out.println("Зміни збережено!");
                    System.out.println();
                    closeUpdate = true;
                    break;
                case 14:
                    updateEmployee = null;
                    System.out.println("Процес редагування даних відмінено!");
                    System.out.println();
                    closeUpdate = true;
                    break;
            }

        }



    }

    public void deleteEmployee() {

        String res = Logic.inputNameFL (); //Повертає строку з фамілії та ім'я

        if (crudEmployee.isPresentEmployeeByName(res)) {
            System.out.println("Працівника виявлено!");

            List<Employee> employees = crudEmployee.getAllEmployeeByName(res);

            Employee employee = ServiceMenu.chooseDelete(employees);

            if( ServiceMenu.delete() ){
                crudEmployee.deleteEmployeeByID(employee);
                System.out.println("Користувача успішно видалено!\n");
            }
        } else{
            System.out.println("Працівника з даним Іменем/Фамілією не існує!\n");
        }

    }



    public List<Employee> getAllEmployee() {

        List<Employee> employees = crudEmployee.getAllEmployee();

        return employees;
    }
}

