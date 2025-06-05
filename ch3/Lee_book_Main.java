package ch3;

import java.util.Scanner;

public class Lee_book_Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n📚 도서 관리 시스템 📚");
            System.out.println("1. 책 추가");
            System.out.println("2. 책 목록 조회");
            System.out.println("3. 책 검색");
            System.out.println("4. 더미 도서 5권 추가");
            System.out.println("5. 종료");
            System.out.print("원하는 기능을 선택하세요: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // 개행 문자 제거

            switch (choice) {
                case 1:
                    Lee_BookManager.addBook(scanner);
                    break;
                case 2:
                    Lee_BookManager.viewBooks();
                    break;
                case 3:
                    Lee_BookManager.searchBook(scanner);
                    break;
                case 4:
                    Lee_BookManager.addDummyBooks();
                    break;
                case 5:
                    System.out.println("📖 도서 관리 시스템을 종료합니다.");
                    running = false;
                    break;
                default:
                    System.out.println("⚠️ 올바른 번호를 입력하세요!");
            }
        }

        scanner.close();
    }
}
