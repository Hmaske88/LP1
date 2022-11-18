import java.util.*;

public class Main
{
    public static void main(String arg[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of processes:");
        int n =sc.nextInt();
        
        int at[]=new int[n];
        int bt[]=new int[n];
        int pid[]=new int[n];
        int wt[]=new int[n];
        int tt[]=new int[n];
        int temp,avgwt=0,avgtt=0;
        
        for(int i=0;i<n;i++)
        {
            System.out.println("Enter the arriving time for process "+(i+1)+":");
            at[i]=sc.nextInt();
            System.out.println("Enter the burst time for process "+(i+1)+":");
            bt[i]=sc.nextInt();
            pid[i]=i+1;
        }
        
        for(int i=0;i<n-1;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                if (at[i]>at[j])
                {
                    temp=at[i];
                    at[i]=at[j];
                    at[j]=temp;
                    
                    temp=bt[i];
                    bt[i]=bt[j];
                    bt[j]=temp;
                    
                    temp=pid[i];
                    pid[i]=pid[j];
                    pid[j]=temp;
                }
            }
        }
        
        for(int i=0;i<n;i++)
        {
            if(i>0)
            {
            wt[i]=tt[i-1]-at[i];
            tt[i]=wt[i]+bt[i];
            }
            else{
                wt[i]=at[i];
                tt[i]=wt[i]+bt[i];
            }
            avgwt+=wt[i];
            avgtt+=tt[i];
        }
        
        System.out.println("pId  \t  at  \t  bt  \t  wt  \t  tt");
        for(int i=0;i<n;i++)
        {
            System.out.println(pid[i]+"  \t  " +at[i]+"  \t  " +bt[i]+ "  \t  "+wt[i]+"  \t  " +tt[i]);
        }
        
        System.out.println("Average waiting time :"+avgwt/n);
        System.out.println("Average turnaround time :"+avgtt/n);
    }
}
