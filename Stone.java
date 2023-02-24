import java.util.Objects;

public abstract class Stone {

    protected String name;
    protected int price;
    protected int carats;
    protected int transparency;

    public Stone(String name, int price, int carats, int transparency) {
        this.name = Objects.requireNonNull(name);
        this.price = price;
        this.carats = carats;
        this.transparency = transparency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return String.format("Stone{name=%s, price=%s, carats=%s, transparency=%s}", name, price, carats, transparency);
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

        return name.equals(other.name)
                && price == other.price
                && carats == other.carats
                && transparency == other.transparency;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, carats, transparency);
    }
}