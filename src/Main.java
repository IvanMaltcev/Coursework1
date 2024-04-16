import java.util.Objects;

public class Main {
    public static void main(String[] args) {

        Employee[] employees = new Employee[10];

        employees[0] = new Employee("Иванов Иван Игоревич", 1, 60000);
        employees[1] = new Employee("Петров Игорь Николаевич", 1, 62000);
        employees[2] = new Employee("Сидорова Маргарита Петровна", 2, 55000);
        employees[3] = new Employee("Новиков Борис Андреевич", 4, 80000);
        employees[4] = new Employee("Попов Константин Евгеньевич", 3, 46000);
        employees[5] = new Employee("Григорьева Наталья Александровна", 2, 58000);
        employees[6] = new Employee("Волков Дмитрий Валерьевич", 3, 45000);
        employees[7] = new Employee("Лисицина Елизовета Павловна", 1, 64000);
        System.out.println("Список сотрудников: ");
        getListOfAllEmployees(employees);
        System.out.println("Сумма затрат на з/п в месяц: \n" + calculatingSumExpenses(employees));
        System.out.println("Сотрудник с минимальной з/п: \n" + findEmployeeWithMinSalary(employees));
        System.out.println("Сотрудник с максимальной з/п: \n" + findEmployeeWithMaxSalary(employees));
        System.out.println("Среднее значение зарплат: \n" + calculatedAverageSalary(employees));
        printAllFullName(employees);

        indexingSalaryAllEmployees(employees, 5);

        int departmentNumber = 1;
        Employee[] employeesByDepartment = findEmployeesByDepartment(employees, departmentNumber);

        System.out.println("Сотрудник отдела с минимальной з/п: \n"
                + findEmployeeWithMinSalaryByDepartment(employeesByDepartment));
        System.out.println("Сотрудник отдела с максимальной з/п: \n"
                + findEmployeeWithMaxSalaryByDepartment(employeesByDepartment));
        System.out.println("Сумма затрат на з/п по отделу " + departmentNumber + ":\n"
                + calculatingSumExpensesByDepartment(employeesByDepartment));
        System.out.println("Средняя з/п по отделу " + departmentNumber + ":\n"
                + calculatedAverageSalaryByDepartment(employeesByDepartment));
        indexingSalaryEmployeesByDepartment(employeesByDepartment, 10);
        getListOfEmployeesByDepartment(employeesByDepartment);


        getListOfAllEmployeesWithMinSalary(employees, 50000);
        getListOfAllEmployeesWithMaxSalary(employees, 70000);

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

    public static Employee findEmployeeWithMaxSalary(Employee[] employees) {
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

    public static void indexingSalaryAllEmployees(Employee[] employees, int percent) {
        for (Employee employee : employees) {
            if (Objects.isNull(employee)) {
                break;
            }
            employee.setSalary(employee.getSalary() + employee.getSalary() * percent / 100);
        }
    }

    public static Employee findEmployeeWithMinSalaryByDepartment(Employee[] employees) {
        return findEmployeeWithMinSalary(employees);
    }

    public static Employee findEmployeeWithMaxSalaryByDepartment(Employee[] employees) {
        return findEmployeeWithMaxSalary(employees);
    }

    public static int calculatingSumExpensesByDepartment(Employee[] employees) {
        return calculatingSumExpenses(employees);
    }

    public static int calculatedAverageSalaryByDepartment(Employee[] employees) {
        return calculatedAverageSalary(employees);
    }

    public static void indexingSalaryEmployeesByDepartment(Employee[] employees, int percent) {
        indexingSalaryAllEmployees(employees, percent);
    }

    public static void getListOfEmployeesByDepartment(Employee[] employees) {
        System.out.println("Сотрудники отдела " + employees[0].getDepartment() + ":");
        for (Employee employee : employees) {
            if (Objects.isNull(employee)) {
                break;
            }
            printEmployeeWithoutDepartment(employee);
        }
    }

    public static void getListOfAllEmployeesWithMinSalary(Employee[] employees, int maxSalary) {
        System.out.println("Сотрудники с з/п меньше " + maxSalary + ":");
        int count = 0;
        for (Employee employee : employees) {
            if (Objects.isNull(employee)) {
                break;
            } else if (employee.getSalary() < maxSalary) {
                printEmployeeWithoutDepartment(employee);
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Сотрудники не найдены!");
        }
    }

    public static void getListOfAllEmployeesWithMaxSalary(Employee[] employees, int minSalary) {
        System.out.println("Сотрудники с з/п больше " + minSalary + ":");
        int count = 0;
        for (Employee employee : employees) {
            if (Objects.isNull(employee)) {
                break;
            } else if (employee.getSalary() > minSalary) {
                printEmployeeWithoutDepartment(employee);
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Сотрудники не найдены!");
        }
    }

    private static void printEmployeeWithoutDepartment(Employee employee) {
        System.out.println("id = " + employee.getId() +
                ", fullName = " + employee.getFullName() +
                ", salary = " + employee.getSalary());
    }

    private static Employee[] findEmployeesByDepartment(Employee[] employees, int departmentNumber) {
        Employee[] employeesDepartment = new Employee[employees.length];
        int index = 0;
        for (Employee employee : employees) {
            if (Objects.isNull(employee)) {
                break;
            } else if (employee.getDepartment() == departmentNumber) {
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