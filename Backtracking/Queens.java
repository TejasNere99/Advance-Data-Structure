import java.util.*;

public class Queens {
    public static int i;

    public static void print(char board[][]) {
        int n = board.length;
        i++;
        System.out.println("Solution Number : " + i);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isSafe(char board[][], int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        int r = row, c = col;
        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q') {
                return false;
            }
            row--;
            col--;
        }
        row = r;
        col = c;
        while (row >= 0 && col < board.length) {
            if (board[row][col] == 'Q') {
                return false;
            }
            row--;
            col++;
        }
        return true;
    }

    public static void place(char board[][], int row, int col) {
        int n = board.length;

        if (n <= row) {
            print(board);
            return;
        }
        // if (n <= row || n <= col) {
        //     System.out.println("return : (" + row + "," + col + ")");
        //     return;
        // }
        for (int i = col; i < n; i++) {
            boolean safe = isSafe(board, row, i);
            // System.out.println("(" + row + "," + i + ") = > " + safe);
            if (safe) {
                board[row][i] = 'Q';
                place(board, row + 1, 0);
                board[row][i] = '-';
            }
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of N for NxN Board : ");
        int n = sc.nextInt();
        i = 0;
        char board[][] = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '-';
            }
        }
        place(board, 0, 0);
        if (i == 0) {
            System.out.println("No any solution exists");
        }
    }
}
