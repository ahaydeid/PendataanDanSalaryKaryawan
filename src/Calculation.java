public class Calculation {
    public static double calculateSalary(Employee employee) {
        Placement placement = Placement.valueOf(employee.getPlacement().toUpperCase());
        double salaryPercentage = 1.0; // Employee
        if (employee instanceof Programmer) {
            salaryPercentage = 1.5;
        } else if (employee instanceof ProjectLeader) {
            salaryPercentage = 2.0;
        } else if (employee instanceof Analyst) {
            salaryPercentage = 1.6;
        }
        return placement.getUmk() * salaryPercentage;
    }

    public static double calculateAllowance(Employee employee) {
        if (employee instanceof Programmer) {
            Programmer programmer = (Programmer) employee;
            if (programmer.getExperiences() > 4) {
                return 0.2 * employee.getSalary();
            } else {
                return 0.1 * employee.getSalary();
            }
        } else if (employee instanceof ProjectLeader) {
            ProjectLeader projectLeader = (ProjectLeader) employee;
            if (projectLeader.getTotalProject() >= 2) {
                return 0.15 * employee.getSalary();
            } else {
                return 0.05 * employee.getSalary();
            }
        } else if (employee instanceof Analyst) {
            return 0.05 * employee.getSalary();
        } else {
            return 0.0;
        }
    }
}
