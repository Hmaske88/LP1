import java.util.*;

public class LRU
{
    public static void main(String age[])
    {
        int page[]={3,2,6,5,6,7,8,9};
        int n=page.length;
        int capacity=4;
        int m=0, pf=0, hit=0;
        HashSet <Integer> set=new HashSet<>(capacity);
        
        for(int i=0;i<n;i++)
        {
            if(set.size()<capacity)
            {
                if(!set.contains(page[i]))
                {
                    set.add(page[i]);
                    pf++;
                }
                else
                {
                    set.add(page[i]);
                    hit++;
                }
            }
            else
            {
                if(!set.contains(page[i]))
                {
                    set.remove(page[m]);
                    set.add(page[i]);
                    pf++;
                    m++;
                }
                else
                {
                    set.remove(page[m]);
                    set.add(page[i]);
                    hit++;
                    m++;
                }
            }
        }
        
        System.out.println("Page fault :"+pf);
        System.out.println("Page hit :"+hit);
        
    }
}
