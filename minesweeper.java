public class Minesweeper {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);

        // Create a boolean array set to false

        boolean[][] mineArray = new boolean[m][n];

        // Randomly select k spots in array and switch to true;
        int setMines = 0;

        while (setMines != k) {
            int i = (int) (Math.random() * m);
            int j = (int) (Math.random() * n);
            if (!mineArray[i][j]) {
                mineArray[i][j] = true;
                setMines++;
            }
        }

        // Create a new array with padding and copy boolean array into the middle

        boolean[][] paddedArray = new boolean[m + 2][n + 2];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                paddedArray[i + 1][j + 1] = mineArray[i][j];
            }
        }


        // Print the bool array for debugging
       /* for (int i = 0; i < n + 2; i++) {
            for (int j = 0; j < m + 2; j++) {
                System.out.print(paddedArray[j][i] + "  ");

            }
            System.out.println();
        } */

        // Create a counter array for tracking the mines
        int[][] countArray = new int[m][n];


        // Check the neighbors in the padded array and count
        for (int j = 1; j < n + 1; j++) {
            for (int i = 1; i < m + 1; i++) {
                int counter = 0;
                // use 17 as a placeholder for mines to replace with a *
                if (paddedArray[i][j]) {
                    countArray[i - 1][j - 1] = 17;
                }

                else {
                    if (paddedArray[i - 1][j]) counter++;
                    if (paddedArray[i - 1][j - 1]) counter++;
                    if (paddedArray[i - 1][j + 1]) counter++;
                    if (paddedArray[i][j - 1]) counter++;
                    if (paddedArray[i][j + 1]) counter++;
                    if (paddedArray[i + 1][j]) counter++;
                    if (paddedArray[i + 1][j - 1]) counter++;
                    if (paddedArray[i + 1][j + 1]) counter++;

                    countArray[i - 1][j - 1] = counter;
                }

            }
        }

        // print the minesweeper array

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (countArray[i][j] == 17) {
                    System.out.print("*  ");
                }
                else {
                    System.out.print(countArray[i][j] + "  ");
                }

            }
            System.out.println();

        }


    }

}



