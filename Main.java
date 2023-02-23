import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        testNecklaceMethods();
        testStoneMethods();
        testPolymorphism();
    }

    private static void testNecklaceMethods() {
        Stone diamond1 = new Diamond(100, 20, 5);
        Stone diamond2 = new Diamond(200, 40, 4);
        Stone topaz1 = new Topaz(60, 30, 7);
        Stone topaz2 = new Topaz(20, 10, 8);

        Necklace necklace = new Necklace(Arrays.asList(diamond1, diamond2, topaz1, topaz2));
        Necklace theSameNecklace = new Necklace(Arrays.asList(diamond1, diamond2, topaz1, topaz2));
        Necklace otherNecklace = new Necklace(Arrays.asList(diamond2, topaz1, topaz2));

        System.out.println("necklace price: " + necklace.getPrice()); // 380
        System.out.println("necklace carats: " + necklace.getCarats()); // 100
        System.out.println("stones sorted by price: " + necklace.getStonesSortedByPrice()); // diamond2, diamond1, topaz1, topaz2
        System.out.println("5 <= transparency <= 7: " + necklace.getStonesByTransparency(5, 7)); // diamond1, topaz1

        System.out.println("Necklace toString: " + necklace.toString());
        System.out.println("Necklace hashCode: " + necklace.hashCode());
        System.out.println("Necklace equals true: " + necklace.equals(theSameNecklace));
        System.out.println("Necklace equals false: " + necklace.equals(otherNecklace));

    }

    private static void testStoneMethods() {
        Stone diamond = new Diamond(100, 20, 5);
        Stone theSameDiamond = new Diamond(100, 20, 5);
        Stone otherDiamond = new Diamond(100, 20, 6);

        System.out.println("stone toString: " + diamond.toString());
        System.out.println("stone hashCode: " + diamond.hashCode());
        System.out.println("stone equals true: " + diamond.equals(theSameDiamond));
        System.out.println("stone equals false: " + diamond.equals(otherDiamond));
    }

    private static void testPolymorphism() {
        Stone diamond = new Diamond(70, 4, 1);
        Stone topaz = new Topaz(20, 4, 1);

        System.out.println("**** Polymorphism ***");
        System.out.println("type :" + diamond.getType());
        System.out.println("type :" + topaz.getType());
    }

}
