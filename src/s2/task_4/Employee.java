package s2.task_4;

import java.io.Serializable;

/**
 * Class describes typical employee with two types of salary "fixed" and "hourly" pay.
 */
public abstract class Employee implements Serializable, Comparable {

    /**
     * Employee with hourly pay salary
     */
    public static final String EMPL_TYPE_HOURLY = "hourly";
    /**
     * Employee with fixed salary
     */
    public static final String EMPL_TYPE_FIXED = "fixed";

    private String employeeType; //Type of the salary
    private String name;         //Name of employee
    private double averageSalary;//Average salary of Employee

    public Employee(String employeeType, String name, double averageSalary) {
        this.name = name;
        this.employeeType = employeeType;
        this.averageSalary = averageSalary;
    }


    /**
     * Method sorts employees by average salary. If salary of two employees is equals
     * sorting is by the alphabet.
     * @param o
     * @return
     */
    @Override
    public int compareTo(Object o) {
        Employee entry = (Employee) o;

        int result = Double.compare(entry.averageSalary, averageSalary);
        if (result != 0) return result;

        result = name.compareTo(entry.name);
        if (result != 0) return result;

        return 0;
    }

    /**
     * Get average salary
     * @return average salary value
     */
    public abstract double getAverageSalary();

    /**
     * Get name of current employee instance
     * @return name of current Employee
     */
    public String getName() {
        return name;
    }

    /**
     * Get Employee salary type
     * @return employee type "fixed" or "hourly"
     */
    public String getEmployeeType() {
        return employeeType;
    }
}
