import java.util.*;
public class SearchInRotatedArray {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of the array : ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.print("Enter elements : ");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter key to search : ");
        int key = sc.nextInt();
        int start = 0,end = n-1;

        while(start<=end){
            int mid = (start+end)/2;
            if(key==arr[mid]){
                System.out.println("Target is found at index : "+mid);
                break;
            }
            if(key < arr[mid]){
                if(arr[start]<=key){
                    end = mid-1;
                }else{
                    start = mid+1;
                }
            }else if(key > arr[mid]){
                if(arr[end]>=key){
                    start = mid+1;
                }else{
                    end = mid-1;
                }
            }
        }
        if(start>end){
            System.out.println("Target not found");
        }
    }
}
