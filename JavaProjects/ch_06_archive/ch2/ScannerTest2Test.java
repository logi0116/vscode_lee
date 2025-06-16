package ch2;

import util.user.UserServiceLee;

public class ScannerTest2Test {
    public static void main(String[] args) {
        // ✅ 회원가입 실행 (회원가입이 끝나면 자동으로 로그인 진행)
        UserServiceLee.RegisterUser();

        // ✅ 모든 입력이 끝난 후 Scanner 닫기
        UserServiceLee.CloseScanner();
    }
}
