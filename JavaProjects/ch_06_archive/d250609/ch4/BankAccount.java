package d250609.ch4;

// 🏦 은행 계좌를 관리하는 클래스야.
public class BankAccount {
    // 📌 계좌 소유자 (각 객체가 고유한 값을 가짐)
   private String owner;

    // 📌 총 계좌 개설 건수를 추적할 거야 (모든 객체가 공유)
    public static int accountCount = 0;


    // 📌 은행의 고정 이자율 (값을 변경할 수 없음)
    public static final double INTEREST_RATE = 0.02;

    // 🏗️ 새로운 계좌를 생성할 때 필요한 정보 (owner의 이름을 받을 거야)
    public BankAccount(String owner) {
        this.owner = owner; // 소유자를 저장했어.
        accountCount++; // 새 계좌가 개설됐으니 개설 건수를 증가시킬게!
    }

    // 🆕 계좌를 개설하는 static 메서드 (계좌개설건수 자동 증가 기능 활용)
    public static BankAccount openAccount(String owner) {
        // 새로운 계좌를 만들면서 생성자에서 accountCount가 자동 증가함
        return new BankAccount(owner);
    }

    // 🏦 현재 총 계좌 개설 건수와 이자율을 확인할 수 있는 메서드야.
    public void showInfo() {
        System.out.println("총 계좌 개설 건수: " + accountCount);
        System.out.println("현재 이자율: " + INTEREST_RATE);
        System.out.println("계좌 정보 확인!");
        System.out.println("소유자: " + this.owner);
    }
}