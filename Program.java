public class Program {
    public static void main(String[] args) {
        Store toyStore = new Store();
        toyStore.put("1 2 2"); // id=1, name="2", weight=2
        toyStore.put("2 2 2");
        toyStore.put("3 6 6");
        //Файл, в который будет записываться результат работы программы:
        toyStore.saveToFile("output.txt", 10);
    }
}