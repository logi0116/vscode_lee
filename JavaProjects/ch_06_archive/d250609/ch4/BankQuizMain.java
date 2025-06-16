package d250609.ch4;

public class BankQuizMain {
    public static void main(String[] args) {
        // 🏗️ 새로운 계좌를 5개 만들어볼게!
        BankAccount account1 = new BankAccount("Alice");    // 인스턴스 1: account1
        BankAccount account2 = new BankAccount("Bob");      // 인스턴스 2: account2
        BankAccount account3 = new BankAccount("Charlie");  // 인스턴스 3: account3
        BankAccount account4 = new BankAccount("David");    // 인스턴스 4: account4
        BankAccount account5 = new BankAccount("Eve");      // 인스턴스 5: account5

        // 🏦 계좌 정보를 출력할게!
        account1.showInfo(); // account1의 정보
        account2.showInfo(); // account2의 정보
        account3.showInfo(); // account3의 정보
        account4.showInfo(); // account4의 정보
        account5.showInfo(); // account5의 정보

        // ⚠️ 이자율을 변경하려 하면 오류가 날 거야!
        // BankAccount.INTEREST_RATE = 0.03; // ❌ 컴파일 에러 발생 (final 변수는 변경 불가)
    }
}