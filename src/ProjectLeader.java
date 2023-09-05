public class ProjectLeader extends Employee {
    private int totalProject;

    public ProjectLeader(String name, String address, int age, String employeeId, double salary, String jobDesc, String placement, int totalProject) {
        super(name, address, age, employeeId, salary, jobDesc, placement);
        this.totalProject = totalProject;
    }

    public int getTotalProject() {
        return totalProject;
    }

    public void setTotalProject(int totalProject) {
        this.totalProject = totalProject;
    }
}
