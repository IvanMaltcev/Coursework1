public class Main {
    public static void main(String[] args) {

        EmployeeBook employeeBook = new EmployeeBook();

        System.out.println(employeeBook.addNewEmployee(new Employee
                ("Иванов Иван Игоревич", 1, 60000)));
        System.out.println(employeeBook.addNewEmployee(new Employee
                ("Петров Игорь Николаевич", 1, 62000)));
        System.out.println(employeeBook.addNewEmployee(new Employee
                ("Сидорова Маргарита Петровна", 2, 55000)));
        System.out.println(employeeBook.addNewEmployee(new Employee
                ("Новиков Борис Андреевич", 4, 80000)));
        System.out.println(employeeBook.addNewEmployee(new Employee
                ("Попов Константин Евгеньевич", 3, 46000)));
        System.out.println(employeeBook.addNewEmployee(new Employee
                ("Григорьева Наталья Александровна", 2, 58000)));
        System.out.println(employeeBook.addNewEmployee(new Employee
                ("Волков Дмитрий Валерьевич", 3, 45000)));
        System.out.println(employeeBook.addNewEmployee(new Employee
                ("Лисицина Елизовета Павловна", 1, 64000)));
        System.out.println(employeeBook.addNewEmployee(new Employee
                ("Полушкина Анастасия Сергеевна", 2, 52000)));
        System.out.println(employeeBook.addNewEmployee(new Employee
                ("Кондратьев Семен Алексеевич", 4, 85000)));
        System.out.println(employeeBook.addNewEmployee(new Employee
                ("Колесников Виталий Иванович", 5, 101000)));

        employeeBook.deleteEmployeeById(1);
        employeeBook.deleteEmployeeById(4);
        System.out.println(employeeBook.addNewEmployee(new Employee
                ("Волевой Игорь Борисович", 1, 60000)));
        System.out.println(employeeBook.getEmployeeById(3));

        System.out.println("Список сотрудников:");
        employeeBook.getListOfAllEmployees();
        System.out.println("Сумма затрат на з/п в месяц:\n"
                + employeeBook.calculatingSumExpenses());
        System.out.println("Сотрудник с минимальной з/п:\n"
                + employeeBook.findEmployeeWithMinSalary());
        System.out.println("Сотрудник с максимальной з/п:\n"
                + employeeBook.findEmployeeWithMaxSalary());
        System.out.println("Среднее значение зарплат:\n"
                + employeeBook.calculatedAverageSalary());
        employeeBook.printAllFullName();

        employeeBook.indexingSalaryAllEmployees(5);

        int departmentNumber = 1;
        System.out.println("Сотрудник отдела с минимальной з/п: \n"
                + employeeBook.findEmployeeWithMinSalaryByDepartment(departmentNumber));
        System.out.println("Сотрудник отдела с максимальной з/п: \n"
                + employeeBook.findEmployeeWithMaxSalaryByDepartment(departmentNumber));
        System.out.println("Сумма затрат на з/п по отделу:\n"
                + employeeBook.calculatingSumExpensesByDepartment(departmentNumber));
        System.out.println("Средняя з/п по отделу:\n"
                + employeeBook.calculatedAverageSalaryByDepartment(departmentNumber));
        employeeBook.indexingSalaryEmployeesByDepartment(departmentNumber, 10);
        System.out.println("Сотрудники отдела:");
        employeeBook.getListOfEmployeesByDepartment(departmentNumber);

        employeeBook.getListOfAllEmployeesWithMinSalary(50000);
        employeeBook.getListOfAllEmployeesWithMaxSalary(70000);
    }
}