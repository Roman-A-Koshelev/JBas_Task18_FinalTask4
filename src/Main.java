import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Отгадайте загадку: Сидит дед, во сто шуб одет, кто его раздевает, тот слезы про-\nливает.");
        System.out.println("На первой попытке вы можете воспользоваться подсказкой. Для это введите слово\n\"Подсказка\".");
        final String RIGHT_ANSWER = "Заархивированный вирус";
        final String HINT_REQUEST = "Подсказка"; // Запрос подсказки
        final String HINT = "Решение лежит в IT-области.";

        final String YOU_ARE_RIGHT = "Правильно!";
        final int FIRST_ATTEMPT = 0;
        final String FAREWELL = "Обидно, приходи в другой раз."; // Прощание
        final String HINT_IS_NOT_AVAILABLE = "Подсказка уже недоступна.";
        final String THINK_AGAIN = "Подумай еще!";
        String answer;
        boolean isHintUsed = false;

        Scanner in = new Scanner(System.in);

        int countAttempts = 3;
        for (int numAttempt = 0; numAttempt < countAttempts; ++numAttempt) {
            System.out.print("Попытка " + (numAttempt+1) + ": ");
            answer = in.nextLine();

            if (answer.equalsIgnoreCase(RIGHT_ANSWER)) {
                System.out.println(YOU_ARE_RIGHT);
                return;
            }

            if (isHintUsed) {
                System.out.println(FAREWELL);
                return;
            }

            if (answer.equalsIgnoreCase(HINT_REQUEST)) {
                if (FIRST_ATTEMPT == numAttempt) {
                    System.out.println(HINT);
                }
                else {
                    System.out.println(HINT_IS_NOT_AVAILABLE);
                }
                isHintUsed = true;
                continue;
            }

            if (countAttempts - 1 != numAttempt) {
                System.out.println(THINK_AGAIN);
            }
        }

        System.out.println(FAREWELL);
    }
}