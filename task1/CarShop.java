package task1;

public class CarShop  {
    private int car = 0;
    private final int TIMEOUT = 3000;
    private final int BUILDTIME = 5000;

    public synchronized void buyCar() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + " зашел в автосалон");
            try {
                while (car < 1) {
                    System.out.println(Thread.currentThread().getName() + " ждет машину");
                    wait();
                }
            Thread.sleep(TIMEOUT);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            car--;
            System.out.println(Thread.currentThread().getName() + " уехал на новеньком авто");
            notify();
        }
    }

    public synchronized void makeCar() {
        try {
            while (car >= 1) {
                wait();
            }
        car++;
        Thread.sleep(BUILDTIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " выпустил 1 авто");
        notifyAll();
    }
}
