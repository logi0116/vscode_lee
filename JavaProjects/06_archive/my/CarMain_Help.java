package my;

/**
 * 자동차 정보 모델 클래스 - "자동차 설계도"
 * 사고의 흐름: "자동차 한 대의 모든 정보를 하나로 묶어서 관리하면 편할 것 같아"
 * 세부 사고: "현실의 자동차를 프로그램 안에서 표현하려면 어떤 정보들이 필요할까?"
 * 세부 사고: "자동차명, 제조사, 연식, 등록일 정도면 기본적인 관리가 가능할 것 같아"
 * 세부 사고: "이 정보들을 하나의 클래스로 묶어서 자동차 객체를 만들 수 있게 하자"
 */
public class CarMain_Help {
    // 사고의 흐름: "자동차에게 필요한 정보들을 변수로 정의해두자"
    // 세부 사고: "외부에서 함부로 접근하면 안 되니까 private으로 보호하자"
    // 세부 사고: "자동차명은 문자열이니까 String 타입으로 선언하자"
    private String carName;        // 자동차명 - "차량 이름표"
    
    // 세부 사고: "제조사도 문자열 정보니까 String 타입으로 선언하자"
    private String manufacturer;   // 제조사 - "만든 회사"
    
    // 세부 사고: "연식은 숫자니까 int 타입으로 선언하자"
    // 세부 사고: "2023, 2024 같은 년도 정보를 저장할 거야"
    private int year;             // 연식 - "출시 년도"
    
    // 세부 사고: "등록일은 날짜 형태의 문자열로 저장하자"
    // 세부 사고: "2024-01-15 같은 형식으로 저장할 예정이야"
    private String registDate;    // 등록일 - "시스템 등록 날짜"
    
    /**
     * 기본 생성자 - "빈 자동차 틀"
     * 사고의 흐름: "아무 정보 없이 자동차 객체를 만들 수도 있어야겠어"
     * 세부 사고: "나중에 setter 메서드로 정보를 하나씩 설정할 수도 있으니까"
     * 세부 사고: "기본 생성자는 아무것도 하지 않아도 돼, 그냥 빈 객체만 만들면 돼"
     */
    public Car() {
        // 세부 사고: "Java에서 기본 생성자는 내용이 없어도 괜찮아"
        // 세부 사고: "객체만 생성되고 모든 변수는 기본값으로 초기화될 거야"
    }
    
    /**
     * 매개변수 생성자 - "자동차 정보 한번에 설정"
     * 사고의 흐름: "새로운 자동차 정보를 만들 때 모든 정보를 한번에 설정할 수 있게 하자"
     * 세부 사고: "매개변수로 받은 값들을 this.변수명으로 저장하자"
     * 세부 사고: "this를 사용하는 이유는 매개변수명과 멤버변수명이 같아서 구분하기 위해서야"
     */
    public Car(String carName, String manufacturer, int year, String registDate) {
        // 세부 사고: "this.carName은 멤버변수, carName은 매개변수를 의미해"
        this.carName = carName;
        // 세부 사고: "매개변수로 받은 제조사 정보를 멤버변수에 저장하자"
        this.manufacturer = manufacturer;
        // 세부 사고: "매개변수로 받은 연식 정보를 멤버변수에 저장하자"
        this.year = year;
        // 세부 사고: "매개변수로 받은 등록일 정보를 멤버변수에 저장하자"
        this.registDate = registDate;
    }
    
    /**
     * 자동차 정보 출력 메서드 - "자동차 신분증 보여주기"
     * 사고의 흐름: "자동차 정보를 예쁘게 출력하는 기능이 있으면 편할 것 같아"
     * 세부 사고: "System.out.printf를 사용해서 형식을 맞춰서 출력하자"
     * 세부 사고: "[제조사] 자동차명 연식년식 (등록일: 날짜) 형태로 보여주자"
     * 세부 사고: "%s는 문자열, %d는 정수, %n은 줄바꿈을 의미해"
     */
    public void showInfo() {
        // 세부 사고: "printf의 첫 번째 %s에는 manufacturer가 들어가고"
        // 세부 사고: "두 번째 %s에는 carName이 들어가고"
        // 세부 사고: "%d에는 year가 들어가고"
        // 세부 사고: "세 번째 %s에는 registDate가 들어갈 거야"
        System.out.printf("[%s] %s %d년식 (등록일: %s)%n", 
            manufacturer, carName, year, registDate);
    }
    
    // Getter 메서드들 - "정보 열람 창구"
    // 사고의 흐름: "외부에서 자동차 정보를 확인할 수 있게 getter 메서드들을 만들자"
    // 세부 사고: "private 변수들은 외부에서 직접 접근할 수 없으니까"
    // 세부 사고: "public 메서드를 통해서 안전하게 값을 반환해주자"
    
    // 세부 사고: "carName 변수의 값을 반환하는 메서드야"
    // 세부 사고: "return 키워드로 carName의 현재 값을 돌려줘"
    public String getCarName() { return carName; }
    
    // 세부 사고: "manufacturer 변수의 값을 반환하는 메서드야"
    public String getManufacturer() { return manufacturer; }
    
    // 세부 사고: "year 변수의 값을 반환하는 메서드야"
    // 세부 사고: "int 타입이니까 반환 타입도 int로 설정했어"
    public int getYear() { return year; }
    
    // 세부 사고: "registDate 변수의 값을 반환하는 메서드야"
    public String getRegistDate() { return registDate; }
    
    // Setter 메서드들 - "정보 수정 창구"
    // 사고의 흐름: "외부에서 자동차 정보를 수정할 수 있게 setter 메서드들을 만들자"
    // 세부 사고: "매개변수로 받은 새로운 값을 멤버변수에 저장하자"
    // 세부 사고: "void 타입이니까 값을 반환하지 않고 저장만 해"
    
    // 세부 사고: "새로운 자동차명을 매개변수로 받아서 멤버변수에 저장하자"
    public void setCarName(String carName) { this.carName = carName; }
    
    // 세부 사고: "새로운 제조사명을 매개변수로 받아서 멤버변수에 저장하자"
    public void setManufacturer(String manufacturer) { this.manufacturer = manufacturer; }
    
    // 세부 사고: "새로운 연식을 매개변수로 받아서 멤버변수에 저장하자"
    public void setYear(int year) { this.year = year; }
    
    // 세부 사고: "새로운 등록일을 매개변수로 받아서 멤버변수에 저장하자"
    public void setRegistDate(String registDate) { this.registDate = registDate; }
}
