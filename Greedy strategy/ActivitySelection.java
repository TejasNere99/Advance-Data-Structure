import java.util.*;

public class ActivitySelection {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of shops : ");
        int n = sc.nextInt();
        int s[] = new int[n];
        int e[] = new int[n];
        // Input: S[] = {1, 8, 3, 2, 6}, E[] = {5, 10, 6, 5, 9}, K = 2
        // Output: 4
        // Input: S[] = {1, 2, 3}, E[] = {3, 4, 5}, K = 2
        // Output: 3
        System.out.println("Enter the Starting and Closing time for each shop : ");
        for(int i=0;i<n;i++){
            System.out.print("shop "+i+" : ");
            s[i] = sc.nextInt();
            e[i] = sc.nextInt();
        }
        System.out.print("Enter the number of persons : ");
        int k = sc.nextInt();
        int arr[][] = new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0] = s[i];
            arr[i][1] = e[i];
        }
        Arrays.sort(arr,(a,b)->a[1]-b[1]);
        // for(int i=0;i<n;i++){
        //     System.out.println(arr[i][0]+" | "+arr[i][1]);
        // }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int ans = 0;
        
        for(int i=0;i<n;i++){
            int start = arr[i][0];
            int end = arr[i][1];
            
            if(pq.isEmpty()){
                pq.add(end);
                ans++;
            }else{
                if(pq.peek()<=start){
                    pq.remove();
                    pq.add(end);
                    ans++;
                }else if(pq.peek()>start){
                    if(pq.size()<k){
                        pq.add(end);
                        ans++;
                    }
                }
            }
            
        }
        System.out.println("Maximum number of shops "+k+" persons can visit : "+ans);
    }
}
