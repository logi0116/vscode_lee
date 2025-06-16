package ch3;

import java.util.Random;
import java.util.Scanner;

public class Lee_Array {

    // 📌 사용자 입력받아 배열 반환 (정수 입력)
    public int[] inputNumbers(Scanner scanner) {
        int[] numbers = new int[5];
        System.out.println("정수 5개를 입력하세요:");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextInt();
        }
        return numbers;
    }

    // 📌 배열을 역순으로 변환하는 메서드
    public int[] getReversedArray(int[] original) {
        int[] reversed = new int[original.length];

        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }

        return reversed;
    }

    // 📌 3x3 배열을 생성해서 채우는 메서드
    public int[][] createMatrix() {
        int[][] matrix = new int[3][3];
        int num = 1;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = num++;
            }
        }

        return matrix;
    }

    // 📌 문자열 입력 받아 배열 반환
    public String[] inputStrings(Scanner scanner) {
        String[] words = new String[5];
        System.out.println("문자열 5개를 입력하세요:");
        for (int i = 0; i < words.length; i++) {
            words[i] = scanner.next();
        }
        return words;
    }

    // 📌 랜덤 문자열 배열 생성하는 메서드
    public String[] generateRandomStrings(int size) {
        String[] randomStrings = new String[size];
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            int length = random.nextInt(5, 10); // 문자열 길이를 5~10로 랜덤 설정
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < length; j++) {
                sb.append(chars.charAt(random.nextInt(chars.length())));
            }

            randomStrings[i] = sb.toString();
        }

        return randomStrings;
    }

    // 📌 문자열 배열 중 가장 긴 문자열 반환
    public String findLongestString(String[] arr) {
        String longest = arr[0];

        for (String word : arr) {
            if (word.length() > longest.length()) {
                longest = word;
            }
        }

        return longest;
    }

    // 📌 정수 배열 출력하는 메서드
    public void printArray(String message, int[] arr) {
        System.out.print(message + " ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // 📌 2차원 배열 출력하는 메서드
    public void printMatrix(String message, int[][] matrix) {
        System.out.println(message);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
