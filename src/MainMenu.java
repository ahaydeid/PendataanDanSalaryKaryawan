import java.util.List;
import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Main Menu");
            System.out.println("1. Add Employee");
            System.out.println("2. Edit Employee");
            System.out.println("3. Data Employee");
            System.out.println("4. Data Payroll");
            System.out.println("5. Delete Employee");
            System.out.println("6. Searching");
            System.out.println("7. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    editEmployee();
                    break;
                case 3:
                    displayEmployeeData(RepositoryEmployee.getAllEmployee());
                    break;
                case 4:
                    displayPayrollData(RepositoryEmployee.getAllEmployee());
                    break;
                case 5:
                    deleteEmployee();
                    break;
                case 6:
                    searchEmployeeByPlacement();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void addEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter employee type (1. Regular Employee, 2. Programmer, 3. Project Leader, 4. Analyst): ");
        int employeeType = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Address: ");
        String address = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter JobDesc: ");
        String jobDesc = scanner.nextLine();
        System.out.print("Enter Placement: ");
        String placement = scanner.nextLine();

        int nextEmployeeNumber = RepositoryEmployee.getAllEmployee().size() + 1;
        String formattedEmployeeId = String.format("%03d", nextEmployeeNumber);

        if (employeeType == 1) {
            Employee employee = new Employee(name, address, age, "", 0, jobDesc, placement);
            employee.setEmployeeId("Emp-" + formattedEmployeeId);
            employee.setSalary(Calculation.calculateSalary(employee));
            employee.setAllowance(Calculation.calculateAllowance(employee));
            RepositoryEmployee.getAllEmployee().add(employee);
        } else if (employeeType == 2) {
            System.out.print("Enter Programming Language: ");
            String programmingLanguage = scanner.nextLine();
            System.out.print("Enter Experiences: ");
            int experiences = scanner.nextInt();

            Programmer programmer = new Programmer(name, address, age, "", 0, jobDesc, placement, programmingLanguage, experiences);
            programmer.setEmployeeId("Pro-" + formattedEmployeeId);
            programmer.setSalary(Calculation.calculateSalary(programmer));
            programmer.setAllowance(Calculation.calculateAllowance(programmer));
            RepositoryEmployee.getAllEmployee().add(programmer);
        } else if (employeeType == 3) {
            System.out.print("Enter Total Projects: ");
            int totalProject = scanner.nextInt();

            ProjectLeader projectLeader = new ProjectLeader(name, address, age, "", 0, jobDesc, placement, totalProject);
            projectLeader.setEmployeeId("PrL-" + formattedEmployeeId);
            projectLeader.setSalary(Calculation.calculateSalary(projectLeader));
            projectLeader.setAllowance(Calculation.calculateAllowance(projectLeader));
            RepositoryEmployee.getAllEmployee().add(projectLeader);
        } else if (employeeType == 4) {
            Analyst analyst = new Analyst(name, address, age, "", 0, jobDesc, placement);
            analyst.setEmployeeId("Ana-" + formattedEmployeeId);
            analyst.setSalary(Calculation.calculateSalary(analyst));
            analyst.setAllowance(Calculation.calculateAllowance(analyst));
            RepositoryEmployee.getAllEmployee().add(analyst);
        } else {
            System.out.println("Invalid employee type.");
        }
    }




    private static void editEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter EmployeeId to edit: ");
        String employeeId = scanner.nextLine();

        Employee employeeToEdit = null;
        for (Employee employee : RepositoryEmployee.getAllEmployee()) {
            if (employee.getEmployeeId().equals(employeeId)) {
                employeeToEdit = employee;
                break;
            }
        }

        if (employeeToEdit != null) {
            System.out.print("Enter new Placement: ");
            String newPlacement = scanner.nextLine();
            employeeToEdit.setPlacement(newPlacement);

            // Recalculate salary and allowance
            employeeToEdit.setSalary(Calculation.calculateSalary(employeeToEdit));
            employeeToEdit.setAllowance(Calculation.calculateAllowance(employeeToEdit));

            System.out.println("Employee data updated.");
        } else {
            System.out.println("Employee not found.");
        }
    }


    private static void deleteEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter EmployeeId to delete: ");
        String employeeId = scanner.nextLine();

        Employee employeeToDelete = null;
        for (Employee employee : RepositoryEmployee.getAllEmployee()) {
            if (employee.getEmployeeId().equals(employeeId)) {
                employeeToDelete = employee;
                break;
            }
        }

        if (employeeToDelete != null) {
            RepositoryEmployee.getAllEmployee().remove(employeeToDelete);
            System.out.println("Employee deleted.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    private static void searchEmployeeByPlacement() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter placement to search: ");
        String placement = scanner.nextLine();

        System.out.println("Employee Data with Placement " + placement + ":");
        System.out.println("EmployeeId | Name | Address | Age | JobDesc | Placement");
        for (Employee employee : RepositoryEmployee.getAllEmployee()) {
            if (employee.getPlacement().equalsIgnoreCase(placement)) {
                System.out.println(employee.getEmployeeId() + " | " + employee.getName() + " | " + employee.getAddress() +
                        " | " + employee.getAge() + " | " + employee.getJobDesc() + " | " + employee.getPlacement());
            }
        }
    }

    private static void displayEmployeeData(List<Employee> employees) {
        System.out.println("Employee Data:");
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.printf("| %-2s | %-10s | %-10s | %-10s | %-4s | %-20s | %-15s |%n",
                "No", "EmployeeId", "Name", "Address", "Age", "JobDesc", "Placement");
        System.out.println("---------------------------------------------------------------------------------------------");
        int no = 1;
        for (Employee employee : employees) {
            System.out.printf("| %-2d | %-10s | %-10s | %-10s | %-4d | %-20s | %-15s |%n",
                    no, employee.getEmployeeId(), employee.getName(), employee.getAddress(),
                    employee.getAge(), employee.getJobDesc(), employee.getPlacement());
            no++;
        }
        System.out.println("---------------------------------------------------------------------------------------------");
    }

    private static void displayPayrollData(List<Employee> employees) {
        System.out.println("Payroll Data:");
        System.out.println("---------------------------------------------------------------------------------------------------");
        System.out.printf("| %-2s | %-10s | %-10s | %-20s | %-15s | %-10s | %-10s |%n",
                "No", "EmployeeId", "Name", "JobDesc", "Placement", "Allowance", "Salary");
        System.out.println("---------------------------------------------------------------------------------------------------");
        int no = 1;
        int totalPayroll = 0;
        for (Employee employee : employees) {
            System.out.printf("| %-2d | %-10s | %-10s | %-20s | %-15s | %-10d | %-10d |%n",
                    no, employee.getEmployeeId(), employee.getName(), employee.getJobDesc(),
                    employee.getPlacement(), (int) employee.getAllowance(), (int) employee.getSalary());
            no++;
            totalPayroll += (int) employee.getSalary() + (int) employee.getAllowance();
        }
        System.out.println("---------------------------------------------------------------------------------------------------");
        System.out.printf("| %-82s | %-10d |%n", "Total Payroll:", totalPayroll);
        System.out.println("---------------------------------------------------------------------------------------------------");
    }

}
