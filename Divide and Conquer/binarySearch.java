import java.util.*;

public class binarySearch{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of the array : ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter numbers in ascending order : ");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter key to search : ");
        int key = sc.nextInt();
        int start = 0,end = n-1;
        while(start<=end){
            int mid = end+(start-end)/2;
            if(arr[mid]==key){
                System.out.println("key is present at index : "+mid);
                return;
            }else if(arr[mid]<key){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        System.out.println("key is not present");
    }
}