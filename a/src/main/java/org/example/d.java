package org.example;

import java.util.Scanner;

public class d {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            long n = scanner.nextLong();
            if (n <= 0 || n > 1000000) {
                System.out.println("NO");
                return;
            }

            long square = n * n;
            String nStr = String.valueOf(n);
            String squareStr = String.valueOf(square);

            if (squareStr.endsWith(nStr)) {
                System.out.println("SI");
            } else {
                System.out.println("NO");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
