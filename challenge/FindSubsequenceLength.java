package challenge;

public class FindSubsequenceLength {
    public static void main(String[] args) {
      String s = "ATA"; // tiny example
      lrsWithLogs(s);
    }

    static int lrsWithLogs(String s) {
      int n = s.length();
      int[][] dp = new int[n + 1][n + 1];

      // Print headers
      System.out.println("String: " + s + " (length " + n + ")");
      System.out.println("Filling dp table in row-major order: i = 1..n, j = 1..n\n");

      for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {

          char rowChar = s.charAt(i - 1);
          char colChar = s.charAt(j - 1);

          System.out.printf("Cell dp[%d][%d]: compare row[%d]=%c with col[%d]=%c\n",
              i, j, i - 1, rowChar, j - 1, colChar);

          if (rowChar == colChar && i != j) {
            // MATCH from different positions → use both, so add 1 and go diagonal
            dp[i][j] = 1 + dp[i - 1][j - 1];
            System.out.printf("  -> MATCH & i!=j: dp[%d][%d] = 1 + dp[%d][%d] = 1 + %d = %d\n",
                i, j, i - 1, j - 1, dp[i - 1][j - 1], dp[i][j]);
          } else {
            // NO MATCH (or same position) → skip one side: take max of up and left
            dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            System.out.printf("  -> NO MATCH or i==j: dp[%d][%d] = max(dp[%d][%d]=%d, dp[%d][%d]=%d) = %d\n",
                i, j, i - 1, j, dp[i - 1][j], i, j - 1, dp[i][j - 1], dp[i][j]);
          }

          System.out.println();
        }
      }

      // Print final table
      System.out.println("Final dp table:");
      printTable(dp);

      System.out.println("\nAnswer = dp[n][n] = dp[" + n + "][" + n + "] = " + dp[n][n]);
      return dp[n][n];
    }

    static void printTable(int[][] dp) {
      for (int i = 0; i < dp.length; i++) {
        for (int j = 0; j < dp[0].length; j++) {
          System.out.printf("%2d ", dp[i][j]);
        }
        System.out.println();
      }
    }
}
