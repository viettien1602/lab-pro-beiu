package model;

import java.time.LocalDate;

public class Business extends Employee {
    // Contains properties of employee
    private double revenue;
    private double commission;

    public Business() {}

    public Business(String name, String code, Gender gender, LocalDate birthdate, double basicSalary, int yearOfWork, double revenue) {
        super(name, code, gender, birthdate, basicSalary, yearOfWork);
        this.revenue = revenue;
        calculateRealSalary();
        calculateCommission();
    }

    private void calculateCommission() {
        int a = 5000000;
        int b = 10000000;
        int c = 20000000;
        if (revenue < a) this.commission = 0;
        else if (revenue >= a && revenue < b) this.commission = 0.05;
        else if (revenue >= b && revenue < c) this.commission = 0.1;
        else this.commission = 0.2;
    }
    public double getCommission() {
        return commission;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
        calculateRealSalary();
    }

    @Override
    public void setBasicSalary(double basicSalary) {
        super.setBasicSalary(basicSalary);
        calculateRealSalary();
    }

    @Override
    public void setYearOfWork(int yearOfWork) {
        super.setYearOfWork(yearOfWork);
        calculateRealSalary();
    }
    @Override
    public void calculateRealSalary() {
        realSalary = basicSalary * salaryIndex + revenue * commission;
    }

    @Override
    public String toString() {
        return "Business{" + super.toString() + "revenue=" + revenue + ", commission=" + commission + "}";
    }
}
