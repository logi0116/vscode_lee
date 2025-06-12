package remind;

import java.util.Scanner;

/**
 * ch4 핵심 복습 예제
 * - 클래스/객체/생성자/캡슐화/접근제어자/Getter-Setter/static/final
 * - 퀴즈/연습/해설/마법사 대사 포함
 */
public class Ch4MagicOOPReview {

    // 1. [클래스와 객체] 마법 도구의 설계도와 실체
    static class Wand {
        // 마법사: "이건 마법봉 설계도야!"
        String name;
        int power;

        // 생성자: 마법봉을 만들 때 이름과 힘을 넣는 주문
        public Wand(String name, int power) {
            this.name = name;
            this.power = power;
        }

        // 마법봉 정보 출력
        public void showInfo() {
            System.out.println("마법봉 이름: " + name + ", 힘: " + power);
        }
    }

    // 2. [캡슐화/접근제어자/Getter-Setter] 마법사의 비밀 금고
    static class Wizard {
        // 마법사: "내 이름, 이메일, 패스워드는 비밀 금고에 넣어둘래!"
        private String name;
        private String email;
        private String password;

        // 생성자
        public Wizard(String name, String email, String password) {
            this.name = name;
            this.email = email;
            this.password = password;
        }

        // Getter (열쇠로 꺼내기)
        public String getName() { return name; }
        public String getEmail() { return email; }
        public String getPassword() { return password; }

        // Setter (열쇠로 바꾸기)
        public void setName(String name) { this.name = name; }
        public void setEmail(String email) { this.email = email; }
        public void setPassword(String password) { this.password = password; }

        // 정보 출력
        public void showInfo() {
            System.out.println("이름: " + name + ", 이메일: " + email + ", 패스워드: " + password);
        }

        // 한 번에 정보 변경하는 마법
        public void changeAll(String name, String email, String password) {
            this.name = name;
            this.email = email;
            this.password = password;
        }
    }

    // 3. [static/final] 마법사의 공유 마법과 영원한 마법
    static class MagicSchool {
        // static: 모든 마법사가 공유하는 마법
        static int wizardCount = 0;
        // final: 영원히 변하지 않는 마법(상수)
        static final String SCHOOL_NAME = "호그와트 마법학교";

        // 마법사 등록
        public static void registerWizard() {
            wizardCount++;
            System.out.println("마법사 한 명이 입학했습니다! 현재 마법사 수: " + wizardCount);
        }

        // 학교 정보 출력
        public static void showSchoolInfo() {
            System.out.println("학교명: " + SCHOOL_NAME + ", 전체 마법사 수: " + wizardCount);
        }
    }

    // 4. [퀴즈1] Member 클래스 실전 연습
    static class Member {
        private String name;
        private String email;
        private String password;

        public Member(String name, String email, String password) {
            this.name = name;
            this.email = email;
            this.password = password;
        }

        public void showInfo() {
            System.out.println("이름: " + name + ", 이메일: " + email + ", 패스워드: " + password);
        }

        public String getName() { return name; }
        public String getEmail() { return email; }
        public String getPassword() { return password; }

        public void setName(String name) { this.name = name; }
        public void setEmail(String email) { this.email = email; }
        public void setPassword(String password) { this.password = password; }

        public void changeNameEmailPassword(String name, String email, String password) {
            this.name = name;
            this.email = email;
            this.password = password;
        }
    }

    // 5. [퀴즈2] static/final 활용 – BankAccount 클래스
    static class BankAccount {
        private String owner;
        private static int accountCount = 0;
        public static final double INTEREST_RATE = 0.02;

        public BankAccount(String owner) {
            this.owner = owner;
            accountCount++;
        }

        public void showInfo() {
            System.out.println("소유자: " + owner + ", 전체 계좌 개설 건수: " + accountCount + ", 이자율: " + INTEREST_RATE);
        }
    }

    // 6. [연습] 객체 배열과 반복문 활용
    static void memberArrayPractice() {
        System.out.println("\n[객체 배열 연습] 여러 명의 마법사(회원) 관리하기!");
        Member[] members = new Member[3];
        members[0] = new Member("해리", "harry@hogwarts.com", "1234");
        members[1] = new Member("헤르미온느", "hermione@hogwarts.com", "5678");
        members[2] = new Member("론", "ron@hogwarts.com", "abcd");

        // 반복문으로 전체 정보 출력
        for (Member m : members) {
            m.showInfo();
        }
    }

    // 7. [연습] static 변수/메서드 활용
    static void staticPractice() {
        System.out.println("\n[static 연습] 마법사 학교 입학/정보 출력");
        MagicSchool.registerWizard();
        MagicSchool.registerWizard();
        MagicSchool.showSchoolInfo();
    }

    // 8. [연습] final 상수 활용
    static void finalPractice() {
        System.out.println("\n[final 연습] 학교명(상수) 출력");
        System.out.println("학교명: " + MagicSchool.SCHOOL_NAME);
        // MagicSchool.SCHOOL_NAME = "다른학교"; // 오류! final은 변경 불가
    }

    // 9. [실전 퀴즈] 직접 입력받아 객체 생성/정보 변경
    static void memberQuizPractice(Scanner scanner) {
        System.out.println("\n[실전 퀴즈] 회원(Member) 직접 입력/정보 변경 연습");
        System.out.print("이름 입력: ");
        String name = scanner.nextLine();
        System.out.print("이메일 입력: ");
        String email = scanner.nextLine();
        System.out.print("패스워드 입력: ");
        String password = scanner.nextLine();

        Member m = new Member(name, email, password);
        System.out.println("회원 정보:");
        m.showInfo();

        System.out.println("정보를 변경해볼까요?");
        System.out.print("새 이름 입력: ");
        String newName = scanner.nextLine();
        System.out.print("새 이메일 입력: ");
        String newEmail = scanner.nextLine();
        System.out.print("새 패스워드 입력: ");
        String newPassword = scanner.nextLine();

        m.changeNameEmailPassword(newName, newEmail, newPassword);
        System.out.println("변경된 회원 정보:");
        m.showInfo();
    }

    // 10. [실전 퀴즈] BankAccount 직접 입력/정보 출력
    static void bankAccountQuizPractice(Scanner scanner) {
        System.out.println("\n[실전 퀴즈] 계좌(BankAccount) 직접 입력/정보 출력 연습");
        System.out.print("계좌 소유자 이름 입력: ");
        String owner = scanner.nextLine();
        BankAccount acc = new BankAccount(owner);
        acc.showInfo();
    }

    // 11. [마법사 대사로 배우는 핵심 해설]
    static void magicSummary() {
        System.out.println("\n=== 마법사 학교 ch4 핵심 해설 ===");
        System.out.println("1. 클래스는 마법 도구의 설계도, 객체는 그 설계도로 만든 진짜 마법 도구!");
        System.out.println("2. 생성자는 마법 도구를 만들 때 한 번에 힘을 불어넣는 주문!");
        System.out.println("3. 중요한 정보는 비밀 금고(private)에 넣고, 열쇠(getter/setter)로만 꺼내거나 바꾼다!");
        System.out.println("4. static은 모든 마법사가 공유하는 마법, final은 영원히 변하지 않는 마법(상수)!");
        System.out.println("5. 객체 배열과 반복문을 조합하면 여러 마법사를 한 번에 관리할 수 있다!");
        System.out.println("6. 직접 입력받아 객체를 만들고, 정보를 바꿔보며 연습하면 진짜 마법사가 된다!");
    }

    // 12. [실행 메인]
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== ch4 마법사 학교 객체지향 복습 ===");

        // 1. 클래스/객체/생성자 연습
        System.out.println("\n[1] 마법봉 객체 만들기/정보 출력");
        Wand wand1 = new Wand("엘더완드", 100);
        Wand wand2 = new Wand("플라워완드", 50);
        wand1.showInfo();
        wand2.showInfo();

        // 2. 캡슐화/Getter-Setter 연습
        System.out.println("\n[2] 마법사(회원) 객체 만들기/정보 출력/변경");
        Wizard wizard = new Wizard("해리", "harry@hogwarts.com", "1234");
        wizard.showInfo();
        System.out.println("이름만 바꿔볼게요!");
        wizard.setName("해리포터");
        wizard.showInfo();

        // 3. static/final 연습
        staticPractice();
        finalPractice();

        // 4. 객체 배열/반복문 연습
        memberArrayPractice();

        // 5. 퀴즈1: Member 클래스 실전 연습
        System.out.println("\n[3] 퀴즈1: Member 3명 만들고 정보 출력/변경");
        Member m1 = new Member("해리", "harry@hogwarts.com", "1234");
        Member m2 = new Member("헤르미온느", "hermione@hogwarts.com", "5678");
        Member m3 = new Member("론", "ron@hogwarts.com", "abcd");
        m1.showInfo();
        m2.showInfo();
        m3.showInfo();
        System.out.println("m1 정보 변경!");
        m1.changeNameEmailPassword("해리포터", "harryp@hogwarts.com", "9999");
        m1.showInfo();

        // 6. 퀴즈2: BankAccount 클래스 실전 연습
        System.out.println("\n[4] 퀴즈2: BankAccount 3개 만들고 정보 출력");
        BankAccount acc1 = new BankAccount("해리");
        BankAccount acc2 = new BankAccount("헤르미온느");
        BankAccount acc3 = new BankAccount("론");
        acc1.showInfo();
        acc2.showInfo();
        acc3.showInfo();

        // 7. 직접 입력/정보 변경 연습
        memberQuizPractice(scanner);
        bankAccountQuizPractice(scanner);

        // 8. 마법사 학교 핵심 해설
        magicSummary();

        scanner.close();
        System.out.println("\n=== ch4 복습 마법 끝! ===");
    }
}