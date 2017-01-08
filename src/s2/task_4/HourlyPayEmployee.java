package s2.task_4;

/**
 *
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
