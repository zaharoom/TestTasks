package s2.task_4;

import java.io.*;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Построить три класса (базовый и 2 потомка), описывающих некоторых работников
 * с почасовой оплатой (один из потомков) и фиксированной оплатой (второй потомок).
 * Описать в базовом классе абстрактный метод для расчета среднемесячной заработной платы.
 * Для “повременщиков” формула для расчета такова: “среднемесячная заработная плата = 20.8 * 8 * почасовую ставку”,
 * для работников с фиксированной оплатой “среднемесячная заработная плата = фиксированной месячной оплате”.
 * -   Упорядочить всю последовательность работников по убыванию среднемесячного заработка.
 * При совпадении зарплаты - упорядочивать данные по алфавиту по имени.
 * Вывести идентификатор работника, имя и среднемесячный заработок для всех элементов списка.
 * -   Вывести первые 5 имен работников из полученного в первом пункте списка.
 * -   Вывести последние 3 идентификатора работников из полученного в первом пункте списка.
 * -   Организовать запись и чтение коллекции в/из файл.
 * -   Организовать обработку некорректного формата входного файла.
 */

public class AnyCompany {
    static TreeSet<Employee> employees = new TreeSet<>();

    static {
        loadEmployees();
    }

    public static void main(String[] args) {
        boolean running = true;
        System.out.println("Программа для работы с сотрудниками\n" +
                "1 - Вывести спипок сотрудников согласно первому пункту задания\n" +
                "2 - Вывести первые 5 имен сотрудников\n" +
                "3 - Вывести последние 3 идентификатора\n" +
                "4 - Записать нового сотрудника\n" +
                "любая другая цифра - Завершить работу");

        Scanner scanner = new Scanner(System.in);

        while (running) {
            switch (scanner.nextInt()) {
                case 1:
                    showList();
                    break;
                case 2:
                    int counter = 0;
                    Iterator<Employee> iter = employees.iterator();
                    while (counter < 5) {
                        if (iter.hasNext())
                            System.out.println(iter.next().getName());
                        counter++;
                    }
                    break;
                case 3:
                    counter = 0;
                    iter = employees.descendingIterator();
                    while (counter < 3) {
                        if (iter.hasNext())
                            System.out.println(iter.next().getEmployeeType());
                        counter++;
                    }
                    break;
                case 4:
                    addNewEmployee();
                    break;
                default:
                    running = false;
            }
            saveEmployees();
        }
    }

    private static void showList() {
        System.out.println("type     " + "name   " + "average_salary\n");
        for (Employee e : employees) {
            System.out.println(e.getEmployeeType() + "    " + e.getName() + "      " + e.getAverageSalary());
        }
    }

    private static void addNewEmployee() {
        String type = "", name = "";
        double salary = 0d;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Введите тип гонорара (\"fixed\" или \"hourly\"):");
            type = br.readLine();
            System.out.println("Введите имя:");
            name = br.readLine();
            System.out.println("Введите размер зарплаты:");
            salary = Double.parseDouble(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (type.equals(Employee.EMPL_TYPE_FIXED)) {
            employees.add(new FixedSalaryEmployee(name, salary));
        } else if (type.equals(Employee.EMPL_TYPE_HOURLY)) {
            employees.add(new HourlyPayEmployee(name, salary));
        }

        saveEmployees();
    }

    private static void fillList() {
        employees.add(new FixedSalaryEmployee("Josh", 3000));
        employees.add(new HourlyPayEmployee("Jon", 18));
        employees.add(new FixedSalaryEmployee("Jake", 3100));
        employees.add(new HourlyPayEmployee("July", 14));
        employees.add(new FixedSalaryEmployee("Jim", 3200));
        employees.add(new HourlyPayEmployee("Jacob", 18));
        employees.add(new FixedSalaryEmployee("Ann", 2900));
        employees.add(new HourlyPayEmployee("Donald", 15));
        employees.add(new HourlyPayEmployee("Donald", 20));
        employees.add(new FixedSalaryEmployee("Josh", 3100));
    }

    private static void loadEmployees() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("employees.ser"));
            employees = (TreeSet<Employee>) ois.readObject();
        } catch (FileNotFoundException e) {
            fillList(); //If serialization not processed anytime fill by default values or file name wrong
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void saveEmployees() {
        try {
            ObjectOutputStream oostr = new ObjectOutputStream(new FileOutputStream("employees.ser"));
            oostr.writeObject(employees);
            oostr.close();
            System.out.println("Array with employees was saved in employees.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
