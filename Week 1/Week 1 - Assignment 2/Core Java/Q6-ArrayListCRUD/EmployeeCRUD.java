import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeCRUD {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Employee CRUD Menu ---");
            System.out.println("1. Create Employee");
            System.out.println("2. Read All Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Department: ");
                    String dept = scanner.nextLine();
                    employees.add(new Employee(id, name, dept));
                    break;

                case 2:
                    if (employees.isEmpty()) {
                        System.out.println("No employees found.");
                    } else {
                        for (Employee emp : employees) {
                            emp.display();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();
                    boolean found = false;
                    for (Employee emp : employees) {
                        if (emp.getId() == updateId) {
                            System.out.print("Enter new name: ");
                            emp.setName(scanner.nextLine());
                            System.out.print("Enter new department: ");
                            emp.setDepartment(scanner.nextLine());
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Employee not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter ID to delete: ");
                    int deleteId = scanner.nextInt();
                    employees.removeIf(emp -> emp.getId() == deleteId);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
