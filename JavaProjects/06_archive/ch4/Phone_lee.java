package ch4;

public class Phone_lee {
    // 📌 사고 흐름: 우리는 '핸드폰'을 객체로 표현하고 싶다.
    // 📌 이유: 각 핸드폰은 서로 다른 모델, 가격, 제조사를 가지므로 클래스로 정의하는 것이 효율적이다.
    
    // 🔹 멤버 변수 (핸드폰의 기본 정보)
    // 📌 사고 흐름: 핸드폰마다 저장할 정보가 필요하다.
    // 📌 이유: 객체를 만들 때 모델명, 가격, 제조사를 저장해야 하기 때문.
    String model;  
    String price;  
    String company;  

    // 🔹 기본 생성자
    // 📌 사고 흐름: 빈 객체도 만들 수 있어야 한다.
    // 📌 이유: 기본 생성자를 통해 빈 핸드폰 객체를 만들고 나중에 속성을 추가할 수 있다.
    public Phone_lee() {
    }

    // 🔹 매개변수가 있는 생성자
    // 📌 사고 흐름: 핸드폰을 만들 때 모델, 가격, 제조사를 한 번에 지정하고 싶다.
    // 📌 이유: 반복적인 설정을 줄이고 객체를 깔끔하게 초기화하기 위해 생성자를 사용한다.
    public Phone_lee(String model, String price, String company) {
        this.model = model;
        this.price = price;
        this.company = company;
    }

    // 🔹 정보 출력 메소드
    // 📌 사고 흐름: 핸드폰 정보를 출력할 기능이 필요하다.
    // 📌 이유: 객체 내부 정보를 한눈에 확인할 수 있도록 showInfo() 메서드를 만든다.
    public void showInfo() {
        System.out.println("모델: " + model + ", 가격: " + price + ", 제조사: " + company);
    }

    public static void main(String[] args) {
        // 📌 사고 흐름: 여러 개의 핸드폰을 관리해야 한다.
        // 📌 이유: 개별 객체를 따로 저장하면 관리하기 힘들기 때문에 배열을 사용한다.

        // 🔹 Phone_lee 클래스를 담을 배열 만들기
        Phone_lee[] phones = new Phone_lee[5];  // Phone_lee 객체를 담을 배열 생성

        // 📌 사고 흐름: 핸드폰 객체를 만들고 배열에 저장해야 한다.
        // 📌 이유: 여러 개의 핸드폰을 빠르게 관리하려면 배열을 활용하는 것이 편리하다.

        // 🔹 핸드폰 객체 생성 및 배열에 담기
        phones[0] = new Phone_lee("Galaxy S23", "100만원", "삼성전자");
        phones[1] = new Phone_lee("iPhone 14", "120만원", "Apple");
        phones[2] = new Phone_lee("Pixel 7", "90만원", "Google");
        phones[3] = new Phone_lee("OnePlus 11", "80만원", "OnePlus");
        phones[4] = new Phone_lee("Xiaomi 13", "70만원", "Xiaomi");

        // 📌 사고 흐름: 배열에 담긴 핸드폰 정보를 출력해야 한다.
        // 📌 이유: 모든 객체의 정보를 확인하고 싶기 때문.

        // 🔹 출력하기 - 배열의 각 요소를 반복문으로 출력
        System.out.println("=== Phone 정보 출력 ===");
        for (int i = 0; i < phones.length; i++) {
            System.out.print("phones[" + i + "] - ");
            phones[i].showInfo();  // 각 객체의 정보를 출력
        }

        System.out.println();

        // 📌 사고 흐름: 각 핸드폰 객체의 메모리 주소를 확인해야 한다.
        // 📌 이유: 객체들이 서로 다른 메모리 공간에 저장되는지 확인하기 위해.

        // 🔹 각 멤버의 주소값 확인하기
        System.out.println("=== 각 Phone 객체의 메모리 주소값 확인 ===");
        for (int i = 0; i < phones.length; i++) {
            System.out.println("phones[" + i + "] 주소: " + System.identityHashCode(phones[i]));
        }

        System.out.println();

        // 📌 사고 흐름: 같은 속성을 가진 새로운 객체를 만들어 비교해야 한다.
        // 📌 이유: 같은 데이터를 가진 객체라도 메모리 위치가 다르면 별개의 객체임을 확인할 수 있다.

        // 🔹 같은 내용이지만 다른 객체인지 확인
        Phone_lee phone6 = new Phone_lee("Galaxy S23", "100만원", "삼성전자");
        System.out.println("=== 같은 내용의 새로운 객체 주소 비교 ===");
        System.out.println("phones[0] 주소: " + System.identityHashCode(phones[0]));
        System.out.println("phone6 주소: " + System.identityHashCode(phone6));
        System.out.println("같은 객체인가? " + (phones[0] == phone6)); // false가 나와야 함
    }
}
