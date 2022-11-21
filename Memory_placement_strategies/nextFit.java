import java.util.*;

public class nextFit
{
    public static void main(String arg[])
    {
        
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of partitions : ");
        int npar=sc.nextInt();
        
        int part[]=new int[npar];
        System.out.println("Enter the size of partitions : ");
        for(int i=0;i<npar;i++)
        {
            part[i]=sc.nextInt();    
        }
        
        System.out.println("Enter the number of processes : ");
        int npro=sc.nextInt();
        
        int pro[]=new int[npro];
        System.out.println("Enter the size of processes : ");
        for(int i=0;i<npro;i++)
        {
            pro[i]=sc.nextInt();
        }
        
        int m=0;
        for(int i=0;i<npro;i++)
        {
            for(int j=m;j<npar;j++)
            {
                if(pro[i]<part[j])
                {
                    System.out.println("The process of size "+pro[i]+" is placed in partition "+part[j]+" and hole of "+(part[j]-pro[i])+" is created");
                    part[j]=part[j]-pro[i];
                    m=j;
                    break;
                }
            }
        }
    }
}
