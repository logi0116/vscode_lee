package d250609.ch4;

public class MemberTest {
    public static void main(String[] args) {
        // 1) 인스턴스 3개 생성
        Member m1 = new Member("홍길동", "hong@test.com", "1111");
        Member m2 = new Member("이순신", "lee@test.com", "2222");
        Member m3 = new Member("강감찬", "kang@test.com", "3333");

        // 2) 각 인스턴스 정보 출력
        System.out.println("=== 생성 직후 정보 ===");
        m1.showInfo();
        m2.showInfo();
        m3.showInfo();

        // 3) 정보 변경
        m1.changeNameEmailPassword("홍길순", "hongsun@test.com", "abcd");
        m2.changeNameEmailPassword("이순자", "leeja@test.com", "efgh");
        m3.changeNameEmailPassword("강감자", "kangja@test.com", "ijkl");

        // 4) 변경 후 정보 출력
        System.out.println("=== 정보 변경 후 ===");
        m1.showInfo();
        m2.showInfo();
        m3.showInfo();
    }
}