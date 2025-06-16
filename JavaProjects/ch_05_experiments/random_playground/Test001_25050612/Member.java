package ch_05_experiments.random_playground.Test001_25050612;

public class Member {
    // 1-1. 필드 선언 (회원 정보)
    private String name;
    private String email;
    private String password;
    private String registrationDate; // 가입일 (yyyy-MM-dd HH:mm 형식)

    // 1-2. 생성자 (새로운 Member 객체를 만들 때 사용)
    public Member(String name, String email, String password, String registrationDate) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.registrationDate = registrationDate;
    }

    // 1-3. Getter 메서드들 (각 필드 값을 외부에서 읽을 때 사용)
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    // 1-4. Setter 메서드들 (각 필드 값을 외부에서 변경할 때 사용)
    // 현재 구현에서는 주로 수정 기능에서 사용될 수 있습니다.
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    // 1-5. Member 객체를 CSV 형식의 문자열로 변환하는 메서드
    // 역할: 회원 정보를 "이름,이메일,비밀번호,가입일"과 같은 형태로 만들어 파일에 저장하기 쉽게 합니다.
    public String toCSV() {
        // CSV 파일에 쉼표(,)가 포함된 데이터를 저장할 경우 문제가 생길 수 있으므로,
        // 실제 운영 환경에서는 인용 부호 처리 등의 추가 로직이 필요하지만,
        // 여기서는 간단하게 구현합니다.
        return String.join(",", name, email, password, registrationDate);
    }

    // 1-6. CSV 형식의 문자열을 Member 객체로 변환하는 정적(static) 메서드
    // 역할: 파일에서 "이름,이메일,비밀번호,가입일" 형식의 한 줄을 읽어와
    // 새로운 Member 객체를 생성해 줍니다.
    public static Member fromCSV(String csvLine) {
        String[] parts = csvLine.split(","); // 쉼표(,)를 기준으로 문자열을 분리
        if (parts.length == 4) { // 분리된 부분이 4개인지 확인 (이름, 이메일, 비밀번호, 가입일)
            return new Member(parts[0], parts[1], parts[2], parts[3]);
        }
        return null; // 형식이 맞지 않으면 null 반환
    }
}