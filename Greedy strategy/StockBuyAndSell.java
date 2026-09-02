import java.util.Scanner;

public class StockBuyAndSell {
//     Input: prices[] = [100, 180, 260, 310, 40, 535, 695]
//     Output: 865
//     Input: prices[] = [4, 2]
//     Output: 0

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of days : ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the stock price for particular day : ");
        for(int i=0;i<n;i++){
            System.out.print("Day "+(i+1)+" : ");
            arr[i] = sc.nextInt();
        }
        int ans = 0;
        for(int i=1;i<n;i++){
            if(arr[i]>arr[i-1]){
                ans += arr[i]-arr[i-1];
            }
        }
        System.out.println("Maximum Profit : "+ans);
    }
}
