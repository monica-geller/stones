public abstract class Stone {

    protected int price;
    protected int carats;
    protected int transparency;

    public Stone(int price, int carats, int transparency) {
        this.price = price;
        this.carats = carats;
        this.transparency = transparency;
    }

    public int getPrice() {
        return price;
    }

    public int getCarats() {
        return carats;
    }

    public int getTransparency() {
        return transparency;
    }

    @Override
    public String toString() {
        return String.format("%s {price=%s, carats=%s, transparency=%s}",
                getClass().getSimpleName(), price, carats, transparency);
    }
}