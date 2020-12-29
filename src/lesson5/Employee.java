package lesson5;

public class Employee {
    private String displayName;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    public int getAge() {
        return age;
    }

    public Employee(String displayName, String position, String email, String phone, int salary, int age) {
        this.displayName = displayName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void info() {
        System.out.println("Name: " + displayName
                + " Position: " + position
                + " Email: " + email
                + " Phone: " + phone
                + " Salary: " + salary
                + " Age: " + age);
    }
}
