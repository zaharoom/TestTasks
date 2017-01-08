package s2.task_4;

/**
 *
 */
public class FixedSalaryEmployee extends Employee {

    double salary;

    public FixedSalaryEmployee(String name, double salary) {
        super(EMPL_TYPE_FIXED, name, salary);
        this.salary = salary;
    }

    @Override
    public double getAverageSalary() {
        return salary;
    }

}
