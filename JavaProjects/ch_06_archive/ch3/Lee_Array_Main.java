package ch3;

import java.util.Scanner;

public class Lee_Array_Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Lee_Array arrayUtil = new Lee_Array();

        // 📌 사용자 입력 → 역순 배열 변환
        int[] numbers = arrayUtil.inputNumbers(scanner);
        int[] reversedArray = arrayUtil.getReversedArray(numbers);
        arrayUtil.printArray("입력한 숫자의 역순: ", reversedArray);

        // 📌 3x3 배열 생성 및 출력
        int[][] matrix = arrayUtil.createMatrix();
        arrayUtil.printMatrix("3x3 배열:", matrix);

        // 📌 사용자 입력 문자열 배열 중 가장 긴 문자열 찾기
        String[] words = arrayUtil.inputStrings(scanner);
        String longestWordUser = arrayUtil.findLongestString(words);
        System.out.println("사용자가 입력한 문자열 중 가장 긴 문자열: " + longestWordUser);

        // 📌 랜덤 문자열 배열 생성 및 출력
        System.out.println("랜덤한 문자열 5개를 생성합니다...");
        String[] randomWords = arrayUtil.generateRandomStrings(5);
        for (String word : randomWords) {
            System.out.println(word);
        }

        // 📌 랜덤 문자열 중 가장 긴 문자열 찾기
        String longestWordRandom = arrayUtil.findLongestString(randomWords);
        System.out.println("랜덤 문자열 중 가장 긴 문자열: " + longestWordRandom);

        scanner.close();
    }
}
