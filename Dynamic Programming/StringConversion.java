// Given two strings s1 and s2, the task is to check if it is possible to convert s1 to s2 by performing the following operations.

//  Make some lowercase letters uppercase.
//  Delete all the lowercase letters.
//  Note: You can perform one, two or none operations to convert the string s1 to s2 as needed.

// Examples:  
// Input: s1 = "daBcd", s2 = "ABC"
// Output: Yes
// Explanation: Convert 'a' and 'c', delete both the d's

// Input: s1 = "ABcd", s2 = "BCD"
// Output: No
// Explanation: Can not delete A

import java.util.Scanner;

public class StringConversion {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter String 1 : ");
        String s1 = sc.nextLine();
        System.out.print("Enter String 2 : ");
        String s2 = sc.nextLine();
        int n = s1.length(),m = s2.length();
        boolean dp[][] = new boolean[n+1][m+1];
        dp[0][0] = true;
        for(int i=1;i<n+1;i++){
            char ch = s1.charAt(i-1);
            if(Character.isLowerCase(ch)){
                dp[i][0] = true;
            }
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                char ch1 = s1.charAt(i-1);
                char ch2 = s2.charAt(j-1);
                if(i>=j){
                    if(Character.isUpperCase(ch1)){
                        if(ch1==ch2){
                            dp[i][j] = dp[i-1][j-1];
                        }
                    }else{
                        if(ch1==Character.toLowerCase(ch2)){
                            dp[i][j] = dp[i-1][j-1] || dp[i-1][j];
                        }else{
                            dp[i][j] = dp[i-1][j];
                        }
                    }
                }
            }
        }
        if(dp[n][m]){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }  
    }
}
