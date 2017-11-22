package com.kysylytsia.dao.entity;


import java.io.Serializable;
import java.sql.Date;

/**
 * Created by SERAFIM on 15.11.2017.
 */
public class Employee implements Serializable {
    private int ID;
    private String lastName;
    private String firstName;
    private String middleName;
    private Date birthday; //Date
    private String position;
    private String department;
    private int roomNumber;
    private String officialTelephone;
    private String officialEmail;
    private int monthlySalary;
    private Date recruitmentDate; //Date
    private String fieldForNotes;


    public Employee(String lastName, String firstName, String middleName,
                    Date birthday, String position, String department, int roomNumber,
                    String officialTelephone, String officialEmail, int monthlySalary,
                    Date recruitmentDate, String fieldForNotes) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.birthday = birthday;
        this.position = position;
        this.department = department;
        this.roomNumber = roomNumber;
        this.officialTelephone = officialTelephone;
        this.officialEmail = officialEmail;
        this.monthlySalary = monthlySalary;
        this.recruitmentDate = recruitmentDate;
        this.fieldForNotes = fieldForNotes;
    }

    public Employee() {

    }

    public int getID() {
        return ID;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getPosition() {
        return position;
    }

    public String getDepartment() {
        return department;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getOfficialTelephone() {
        return officialTelephone;
    }

    public String getOfficialEmail() {
        return officialEmail;
    }

    public int getMonthlySalary() {
        return monthlySalary;
    }

    public Date getRecruitmentDate() {
        return recruitmentDate;
    }

    public String getFieldForNotes() {
        return fieldForNotes;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setOfficialTelephone(String officialTelephone) {
        this.officialTelephone = officialTelephone;
    }

    public void setOfficialEmail(String officialEmail) {
        this.officialEmail = officialEmail;
    }

    public void setMonthlySalary(int monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public void setRecruitmentDate(Date recruitmentDate) {
        this.recruitmentDate = recruitmentDate;
    }

    public void setFieldForNotes(String fieldForNotes) {
        this.fieldForNotes = fieldForNotes;
    }

    @Override
    public String toString() {
        return ID + "; " + lastName + "; " + firstName + "; " + middleName + "; " + birthday
                + "; " + position + "; " + department + "; " + roomNumber + "; " + officialTelephone
                + "; " + officialEmail + "; " + monthlySalary + "; " + recruitmentDate + "; " + fieldForNotes + ";";
    }
}
