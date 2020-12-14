package lesson5;

public class Main {
    public static void main(String[] args) {

        Employee[] employees = new  Employee[5];
        employees[0] = new Employee("Ivanov Ivan","CEO", "whocares@nowhere.com","+7callme",10000000,65);
        employees[1] = new Employee("Ivanov Oleg","Manager", "whocares@nowhere.com","+7notcallme",200000,25);
        employees[2] = new Employee("Petrov Nikolay","Worker", "anotherone@nowhere.com","+78765768",500000,43);
        employees[3] = new Employee("Belov Valentin","IT", "vhgjhk@nowhere.com","+35689789",16576000,39);
        employees[4] = new Employee("Ivanov Ivan","Developer", "hjkjkljg@nowhere.com","+7578879",10000000,58);

        for (Employee employee : employees) {
            if (employee.getAge() > 40) employee.info();
        }
    }
}
