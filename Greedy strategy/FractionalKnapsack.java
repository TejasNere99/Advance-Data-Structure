import java.util.*;
// Given two arrays, val[] and wt[] , representing the values and weights of items, and an integer capacity representing the maximum weight a knapsack can hold, determine the maximum total value that can be achieved by putting items in the knapsack. You are allowed to break items into fractions if necessary.
// Return the maximum value as a double, rounded to 6 decimal places.

// Examples :

// Input: val[] = [60, 100, 120], wt[] = [10, 20, 30], capacity = 50
// Output: 240.000000
// Explanation: By taking items of weight 10 and 20 kg and 2/3 fraction of 30 kg. Hence total price will be 60+100+(2/3)(120) = 240
// Input: val[] = [500], wt[] = [30], capacity = 10
// Output: 166.670000
// Explanation: Since the item’s weight exceeds capacity, we take a fraction 10/30 of it, yielding value 166.670000.

public class FractionalKnapsack {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of items : ");
        int n = sc.nextInt();
        int wt[] = new int[n];
        int val[] = new int[n];
        System.out.println("Enter items weight and value : ");
        for(int i=0;i<n;i++){
            System.out.print("Item "+i+" : ");
            val[i] = sc.nextInt();
            wt[i] = sc.nextInt();
        }
        System.out.print("Enter capacity : ");
        int c = sc.nextInt();

        double arr[][] = new double[n][3];
        for(int i=0;i<n;i++){
            arr[i][0] = (double)wt[i];
            arr[i][1] = (double)val[i];
            arr[i][2] = (double)val[i]/wt[i];
        }
        Arrays.sort(arr,(a,b)->(int)(b[2]-a[2]));
        for(int i=0;i<n;i++){
            System.out.println(arr[i][0]+" | "+arr[i][1]+" | "+arr[i][2]);
        }
        double ans = 0;
        for(int i=0;i<n && c>0;i++){
            if(arr[i][0]<=c){
                ans += arr[i][1];
                c -= arr[i][0];
            }else{
                ans += c*(arr[i][2]);
                c = 0;
                break;
            }
        }
        System.out.println("Maximum value that can be obtained : "+ans);
    }
}
