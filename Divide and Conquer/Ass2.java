import java.util.*;
public class Ass2 {
    public static void merge(int arr[],int start,int mid,int end){
        int arr1[] = new int[mid-start+1];
        int arr2[] = new int[end-mid];
        int temp[] = new int[end-start+1];
        int idx1 = 0,idx2 = 0;
        // System.out.println("start : "+start+" mid : "+mid+" end : "+end);
        for(int i=start;i<=mid;i++){
            arr1[idx1] = arr[i];
            idx1++;
        }
        for(int i=mid+1;i<=end;i++){
            arr2[idx2] = arr[i];
            idx2++;
        }

        idx1 = 0;
        idx2 = 0;
        int idx = 0;
        while(idx1<arr1.length && idx2<arr2.length){
            if(arr1[idx1]>arr2[idx2]){
                temp[idx] = arr1[idx1];
                idx1++;
            }else{
                temp[idx] = arr2[idx2];
                idx2++;
            }
            idx++;
        }
        while(idx1<arr1.length){
            temp[idx] = arr1[idx1];
            idx1++;
            idx++;
        }
        while(idx2<arr2.length){
            temp[idx] = arr2[idx2];
            idx2++;
            idx++;
        }
        idx = 0;
        for(int i=start;i<=end;i++){
            arr[i] = temp[idx];
            idx++;
        }
    }
    public static void mergeSort(int arr[],int start,int end){
        if(start>=end){
            return;
        }
        int mid = (start+end)/2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid+1, end);
        
        merge(arr,start,mid,end);
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int n = sc.nextInt();
        System.out.print("Enter numbers : ");
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        mergeSort(arr,0,n-1);

        System.out.print("Array : ");
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
