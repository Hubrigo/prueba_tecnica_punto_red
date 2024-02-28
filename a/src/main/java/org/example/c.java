package org.example;

import java.util.Scanner;

public class c {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            scanner.nextLine();

            StringBuilder output = new StringBuilder();
            for (int i = 0; i < n; i++) {
                String[] values = scanner.nextLine().split(" ");
                int x = Integer.parseInt(values[0]);
                int y = Integer.parseInt(values[1]);

                int result = x * y;
                if (isValidResult(result)) {
                    output.append("NO\n");
                } else {
                    output.append("SI\n");
                }
            }

            System.out.print(output.toString());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    private static boolean isValidResult(int result) {
        return result >= 10000 && result <= 99999 && String.valueOf(result).charAt(0) != '0';
    }

}
