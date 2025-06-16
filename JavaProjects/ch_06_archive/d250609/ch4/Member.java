package d250609.ch4;

public class Member {
    private String name;
    private String email;
    private String password;

    // 생성자
    public Member(String name, String email, String password) {
        this.name = name; //오른쪽 name은 받는 네임, 왼쪽 name은 클래스의 멤버 변수
        this.email = email;
        this.password = password;
    }

    // 정보 출력 메서드
    public void showInfo() {
        System.out.println("이름 : " + name);
        System.out.println("이메일 : " + email);
        System.out.println("패스워드 : " + password);
    }

    // Getter
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }

    // Setter
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; }

    // 정보 한 번에 변경하는 메서드
    public void changeNameEmailPassword(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}