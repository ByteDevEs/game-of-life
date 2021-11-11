import java.lang.Thread.State;
import java.util.concurrent.TimeUnit;

public class gol {
    // Create a 20x20 matrix
    public static int[][] matrix = new int[100][100];

    public static void main(String[] args) {
        matrix[40][50] = 1;
        matrix[40][51] = 1;
        matrix[39][49] = 1;
        matrix[39][50] = 1;
        matrix[41][50] = 1;

        matrix[60][50] = 2;
        matrix[60][51] = 2;
        matrix[59][49] = 2;
        matrix[59][50] = 2;
        matrix[61][50] = 2;
        while (true) {

            runGeneration();
            printMatrix();
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (Exception e) {
                System.out.println("Oops! Something went wrong!");
            }
        }
    }

    public static void runGeneration() {
        // Create a 20x20 matrix
        int[][] newMatrix = new int[100][100];

        // Loop through the matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                // Count the number of neighbors
                int neighbors = countNeighbors(i, j);
                int neighborInt = getNeighborInt(i, j);

                // If the cell is alive
                if (matrix[i][j] != 0) {
                    // If it has 2 or 3 neighbors, it stays alive
                    if (neighbors == 2 || neighbors == 3) {
                        newMatrix[i][j] = matrix[i][j];
                    }
                    // If it has less than 2 or more than 3 neighbors, it dies
                    else {
                        newMatrix[i][j] = 0;
                    }
                }
                // If the cell is dead
                else {
                    // If it has 3 neighbors, it becomes alive
                    if (neighbors == 3) {
                        newMatrix[i][j] = neighborInt;
                    }
                    // If it has less than 3 neighbors, it stays dead
                    else {
                        newMatrix[i][j] = 0;
                    }
                }
            }
        }

        // Set the new matrix to the old matrix
        matrix = newMatrix;
    }

    public static int countNeighbors(int i, int j) {
        int count = 0;
        // Loop through the matrix
        try {
            if (matrix[i + 1][j] != 0) {
                count++;
            }
            if (matrix[i - 1][j] != 0) {
                count++;
            }
            if (matrix[i][j + 1] != 0) {
                count++;
            }
            if (matrix[i][j - 1] != 0) {
                count++;
            }
            if (matrix[i + 1][j + 1] != 0) {
                count++;
            }
            if (matrix[i - 1][j - 1] != 0) {
                count++;
            }
            if (matrix[i - 1][j + 1] != 0) {
                count++;
            }
            if (matrix[i + 1][j - 1] != 0) {
                count++;
            }
        } catch (Exception e) {
            // System.out.println("Oops! Something went wrong!");
        }
        return count;
    }

    public static int getNeighborInt(int i, int j) {
        float count = 0;
        float nInt = 0;
        // Loop through the matrix
        try {
            if (matrix[i + 1][j] != 0) {
                count++;
                nInt += matrix[i + 1][j];
            }
            if (matrix[i - 1][j] != 0) {
                count++;
                nInt += matrix[i - 1][j];
            }
            if (matrix[i][j + 1] != 0) {
                count++;
                nInt += matrix[i][j + 1];
            }
            if (matrix[i][j - 1] != 0) {
                count++;
                nInt += matrix[i][j - 1];
            }
            if (matrix[i + 1][j + 1] != 0) {
                count++;
                nInt += matrix[i + 1][j + 1];
            }
            if (matrix[i - 1][j - 1] != 0) {
                count++;
                nInt += matrix[i - 1][j - 1];
            }
            if (matrix[i - 1][j + 1] != 0) {
                count++;
                nInt += matrix[i - 1][j + 1];
            }
            if (matrix[i + 1][j - 1] != 0) {
                count++;
                nInt += matrix[i + 1][j - 1];
            }
        } catch (Exception e) {
            // System.out.println("Oops! Something went wrong!");
        }
        return Math.round(nInt / count);
    }

    public static void printMatrix() {
        // Loop through the matrix
        String output = "";
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1) {
                    output += "X";
                } else if (matrix[i][j] == 2) {
                    output += "O";
                } else {
                    output += " ";
                }
            }
            output += "\n";
        }
        System.out.println(output);
    }
}