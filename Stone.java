import java.util.Objects;

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

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCarats() {
        return carats;
    }

    public void setCarats(int carats) {
        this.carats = carats;
    }

    public int getTransparency() {
        return transparency;
    }

    public void setTransparency(int transparency) {
        this.transparency = transparency;
    }

    public abstract String getType();

    @Override
    public String toString() {
        return String.format("Stone{type=%s, price=%s, carats=%s, transparency=%s}",
                getType(), price, carats, transparency);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Stone other = (Stone) o;

        return price == other.price
                && carats == other.carats
                && transparency == other.transparency
                && getType().equals(other.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, carats, transparency, getType());
    }
}