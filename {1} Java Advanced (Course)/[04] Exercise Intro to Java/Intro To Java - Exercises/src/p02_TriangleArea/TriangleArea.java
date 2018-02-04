package p02_TriangleArea;

import java.util.Arrays;
import java.util.Scanner;

public class TriangleArea {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] A = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int[] B = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int[] C = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

    int area = Math.abs((A[0] * (B[1] - C[1]) + B[0] * (C[1] - A[1]) + C[0] * (A[1] - B[1])) / 2);

        System.out.println(area);
    }
}
