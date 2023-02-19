import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Stone diamond1 = new Diamond(100, 20, 5);
        Stone diamond2 = new Diamond(200, 40, 4);
        Stone topaz1 = new Topaz(60, 30, 7);
        Stone topaz2 = new Topaz(20, 10, 8);

        List<Stone> stones = Arrays.asList(diamond1, diamond2, topaz1, topaz2);

        Necklace necklace = new Necklace(stones);

        System.out.println("necklace price: " + necklace.getPrice()); // 380
        System.out.println("necklace carats: " + necklace.getCarats()); // 100
        System.out.println("stones sorted by price: " + necklace.getStonesSortedByPrice()); // diamond2, diamond1, topaz1, topaz2
        System.out.println("5 <= transparency <= 7: " + necklace.getStonesByTransparency(5, 7)); // diamond1, topaz1

    }

}
