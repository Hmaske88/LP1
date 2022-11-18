import java.util.List;
import java.util.ArrayList;

public class producer_consumer 
{
    public static void main(String[] args) throws InterruptedException 
    {
        List<Integer> sharedList = new ArrayList<Integer>();
        Thread thread1 = new Thread(new Producer(sharedList));
        Thread thread2 = new Thread(new Consumer(sharedList));
        thread1.start();
        thread2.start();
    }
}

class Producer implements Runnable 
{
    List<Integer> sharedList = null;
    final int MAX_SIZE = 5;
    private int i = 0;

    public Producer(List<Integer> sharedList) 
    {
        super();
        this.sharedList = sharedList;
    }

    @Override
    public void run() 
    {
        while (true) 
        {
            try 
            {
                produce(i++);
            } 
            catch (InterruptedException exception) 
            {

            }
        }
    }

    public void produce(int i) throws InterruptedException 
    {
        synchronized (sharedList) 
        {
            while (sharedList.size() == MAX_SIZE) 
            {
                System.out.println("Sharedlist is Full...waiting for the consumer to be consumed");
                sharedList.wait();
            }
        }
        synchronized (sharedList) 
        {
            System.out.println("producer produced element" + i);
            sharedList.add(i);
            Thread.sleep(500);
            sharedList.notify();
        }
    }
}

// consumer class
class Consumer implements Runnable 
{
    List<Integer> sharedList = null;

    // constructor or consumer class
    public Consumer(List<Integer> sharedList) {
        super();
        this.sharedList = sharedList;
    }

    @Override
    public void run() {
        while (true) {
            try {
                consume();
            } catch (InterruptedException exception) {

            }
        }
    }

    public void consume() throws InterruptedException {
        synchronized (sharedList) {
            while (sharedList.isEmpty()) {
                System.out.println("Sharedlist is empty...waiting for the producer  to be produced");
                sharedList.wait();
            }
        }
        synchronized (sharedList) {

            Thread.sleep(1000);
            System.out.println("Consumed the element" + sharedList.remove(0));
            sharedList.notify();
        }
    }

}
