package model;

import util.Validation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class HR {
    private ArrayList<Employee> employees;


    public HR() {
        employees = new ArrayList<>();
    }

    public Employee searchAnEmployee(String code) {
        if (employees.isEmpty()) {
            return null;
        }

        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getCode().equalsIgnoreCase(code)) {
                return employees.get(i);
            }
        }

        return null;
    }

    private String addName() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input name: ");
        String name = sc.nextLine().trim();
        if (name.equals("") || name.length() > 50) {
            System.out.println(".,....");
        }
        sc.close();
        return name;
    }

    private String addCode() {
        Scanner sc = new Scanner(System.in);
        String code = "";
        while (true) {
            System.out.println("Input code: ");
            code = sc.nextLine().trim().toUpperCase();
            if (Validation.testCode(code)) {
                Employee xxx = searchAnEmployee(code);
                if (xxx == null) {
                    break;
                } else {
                    System.out.println("ID duplication! Try with another one");
                }
            }
            else {
                System.out.println("ID format is not correct! Try with another one");
            }
        }
        sc.close();
        return code;
    }


    public void addBusinessEmployee() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input Business employees profile #" + (employees.size() + 1));
        String name = addName();
        String code = addCode();
        Gender gender ;
        LocalDate birthdate;
        double basicSalary;
        int yearOfWork;
        double revenue;


        while (true) {
            try {
                System.out.println("Input gender: ");
                gender = Gender.valueOf(sc.nextLine().toUpperCase());
                break;
            }
            catch (IllegalArgumentException e) {
                System.out.println("Gender format is not correct, try again!");
            }
        }

        while (true) {
            try {
                System.out.println("Input birthdate(dd/mm/yyyy): ");
                String birthdateStr = sc.nextLine();
                birthdate = LocalDate.parse(birthdateStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                break;
            }
            catch (DateTimeParseException e) {
                System.out.println("Birthdate format is not correct, try again!");
            }
        }


        System.out.println("Input basic salary: ");
        basicSalary = Double.parseDouble(sc.nextLine()); //co the loi

        System.out.println("Input year of work: ");
        yearOfWork = Integer.parseInt(sc.nextLine()); //co the loi

        System.out.println("Input revenue: ");
        revenue = Double.parseDouble(sc.nextLine()); //co the loi

        employees.add(new Business(name, code, gender, birthdate, basicSalary, yearOfWork, revenue));

    }

    public void addAdministratorEmployee() {

    }

    public void printAllEmployees() {
        for (Employee employee: employees) System.out.println(employee.toString());
    }

    public void printAllBusiness() {
        for (Employee employee: employees)
            if (employee instanceof Business) System.out.println(employee);
    }

    public void printAllAdministrator() {
        for (Employee employee: employees)
            if (employee instanceof Administrator) System.out.println(employee);
    }


    public void searchLowestSalary() {
        double minSalary = employees.get(0).getRealSalary();
        int index = 0;
        for (int i = 0; i < employees.size(); i++) {
            if(employees.get(i).getRealSalary() < minSalary) {
                minSalary = employees.get(i).getRealSalary();
                index = i;
            }
        }
        System.out.println("The lowest salary in the entire company is: " + minSalary);
        System.out.println("The profile of the employee with the lowest salary in the company is: ");
        System.out.println(employees.get(index).toString());


    }

    public void updateName(String code) {
        // .. employeee : code
        String name = addName();
        //employee.setName(name)
    }

    public void updateBirthdate(String code) {
        // .. employeee : code

    }




}
