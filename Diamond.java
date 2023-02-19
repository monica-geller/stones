public class Diamond extends GemStone {
    public Diamond(int price, int carats, int transparency) {
        super(price, carats, transparency);
    }

    @Override
    public String getDescription() {
        return "This is diamond.";
    }

}