package my.material;

import java.util.Scanner;
import java.util.Random;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 통합 관리 시스템
 * - 회원 관리 (가입, 로그인)
 * - 도서 관리 (CRUD, 검색)
 * - 계산기 기능
 * - 유틸리티 (로또, 문자열 계산)
 * 
 * 모든 기능이 하나의 파일에서 실행되도록 구성
 */
public class 도서추가등 {
    
    // ========== 상수 정의 ==========
    private static final int MAX_BOOKS = 100;
    private static final String ADMIN_EMAIL = "admin@naver.com";
    private static final String ADMIN_PASSWORD = "1234";
    
    // ========== 도서 관리용 배열 ==========
    private static String[] bookNames = new String[MAX_BOOKS];
    private static String[] authors = new String[MAX_BOOKS];
    private static String[] publishers = new String[MAX_BOOKS];
    private static String[] registrationDates = new String[MAX_BOOKS];
    private static int bookCount = 0; // 현재 등록된 도서 수
    
    /**
     * 프로그램 메인 메서드 - 프로그램 진입점
     * 전체 시스템의 메뉴를 제공하고 사용자 선택에 따라 각 기능을 실행
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 프로그램 시작 인사말
        System.out.println("========================================================");
        System.out.println("🎉 통합 관리 시스템에 오신 것을 환영합니다!");
        System.out.println("========================================================");
        
        // 메인 루프: 사용자가 종료를 선택할 때까지 반복 실행
        while (true) {
            try {
                displayMainMenu(); // 메인 메뉴 출력
                String choice = scanner.nextLine().trim(); // 사용자 선택 입력
                
                // 메뉴 선택에 따른 기능 실행
                if (!processMenuChoice(choice, scanner)) {
                    break; // 종료 선택 시 루프 탈출
                }
                
                // 각 기능 실행 후 잠시 대기 (사용자가 결과를 확인할 시간 제공)
                System.out.println("\n계속하려면 Enter를 눌러주세요...");
                scanner.nextLine();
                
            } catch (Exception e) {
                System.err.println("❌ 오류가 발생했습니다: " + e.getMessage());
                System.out.println("다시 시도해주세요.");
            }
        }
        
        // 프로그램 종료 처리
        scanner.close();
        System.out.println("👋 프로그램을 종료합니다. 감사합니다!");
    }
    
    /**
     * 메인 메뉴 출력 메서드
     * 사용자가 선택할 수 있는 모든 기능을 카테고리별로 정리하여 표시
     */
    private static void displayMainMenu() {
        System.out.println("\n========================================================");
        System.out.println("메뉴를 선택해주세요:");
        System.out.println("========================================================");
        System.out.println("회원 관리");
        System.out.println("  1. 회원 가입");
        System.out.println("  2. 로그인");
        System.out.println("도서 관리");
        System.out.println("  3. 도서 관리 시스템");
        System.out.println("계산기 기능");
        System.out.println("  4. 산술 연산자 테스트");
        System.out.println("  5. 산술 연산자 테스트2");
        System.out.println("유틸리티");
        System.out.println("  6. 로또 번호 생성기");
        System.out.println("  7. 문자열 개수 계산기");
        System.out.println("종료");
        System.out.println("  0. 프로그램 종료");
        System.out.println("========================================================");
        System.out.print("선택 (0~7): ");
    }
    
    /**
     * 메뉴 선택 처리 메서드
     * 사용자가 선택한 메뉴에 따라 해당 기능을 실행
     * @param choice 사용자가 선택한 메뉴 번호
     * @param scanner 입력을 위한 Scanner 객체
     * @return 계속 실행 여부 (false면 프로그램 종료)
     */
    private static boolean processMenuChoice(String choice, Scanner scanner) {
        switch (choice) {
            case "1":
                System.out.println("\n🔹 회원 가입 기능을 실행합니다.");
                registerUser(scanner);
                break;
                
            case "2":
                System.out.println("\n🔹 로그인 기능을 실행합니다.");
                loginUser(scanner);
                break;
                
            case "3":
                System.out.println("\n🔹 도서 관리 시스템을 실행합니다.");
                runBookManagementSystem(scanner);
                break;
                
            case "4":
                System.out.println("\n🔹 산술 연산자 테스트를 실행합니다.");
                basicCalculatorTest();
                break;
                
            case "5":
                System.out.println("\n🔹 산술 연산자 테스트2를 실행합니다.");
                advancedCalculatorTest();
                break;
                
            case "6":
                System.out.println("\n🔹 로또 번호 생성기를 실행합니다.");
                generateLottoNumbers();
                break;
                
            case "7":
                System.out.println("\n🔹 문자열 개수 계산기를 실행합니다.");
                int count = countCharacters(scanner);
                System.out.println("입력한 문자 개수: " + count);
                break;
                
            case "0":
                return false; // 프로그램 종료
                
            default:
                System.out.println("잘못된 입력입니다. 0~7 중에서 선택해주세요.");
        }
        
        return true; // 계속 실행
    }
    
    // ========== 회원 관리 기능 ==========
    
    /**
     * 회원 가입 처리 메서드
     * 사용자로부터 이름, 이메일, 패스워드를 입력받아 회원 가입 처리
     * 패스워드 확인을 통한 유효성 검증 포함
     * @param scanner 입력을 위한 Scanner 객체
     */
    public static void registerUser(Scanner scanner) {
        System.out.println("\n=== 🎉 회원가입 시스템 ===");
        
        // 1단계: 이름 입력
        System.out.print("이름을 입력해주세요: ");
        String name = scanner.nextLine().trim();
        
        // 2단계: 이메일 입력
        System.out.print("이메일을 입력해주세요: ");
        String email = scanner.nextLine().trim();
        
        // 3단계: 패스워드 입력 및 확인 (보안을 위한 이중 확인)
        String password = "";
        while (true) {
            System.out.print("패스워드를 입력해주세요: ");
            password = scanner.nextLine();
            
            // 빈 패스워드 검증
            if (password.isEmpty()) {
                System.out.println("패스워드는 비워둘 수 없습니다. 다시 입력해주세요.");
                continue;
            }
            
            System.out.print("패스워드 확인을 입력해주세요: ");
            String passwordConfirm = scanner.nextLine();
            
            // 패스워드 일치 확인
            if (password.equals(passwordConfirm)) {
                System.out.println("패스워드가 일치합니다!");
                break;
            } else {
                System.out.println("패스워드가 일치하지 않습니다. 다시 입력해주세요.\n");
            }
        }
        
        // 4단계: 가입일 자동 생성
        String regDate = getCurrentDateTime();
        
        // 5단계: 회원 정보 출력 및 완료 메시지
        System.out.println("\n=== 회원가입 완료 ===");
        System.out.println("이름: " + name);
        System.out.println("이메일: " + email);
        System.out.println("패스워드: " + password);
        System.out.println("가입일: " + regDate);
        System.out.println("회원가입이 성공적으로 완료되었습니다!");
    }
    
    /**
     * 로그인 처리 메서드
     * 이메일과 패스워드를 입력받아 인증 처리
     * 현재는 하드코딩된 관리자 계정으로만 인증 (추후 DB 연동 시 확장 가능)
     * @param scanner 입력을 위한 Scanner 객체
     */
    public static void loginUser(Scanner scanner) {
        System.out.println("\n=== 로그인 시스템 ===");
        
        String email = "";
        String password = "";
        
        // 로그인 성공까지 반복
        while (true) {
            // 이메일 입력 및 검증
            System.out.print("이메일을 입력해주세요: ");
            email = scanner.nextLine().trim();
            
            if (email.isEmpty()) {
                System.out.println("❌ 이메일은 비워둘 수 없습니다. 다시 입력해주세요.\n");
                continue;
            }
            
            // 패스워드 입력 및 검증
            System.out.print("패스워드를 입력해주세요: ");
            password = scanner.nextLine();
            
            if (password.isEmpty()) {
                System.out.println("❌ 패스워드는 비워둘 수 없습니다. 다시 입력해주세요.\n");
                continue;
            }
            
            // 인증 처리 (현재는 하드코딩된 관리자 계정)
            if (ADMIN_EMAIL.equals(email) && ADMIN_PASSWORD.equals(password)) {
                System.out.println("\n=== 로그인 성공 ===");
                System.out.println("로그인 이메일: " + email);
                System.out.println("로그인이 성공적으로 완료되었습니다!");
                break;
            } else {
                System.out.println("로그인 실패! 이메일 또는 패스워드를 확인해주세요.\n");
            }
        }
    }
    
    // ========== 도서 관리 기능 ==========
    
    /**
     * 도서 관리 시스템 메인 실행 메서드
     * 도서 관리의 모든 기능을 제공하는 서브 메뉴 시스템
     * @param scanner 입력을 위한 Scanner 객체
     */
    public static void runBookManagementSystem(Scanner scanner) {
        System.out.println("\n도서 관리 시스템에 오신 것을 환영합니다!");
        
        int menu;
        do {
            // 도서 관리 메뉴 출력
            System.out.println("\n=== 도서 관리 시스템 ===");
            System.out.println("1. 도서 추가");
            System.out.println("2. 도서 조회");
            System.out.println("3. 도서 수정");
            System.out.println("4. 도서 삭제");
            System.out.println("5. 더미 데이터 추가 (5개)");
            System.out.println("6. 도서 검색");
            System.out.println("0. 메인 메뉴로 돌아가기");
            System.out.println("========================");
            System.out.print("메뉴를 선택하세요 (0~6): ");
            
            // 메뉴 선택 입력 처리
            try {
                menu = scanner.nextInt();
                scanner.nextLine(); // 개행 문자 제거
            } catch (Exception e) {
                scanner.nextLine(); // 잘못된 입력 제거
                menu = -1; // 잘못된 입력 표시
            }
            
            // 선택된 메뉴에 따른 기능 실행
            switch (menu) {
                case 1:
                    addBook(scanner);
                    break;
                case 2:
                    viewBooks();
                    break;
                case 3:
                    updateBook(scanner);
                    break;
                case 4:
                    deleteBook(scanner);
                    break;
                case 5:
                    addDummyBooks();
                    break;
                case 6:
                    searchBook(scanner);
                    break;
                case 0:
                                       System.out.println("도서 관리 시스템을 종료합니다.");
                    break;
                default:
                    System.out.println("잘못된 메뉴 선택입니다. 다시 시도하세요.");
            }
        } while (menu != 0);
    }
    
    /**
     * 도서 추가 기능
     * 사용자로부터 도서 정보를 입력받아 배열에 저장
     * @param scanner 입력을 위한 Scanner 객체
     */
    public static void addBook(Scanner scanner) {
        System.out.println("\n=== 도서 추가 ===");
        
        // 최대 도서 수 확인
        if (bookCount >= MAX_BOOKS) {
            System.out.println("도서 수가 최대치(" + MAX_BOOKS + ")를 초과했습니다.");
            return;
        }
        
        // 도서 정보 입력 받기
        System.out.print("도서명을 입력하세요: ");
        String bookName = scanner.nextLine().trim();
        
        System.out.print("저자명을 입력하세요: ");
        String authorName = scanner.nextLine().trim();
        
        System.out.print("출판사를 입력하세요: ");
        String publisherName = scanner.nextLine().trim();
        
        // 입력 유효성 검증
        if (bookName.isEmpty() || authorName.isEmpty() || publisherName.isEmpty()) {
            System.out.println("모든 정보를 입력해주세요.");
            return;
        }
        
        // 도서 정보 저장
        bookNames[bookCount] = bookName;
        authors[bookCount] = authorName;
        publishers[bookCount] = publisherName;
        registrationDates[bookCount] = getCurrentDateTime();
        
        bookCount++;
        
        System.out.println(" 도서가 성공적으로 추가되었습니다!");
        System.out.println("도서명: " + bookName);
        System.out.println("저자: " + authorName);
        System.out.println("출판사: " + publisherName);
        System.out.println("등록일: " + registrationDates[bookCount - 1]);
    }
    
    /**
     * 도서 조회 기능
     * 등록된 모든 도서 정보를 출력
     */
    public static void viewBooks() {
        System.out.println("\n=== 📋 도서 목록 조회 ===");
        
        if (bookCount == 0) {
            System.out.println("📭 등록된 도서가 없습니다.");
            return;
        }
        
        System.out.println("📊 총 " + bookCount + "권의 도서가 등록되어 있습니다.\n");
        
        for (int i = 0; i < bookCount; i++) {
            System.out.println("[" + i + "] " + (i + 1) + "번째 도서");
            System.out.println("   도서명: " + bookNames[i]);
            System.out.println("    저자: " + authors[i]);
            System.out.println("   출판사: " + publishers[i]);
            System.out.println("   등록일: " + registrationDates[i]);
            System.out.println();
        }
    }
    
    /**
     * 도서 수정 기능
     * 인덱스를 통해 특정 도서의 정보를 수정
     * @param scanner 입력을 위한 Scanner 객체
     */
    public static void updateBook(Scanner scanner) {
        System.out.println("\n=== ✏️  도서 수정 ===");
        
        if (bookCount == 0) {
            System.out.println("📭 수정할 도서가 없습니다.");
            return;
        }
        
        // 현재 도서 목록 간단히 표시
        System.out.println("현재 등록된 도서 목록:");
        for (int i = 0; i < bookCount; i++) {
            System.out.println("[" + i + "] " + bookNames[i] + " - " + authors[i]);
        }
        
        System.out.print("수정할 도서의 인덱스를 입력하세요 (0 ~ " + (bookCount - 1) + "): ");
        
        try {
            int index = scanner.nextInt();
            scanner.nextLine(); // 개행 문자 제거
            
            if (index < 0 || index >= bookCount) {
                System.out.println("잘못된 인덱스입니다.");
                return;
            }
            
            // 기존 정보 표시
            System.out.println("\n현재 도서 정보:");
            System.out.println("도서명: " + bookNames[index]);
            System.out.println("저자: " + authors[index]);
            System.out.println("출판사: " + publishers[index]);
            
            // 새로운 정보 입력
            System.out.print("\n새로운 도서명을 입력하세요: ");
            String newBookName = scanner.nextLine().trim();
            
            System.out.print("새로운 저자명을 입력하세요: ");
            String newAuthorName = scanner.nextLine().trim();
            
            System.out.print("새로운 출판사를 입력하세요: ");
            String newPublisherName = scanner.nextLine().trim();
            
            // 입력 유효성 검증
            if (newBookName.isEmpty() || newAuthorName.isEmpty() || newPublisherName.isEmpty()) {
                System.out.println("모든 정보를 입력해주세요.");
                return;
            }
            
            // 정보 업데이트
            bookNames[index] = newBookName;
            authors[index] = newAuthorName;
            publishers[index] = newPublisherName;
            registrationDates[index] = getCurrentDateTime(); // 수정일로 업데이트
            
            System.out.println("도서 정보가 성공적으로 수정되었습니다!");
            System.out.println("수정된 도서: " + newBookName + " - " + newAuthorName);
            
        } catch (Exception e) {
            scanner.nextLine(); // 잘못된 입력 제거
            System.out.println("올바른 숫자를 입력해주세요.");
        }
    }
    
    /**
     * 도서 삭제 기능
     * 인덱스를 통해 특정 도서를 삭제하고 배열을 재정렬
     * @param scanner 입력을 위한 Scanner 객체
     */
    public static void deleteBook(Scanner scanner) {
        System.out.println("\n=== 도서 삭제 ===");
        
        if (bookCount == 0) {
            System.out.println("삭제할 도서가 없습니다.");
            return;
        }
        
        // 현재 도서 목록 간단히 표시
        System.out.println("현재 등록된 도서 목록:");
        for (int i = 0; i < bookCount; i++) {
            System.out.println("[" + i + "] " + bookNames[i] + " - " + authors[i]);
        }
        
        System.out.print("삭제할 도서의 인덱스를 입력하세요 (0 ~ " + (bookCount - 1) + "): ");
        
        try {
            int index = scanner.nextInt();
            scanner.nextLine(); // 개행 문자 제거
            
            if (index < 0 || index >= bookCount) {
                System.out.println("잘못된 인덱스입니다.");
                return;
            }
            
            // 삭제할 도서 정보 출력
            System.out.println("삭제할 도서 정보: " + bookNames[index] + " - " + authors[index] + " (" + registrationDates[index] + ")");
            
            // 삭제 확인
            System.out.print("정말로 삭제하시겠습니까? (y/n): ");
            String confirm = scanner.nextLine().trim().toLowerCase();
            
            if (!confirm.equals("y") && !confirm.equals("yes")) {
                System.out.println("삭제가 취소되었습니다.");
                return;
            }
            
            // 해당 인덱스의 도서 정보를 삭제하고, 뒤에 있는 도서 정보를 앞으로 이동
            for (int i = index; i < bookCount - 1; i++) {
                bookNames[i] = bookNames[i + 1];
                authors[i] = authors[i + 1];
                publishers[i] = publishers[i + 1];
                registrationDates[i] = registrationDates[i + 1];
            }
            
            // 마지막 도서 정보는 null로 설정
            bookNames[bookCount - 1] = null;
            authors[bookCount - 1] = null;
            publishers[bookCount - 1] = null;
            registrationDates[bookCount - 1] = null;
            
            // 도서 수 감소
            bookCount--;
            
            System.out.println("도서가 성공적으로 삭제되었습니다.");
            
        } catch (Exception e) {
            scanner.nextLine(); // 잘못된 입력 제거
            System.out.println("올바른 숫자를 입력해주세요.");
        }
    }
    
    /**
     * 더미 데이터 추가 기능
     * 테스트용 도서 데이터 5개를 자동으로 생성하여 추가
     */
    public static void addDummyBooks() {
        System.out.println("\n=== 더미 데이터 추가 ===");
        
        String[] dummyBookNames = {
            "자바 프로그래밍 입문", "스프링 부트 실전 가이드", "데이터베이스 설계", 
            "알고리즘 문제 해결", "웹 개발 완벽 가이드"
        };
        String[] dummyAuthors = {
            "김자바", "이스프링", "박데이터", "최알고", "정웹개발"
        };
        String[] dummyPublishers = {
            "자바출판사", "스프링북스", "데이터출판", "알고리즘프레스", "웹개발사"
        };
        
        int addedCount = 0;
        for (int i = 0; i < 5; i++) {
            if (bookCount < MAX_BOOKS) {
                bookNames[bookCount] = dummyBookNames[i];
                authors[bookCount] = dummyAuthors[i];
                publishers[bookCount] = dummyPublishers[i];
                registrationDates[bookCount] = getCurrentDateTime();
                bookCount++;
                addedCount++;
            } else {
                System.out.println("더미 도서 추가 실패: 최대 도서 수 초과");
                break;
            }
        }
        
        System.out.println("더미 도서 " + addedCount + "권이 추가되었습니다.");
    }
    
    /**
     * 도서 검색 기능
     * 도서명 또는 저자명으로 검색하여 일치하는 도서를 출력
     * @param scanner 입력을 위한 Scanner 객체
     */
    public static void searchBook(Scanner scanner) {
        System.out.println("\n=== 도서 검색 ===");
        
        if (bookCount == 0) {
            System.out.println("검색할 도서가 없습니다.");
            return;
        }
        
        System.out.print("검색할 도서명 또는 저자명을 입력하세요: ");
        String searchQuery = scanner.nextLine().trim();
        
        if (searchQuery.isEmpty()) {
            System.out.println("검색어를 입력해주세요.");
            return;
        }
        
        boolean found = false;
        System.out.println("\n📋 검색 결과:");
        
        for (int i = 0; i < bookCount; i++) {
            // 도서명 또는 저자명에 검색어가 포함되어 있는지 확인 (대소문자 구분 없음)
            if (bookNames[i].toLowerCase().contains(searchQuery.toLowerCase()) || 
                authors[i].toLowerCase().contains(searchQuery.toLowerCase())) {
                
                System.out.println("[" + i + "] 검색 결과");
                System.out.println("   도서명: " + bookNames[i]);
                System.out.println("   저자: " + authors[i]);
                System.out.println("   출판사: " + publishers[i]);
                System.out.println("   등록일: " + registrationDates[i]);
                System.out.println();
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("'" + searchQuery + "'에 대한 검색 결과가 없습니다.");
        }
    }
    
    // ========== 계산기 기능 ==========
    
    /**
     * 기본 계산기 테스트
     * 간단한 사칙연산 예제를 보여주는 기능
     */
    public static void basicCalculatorTest() {
        System.out.println("\n=== 🔢 기본 산술 연산자 테스트 ===");
        
        int a = 10;
        int b = 3;
        
        System.out.println("숫자 a = " + a + ", 숫자 b = " + b);
        System.out.println("➕ 덧셈: " + a + " + " + b + " = " + (a + b));
        System.out.println("➖ 뺄셈: " + a + " - " + b + " = " + (a - b));
        System.out.println("✖️  곱셈: " + a + " * " + b + " = " + (a * b));
        System.out.println("➗ 나눗셈: " + a + " / " + b + " = " + (a / b));
        System.out.println("🔢 나머지: " + a + " % " + b + " = " + (a % b));
        
        // 실수 연산 예제
        double c = 10.5;
        double d = 3.2;
        
        System.out.println("\n실수 연산 예제:");
        System.out.println("숫자 c = " + c + ", 숫자 d = " + d);
        System.out.println("➕ 덧셈: " + c + " + " + d + " = " + (c + d));
        System.out.println("➖ 뺄셈: " + c + " - " + d + " = " + (c - d));
        System.out.println("✖️  곱셈: " + c + " * " + d + " = " + (c * d));
        System.out.println("➗ 나눗셈: " + c + " / " + d + " = " + (c / d));
    }
    
    /**
     * 고급 계산기 테스트
     * 다양한 연산과 형변환 예제를 보여주는 기능
     */
    public static void advancedCalculatorTest() {
        System.out.println("\n=== 🔢 고급 산술 연산자 테스트 ===");
        
        // 정수와 실수 혼합 연산
        int intNum = 15;
        double doubleNum = 4.5;
        
        System.out.println("정수와 실수 혼합 연산:");
        System.out.println("정수: " + intNum + ", 실수: " + doubleNum);
        System.out.println("➕ 덧셈: " + intNum + " + " + doubleNum + " = " + (intNum + doubleNum));
        System.out.println("➖ 뺄셈: " + intNum + " - " + doubleNum + " = " + (intNum - doubleNum));
        System.out.println("✖️  곱셈: " + intNum + " * " + doubleNum + " = " + (intNum * doubleNum));
        System.out.println("➗ 나눗셈: " + intNum + " / " + doubleNum + " = " + (intNum / doubleNum));
        
        // 증감 연산자 테스트
        System.out.println("\n증감 연산자 테스트:");
        int x = 5;
        System.out.println("초기값 x = " + x);
        System.out.println("x++ (후위증가): " + (x++)); // 5 출력 후 x는 6이 됨
        System.out.println("현재 x = " + x); // 6
        System.out.println("++x (전위증가): " + (++x)); // x를 7로 증가시킨 후 7 출력
        System.out.println("x-- (후위감소): " + (x--)); // 7 출력 후 x는 6이 됨
        System.out.println("--x (전위감소): " + (--x)); // x를 5로 감소시킨 후 5 출력
        
        // 복합 대입 연산자 테스트
        System.out.println("\n복합 대입 연산자 테스트:");
        int y = 10;
        System.out.println("초기값 y = " + y);
        y += 5; // y = y + 5
        System.out.println("y += 5: " + y);
        y -= 3; // y = y - 3
        System.out.println("y -= 3: " + y);
        y *= 2; // y = y * 2
        System.out.println("y *= 2: " + y);
        y /= 4; // y = y / 4
        System.out.println("y /= 4: " + y);
        y %= 3; // y = y % 3
        System.out.println("y %= 3: " + y);
    }
    
    // ========== 유틸리티 기능 ==========
    
    /**
     * 로또 번호 생성기
     * 1~45 사이의 중복되지 않는 6개 번호를 생성하여 출력
     */
    public static void generateLottoNumbers() {
        System.out.println("\n=== 🎲 로또 번호 생성기 ===");
        
        Random random = new Random();
        int[] lottoNumbers = new int[6];
        boolean[] used = new boolean[46]; // 1~45 사용 여부 체크 (인덱스 0은 사용 안함)
        
        // 중복되지 않는 6개 번호 생성
        for (int i = 0; i < 6; i++) {
            int number;
            do {
                number = random.nextInt(45) + 1; // 1~45 사이의 랜덤 번호
            } while (used[number]); // 이미 사용된 번호면 다시 생성
            
            lottoNumbers[i] = number;
            used[number] = true;
        }
        
        // 번호 정렬 (오름차순)
        for (int i = 0; i < 5; i++) {
            for (int j = i + 1; j < 6; j++) {
                if (lottoNumbers[i] > lottoNumbers[j]) {
                    int temp = lottoNumbers[i];
                    lottoNumbers[i] = lottoNumbers[j];
                    lottoNumbers[j] = temp;
                }
            }
        }
        
        // 결과 출력
        System.out.println("🍀 행운의 로또 번호:");
        System.out.print("🎯 ");
        for (int i = 0; i < 6; i++) {
            System.out.print(lottoNumbers[i]);
            if (i < 5) {
                System.out.print(" - ");
            }
        }
        System.out.println();
        System.out.println("🎉 행운을 빕니다!");
    }
    
    /**
     * 문자열 개수 계산기
     * 사용자가 입력한 문자열의 길이를 계산하여 반환
     * @param scanner 입력을 위한 Scanner 객체
     * @return 입력된 문자열의 길이
     */
    public static int countCharacters(Scanner scanner) {
        System.out.println("\n=== 📝 문자열 개수 계산기 ===");
        
        System.out.print("문자열을 입력해주세요: ");
        String input = scanner.nextLine();
        
        int length = input.length();
        
        System.out.println("📊 분석 결과:");
        System.out.println("   입력된 문자열: \"" + input + "\"");
        System.out.println("   전체 문자 개수: " + length);
        
        // 공백 제거한 문자 개수도 계산
        String noSpaces = input.replace(" ", "");
        System.out.println("   공백 제외 문자 개수: " + noSpaces.length());
        
        // 단어 개수 계산 (공백으로 구분)
        if (!input.trim().isEmpty()) {
            String[] words = input.trim().split("\\s+");
            System.out.println("   단어 개수: " + words.length);
        } else {
            System.out.println("   단어 개수: 0");
        }
        
        return length;
    }
    
    // ========== 유틸리티 메서드 ==========
    
    /**
     * 현재 날짜와 시간을 문자열로 반환
     * 형식: yyyy-MM-dd HH:mm:ss
     * @return 현재 날짜시간 문자열
     */
    private static String getCurrentDateTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return now.format(formatter);
    }
}