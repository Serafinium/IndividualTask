package com.kysylytsia.controller;

import com.kysylytsia.dao.entity.Employee;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by SERAFIM on 15.11.2017.
 */
public class Logic {

    public static int makeChoice() {

        System.out.print("Виберіть дію: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x;
        try {
            x = Integer.parseInt(br.readLine());
        } catch (IOException | NumberFormatException e) {
            System.out.println("Допущено помилку! Введіть цифрове значення в діапазоні від 1-5");
            return Logic.makeChoice();
        }

        if (x > 5 | x <= 0) {
            System.out.println("Допущено помилку! Введіть цифрове значення в діапазоні від 1-5");
            return Logic.makeChoice();
        }

        return x;
    }


    public static String readString() {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;

        try {
            str = br.readLine();
        } catch (IOException | NumberFormatException e) {
            System.out.println("Допущено помилку! Повторіть ввід даних");
            return Logic.readString();
        }

        if(str.length() <= 0){
            System.out.println("Дане поле не може бути пустим!");
            return Logic.readString();
        }
        return str.toLowerCase();
    }


    public static int readInt(int noMax) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x;
        try {
            x = Integer.parseInt(br.readLine());
        } catch (IOException | NumberFormatException e) {
            System.out.print("Допущено помилку! Введіть цифрове значення: ");
            return Logic.readInt(noMax);
        }

        if (x <= 0) {
            System.out.print("Значення не може бути нулем, або менше нуля! Повторіть ввід:");
            return readInt(noMax);
        }
        if (x > noMax) {
            System.out.print("Значення не може бути більше ніж: " + noMax + "! Повторіть ввід:");
            return readInt(noMax);
        }
        return x;
    }

    public static int showEmployeeAndCommand(Employee employee) {

        System.out.println("Редагуємо данні працівника: ");
        System.out.print("1:  Прізвище: " + employee.getLastName() + "\n");
        System.out.print("2:  Ім'я: " + employee.getFirstName() + "\n");
        System.out.print("3:  По-батькові: " + employee.getMiddleName() + "\n");
        System.out.print("4   Дата народження: " + employee.getBirthday() + "\n");
        System.out.print("5:  Посада: " + employee.getPosition() + "\n");
        System.out.print("6:  Підрозділ (Відділ): " + employee.getDepartment() + "\n");
        System.out.print("7:  Номер кімнати: " + employee.getRoomNumber() + "\n");
        System.out.print("8:  Службовий телефон: " + employee.getOfficialTelephone() + "\n");
        System.out.print("9:  Службовий e-mail: " + employee.getOfficialEmail() + "\n");
        System.out.print("10: Місячний оклад: " + employee.getMonthlySalary() + "\n");
        System.out.print("11: Дата прийняття на роботу: " + employee.getRecruitmentDate() + "\n");
        System.out.print("12: Поле для приміток: " + employee.getFieldForNotes() + "\n");
        System.out.print("13: Зберегти зміни!\n");
        System.out.print("14: Відмінити редагування!\n");

        System.out.println();
        System.out.print("Виберіть дію: ");
        int choose = Logic.readInt(14);
        return choose;
    }

    public static void fileWriter(String str, String fileName) {

        try (FileWriter writer = new FileWriter(fileName, false)) {
            writer.write(str);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Проблема!");
        }
    }

    public static void serializableEmploye(Employee employee) throws FileNotFoundException, IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("temp.out");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(employee);
        objectOutputStream.flush();
        objectOutputStream.close();
    }

    public static Employee deSerializableEmploye() throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fileOutputStream = new FileInputStream("temp.out");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileOutputStream);
        Employee employee = (Employee) objectInputStream.readObject();
        return employee;
    }

    public static String readEmail(){

        String email = Logic.readString();
        if (!passwordCheck(email)){
            System.out.print("Введено некоректний email. Повторыть ввід: ");
            return readEmail();
        }
        return email;
    }

    public static boolean passwordCheck(String email) {

        final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile(
                "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(email);
        return matcher.find();
    }


    public static String inputNameFL (){
        System.out.println();
        System.out.print("Введіть фамілію: \n");
        String lastName = Logic.readString();

        System.out.print("Введіть ім'я: \n");
        String firstName = Logic.readString();
        System.out.println();

        String res = (lastName + " " + firstName);
        return res;
    }
}