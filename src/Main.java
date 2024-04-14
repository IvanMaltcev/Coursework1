import java.util.Objects;

public class Main {
    public static void main(String[] args) {

        Employee[] employees = new Employee[10];

        employees[0] = new Employee("Иванов Иван Игоревич", 1, 10000);
        employees[1] = new Employee("Петров Игорь Николаевич", 1, 20000);
        employees[2] = new Employee("Сидорова Маргарита Петровна", 2, 21000);
        getListOfAllEmployees(employees);
        System.out.println(calculatingSumExpenses(employees));
        System.out.println(findEmployeeWithMinSalary(employees));
        System.out.println(findEmployeeWithMaxSalary(employees));
        System.out.println(calculatedAverageSalary(employees));
        printAllFullName(employees);

    }

    public static void getListOfAllEmployees(Employee[] employees) {
        for (Employee employee : employees) {
            if (Objects.isNull(employee)) {
                break;
            }
            System.out.println(employee);
        }
    }
    public static int calculatingSumExpenses(Employee[] employees) {
        int sum = 0;
        for (Employee employee : employees) {
            if (Objects.isNull(employee)) {
                break;
            }
            sum += employee.getSalary();
        }
        return sum;
    }
    public static Employee findEmployeeWithMinSalary(Employee[] employees) {
        int salary = Integer.MAX_VALUE;
        Employee employeeWithMinSalary = null;
        for (Employee employee : employees) {
            if (Objects.isNull(employee)) {
                break;
            }
            if (employee.getSalary() < salary) {
                salary = employee.getSalary();
                employeeWithMinSalary = employee;
            }
        }
        return employeeWithMinSalary;
    }
    public static Employee findEmployeeWithMaxSalary (Employee[] employees) {
        int salary = Integer.MIN_VALUE;
        Employee employeeWithMaxSalary = null;
        for (Employee employee : employees) {
            if (Objects.isNull(employee)) {
                break;
            }
            if (employee.getSalary() > salary) {
                salary = employee.getSalary();
                employeeWithMaxSalary = employee;
            }
        }
        return employeeWithMaxSalary;
    }
    public static int calculatedAverageSalary(Employee[] employees) {
        int count = 0;
        for (Employee employee : employees) {
            if (Objects.isNull(employee)) {
                break;
            }
            count++;
        }
        return calculatingSumExpenses(employees) / count;
    }
    public static void printAllFullName(Employee[] employees) {
        for (Employee employee : employees) {
            if (Objects.isNull(employee)) {
                break;
            }
            System.out.println(employee.getFullName());
        }
    }
}