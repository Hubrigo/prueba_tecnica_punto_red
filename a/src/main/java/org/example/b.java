package org.example;

import java.util.Scanner;

public class b {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            if (n <= 0 || n > 100000) {
                System.out.println("Error: Valor de entrada fuera de rango.");
                return;
            }

            int[][] matrix = new int[n][n];
            int diagonalSum = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (j < n - i - 1) {
                        matrix[i][j] = 1;
                    } else if (j == n - i - 1) {
                        matrix[i][j] = n - i;
                        diagonalSum += matrix[i][j];
                    } else {
                        matrix[i][j] = 0;
                    }
                }
            }

            // Imprimir la matriz
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }

            System.out.println(diagonalSum);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
