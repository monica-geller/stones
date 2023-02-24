import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {

        testNecklaceMethods();
        testStoneMethods();

        testStoneSerialization();
        testNecklaceSerialization();
    }

    private static void testNecklaceMethods() {
        Stone diamond1 = new GemStone("Diamond", 100, 20, 5);
        Stone diamond2 = new GemStone("Diamond", 200, 40, 4);
        Stone topaz1 = new SemipreciousStone("Topaz", 60, 30, 7);
        Stone topaz2 = new SemipreciousStone("Topaz", 20, 10, 8);

        Necklace necklace = new Necklace(Arrays.asList(diamond1, diamond2, topaz1, topaz2));
        Necklace theSameNecklace = new Necklace(Arrays.asList(diamond1, diamond2, topaz1, topaz2));
        Necklace otherNecklace = new Necklace(Arrays.asList(diamond2, topaz1, topaz2));

        System.out.println("necklace price: " + necklace.getPrice()); // 380
        System.out.println("necklace carats: " + necklace.getCarats()); // 100
        System.out.println("stones sorted by price: " + necklace.getStonesSortedByPrice()); // diamond2, diamond1, topaz1, topaz2
        System.out.println("5 <= transparency <= 7: " + necklace.getStonesByTransparency(5, 7)); // diamond1, topaz1

        System.out.println("Necklace toString: " + necklace.toString());
        System.out.println("Necklace equals true: " + necklace.equals(theSameNecklace));
        System.out.println("Necklace equals false: " + necklace.equals(otherNecklace));

    }

    private static void testStoneMethods() {
        Stone stone = new GemStone("Diamond", 100, 20, 5);
        Stone theSameStone = new GemStone("Diamond", 100, 20, 5);
        Stone otherStone = new GemStone("Diamond", 100, 20, 6);

        System.out.println("stone toString: " + stone.toString());
        System.out.println("stone equals true: " + stone.equals(theSameStone));
        System.out.println("stone equals false: " + stone.equals(otherStone));
    }

    private static void testStoneSerialization() throws Exception {
        Stone stone = new GemStone("Diamond", 100, 5, 5);

        // write object to file
        FileOutputStream fos = new FileOutputStream("stone.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(stone);
        oos.flush();
        oos.close();

        // read object from file
        FileInputStream fis = new FileInputStream("stone.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Stone stone2 = (Stone) ois.readObject();
        ois.close();

        System.out.println("Serialization stone: " + stone);
        System.out.println("Serialization stone2: " + stone2);
    }

    private static void testNecklaceSerialization() throws Exception {
        Stone stone1 = new GemStone("Diamond", 100, 5, 5);
        Stone stone2 = new SemipreciousStone("Topaz", 90, 3, 5);
        Necklace necklace = new Necklace(Arrays.asList(stone1, stone2));

        // write object to file
        FileOutputStream fos = new FileOutputStream("necklace.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(necklace);
        oos.flush();
        oos.close();

        // read object from file
        FileInputStream fis = new FileInputStream("necklace.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Necklace necklace2 = (Necklace) ois.readObject();
        ois.close();

        System.out.println("Serialization necklace: " + necklace.equals(necklace2));
    }

}
