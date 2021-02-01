public class Main {
    public static void main(String[] args) {
        ProductionLine productionLine = new ProductionLine();
        Producer producer1 = new Producer(20,productionLine);
        Producer producer2 = new Producer(15,productionLine);
        Producer producer3 = new Producer(12,productionLine);
        Producer producer4 = new Producer(7,productionLine);
        Consumer consumer = new Consumer(30,productionLine);
        
        producer1.start();
        producer2.start();
        producer3.start();
        producer4.start();

        consumer.start();
    }
}
