import java.util.Objects;

public class EmployeeBook {

    private final Employee[] employees = new Employee[10];

    public boolean addNewEmployee(Employee employee) {
        for (int i = 0; i < employees.length; i++) {
            if (Objects.isNull(employees[i])) {
                employees[i] = employee;
                return true;
            }
        }
        return false;
    }

    public void deleteEmployeeById(int id) {
        boolean isEmployeeFind = false;
        for (int i = 0; i < employees.length; i++) {
            if (Objects.isNull(employees[i])) {
                continue;
            }
            if (employees[i].getId() == id) {
                employees[i] = null;
                isEmployeeFind = true;
                System.out.println("Сотрудник удален.");
                break;
            }
        }
        if (!isEmployeeFind) {
            throw new IllegalArgumentException("Сотрудник не найден!");
        }
    }

    public Employee getEmployeeById(int id) {
        for (Employee employee : employees) {
            if (Objects.isNull(employee)) {
                continue;
            }
            if (employee.getId() == id) {
                return employee;
            }
        }
        throw new IllegalArgumentException("Сотрудник не найден!");
    }

    public void getListOfAllEmployees() {
        for (Employee employee : employees) {
            if (Objects.isNull(employee)) {
                continue;
            }
            System.out.println(employee);
        }
    }

    public int calculatingSumExpenses() {
        int sum = 0;
        for (Employee employee : employees) {
            if (Objects.isNull(employee)) {
                continue;
            }
            sum += employee.getSalary();
        }
        return sum;
    }

    public Employee findEmployeeWithMinSalary() {
        int salary = Integer.MAX_VALUE;
        Employee employeeWithMinSalary = null;
        for (Employee employee : employees) {
            if (Objects.isNull(employee)) {
                continue;
            }
            if (employee.getSalary() < salary) {
                salary = employee.getSalary();
                employeeWithMinSalary = employee;
            }
        }
        return employeeWithMinSalary;
    }

    public Employee findEmployeeWithMaxSalary() {
        int salary = Integer.MIN_VALUE;
        Employee employeeWithMaxSalary = null;
        for (Employee employee : employees) {
            if (Objects.isNull(employee)) {
                continue;
            }
            if (employee.getSalary() > salary) {
                salary = employee.getSalary();
                employeeWithMaxSalary = employee;
            }
        }
        return employeeWithMaxSalary;
    }

    public int calculatedAverageSalary() {
        int count = 0;
        for (Employee employee : employees) {
            if (Objects.isNull(employee)) {
                continue;
            }
            count++;
        }
        if (count == 0) {
            throw new ArithmeticException("Сотрудники не найдены!");
        }
        return calculatingSumExpenses() / count;
    }

    public void printAllFullName() {
        for (Employee employee : employees) {
            if (Objects.isNull(employee)) {
                continue;
            }
            System.out.println(employee.getFullName());
        }
    }

    public void indexingSalaryAllEmployees(int percent) {
        for (Employee employee : employees) {
            if (Objects.isNull(employee)) {
                continue;
            }
            employee.setSalary(employee.getSalary() + employee.getSalary() * percent / 100);
        }
    }

    public Employee findEmployeeWithMinSalaryByDepartment(int department) {
        int salary = Integer.MAX_VALUE;
        Employee employeeWithMinSalary = null;
        for (Employee employee : findEmployeesByDepartment(department)) {
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

    public Employee findEmployeeWithMaxSalaryByDepartment(int department) {
        int salary = Integer.MIN_VALUE;
        Employee employeeWithMaxSalary = null;
        for (Employee employee : findEmployeesByDepartment(department)) {
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

    public int calculatingSumExpensesByDepartment(int department) {
        int sum = 0;
        for (Employee employee : findEmployeesByDepartment(department)) {
            if (Objects.isNull(employee)) {
                break;
            }
            sum += employee.getSalary();
        }
        return sum;
    }

    public int calculatedAverageSalaryByDepartment(int department) {
        int count = 0;
        for (Employee employee : findEmployeesByDepartment(department)) {
            if (Objects.isNull(employee)) {
                break;
            }
            count++;
        }
        return calculatingSumExpensesByDepartment(department) / count;
    }

    public void indexingSalaryEmployeesByDepartment(int department, int percent) {
        for (Employee employee : findEmployeesByDepartment(department)) {
            if (Objects.isNull(employee)) {
                break;
            }
            employee.setSalary(employee.getSalary() + employee.getSalary() * percent / 100);
        }
    }

    public void getListOfEmployeesByDepartment(int department) {
        for (Employee employee : findEmployeesByDepartment(department)) {
            if (Objects.isNull(employee)) {
                break;
            }
            printEmployeeWithoutDepartment(employee);
        }
    }

    public void getListOfAllEmployeesWithMinSalary(int maxSalary) {
        System.out.println("Сотрудники с з/п меньше " + maxSalary + ":");
        int count = 0;
        for (Employee employee : employees) {
            if (Objects.isNull(employee)) {
                continue;
            }
            if (employee.getSalary() < maxSalary) {
                printEmployeeWithoutDepartment(employee);
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Сотрудники не найдены!");
        }
    }

    public void getListOfAllEmployeesWithMaxSalary(int minSalary) {
        System.out.println("Сотрудники с з/п больше " + minSalary + ":");
        int count = 0;
        for (Employee employee : employees) {
            if (Objects.isNull(employee)) {
                continue;
            }
            if (employee.getSalary() > minSalary) {
                printEmployeeWithoutDepartment(employee);
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Сотрудники не найдены!");
        }
    }

    private void printEmployeeWithoutDepartment(Employee employee) {
        System.out.println("id = " + employee.getId() +
                ", fullName = " + employee.getFullName() +
                ", salary = " + employee.getSalary());
    }

    private Employee[] findEmployeesByDepartment(int departmentNumber) {
        Employee[] employeesDepartment = new Employee[employees.length];
        int index = 0;
        for (Employee employee : employees) {
            if (Objects.isNull(employee)) {
                continue;
            }
            if (employee.getDepartment() == departmentNumber) {
                employeesDepartment[index] = employee;
                index++;
            }
        }
        if (Objects.isNull(employeesDepartment[0])) {
            throw new IllegalArgumentException("В этом отделе нет сотрудников!");
        }

        return employeesDepartment;
    }
}
