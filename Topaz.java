public class Topaz extends SemipreciousStone {

    public Topaz(int price, int carats, int transparency) {
        super(price, carats, transparency);
    }

    @Override
    public String getType() {
        return "Topaz";
    }
}