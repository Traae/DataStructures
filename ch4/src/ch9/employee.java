package ch9;
import java.util.Objects;
public class employee implements Comparable<employee> {

    // instances variables
    private String name;
    private double salary;

    // Cionstructor
    public employee (String n, double sal) {
        name = n;
        salary = sal;
    }

    // GET & SET
    public double getSalary() { return salary; }
    public String getName() { return name;}
    public void setName(String n) {
        name = n;
    }
    public void setSalary(double s) {
        salary = s;
    }

    public int compareTo(employee e) {
        if (this.getSalary() < e.getSalary()) {return -1;}
        else if (this.getSalary() == e.getSalary()) {return 0;}
        else { return 1;}
    }
    public String toString() {return "Employee name: " + this.getName() + " salary: " + this.getSalary(); }
}
