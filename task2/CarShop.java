package task2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class CarShop {
    private int car = 0;
    private final int TIMEOUT = 3000;
    private final int BUILDTIME = 3000;
    ReentrantLock locker;
    Condition condition;

    public CarShop() {
        locker = new ReentrantLock();
        condition = locker.newCondition();
    }
    public void makeCar() {
        locker.lock();
        try {
            while (car >= 1) {
                condition.await();
            }
            car++;
            Thread.sleep(BUILDTIME);
            System.out.println(Thread.currentThread().getName() + " выпустил 1 авто");
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            locker.unlock();
        }
    }

    public void buyCar() {
        locker.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " зашел в автосалон");
            while (car < 1) {
                System.out.println(Thread.currentThread().getName() + " ждет машину");
                condition.await();
            }
            Thread.sleep(TIMEOUT);
            car--;
            System.out.println(Thread.currentThread().getName() + " уехал на новеньком авто");
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            locker.unlock();
        }
    }


}
