import java.util.Objects;

public class Employee {

    private static int counter;
    private final int id;
    private final String fullName;
    private int department;
    private int salary;

    public Employee(String fullName, int department, int salary) {
        id = incrementCounter() ;
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
    }

    public static int incrementCounter() {
        return ++counter;
    }
    public int getId() {
        return id;
    }
    public String getFullName() {
        return fullName;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "id = " + id +
                ", fullName = " + fullName +
                ", department = " + department +
                ", salary = " + salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(fullName, employee.fullName)
                && Objects.equals(department, employee.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, department);
    }
}
