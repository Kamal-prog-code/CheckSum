import java.util.*;
class cs
{
  public static long comp(long num)
  {
      String str = Long.toString(num);
      StringBuilder sb = new StringBuilder(str);
      for(int i=0;i<str.length();i++)
      {
        if(str.charAt(i)=='0')
        {
          sb.setCharAt(i,'1');
        }
        else
        {
          sb.setCharAt(i,'0');
        }
      }
      long x = Long.valueOf(sb.toString());
      return x;
   }

   public static long dectobin(int n)
   {
     int a=0;
     String x = "";
     while(n > 0)
     {
        a = n % 2;
        x = a+""+x;
        n = n / 2;
     }
     long b = Long.valueOf(x);
     return b;
    }

    public static long rec(long num)
    {
      long reversed = 0;
      while(num != 0)
      {
        long digit = num % 10;
        reversed = reversed * 10 + digit;
        num /= 10;
      }
      return reversed;
    }

    public static long Sum(long a,long b)
    {
      int carry =0;
      long sum =0;
      while(a!=0 || b!=0)
      {
        sum = sum*10 + (int)((a%10 + b%10 + carry)%2);
        carry = (int)((a%10 + b%10 + carry)/2);
        a=a/10;
        b=b/10;
      }
      if(carry!=0)
      {
        sum = sum*10 + carry;
      }
      long rsum = rec(sum);
      if(a==0||b==0)
      {
        rsum=rsum*10;
      }
      return rsum;
    }

  public static void main(String args[])  //It's UltimateKK creation
  {
    Scanner s = new Scanner(System.in);
    System.out.println("Enter 4 Characters from Sender side :");
    String st = new String();
    st=s.nextLine();
    int a[] = new int[10];
    long[] bin = new long[10];
    System.out.println("Binary Sequences :");
    for(int i=0;i<4;i++)
    {
      a[i] = (int)((st.charAt(i)));
      bin[i] = dectobin(a[i]);
      System.out.print(bin[i]+ " ");
    }
    System.out.println();
    int j=0;
    long x=0;
    long y=0;
    while(j!=4)
    {
      x= Sum(bin[j],bin[j+1]);
      y=Sum(x,y);
      j=j+2;
    }
    System.out.println("Summation : "+y);
    System.out.println("Checksum :"+comp(y));
    System.out.println("Enter 4 Characters at reciever side :");
    String st1 = new String();
    st1=s.nextLine();
    int a1[] = new int[10];
    long[] bin1 = new long[10];
    System.out.println("Binary Sequences :");
    for(int i=0;i<4;i++)
    {
      a1[i] = (int)((st1.charAt(i)));
      bin1[i] = dectobin(a1[i]);
      System.out.print(bin1[i]+ " ");
    }
    System.out.println();
    int j1=0;
    long x1=0;
    long y1=0;
    while(j1!=4)
    {
      x1= Sum(bin1[j1],bin1[j1+1]);
      y1=Sum(x1,y1);
      j1=j1+2;
    }
    System.out.println("Summation : "+y1);
    long v = y1+comp(y);
    if(comp(v)==0)
    {
      System.out.println("No error");
    }
    else
    {
      System.out.println("Error");
    }
  }
}
//It's UltimateKK creation
