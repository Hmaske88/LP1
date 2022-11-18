import java.util.*;

public class FIFO
{
    static int pagefaults(int page[],int n, int capacity)
    {
        HashSet<Integer> set = new HashSet<>(capacity);
        // Queue<Integer> indexes = new LinkedList<>();
        
        int pf=0,m=0;           //page fault
        for(int i=0;i<n;i++)
        {
            if(set.size()<capacity)
            {
                if(!set.contains(page[i]))
                {
                    set.add(page[i]);
                    // indexes.add(page[i]);
                    pf++;
                }
            }
            
            else
            {
                if(!set.contains(page[i]))
                {
                    // int val=indexes.peek();
                    // indexes.poll();
                    // set.remove(val);
                    set.remove(page[m]);
                    set.add(page[i]);
                    // indexes.add(page[i]);
                    pf++;
                    m++;
                }
            }
        }
        return pf;
    }
    
    
    public static void main(String arg[])
    {
        int page[]={2,1,3,4,5,2,3,4,7,8,9,8,10};
        int capacity=4;
        int Pagefault=pagefaults(page,page.length,capacity);
        System.out.println("Page Fault = "+Pagefault);
        System.out.println("Page Hit = "+(page.length-Pagefault));
    }
}
