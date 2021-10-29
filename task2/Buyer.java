package task2;

public class Buyer implements Runnable {
    private final CarShop carShop;
    private final int NUMBERBUY = 10;

    public Buyer(CarShop carShop) {
        this.carShop = carShop;
    }

    @Override
    public void run() {
        for (int i = 1; i < NUMBERBUY; i++) {
            carShop.buyCar();
        }
    }
}
