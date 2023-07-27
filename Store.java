import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Random;

public class Store {
    //для хранения игрушек в порядке убывания их весов:
    private PriorityQueue<Toys> toyPriority;
    public Store() {
        toyPriority = new PriorityQueue<>((t1, t2) -> t2.weight - t1.weight);
    }

    public void addToys(Toys toy) {
        toyPriority.add(toy);
    }

    public void put (String arg) {
        String[] parts = arg.split(" ");
        int id = Integer.parseInt(parts[0]);
        String name = parts[1];
        int weight = Integer.parseInt(parts[2]);
        Toys toy = new Toys(id, name, weight);
        toyPriority.add(toy);
    }

    public int get() {
        int totalWeight = toyPriority.stream().mapToInt(t -> t.weight).sum();
        int randomWeight = new Random().nextInt(totalWeight) + 1;
        int currentWeight = 0;

        for (Toys toy : toyPriority) {
            currentWeight += toy.weight;
            if (randomWeight <= currentWeight) {
                return toy.id;
            }
        }
        return -1; // Запасной вариант.
    }

    public void saveToFile(String filename, int numTimes) {
        try (FileWriter writer = new FileWriter(filename)) {
            for (int i = 0; i < numTimes; i++) {
                int result = get();
                writer.write(String.valueOf(result));
                writer.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
