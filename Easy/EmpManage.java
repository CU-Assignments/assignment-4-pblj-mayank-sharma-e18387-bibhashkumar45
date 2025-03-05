import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Salary: " + salary;
    }
}

class EmpManage {
    private static ArrayList<Employee> empList = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void addEmp() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();
        empList.add(new Employee(id, name, salary));
        System.out.println("Employee Added Successfully!\n");
    }

    public static void updateEmp() {
        System.out.print("Enter Employee ID to Update: ");
        int id = sc.nextInt();
        for (Employee e : empList) {
            if (e.getId() == id) {
                sc.nextLine();
                System.out.print("Enter New Name: ");
                e.setName(sc.nextLine());
                System.out.print("Enter New Salary: ");
                e.setSalary(sc.nextDouble());
                System.out.println("Employee Updated Successfully!\n");
                return;
            }
        }
        System.out.println("Employee Not Found!\n");
    }

    public static void removeEmp() {
        System.out.print("Enter Employee ID to Remove: ");
        int id = sc.nextInt();
        empList.removeIf(e -> e.getId() == id);
        System.out.println("Employee Removed (if existed)!\n");
    }

    public static void searchEmp() {
        System.out.print("Enter Employee ID to Search: ");
        int id = sc.nextInt();
        for (Employee e : empList) {
            if (e.getId() == id) {
                System.out.println("Employee Found: " + e + "\n");
                return;
            }
        }
        System.out.println("Employee Not Found!\n");
    }

    public static void displayEmp() {
        if (empList.isEmpty()) {
            System.out.println("No Employees Available!\n");
            return;
        }
        System.out.println("Employee List:");
        for (Employee e : empList) {
            System.out.println(e);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Add Employee\n2. Update Employee\n3. Remove Employee\n4. Search Employee\n5. Display Employees\n6. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> addEmp();
                case 2 -> updateEmp();
                case 3 -> removeEmp();
                case 4 -> searchEmp();
                case 5 -> displayEmp();
                case 6 -> {
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid Option! Try Again.\n");
            }
        }
    }
}
