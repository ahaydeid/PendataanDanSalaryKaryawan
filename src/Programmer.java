public class Programmer extends Employee {
    private String programmingLanguage;
    private int experiences;

    public Programmer(String name, String address, int age, String employeeId, double salary, String jobDesc, String placement, String programmingLanguage, int experiences) {
        super(name, address, age, employeeId, salary, jobDesc, placement);
        this.programmingLanguage = programmingLanguage;
        this.experiences = experiences;
    }



    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    public int getExperiences() {
        return experiences;
    }

    public void setExperiences(int experiences) {
        this.experiences = experiences;
    }
}
