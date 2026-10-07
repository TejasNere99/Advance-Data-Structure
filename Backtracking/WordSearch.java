import java.util.*;

public class WordSearch {
    public static boolean find(char arr[][], boolean vis[][], String word, int idx, int row, int col) {
        if (idx == word.length()) {
            return true;
        }
        // System.out.println(idx+" "+row+" "+col);
        int n = arr.length;
        int m = arr[0].length;
        vis[row][col] = true;
        int dr[] = { 0, -1, 0, 1 };
        int dc[] = { -1, 0, 1, 0 };
        for (int i = 0; i < 4; i++) {
            int r = row + dr[i];
            int c = col + dc[i];
            char ch = word.charAt(idx);
            if (r >= 0 && r < n && c >= 0 && c < m && ch == arr[r][c] && !vis[r][c]
                    && find(arr, vis, word, idx + 1, r, c)) {
                return true;
            }
            if (r >= 0 && r < n && c >= 0 && c < m) {
                vis[r][c] = false;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the 2D board  ");
        System.out.print("Enter the number of rows : ");
        int n = sc.nextInt();
        System.out.print("Enter the number of cols : ");
        int m = sc.nextInt();
        char arr[][] = new char[n][m];
        boolean vis[][] = new boolean[n][m];
        System.out.println("Enter the characters of the board : ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print("[" + i + "," + j + "] : ");
                arr[i][j] = sc.next().charAt(0);
            }
        }
        System.out.println("Board : ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.print("Enter the word : ");
        String word = sc.next();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char ch = word.charAt(0);
                if (ch == arr[i][j] && find(arr, vis, word, 1, i, j)) {
                    System.out.println("Word is present");
                    return;
                }
            }
        }
        System.out.println("Word is absent");

    }
}
