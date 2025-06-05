package util.user;

public class UserDataLee {
    private String name;
    private String email;
    private String password;

    // 생성자 (회원 정보를 저장할 때 사용)
    public UserDataLee(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    // 정보 출력 메서드
    public void displayUserInfo() {
        System.out.println("\n🎉 회원 정보 저장 완료!");
        System.out.println("이름: " + name);
        System.out.println("이메일: " + email);
        System.out.println("패스워드: ***** (보안상 숨김)");
    }

    // ✅ 로그인 검증 메서드 (이메일과 비밀번호 모두 일치해야 함)
    public boolean verifyLogin(String inputEmail, String inputPassword) {
        return this.email.equals(inputEmail) && this.password.equals(inputPassword);
    }

    // ✅ 사용자 이름 가져오는 메서드
    public String getName() {
        return name;
    }
}
