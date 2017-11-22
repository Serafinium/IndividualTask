package com.kysylytsia.view;

import com.kysylytsia.dao.entity.Employee;
import java.util.List;

/**
 * Created by SERAFIM on 15.11.2017.
 */
public class Console {

    public static String showOnTheDisplay (List <Employee> employeeList){
        Console console = new Console();

        headLine = console.creatorLine() + "\n";
        console.respond += headLine;

        for(int i=0; i<employeeList.size(); i++){
            Employee employee = employeeList.get(i);
            respond += ("| " + console.replace(employee) + "\n");
            respond += headLine;

        }

        return respond;
    }

    final int IDLength = 4;
    final int lastNameLength = 15;
    final int firstNameLength = 15;
    final int middleNameLength = 15;
    final int birthdayLength = 18;
    final int positionLength = 20;
    final int departmentLength = 25;
    final int roomNumberLength = 15;
    final int officialTelephoneLength = 18;
    final int officialEmailLength = 40;
    final int monthlySalaryLength = 16;
    final int recruitmentDateLength = 16;
    final int fieldForNotesLength = 25;

    final static String space = "                                                  "; //25
    final static String line  = "--------------------------------------------------"; //25

    final static String template = "ID / Прізвище / Ім'я / По батькові / Дата народження / Посада / Відділ / Номер кімнати / роб. Телефон / Службовий e-mail / Місячний оклад / Дата прийняття / Примітки";


    static String headLine = "";
    static String respond = "";

    private String creatorLine (){
        String str = "+";
        str += (line.substring(0, IDLength) + "+");
        str += (line.substring(0, lastNameLength) + "+");
        str += (line.substring(0, firstNameLength) + "+");
        str += (line.substring(0, middleNameLength) + "+");
        str += (line.substring(0, birthdayLength) + "+");
        str += (line.substring(0, positionLength) + "+");
        str += (line.substring(0, departmentLength) + "+");
        str += (line.substring(0, roomNumberLength) + "+");
        str += (line.substring(0, officialTelephoneLength) + "+");
        str += (line.substring(0, officialEmailLength) + "+");
        str += (line.substring(0, monthlySalaryLength) + "+");
        str += (line.substring(0, recruitmentDateLength) + "+");
        str += (line.substring(0, fieldForNotesLength) + "+");

        return str;
    }

    private String replace (Employee employee){
        String str = template;

        str = str.replace("ID", ""+employee.getID());
        str = str.replace("Прізвище", ""+employee.getLastName() );
        str = str.replace("Ім'я", ""+employee.getFirstName() );
        str = str.replace("По батькові", ""+employee.getMiddleName() );
        str = str.replace("Дата народження", ""+employee.getBirthday().toString() );
        str = str.replace("Посада", ""+employee.getPosition() );
        str = str.replace("Відділ", ""+employee.getDepartment() );
        str = str.replace("Номер кімнати", ""+employee.getRoomNumber() );
        str = str.replace("Телефон", ""+employee.getOfficialTelephone() );
        str = str.replace("Службовий e-mail", ""+employee.getOfficialEmail() );
        str = str.replace("Місячний оклад", ""+employee.getMonthlySalary() );
        str = str.replace("Дата прийняття", ""+employee.getRecruitmentDate().toString() );
        str = str.replace("Примітки", ""+employee.getFieldForNotes() );

        String res = adjustmentStr(str);

        return (res);
    }

    private String adjustmentStr(String str){

        String[] filds = str.split("/");

        int x;

        x = IDLength - filds[0].length();
        filds[0] += (space.substring(0, x-1) + "|");

        x = lastNameLength - filds[1].length();
        filds[1] += (space.substring(0, x) + "|");

        x = firstNameLength - filds[2].length();
        filds[2] += (space.substring(0, x) + "|");

        x = middleNameLength - filds[3].length();
        filds[3] += (space.substring(0, x) + "|");

        x = birthdayLength - filds[4].length();
        filds[4] += (space.substring(0, x) + "|");

        x = positionLength - filds[5].length();
        filds[5] += (space.substring(0, x) + "|");

        x = departmentLength - filds[6].length();
        filds[6] += (space.substring(0, x) + "|");

        x = roomNumberLength - filds[7].length();
        filds[7] += (space.substring(0, x) + "|");

        x = officialTelephoneLength - filds[8].length();
        filds[8] += (space.substring(0, x) + "|");

        x = officialEmailLength - filds[9].length();
        filds[9] += (space.substring(0, x) + "|");

        x = monthlySalaryLength - filds[10].length();
        filds[10] += (space.substring(0, x) + "|");

        x = recruitmentDateLength - filds[11].length();
        filds[11] += (space.substring(0, x) + "|");

        x = fieldForNotesLength - filds[12].length();
        filds[12] += (space.substring(0, x) + "|");

        str="";
        for(String s: filds) str += s;

        return str;
    }

    public static String getHead(){
        Console console = new Console();
        String head = console.creatorLine() +"\n"+ "| " + console.adjustmentStr(template) +"\n";
        return head;
    }

}