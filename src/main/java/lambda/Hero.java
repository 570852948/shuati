package lambda;

public class Hero {
    String name = "hero";

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "hero{" +
                "name='" + name + '\'' +
                '}';
    }
}
