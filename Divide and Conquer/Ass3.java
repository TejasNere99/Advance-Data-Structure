import java.util.*;

public class Ass3 {
    public static long fact(int num) {
        if (num == 0 || num == 1)
            return 1;
        long f = 1;
        while (num > 1) {
            f *= num;
            num--;
        }
        return f;
    }

    public static int countOfZeros(long num){
        int count = 0;
        while(num>0){
            if(num%10 == 0){
                count++;
            }else{
                break;
            }
            num /= 10;
        }
        return count;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number : ");
        int n = sc.nextInt();
        
        int start = 0, end = 5*n;
        int mid = (start + end) / 2;

        while(start<=end){
            mid = (start + end) / 2;
            long f = fact(mid);
            int count = countOfZeros(f);
            if(count < n){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }

        System.out.println(fact(mid));
        
    }
}
