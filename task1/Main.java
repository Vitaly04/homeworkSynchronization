package task1;

public class Main {
    public static void main(String[] args) {
        CarShop carShop = new CarShop();
        Producer producer = new Producer(carShop);
        Buyer buyer = new Buyer(carShop);
        Thread thread1 = new Thread(buyer);
        thread1.setName("Покупатель 1");
        Thread thread2 = new Thread(buyer);
        thread2.setName("Покупатель 2");
        Thread thread3 = new Thread(buyer);
        thread3.setName("Покупатель 3");
        Thread thread4 = new Thread(producer);
        thread4.setName("Производитель Toyota");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
