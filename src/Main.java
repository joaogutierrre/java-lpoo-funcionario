import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Employee> employeeList = new ArrayList<>();

        System.out.println("Quantos funcionários deseja bonificar?");
        int qnt = input.nextInt();

        ArrayList<Employee> employees = insertData(qnt,input,employeeList);
        String returnedValues = verifyEmployeeSalary(employees);
        System.out.println(returnedValues);
    }

    private static ArrayList<Employee> insertData(int qnt, Scanner scanner, ArrayList<Employee> employeeList){
        Scanner input = scanner;
        for (int i = 1; i <= qnt; i++) {
            System.out.println("Insira o nome do funcionário");
            String nameEmployee = input.next();
            System.out.println("Agora, insira o salário do funcionário");
            int salaryEmployee = input.nextInt();

            System.out.println(nameEmployee + ", " + salaryEmployee);

            employeeList = insertEmployees(nameEmployee, salaryEmployee, qnt, employeeList);
        }
        return employeeList;
    }

    private static ArrayList<Employee> insertEmployees(String name, double salary, int qnt, ArrayList<Employee> employeeList) {
        for (int i = 1; i <= qnt; i++) {
            Employee employee = new Employee(name, salary);
            employeeList.add(employee);
            break;
        }
        return employeeList;
    }

    private static String verifyEmployeeSalary(ArrayList<Employee> employeeList) {
        double bonification = 0;
        double liquidSalary = 0;
        String stringStacker = "";
        String returnValues = "";

        for (Employee employee : employeeList) {
            String name = employee.getName();
            double salary = employee.getSalary();

            if (salary >= 0 && salary <= 1000.0) {
                bonification = 0.2;
                liquidSalary = salary + (salary * bonification);
                returnValues = "\n\nNome: " + name + "\nSalário: " + salary + "\nBonus: " + (bonification * salary) + "\nSalário líquido: " + liquidSalary;
                stringStacker += returnValues;
            }
            if (salary > 1000 && salary < 2000) {
                bonification = 0.1;
                liquidSalary = salary + (salary * bonification);
                returnValues = "\n\nNome: " + name + "\nSalário: " + salary + "\nBonus: " + (bonification * salary) + "\nSalário líquido: " + liquidSalary;
                stringStacker += returnValues;
            }
            if (salary > 2000) {
                bonification = 0.1;
                liquidSalary = salary - (salary * bonification);
                returnValues = "\n\nNome: " + name + "\nSalário: " + salary + "\nDesconto: " + (bonification * salary) + "\nSalário líquido: " + liquidSalary;
                stringStacker += returnValues;
            }
            returnValues = stringStacker;
        }
        return returnValues;
    }
}
