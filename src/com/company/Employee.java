package com.company;

import java.sql.*;
import java.util.Scanner;

public class Employee {

    private String firstName;
    private String lastName;
    private int employeeID;
    private String department;
    private int salary;
    private String position;
    char euro = '€';



    public void addEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first name of the new employee!");
        this.firstName = scanner.nextLine();

        System.out.println("Enter the last name of the new employee!");
        this.lastName = scanner.nextLine();

        System.out.println(" - Accounting\n - Technology\n - Sales\n - HR\nEnter the department for the employee!");
        this.department = scanner.nextLine();

        System.out.println(" - Junior\n - Medior\n - Senior\nSelect the new employee's position!");
        this.position = scanner.nextLine();

        System.out.println("Type the new employee's salary!");
        this.salary = scanner.nextInt();

        System.out.println("The new employee: " + firstName + " " +  lastName + "\nDepartment: " + department + "\nPosition: " + position + "\nSalary: " + salary + euro +"\nHas been added with success to the system!");

        employeeID ++;


        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost3306/employees_system", "admin", "admin");

            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("insert into employees (First name, Last name, Department, Position, Salary) values (" + firstName + lastName + department + position +salary +")");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }





    public void promoteEmployee() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the ID of the employee you want to promote!");
        int idToPromote = scanner.nextInt();

        System.out.println("Type the position you want the employee to promote to!");
        String newPosition = scanner.nextLine();

        System.out.println("The employee has been successfully promoted to the position " + newPosition);

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost3306/employees_system", "admin", "admin");

            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("update employees set position = " + newPosition + " where " + idToPromote + " = " + employeeID);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the ID of the employee you want to remove!");
        int idToRemove = scanner.nextInt();
        System.out.println("The employee " + firstName + lastName + " has been successfully removed from the system!");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost3306/employees_system", "admin", "admin");

            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(" delete from employees where " + idToRemove + " = " + employeeID);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }



}
