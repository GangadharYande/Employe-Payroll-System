import java.util.ArrayList;
import java.util.List;

abstract class Employee{
    private String name;
    private int id;
    public Employee(String name, int id){ // Constructor
        this.name= name;
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }
    public abstract double calculateSalary();

    @Override
    public  String toString(){
        return "Employee[Name ="+name+",id="+id+",salary="+calculateSalary()+"]";
    }
}
class FullTimeEmployee extends Employee{
    private double monthlySalary;
    public FullTimeEmployee(String name, int id, double monthlySalary){
        super(name,id);
        this.monthlySalary=monthlySalary;
    }
    @Override
    public double calculateSalary(){
        return monthlySalary;
    }
}
class PartTimeEmployee extends Employee{
    private  int hoursWork;
    private  double hourlyRate;
    public PartTimeEmployee(String name, int id, int hoursWork,double hourlyRate){
        super(name, id);
        this.hourlyRate=hourlyRate;
        this.hoursWork=hoursWork;
    }
    @Override
    public double calculateSalary(){
        return hoursWork*hourlyRate;
    }
}

class PayRollSystem{
    private List<Employee> employeeList;
    public PayRollSystem(){
        employeeList = new ArrayList<>();
    }

    public void AddEmployee(Employee employee){
        employeeList.add(employee);
    }

    public void removeEmployee(int id){
        Employee employeeToRemove=null;
        for(Employee employee :employeeList){
            if(employee.getId()==id){
                employeeToRemove=employee;
                break;
            }
        }
        if(employeeToRemove != null){
            employeeList.remove(employeeToRemove);
        }
    }
    public void displayEmployee(){
        for(Employee employee : employeeList){
            System.out.println(employee);
        }
    }
}
public class Main {
    public static void main(String[] args) {
        PayRollSystem payRollSystem = new PayRollSystem();
        FullTimeEmployee emp1 = new FullTimeEmployee("Vickey",1056,70000);
        PartTimeEmployee emp2 = new PartTimeEmployee("Alex",2022,40,300);
        FullTimeEmployee emp3 = new FullTimeEmployee("Rosy",1012,45000);
        PartTimeEmployee emp4 = new PartTimeEmployee("Dana",6582,45,350);

        payRollSystem.AddEmployee(emp1);
        payRollSystem.AddEmployee(emp2);
        payRollSystem.AddEmployee(emp3);
        payRollSystem.AddEmployee(emp4);
        System.out.println("Initial Employee Details");
        payRollSystem.displayEmployee();
        System.out.println("Removing Employee");
        payRollSystem.removeEmployee(2022);
        System.out.println("Remaining Employee Details");
        payRollSystem.displayEmployee();

    }
}