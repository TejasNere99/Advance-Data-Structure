import java.util.*;

public class CoinChange {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of currency : ");
        int n = sc.nextInt();
        System.out.print("Enter "+n+" different currencies : ");
        int coins[] = new int[n];
        for(int i=0;i<n;i++){
            coins[i] = sc.nextInt();
        }
        System.out.print("Enter the sum : ");
        int sum = sc.nextInt();
        int dp[][] = new int[n+1][sum+1];
        for(int i=0;i<=n;i++){
            dp[i][0] = 1;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){
                int c = coins[i-1];
                if(j>=c){
                    dp[i][j] = dp[i][j-c] + dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println("Number of ways to make sum : "+dp[n][sum]);
    }
}
