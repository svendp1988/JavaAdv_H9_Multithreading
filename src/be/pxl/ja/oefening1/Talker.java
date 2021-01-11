package be.pxl.ja.oefening1;

public class Talker implements Runnable {
    private int id;

    public Talker(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 10; i++) {
            System.out.println(id);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Talker talker1 = new Talker(1);
        Talker talker2 = new Talker(2);
        Talker talker3 = new Talker(3);
        Talker talker4 = new Talker(4);

        new Thread(talker1).start();
        new Thread(talker2).start();
        new Thread(talker3).start();
        new Thread(talker4).start();
    }
}
