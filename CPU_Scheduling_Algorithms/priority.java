import java.util.*;

public class priority
{
    public static void main(String arg[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of processess :");
        int n = sc.nextInt();
        
        int at[]=new int[n];
        int bt[]=new int[n];
        int pid[]=new int[n];
        int wt[]=new int[n];
        int tt[]=new int[n];
        int prt[]=new int[n];
        int f[]=new int[n];
        int temp;
        int ct[]=new int[n];
        int avgwt=0,avgtt=0;
        
        for(int i =0;i<n;i++)
        {
            System.out.println("Enter the arrival time for process "+(i+1)+" :");
            at[i]=sc.nextInt();
            System.out.println("Enter the burst time for process "+(i+1)+" :");
            bt[i]=sc.nextInt();
            System.out.println("Enter the priority for process "+(i+1)+" :");
            prt[i]=sc.nextInt();
            pid[i]=i+1;
            f[i]=0;
        }
        
        int st=0,numberofprocess=0;
        while(true)
        {
            int c=n;
            int priority=999;
            
            if(numberofprocess==n)
            {
                break;
            }
            
            for(int i=0;i<n;i++)
            {
                if((at[i]<=st) && (prt[i]<priority) && (f[i]==0))
                {
                    priority=prt[i];
                    c=i;
                }
            }
            
            if(c==n)
            {
                st++;
            }
            else
            {
                ct[c]=st+bt[c];
                st+=bt[c];
                tt[c]=ct[c]-at[c];
                wt[c]=tt[c]-bt[c];
                f[c]=1;
                numberofprocess++;
                avgwt+=wt[c];
                avgtt+=tt[c];
            }
        }
        System.out.println("pId  \t  priority  \t  at  \t  bt  \t  wt  \t  tt");
        for(int i=0;i<n;i++)
        {
            System.out.println(pid[i]+"  \t  "+prt[i]+"  \t\t  "+at[i]+"  \t  "+bt[i]+"  \t  "+wt[i]+"  \t  "+tt[i]);
        }
        System.out.println("Average waiting time :"+(float)avgwt/n);
        System.out.println("Average turnaround time :"+(float)avgtt/n);
    }
}
