import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Employee> employeeList = new ArrayList<>();

        System.out.println("Quantos funcionários deseja bonificar?");
        int qnt = input.nextInt();

        for (int i = 1; i <= qnt; i++) {
            System.out.println("Insira o nome do funcionário");
            String nameEmployee = input.next();
            System.out.println("Agora, insira o salário do funcionário");
            int salaryEmployee = input.nextInt();

//            System.out.println(nameEmployee + ", " + salaryEmployee);

            employeeList = insertEmployees(nameEmployee, salaryEmployee, qnt, employeeList);
        }

        double bonification = 0;
        double liquidSalary = 0;

        for (Employee employee : employeeList) {
            String name = employee.getName();
            double salary = employee.getSalary();

            System.out.println();

            if (salary >= 0 && salary <= 1000.0) {
                bonification = 0.2;
                liquidSalary = salary + (salary * bonification);
            }
            if(salary > 1000 && salary < 2000){
                bonification = 0.1;
                liquidSalary = salary + (salary * bonification);
            }
            if(salary > 2000){
                bonification = 0.1;
                liquidSalary = salary - (salary * bonification);
            }

            System.out.println("Funcionário: " + name);
            System.out.println("Salário: " + salary);
            System.out.println("Bonus: " + (bonification * salary));
            System.out.println("Salário líquido: " + liquidSalary);
        }
    }

    private static ArrayList<Employee> insertEmployees(String name, double salary, int qnt, ArrayList<Employee> employeeList) {
        for (int i = 1; i <= qnt; i++) {
            Employee employee = new Employee(name, salary);
            employeeList.add(employee);
            break;
        }
        return employeeList;
    }

    private static String verifyEmployeeSalary(double salary, ArrayList<Employee> employeeList) {
        double bonification = 0;
        double liquidSalary = 0;

        for (Employee employee : employeeList) {
            if (salary >= 0 && salary <= 1000.0) {
                bonification = 0.2;
                liquidSalary = salary + (salary * bonification);
            }
            if(salary > 1000 && salary < 2000){
                bonification = 0.1;
                liquidSalary = salary + (salary * bonification);
            }
            if(salary > 2000){
                bonification = 0.1;
                liquidSalary = salary - (salary * bonification);
            }
        }
        return "";
    }

//    private static ArrayList<Employee> instatiateList(){
//        ArrayList<Employee> employeeList = new ArrayList<>();
//        return employeeList;
//    }
}
