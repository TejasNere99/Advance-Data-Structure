import java.util.*;
public class Ass1 {
    public static void main(String args[]){
        Scanner sc     = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int n = sc.nextInt();
        System.out.print("Enter numbers : ");
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int start = 0,end = n-1;
        int mid = end+(start-end)/2;
        while(start<=end){
            mid = end+(start-end)/2;   
            if(arr[mid]==1){
                start = mid+1;
            }else{
                if(mid==0 || arr[mid-1]==1){
                    break;
                }
                end = mid-1;
            }
        }
        System.out.print("Number of zero's : ");
        if(start>end){
            System.out.println(0);
        }else{
            System.out.println(n-mid);
        }
    }
}
