import java.util.*;

public class CountOccurences {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of the array : ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.print("Enter elements : ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter key to search : ");
        int key = sc.nextInt();
        int start = 0, end = n - 1;
        int mid = (start+end)/2;
        while (start <= end) {
            mid = (start + end) / 2;
            if (arr[mid] == key) {
                break;
            } else if (arr[mid] < key) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        if(start>end){
            System.out.println("Number of Occurences : 0");
        }else{
            int count = 0;
            for(int i=mid;i>=0 && arr[i]==key;i--){
                count++;
            }
            for(int i=mid+1;i<n && arr[i]==key;i++){
                count++;
            }
            System.out.println("Number of Occurences : "+count);
        }
        
    }
}
