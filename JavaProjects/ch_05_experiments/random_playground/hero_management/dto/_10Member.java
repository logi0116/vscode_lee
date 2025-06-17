package ch_05_experiments.random_playground.Hero_management.dto;

public class _10Member {
    private int id;
    private String name;
    private String email;
    private String password;
    private String regDate;
    private int huntCount; // 이달의 실적(몬스터 처치 횟수)
    private String grade; // 등급

    public _10Member(int id, String name, String email, String password, String regDate, int huntCount, String grade) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.regDate = regDate;
        this.huntCount = huntCount;
        this.grade = grade;
    }

    // getter/setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public int getHuntCount() {
        return huntCount;
    }

    public void setHuntCount(int huntCount) {
        this.huntCount = huntCount;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + email + "," + password + "," + regDate + "," + huntCount + "," + grade;
    }
}

// --- 클래스 다이어그램 ---
// +-----------------+
// | _10Member |
// +-----------------+
// | id, name, ... |
// +-----------------+
// | get/set, toString|
// +-----------------+
//
// --- 시퀀스 ---
// DTO <-> DAO <-> Service <-> UI
//
// --- 액티비티 ---
// 데이터 저장/전달/수정/조회