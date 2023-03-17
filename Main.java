import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        List<Stone> allStones = new ArrayList<>();
        Necklace necklace = new Necklace(new ArrayList<>());

        String choice = "";
        while (!choice.equals("10")) {
            showMenu();
            choice = in.next();
            handleChoice(in, choice, allStones, necklace);
        }
    }

    private static void showMenu() {
        System.out.print("""
            Доступые команды:
            1. Создать дрогаценный камень
            2. Создать полудрогаценный камень
            3. Вывести созданные камни
            4. Отобрать камни для ожерелья
            5. Вывести список камней в ожерелье
            6. Подсчитать общий вес (в каратах)
            7. Подсчитать стоимость ожерелья
            8. Сортировать на основе ценности
            9. Найти камни по диапозону параметров прозрачности
            10. Выход
            Ваш выбор:"""
        );
    }

    private static void handleChoice(Scanner in, String choice, List<Stone> allStones, Necklace necklace) {
        switch (choice) {
            case "1", "2" -> allStones.add(createStone(in, choice));
            case "3" -> printStones(allStones);
            case "4" -> chooseStonesForNecklace(in, allStones, necklace);
            case "5" -> printStones(necklace.getStones());
            case "6" -> System.out.println("Вес ожерелья: " + necklace.getCarats());
            case "7" -> System.out.println("Стоимость ожерелья: " + necklace.getPrice());
            case "8" -> printStones(necklace.getStonesSortedByPrice());
            case "9" -> showByTransparency(in, necklace);
            case "10" -> System.out.println("Выходим...");
            default -> System.out.println("Неизвестная команда.");
        }
    }

    private static void chooseStonesForNecklace(Scanner in, List<Stone> stones, Necklace necklace) {
        System.out.print("Введите номера камней через запятую: ");
        String[] stoneIndexes = in.next().split(",");

        for (String index : stoneIndexes) {
            Stone stone = stones.get(Integer.parseInt(index) - 1);
            necklace.add(stone);
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

    private static void showByTransparency(Scanner in, Necklace necklace) {
        System.out.print("Введите минимальный параметр прозрачности: ");
        int from = in.nextInt();

        System.out.print("Введите максимальный параметр прозрачности: ");
        int to = in.nextInt();

        printStones(necklace.getStonesByTransparency(from, to));
    }


    public static void printStones(List<Stone> stones) {
        int i = 0;
        for (Stone stone : stones) {
            System.out.printf("%d. %s - цена(в долларах): %d, вес(в каратах): %d,  параметр прозрачности: %d%n",
                    ++i,
                    stone.getName(), stone.getPrice(),
                    stone.getCarats(), stone.getTransparency()
            );
        }
    }

}
