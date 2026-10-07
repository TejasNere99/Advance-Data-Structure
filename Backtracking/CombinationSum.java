import java.util.*;

public class CombinationSum {
    public static void find(int arr[],int target,ArrayList<ArrayList<Integer>> ans,ArrayList<Integer> list){
        if(target==0){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(target<0){
            return;
        }
        for(int i=0;i<arr.length;i++){
            list.add(arr[i]);
            find(arr,target-arr[i],ans,list);
            list.remove(list.size()-1);
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of Elements : ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.print("Enter distinct elements : ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter the target sum : ");
        int target = sc.nextInt();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        find(arr,target,ans,new ArrayList<>());
        System.out.println("All possible combinations to make target sum : ");
        for(int i=0;i<ans.size();i++){
            System.out.print("[");
            for(int j=0;j<ans.get(i).size();j++){
                System.out.print(ans.get(i).get(j));
                if(ans.get(i).size()-1 != j){
                    System.out.print(",");
                }
            }
            System.out.println("]");
        }
    }
}
