import java.util.*;

public class Permutations {
    public static void find(ArrayList<Integer> list,ArrayList<Integer> permutation,ArrayList<ArrayList<Integer>> ans){
        if(list.size()==0){
            ans.add(new ArrayList<>(permutation));
            return;
        }
        for(int i=0;i<list.size();i++){
            int num = list.get(i);
            permutation.add(num);
            list.remove(i);
            find(list,permutation,ans);
            list.add(i,num);
            permutation.remove(permutation.size()-1);
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements : ");
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        System.out.print("Enter the elements : ");
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        System.out.println(list.size());
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        find(list,new ArrayList<>(),ans);
        System.out.println("All permutations : ");
        for(int i=0;i<ans.size();i++){
            for(int j=0;j<ans.get(i).size();j++){
                System.out.print(ans.get(i).get(j));
            }
            System.out.println();
        }
    }
}
