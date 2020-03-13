package producerconsumer;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProdCons {
	
	static final Object lock = new Object();
    static List <Integer> list = new LinkedList<Integer>();
    
    public static void producer() {
        Random random = new Random();
        System.out.println(Thread.currentThread());
        while (true) {
            synchronized (lock) {
                while (list.size() > 10) {
                    try {
                        lock.wait();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ProdCons.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                System.out.println(Thread.currentThread());
                list.add(random.nextInt(100));
                lock.notify();
            }
        }
    }
    
    public static void consumer() {
        while (true) {
            synchronized (lock) {
                while (list.size() < 10) {
                    try {
                        lock.wait();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ProdCons.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                list.remove(0);
                System.out.println(list);
                lock.notify();
            }
        }
    }
    
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
			public void run() {
			    producer();
			}
		});
        
        Thread thread2 = new Thread(new Runnable() {
			public void run() {
			    consumer();
			}
		});
        
        Thread thread3 = new Thread(new Runnable() {
			public void run() {
			    producer();
			}
		});
        
        thread1.start();
        thread2.start();
        thread3.start();
        
        try {
            thread1.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(ProdCons.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            thread2.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(ProdCons.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            thread3.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(ProdCons.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
