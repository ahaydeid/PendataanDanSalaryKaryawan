public class Employee extends Person {
    private String employeeId;
    private double salary;
    private String jobDesc;
    private String placement;
    private double allowance;

    public Employee(String name, String address, int age, String employeeId, double salary, String jobDesc, String placement) {
        super(name, address, age);
        this.employeeId = employeeId;
        this.salary = salary;
        this.jobDesc = jobDesc;
        this.placement = placement;
        this.allowance = Calculation.calculateAllowance(this);
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getJobDesc() {
        return jobDesc;
    }

    public void setJobDesc(String jobDesc) {
        this.jobDesc = jobDesc;
    }

    public String getPlacement() {
        return placement;
    }

    public void setPlacement(String placement) {
        this.placement = placement;
    }

    public double getAllowance() {
        return allowance;
    }

    public void setAllowance(double allowance) {
        this.allowance = allowance;
    }
}
