package ch3;

import java.util.Scanner;
import util.date.*;

public class Lee_BookManager {

    static final int MAX_BOOKS = 100; // 최대 도서 수
    static String[] titles = new String[MAX_BOOKS];
    static String[] authors = new String[MAX_BOOKS];
    static String[] isbns = new String[MAX_BOOKS];
    static String[] publishDates = new String[MAX_BOOKS];
    static int bookCount = 0; // 현재 등록된 책 수

    // 📌 책 추가 메서드
    public static void addBook(Scanner scanner) {
        if (bookCount < MAX_BOOKS) {
            System.out.print("책 제목을 입력하세요: ");
            titles[bookCount] = scanner.nextLine();
            System.out.print("저자를 입력하세요: ");
            authors[bookCount] = scanner.nextLine();
            System.out.print("ISBN을 입력하세요: ");
            isbns[bookCount] = scanner.nextLine();
            publishDates[bookCount] = DateUtil.getCurrentDateTime();

            bookCount++;
            System.out.println("📚 책이 추가되었습니다: " + titles[bookCount-1]);
        } else {
            System.out.println("책 수가 최대치를 초과했습니다.");
        }
    }

    // 📌 책 조회 메서드
    public static void viewBooks() {
        if (bookCount == 0) {
            System.out.println("등록된 책이 없습니다.");
            return;
        }
        System.out.println("📜 등록된 도서 목록:");
        for (int i = 0; i < bookCount; i++) {
            System.out.println((i+1) + ". " + titles[i] + " - " + authors[i] + " (ISBN: " + isbns[i] + ")");
        }
    }

    // 📌 책 검색 메서드
    public static void searchBook(Scanner scanner) {
        System.out.print("검색할 책 제목 또는 ISBN을 입력하세요: ");
        String query = scanner.nextLine().toLowerCase();
        boolean found = false;
        for (int i = 0; i < bookCount; i++) {
            if (titles[i].toLowerCase().contains(query) || isbns[i].toLowerCase().contains(query)) {
                System.out.println("📖 찾은 책: " + titles[i] + " - " + authors[i] + " (ISBN: " + isbns[i] + ")");
                found = true;
            }
        }
        if (!found) System.out.println("검색 결과 없음.");
    }

    // 📌 책 더미 데이터 5권 추가 메서드
    public static void addDummyBooks() {
        String[] dummyTitles = {"자바의 정석", "클린 코드", "이펙티브 자바", "코딩 인터뷰 완전 분석", "파이썬으로 배우는 알고리즘"};
        String[] dummyAuthors = {"남궁성", "로버트 마틴", "조슈아 블로크", "게일 라크먼 맥도웰", "미셸 루비오"};
        String[] dummyIsbns = {"1234567890", "0987654321", "1122334455", "2233445566", "3344556677"};

        for (int i = 0; i < 3; i++) {
            if (bookCount < MAX_BOOKS) {
                titles[bookCount] = dummyTitles[i];
                authors[bookCount] = dummyAuthors[i];
                isbns[bookCount] = dummyIsbns[i];
                publishDates[bookCount] = DateUtil.getCurrentDateTime();
                bookCount++;
            } else {
                System.out.println("더미 데이터 추가 실패: 최대 도서 수 초과");
                break;
            }
        }
        System.out.println("📚 더미 도서 5권이 추가되었습니다.");
    }



    
}
