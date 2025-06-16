package ch4;

public class Phone {
    // 📌 멤버 변수 (클래스에서 속성을 저장하는 공간)
    String model;   // 모델명 (예: 아이폰, 갤럭시)
    int price;      // 가격 (예: 1000000)
    String company; // 제조사 (예: 삼성, 애플)

    // 📌 기본 생성자 (아무 값 없이 객체를 생성할 때 사용)
    public Phone() {
        // 아무 값 없이 객체를 생성할 경우, 기본값 설정
        this.model = "미정";
        this.price = 0;
        this.company = "미정";
    }

    // 📌 생성자 오버로딩 1 - 모델명만 받는 생성자
    public Phone(String model) {
        this.model = model;
        this.price = 0;
        this.company = "미정";
    }

    // 📌 생성자 오버로딩 2 - 모델명과 가격을 받는 생성자
    public Phone(String model, int price) {
        this.model = model;
        this.price = price;
        this.company = "미정";
    }

    // 📌 생성자 오버로딩 3 - 모든 매개변수를 받는 생성자
    public Phone(String model, int price, String company) {
        // this 키워드를 사용해서 현재 객체의 변수에 전달받은 값을 저장
        this.model = model;   // 객체 생성 시 입력받은 모델명 설정
        this.price = price;   // 객체 생성 시 입력받은 가격 설정
        this.company = company; // 객체 생성 시 입력받은 제조사 설정
    }

    // 📌 정보를 출력하는 메서드
    public void showInfo() {
        // this는 현재 객체를 가리킴. 즉, 객체의 변수 값을 출력하는 역할
        System.out.println("모델명 : " + this.model);
        System.out.println("가격 : " + this.price + "원");
        System.out.println("제조사 : " + this.company);
    }

    // 📌 메인 메서드 - 프로그램 실행 시작점
    public static void main(String[] args) {
        // 오버로딩 활용해서 매개변수 생성자 호출하고 1개부터 3개까지 각각의 객체 작성

        // 1번째 객체 생성 - 기본 생성자
        Phone phone1 = new Phone();
        phone1.showInfo();
        System.out.println("-----------------");

        // 2번째 객체 생성 - 매개변수 1개 생성자
        Phone phone2 = new Phone("아이폰");
        phone2.showInfo();
        System.out.println("-----------------");

        // 3번째 객체 생성 - 매개변수 2개 생성자
        Phone phone3 = new Phone("갤럭시", 1200000);
        phone3.showInfo();
        System.out.println("-----------------");

        // 4번째 객체 생성 - 매개변수 3개 생성자
        Phone phone4 = new Phone("픽셀", 800000, "구글");
        phone4.showInfo();
        System.out.println("-----------------");
    }
}
