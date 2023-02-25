import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.Comparator.comparingInt;

public class Necklace implements Serializable, Cloneable {

    private static final long serialVersionUID = 1L;

    private final List<Stone> stones;

    public Necklace(List<Stone> stones) {
        // Objects.requireNonNull to avoid NullPointerException in all methods
        this.stones = Objects.requireNonNull(stones);
    }

    public int getCarats() {
        int carats = 0;

        for (Stone stone : stones) {
            carats += stone.getCarats();
        }

        return carats;

        // return stones.stream().mapToInt(Stone::getCarats).sum();
    }

    public int getPrice() {
        int price = 0;

        for (Stone stone : stones) {
            price += stone.getPrice();
        }

        return price;

        // return stones.stream().mapToInt(Stone::getPrice).sum();
    }

    public List<Stone> getStonesSortedByPrice() {
        List<Stone> sortedStones = new ArrayList<>(stones);
        sortedStones.sort(comparingInt(Stone::getPrice).reversed());
        return sortedStones;

//         return stones.stream().sorted(comparingInt(Stone::getPrice).reversed()).collect(toList());
    }

    public List<Stone> getStonesByTransparency(int from, int to) {
        List<Stone> filteredStones = new ArrayList<>();

        for (Stone stone : stones) {
            if (from <= stone.getTransparency() && stone.getTransparency() <= to) {
                filteredStones.add(stone);
            }
        }

        return filteredStones;

        // return stones.stream().filter(s -> from <= s.getTransparency() && s.getTransparency() <= to).collect(toList());
    }

    @Override
    public String toString() {
        return "Necklace{stones=" + stones + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Necklace other = (Necklace) o;

        return stones.equals(other.stones);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stones);
    }

    @Override
    public Necklace clone() throws CloneNotSupportedException {
        return (Necklace) super.clone();
    }
}