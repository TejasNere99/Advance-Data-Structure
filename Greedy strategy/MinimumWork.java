import java.util.*;

public class MinimumWork {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number of Tasks : ");
        int n = sc.nextInt();
        System.out.println("Enter amount of work to be done for each task : ");
        int task[] = new int[n];
        // task[] = {3,4,7,15} D = 10
        // output = 4
        // task[] = {30,20,22,4,21} D=6
        // output = 22
        for(int i=0;i<n;i++){
            System.out.print("Task "+(i+1)+" : ");
            task[i] = sc.nextInt();
        }
        System.out.print("Enter the number of available days : ");
        int d = sc.nextInt();
        int sum = 0,max = -1;
        for(int i=0;i<n;i++){
            sum += task[i];
            max = Math.max(max,task[i]);
        }
        int start = sum/d;
        int end = max;
        int ans = start;
        while(start<=end){
            int mid = (start+end)/2;
            int days = 0;
            for(int i=0;i<n;i++){
                days += (task[i]/mid) + ((task[i] % mid) == 0 ? 0 : 1);
            }
            // System.out.println(start+" "+end+" "+mid+" "+days);
            if(days<=d){
                end = mid-1;
                ans = mid;
            }else{
                start = mid+1;
            }
        }
        System.out.println("Minimum work to be done : "+ans);
    }
}
