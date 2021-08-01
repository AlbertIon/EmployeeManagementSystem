package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Employee employee = new Employee();

      Scanner scanner = new Scanner(System.in);
        System.out.println("1 - Add a new employee\n2 - Promote an employee\n3 - Remove an employee\nWhat do you want to do in the Employees System?\nHere just type the number");
        int method = scanner.nextInt();

        switch (method) {
            case 1:
                employee.addEmployee();
                break;

            case 2:
                employee.promoteEmployee();
                break;

            case 3:
                employee.removeEmployee();
                break;
        }



    }
}
