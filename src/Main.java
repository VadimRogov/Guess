import java.util.Random;
import java.util.Scanner;

public class Main {
    public static boolean key = false;
    public static void main(String[] args) {
        Random random = new Random();
        int numberRandom = random.nextInt(10);
        System.out.println("ОТГАДАЙКА");
        do {
            if(key) {
                numberRandom = random.nextInt(10);
                key = false;
            }
            System.out.print("Введите число: ");
        } while(!check(numberRandom, input()));
    }
    public static boolean check(int numberRandom, String userNumber) {
        boolean is = false;
        int numberX = 0;
        try {
            numberX = Integer.parseInt(userNumber);
        }catch(NumberFormatException e) {
            System.out.println("Вы неверно ввели значение");
        }
        if (numberX == numberRandom) {
            System.out.println("Вы отгадали число");
            System.out.println("Продолжить игру? (да или нет)");
            if(input().equals("да")) {
                System.out.println("Игра продолжается");
                key = true;
                is = false;
            } else if (input().equals("нет")) {
                System.out.println("Игра завершена");
                is = true;
            }
        } else if (numberX < numberRandom) {
            System.out.println("Загаданное число больше");
            is = false;
        } else if (numberX > numberRandom) {
            System.out.println("Загаданное число меньше");
            is = false;
        }
        return is;
    }

    public static String input() {
        Scanner scan = new Scanner(System.in);
        String userNumber = scan.next();
        return userNumber;
    }
}