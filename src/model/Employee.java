package model;

import java.time.LocalDate;

public abstract class Employee {
    protected String name;
    protected String code;
    protected Gender gender; // "MALE" "FEMALE"
    protected LocalDate birthdate;
    protected double basicSalary;
    protected int salaryIndex;
    protected double realSalary;
    protected int yearOfWork;

    public Employee() {}

    public Employee(String name, String code, Gender gender, LocalDate birthdate, double basicSalary, int yearOfWork) {
        this.name = name;
        this.code = code;
        this.gender = gender;
        this.birthdate = birthdate;
        this.basicSalary = basicSalary;
        this.yearOfWork = yearOfWork;
        calculateSalaryIndex();
    }
    private void calculateSalaryIndex() {
        salaryIndex = 1 + yearOfWork / 5;
    }

    public void setYearOfWork(int yearOfWork) {
        this.yearOfWork = yearOfWork;
        calculateSalaryIndex();
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public abstract void calculateRealSalary();

    public double getRealSalary() {
        return realSalary;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' + ", code='" + code
                + '\'' + ", gender=" + gender + ", birthdate=" + birthdate
                + ", basicSalary=" + basicSalary + ", salaryIndex=" + salaryIndex
                + ", realSalary=" + realSalary + ", yearOfWork=" + yearOfWork;
    }
}
