public class Toys {
    int id;
    String name;
    int weight;

    public Toys(int id, String name, int weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + weight;
    }
}
