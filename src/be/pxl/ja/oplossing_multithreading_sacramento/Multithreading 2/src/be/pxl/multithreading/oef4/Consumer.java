public class Consumer extends Thread{
    private int rate;
    private ProductionLine productionLine;

    public Consumer(int rate, ProductionLine productionLine) {
        this.rate = rate;
        this.productionLine = productionLine;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Package pakje = productionLine.getPackage();
                if (pakje == null) {
                    System.out.println("Geen pakjes meer in productie.");
                }
                else {
                    System.out.println("Pakje : " + pakje.toString() + " verwerken.");
                }
                long sleep = (60 / rate) * 1000;
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
