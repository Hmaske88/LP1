import java.util.*;
import java.util.concurrent.Semaphore;

public class reader_writer
{
    static Semaphore readLock =new Semaphore (1);
    static Semaphore writeLock = new Semaphore(1);
    static int readCount=0;
    
    static class read implements Runnable
    {
        @Override
        public void run()
        {
            try
            {
                readLock.acquire();
                readCount++;
                if(readCount==1)
                {
                    writeLock.acquire();
                }
                readLock.release();
                
                System.out.println("Thread "+Thread.currentThread().getName()+" is reading");
                Thread.sleep(1500);
                System.out.println("Thread "+Thread.currentThread().getName()+" has finished reading");
                
                readLock.acquire();
                readCount--;
                if(readCount==0)
                {
                    writeLock.release();
                }
                readLock.release();
            }
            catch(InterruptedException e)
            {
                System.out.println(e.getMessage());
            }
        }
    }
    
    
    static class write implements Runnable
    {
        @Override
        public void run()
        {
            try
            {
                writeLock.acquire();
                System.out.println("Thread "+Thread.currentThread().getName()+" is writting");
                Thread.sleep(2500);
                System.out.println("Thread "+Thread.currentThread().getName()+" has completed writting");
                writeLock.release();
            }
            catch(InterruptedException e)
            {
                System.out.println(e.getMessage());
            }
        }
    }
    
    public static void main(String arg[]) throws Exception
    {
        read r = new read();
        write w = new write();
        
        Thread t1 = new Thread(r);
        t1.setName("thread 1");
        
        Thread t2 = new Thread(r);
        t2.setName("thread 2");
        
        Thread t3=new Thread(w);
        t3.setName("thread 3");
        
        Thread t4 = new Thread(r);
        t4.setName("thread 4");
        
        Thread t5=new Thread(w);
        t5.setName("thread 5");
        
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
