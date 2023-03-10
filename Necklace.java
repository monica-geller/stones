import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.toList;

public class Necklace implements Serializable, Cloneable {

    private static final long serialVersionUID = 1L;

    private List<Stone> stones;

    public Necklace(List<Stone> stones) {
        // Objects.requireNonNull to avoid NullPointerException in all methods
        this.stones = Objects.requireNonNull(stones);
    }

    public List<Stone> getStones() {
        return stones;
    }

    public void add(Stone stone) {
        stones.add(stone);
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

        // return stones.stream().sorted(comparingInt(Stone::getPrice).reversed()).toList();
    }

    public List<Stone> getStonesByTransparency(int from, int to) {
        List<Stone> filteredStones = new ArrayList<>();

        for (Stone stone : stones) {
            if (from <= stone.getTransparency() && stone.getTransparency() <= to) {
                filteredStones.add(stone);
            }
        }

        return filteredStones;

        // return stones.stream().filter(s -> from <= s.getTransparency() && s.getTransparency() <= to).toList();
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
    public Necklace clone() {
        List<Stone> clonedStones = new ArrayList<>(stones.size());
        for (Stone stone : stones) {
            clonedStones.add(stone.clone());
        }
        // List<Stone> clonedStones = stones.stream().map(Stone::clone).toList();

        try {
            Necklace necklace = (Necklace) super.clone();
            necklace.stones = clonedStones;

            return necklace;

        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}