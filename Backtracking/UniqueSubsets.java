// Given an array arr[] of positive integers, Find all the unique subsets of the array.

// A subset is any selection of elements from an array, where the order does not matter, and no element appears more than once. It can include any number of elements, from none (the empty subset) to all the elements of the array.

// Note: If the array contains duplicate elements, the same subset should not appear more than once in the output. Only unique subsets should be included.

// Examples:

// Input: arr[] = [1, 5, 6]
// Output: [[],[1], [1, 5], [1, 6], [5], [5, 6], [6], [1, 5, 6]]
// Explanation: The Unique subset are [],[1], [1, 5], [1, 6], [5], [5, 6], [6], and [1, 5, 6]

// Input: arr[] = [1, 2, 2]
// Output: [[],[1], [1, 2], [1, 2, 2], [2], [2, 2]]
// Explanation: The Unique subset are [],[1], [1, 2], [1, 2, 2], [2], [2, 2]

import java.util.*;

public class UniqueSubsets {
    public static void find(int arr[], int idx, ArrayList<Integer> list, Set<ArrayList<Integer>> ans) {
        if (idx == arr.length) {
            ans.add(new ArrayList<>(list));
            return;
        }
        find(arr, idx + 1, list, ans);
        list.add(arr[idx]);
        find(arr, idx + 1, list, ans);
        list.remove(list.size()-1);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of Elements : ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.print("Enter the elements : ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Set<ArrayList<Integer>> ans = new HashSet<>();
        find(arr, 0, new ArrayList<>(), ans);
        System.out.print("All possible subsets : [");
        
        for (ArrayList<Integer> set : ans) {
            System.out.print("[");
            for (int j = 0; j < set.size(); j++) {
                System.out.print(set.get(j));
                if (j != set.size() - 1) {
                    System.out.print(",");
                }
            }
            System.out.print("],");
        }
        System.out.print("]");
    }
}
