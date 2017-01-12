package s2.task_4;

/**
 * Class describes Employee with hourly salary type
 */

public class HourlyPayEmployee extends Employee {

    double hourlyPay;

    public HourlyPayEmployee(String name, double hourlyPay) {
        super(EMPL_TYPE_HOURLY, name, 20.8 * 8d * hourlyPay);
        this.hourlyPay = hourlyPay;
    }

    @Override
    public double getAverageSalary() {
        return 20.8 * 8d * hourlyPay;
    }

}
