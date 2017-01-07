package s2.task_1;

/**
 * Написать метод преобразующий символьную числовую строку "String" на пример: "1256" в целочисленное значение "int",
 * При этом не используя стандартных библиотечных методов преобразования типа parseInt
 * <p>
 * На входе:    String str = "1256"
 * На выходе:   int str = 1256
 */

public class StringConverter {

    public static void main(String[] args) {
        int result = convertStringToInt("1256");
        System.out.println(result);
    }

    /**
     * Method converts string value to int without using standard library methods
     *
     * @param str string to convert
     * @return converted int value
     */
    public static int convertStringToInt(String str) {
        int result = 0;

        for (int i = 0; i < str.length(); i++) {
            result = result * 10 + convertCharToInt(str.charAt(i));
        }

        return !str.contains("-") ? result : -result;
    }

    /**
     * Method takes character and gives int number
     *
     * @param ch character to convert
     * @return proper int number
     */
    public static int convertCharToInt(char ch) {
        int result;

        switch (ch) {
            case '0':
                result = 0;
                break;
            case '1':
                result = 1;
                break;
            case '2':
                result = 2;
                break;
            case '3':
                result = 3;
                break;
            case '4':
                result = 4;
                break;
            case '5':
                result = 5;
                break;
            case '6':
                result = 6;
                break;
            case '7':
                result = 7;
                break;
            case '8':
                result = 8;
                break;
            case '9':
                result = 9;
                break;
            default:
                result = 0;
        }

        return result;
    }
}
