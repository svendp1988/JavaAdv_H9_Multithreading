public class Producer extends Thread {
    private int rate;
    private ProductionLine productionLine;

    public Producer(int rate, ProductionLine productionLine) {
        this.rate = rate;
        this.productionLine = productionLine;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Package box = new Package();
                productionLine.addPackage(box);
                System.out.println("NIEUW PAKJE aangemaakt : " + box.toString());
                long sleep = (60 / rate) * 1000;
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
