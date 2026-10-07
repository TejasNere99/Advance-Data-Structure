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
        int first = -1, last = -1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] == key) {
                first = mid;
                end = mid - 1;
            }
            else if (arr[mid] < key) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }

        start = 0;
        end = n - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] == key) {
                last = mid;
                start = mid + 1;
            }
            else if (arr[mid] < key) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }

        if (first == -1) {
            System.out.println("Key not found");
        }
        else {
            int count = last - first + 1;
            System.out.println("Number of occurrences : " + count);
        }

        sc.close();
    }
}