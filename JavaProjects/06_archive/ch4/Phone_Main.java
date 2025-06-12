package ch4;

public class Phone_Main {
    public static void main(String[] args) {
        //  기본 생성자로 객체 생성 (아무 값 없이 생성됨)
        Phone phone1 = new Phone();
        
        // 매개변수 생성자로 객체 생성 (값을 직접 설정)
        Phone phone2 = new Phone("아이폰 15", 1500000, "Apple");
        Phone phone3 = new Phone("갤럭시 S23", 1200000, "Samsung");
        Phone phone4 = new Phone("픽셀 7", 900000, "Google");

        //  모든 객체의 정보 출력
        System.out.println("첫 번째 폰 정보: \n");
        phone1.showInfo(); // 기본 생성자로 생성했으므로 초기값 출력

        System.out.println("두 번째 폰 정보: \n");
        phone2.showInfo();

        System.out.println("세 번째 폰 정보: \n");
        phone3.showInfo();

        System.out.println("네 번째 폰 정보: \n");
        phone4.showInfo();
    }
}
