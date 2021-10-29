package task1;

public class Producer implements Runnable {
    private final CarShop carShop;
    private final int NUMBERSCAR = 10;

    Producer(CarShop carShop){
        this.carShop = carShop;
    }
    public void run() {
        for (int i = 1; i < NUMBERSCAR; i++) {
            carShop.makeCar();
        }
    }
}

