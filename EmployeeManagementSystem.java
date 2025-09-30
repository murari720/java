import java.io.*;
import java.util.*;

class Employee {
    int id;
    String name;
    String designation;
    double salary;

    Employee(int id, String name, String designation, double salary) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + designation + "," + salary;
    }

    public String display() {
        return "ID: " + id + " | Name: " + name + " | Designation: " + designation + " | Salary: " + salary;
    }
}

public class EmployeeManagementSystem {
    private static final String FILE_NAME = "employees.txt";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Employee Management Menu ---");
            System.out.println("1. Add Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: addEmployee(sc); break;
                case 2: displayEmployees(); break;
                case 3: System.out.println("Exiting..."); sc.close(); return;
                default: System.out.println("Invalid choice!");
            }
        }
    }

    private static void addEmployee(Scanner sc) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            System.out.print("Enter Employee ID: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Designation: ");
            String desig = sc.nextLine();
            System.out.print("Enter Salary: ");
            double salary = sc.nextDouble();

            Employee emp = new Employee(id, name, desig, salary);
            bw.write(emp.toString());
            bw.newLine();
            System.out.println("Employee record added.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void displayEmployees() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            if ((line = br.readLine()) == null) {
                System.out.println("No employee records found.");
                return;
            }
            do {
                String[] data = line.split(",");
                Employee emp = new Employee(Integer.parseInt(data[0]), data[1], data[2], Double.parseDouble(data[3]));
                System.out.println(emp.display());
            } while ((line = br.readLine()) != null);
        } catch (FileNotFoundException e) {
            System.out.println("No employee records found.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
