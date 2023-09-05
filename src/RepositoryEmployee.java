import java.util.ArrayList;
import java.util.List;

public class RepositoryEmployee {
    private static List<Employee> employees = new ArrayList<>();

    static {
        employees.add(new Employee("Susi", "Bandung", 27, "Emp-001", Calculation.calculateSalary(new Employee("Susi", "Bandung", 27, "Emp-001", 0, "Admin", "Jakarta")), "Admin", "Jakarta"));
        employees.add(new Employee("Anto", "Bandung", 35, "Emp-002", Calculation.calculateSalary(new Employee("Anto", "Bandung", 35, "Emp-002", 0, "Office Boy", "Bandung")), "Office Boy", "Bandung"));
        employees.add(new Employee("Riman", "Jakarta", 28, "Emp-003", Calculation.calculateSalary(new Employee("Riman", "Jakarta", 28, "Emp-003", 0, "Human Resource Dev", "Bandung")), "Human Resource Dev", "Bandung"));

        employees.add(new Programmer("Budi", "Bandung", 25, "Pro-004", Calculation.calculateSalary(new Programmer("Budi", "Bandung", 25, "Prog-001", 0, "Back End Dev", "Jakarta", "Java", 2)), "Back End Dev", "Jakarta", "Java", 2));
        employees.add(new Programmer("Ani", "Bandung", 30, "Pro-005", Calculation.calculateSalary(new Programmer("Ani", "Bandung", 30, "Prog-002", 0, "Front End Dev", "Bandung", "React Js", 6)), "Front End Dev", "Bandung", "React Js", 6));
        employees.add(new Programmer("Ujang", "Jakarta", 28, "Pro-006", Calculation.calculateSalary(new Programmer("Ujang", "Jakarta", 28, "Prog-003", 0, "Full Stack Dev", "Bandung", "Kotlin", 4)), "Full Stack Dev", "Bandung", "Kotlin", 4));

        employees.add(new ProjectLeader("Ahmad", "Bandung", 25, "PrL-007", Calculation.calculateSalary(new ProjectLeader("Ahmad", "Bandung", 25, "PL-001", 0, "Project Leader", "Garut", 2)), "Project Leader", "Garut", 2));
        employees.add(new ProjectLeader("Dani", "Bandung", 30, "PrL-008", Calculation.calculateSalary(new ProjectLeader("Dani", "Bandung", 30, "PL-002", 0, "Scrum Master", "Bekasi", 1)), "Scrum Master", "Bekasi", 1));
        employees.add(new ProjectLeader("Cecep", "Jakarta", 28, "PrL-009", Calculation.calculateSalary(new ProjectLeader("Cecep", "Jakarta", 28, "PL-003", 0, "Project Owner", "Bogor", 4)), "Project Owner", "Bogor", 4));

        employees.add(new Analyst("Indah", "Garut", 25, "Ana-010", Calculation.calculateSalary(new Analyst("Indah", "Garut", 25, "AL-001", 0, "Analyst", "Jakarta")), "Analyst", "Jakarta"));
        employees.add(new Analyst("Puspa", "Bandung", 30, "Ana-011", Calculation.calculateSalary(new Analyst("Puspa", "Bandung", 30, "AL-002", 0, "Analyst", "Bekasi")), "Analyst", "Bekasi"));
        employees.add(new Analyst("Sari", "Jakarta", 28, "Ana-012", Calculation.calculateSalary(new Analyst("Sari", "Jakarta", 28, "AL-003", 0, "Analyst", "Bogor")), "Analyst", "Bogor"));
    }

    public static List<Employee> getAllEmployee() {
        return employees;
    }
}
