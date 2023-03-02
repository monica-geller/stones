import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Necklace necklace = createNecklace(in);

        String choice = "";
        while (!choice.equals("6")) {
            showMenu();
            choice = in.next();
            handleChoice(in, choice, necklace);
        }
    }

    private static Necklace createNecklace(Scanner in) {
        List<Stone> stones = new ArrayList<>();

        String choice = "";
        while (!choice.equals("3")) {
            System.out.print("""
                    Создание ожерелья:
                    1. Добавить дрогаценный камень
                    2. Добавить полудрогаценный камень
                    3. Выход
                    Ваш выбор:"""
            );

            choice = in.next();

            handleChoice(in, choice, stones);
        }

        return new Necklace(stones);
    }

    private static void handleChoice(Scanner in, String choice, List<Stone> stones) {
        switch (choice) {
            case "1", "2" -> stones.add(createStone(in, choice));
            case "3" -> System.out.println("Выходим...");
            default -> System.out.println("Неизвестная команда.");
        }
    }

    private static Stone createStone(Scanner in, String choice) {
        System.out.print("Введите имя: ");
        String name = in.next();

        System.out.print("Введите стоимость: ");
        int price = in.nextInt();

        System.out.print("Введите вес: ");
        int carats = in.nextInt();

        System.out.print("Введите прозрачность: ");
        int transparency = in.nextInt();

        return choice.equals("1")
                ? new GemStone(name, price, carats, transparency)
                : new SemipreciousStone(name, price, carats, transparency);
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

    private static void handleChoice(Scanner in, String choice, Necklace necklace) {
        switch (choice) {
            case "1" -> System.out.println(necklace.getStones());
            case "2" -> System.out.println("Вес ожерелья: " + necklace.getCarats());
            case "3" -> System.out.println("Стоимость ожерелья: " + necklace.getPrice());
            case "4" -> System.out.println(necklace.getStonesSortedByPrice());
            case "5" -> showByTransparency(in, necklace);
            case "6" -> System.out.println("Выходим...");
            default -> System.out.println("Неизвестная команда.");
        }
    }

    private static void showByTransparency(Scanner in, Necklace necklace) {
        System.out.print("Введите минимальный параметр прозрачности: ");
        int from = in.nextInt();

        System.out.print("Введите максимальный параметр прозрачности: ");
        int to = in.nextInt();

        System.out.println(necklace.getStonesByTransparency(from, to));
    }

}
