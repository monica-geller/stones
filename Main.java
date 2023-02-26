import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Necklace necklace = createTestNecklace();

        Scanner in = new Scanner(System.in);

        String choice = "";
        while (!choice.equals("6")) {
            showMenu();
            choice = in.next();
            handle(choice, necklace, in);
        }
    }

    private static Necklace createTestNecklace() {
        Stone diamond1 = new GemStone("Diamond", 100, 20, 5);
        Stone diamond2 = new GemStone("Ruby", 200, 40, 4);
        Stone topaz1 = new SemipreciousStone("Topaz", 60, 30, 7);
        Stone topaz2 = new SemipreciousStone("Amethyst", 20, 10, 8);

        return new Necklace(Arrays.asList(diamond1, diamond2, topaz1, topaz2));
    }

    private static void showMenu() {
        System.out.print("""
            Доступые команды:
            1. Вывести список камней в ожерелье
            2. Подсчитать общий вес (в каратах)
            3. Подсчитать стоимость ожерелья
            4. Сортировать на основе ценности
            5. Найти камни по диапозону параметров прозрачности
            6. Выход
            Ваш выбор:"""
        );
    }

    private static void handle(String choice, Necklace necklace, Scanner in) {
        switch (choice) {
            case "1" -> System.out.println(necklace.getStones());
            case "2" -> System.out.println("Вес ожерелья: " + necklace.getCarats());
            case "3" -> System.out.println("Стоимость ожерелья: " + necklace.getPrice());
            case "4" -> System.out.println(necklace.getStonesSortedByPrice());
            case "5" -> getStonesByTransparency(in, necklace);
            case "6" -> System.out.println("Выходим...");
            default -> System.out.println("Неизвестная команда.");
        }
    }

    private static void getStonesByTransparency(Scanner in, Necklace necklace) {
        System.out.print("Введите минимальный параметр прозрачности: ");
        int from = in.nextInt();
        System.out.print("Введите максимальный параметр прозрачности: ");
        int to = in.nextInt();

        System.out.println(necklace.getStonesByTransparency(from, to));
    }

}
