package s2.task_3;

/**
 * Напишите метод удаление символа из строки
 */

public class StringChanger {
    public static void main(String[] args) {
        System.out.println(deleteSymbol("kykysja", 3));
    }

    public static String deleteSymbol(String s, int index) {
        return s.substring(0, index) + s.substring(index + 1);
    }
}
