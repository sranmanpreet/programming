import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;
class PlusMinus
{
    public static void main (String[] args) throws java.lang.Exception
    {
            Scanner sc= new Scanner(System.in);
            int n = Integer.parseInt(sc.nextLine());
            int[] arr =  new int[n];
            String inputString = sc.nextLine();
            sc.close();
            String[] strs = inputString.trim().split("\s+");
            for(int i=0;i<n;i++)
              arr[i]= Integer.parseInt(strs[i]);
            int positiveCount = 0;
            int negativeCount = 0;
            int zeroCount = 0;
            for(int i =0; i<arr.length; i++){
                if(arr[i]>0)
                    positiveCount++;
                else if(arr[i]<0)
                    negativeCount++;
                else
                    zeroCount++;
            }
            NumberFormat formatter = new DecimalFormat("#0.000000");     
            System.out.println(formatter.format((double)positiveCount/n));
            System.out.println(formatter.format((double)negativeCount/n));
            System.out.println(formatter.format((double)zeroCount/n));
    }
}
