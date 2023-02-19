import java.util.ArrayList;
import java.util.List;

import static java.util.Comparator.comparingInt;
//import static java.util.stream.Collectors.toList;

public class Necklace {

    private final List<Stone> stones;

    public Necklace(List<Stone> stones) {
        this.stones = stones;
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

}