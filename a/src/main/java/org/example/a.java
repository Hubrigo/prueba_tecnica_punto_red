package org.example;

import java.util.Scanner;

public class a {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)){
            String[] sub1 = scanner.nextLine().split(" ");
            double x1 = Double.parseDouble(sub1[0]);
            double y1 = Double.parseDouble(sub1[1]);
            int z1 = Integer.parseInt(sub1[2]);

            if (!validateXAndY(x1,y1) || validateZ(z1)){
                System.out.println("NO");
                return;
            }

            String[] sub2 = scanner.nextLine().split(" ");
            double x2 = Double.parseDouble(sub2[0]);
            double y2 = Double.parseDouble(sub2[1]);
            int z2 = Integer.parseInt(sub2[2]);

            if (!validateXAndY(x2,y2) || validateZ(z2)){
                System.out.println("NO");
                return;
            }

            double dist = Math.sqrt(Math.pow(x2 - x1,2) + Math.pow(y2-y1,2));

            if (dist <= z1 + z2){
                System.out.println("SI");
            }else {
                System.out.println("NO");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    private static boolean validateXAndY(double x,double y){
        return x >= -100000 && x <= 100000 && y >= -100000 && y <= 100000;
    }

    private static boolean validateZ(int z){
        return z >= 0 && z <= 10000;
    }

}