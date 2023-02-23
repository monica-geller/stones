public class Diamond extends GemStone {

    public Diamond(int price, int carats, int transparency) {
        super("Diamond", price, carats, transparency);
    }


    @Override
    public String getType() {
        return "Diamond";
    }
}