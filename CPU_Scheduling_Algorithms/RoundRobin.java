import java.util.*;

public class RoundRobin
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
        int f[]=new int[n];
        int nbt[]=new int[n];
        int avgwt=0,avgtt=0;
        
        for(int i =0;i<n;i++)
        {
            System.out.println("Enter the arrival time for process "+(i+1)+" :");
            at[i]=sc.nextInt();
            System.out.println("Enter the burst time for process "+(i+1)+" :");
            bt[i]=sc.nextInt();     //bt will change after subtracting quantum time 
            nbt[i]=bt[i];           //nbt stores value of initial burst time
            pid[i]=i+1;
            f[i]=0;
        }
        System.out.println("Enter the quantum time :");
        int qt=sc.nextInt();
        int processCount=0;
        int st=0;
        while(true)
        {
            for(int i=0;i<n;i++)
            {
                if(bt[i]>qt && f[i]==0 && at[i]<=st)
                {
                    bt[i]=bt[i]-qt;
                    st+=qt;
                }
                else if(bt[i]<=qt && f[i]==0 && at[i]<=st)
                {
                    st+=bt[i];
                    bt[i]=0;
                    f[i]=1;
                    tt[i]=st-at[i];
                    wt[i]=tt[i]-nbt[i];
                    processCount++;
                    avgwt+=wt[i];
                    avgtt+=tt[i];
                }
            }
            if(processCount==n)
            {
                break;
            }
        }
        
        System.out.println("pId  \t  at  \t  bt  \t  wt  \t  tt");
        for(int i=0;i<n;i++)
        {
            System.out.println(pid[i]+"  \t  "+at[i]+"  \t  "+nbt[i]+"  \t  "+wt[i]+"  \t  "+tt[i]);
        }
        System.out.println("Average waiting time :"+(float)avgwt/n);
        System.out.println("Average turnaround time :"+(float)avgtt/n);
    }
}
