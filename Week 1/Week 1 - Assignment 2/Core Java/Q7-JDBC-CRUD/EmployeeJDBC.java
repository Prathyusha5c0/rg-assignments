import java.sql.*;
import java.util.Scanner;

public class EmployeeJDBC {
    static final String DB_URL = ""; //database url
    static final String USER = ""; // user name
    static final String PASS = ""; // password
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement()) {

            System.out.println("Connected to database!");

            while (true) {
                System.out.println("\n1. Add Employee\n2. View All\n3. Update Employee\n4. Delete Employee\n5. Exit");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Enter ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Department: ");
                        String dept = scanner.nextLine();
                        String insertSQL = "INSERT INTO employee (id, name, department) VALUES (?, ?, ?)";
                        try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
                            pstmt.setInt(1, id);
                            pstmt.setString(2, name);
                            pstmt.setString(3, dept);
                            pstmt.executeUpdate();
                            System.out.println("Employee added.");
                        }
                        break;

                    case 2:
                        ResultSet rs = stmt.executeQuery("SELECT * FROM employee");
                        while (rs.next()) {
                            System.out.println("ID: " + rs.getInt("id") +
                                    ", Name: " + rs.getString("name") +
                                    ", Dept: " + rs.getString("department"));
                        }
                        break;

                    case 3:
                        System.out.print("Enter ID to update: ");
                        int upId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter new name: ");
                        String upName = scanner.nextLine();
                        System.out.print("Enter new dept: ");
                        String upDept = scanner.nextLine();
                        String updateSQL = "UPDATE employee SET name=?, department=? WHERE id=?";
                        try (PreparedStatement pstmt = conn.prepareStatement(updateSQL)) {
                            pstmt.setString(1, upName);
                            pstmt.setString(2, upDept);
                            pstmt.setInt(3, upId);
                            pstmt.executeUpdate();
                            System.out.println("Employee updated.");
                        }
                        break;

                    case 4:
                        System.out.print("Enter ID to delete: ");
                        int delId = scanner.nextInt();
                        String delSQL = "DELETE FROM employee WHERE id=?";
                        try (PreparedStatement pstmt = conn.prepareStatement(delSQL)) {
                            pstmt.setInt(1, delId);
                            pstmt.executeUpdate();
                            System.out.println("Employee deleted.");
                        }
                        break;

                    case 5:
                        System.out.println("Exiting...");
                        return;

                    default:
                        System.out.println("Invalid choice!");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
