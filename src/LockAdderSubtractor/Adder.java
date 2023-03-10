package LockAdderSubtractor;

import java.util.concurrent.locks.Lock;

public class Adder implements Runnable{
    Count count;
    Lock lock;
    Adder(Count count, Lock lock) {
        this.count = count;
        this.lock = lock;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10000; i++) {
            // Lock here
            lock.lock();
            count.value += i;
            System.out.println("+" + i);
            lock.unlock();
        }
    }
}
