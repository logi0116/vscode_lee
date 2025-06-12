package my;

/**
 * 자동차 정보 모델 클래스 - "자동차 설계도"
 * 사고의 흐름: "자동차 한 대의 모든 정보를 하나로 묶어서 관리하면 편할 것 같아"
 */
public class Car {
    // 사고의 흐름: "자동차에게 필요한 정보들을 변수로 정의해두자"
    private String carName;        // 자동차명 - "차량 이름표"
    private String manufacturer;   // 제조사 - "만든 회사"
    private int year;             // 연식 - "출시 년도"
    private String registDate;    // 등록일 - "시스템 등록 날짜"
    

    
    /**
     * 기본 생성자 - "빈 자동차 틀"
     * 사고의 흐름: "아무 정보 없이 자동차 객체를 만들 수도 있어야겠어"
     */
    public Car() {
    }
    
    /**
     * 매개변수 생성자 - "자동차 정보 한번에 설정"
     * 사고의 흐름: "새로운 자동차 정보를 만들 때 모든 정보를 한번에 설정할 수 있게 하자"
     */
    public Car(String carName, String manufacturer, int year, String registDate) {
        this.carName = carName;
        this.manufacturer = manufacturer;
        this.year = year;
        this.registDate = registDate;
    }
    
    /**
     * 자동차 정보 출력 메서드 - "자동차 신분증 보여주기"
     * 사고의 흐름: "자동차 정보를 예쁘게 출력하는 기능이 있으면 편할 것 같아"
     */
    public void showInfo() {
        System.out.printf("[%s] %s %d년식 (등록일: %s)%n", 
            manufacturer, carName, year, registDate);
    }
    
    // Getter 메서드들 - "정보 열람 창구"
    // 사고의 흐름: "외부에서 자동차 정보를 확인할 수 있게 getter 메서드들을 만들자"
    public String getCarName() { return carName; }
    public String getManufacturer() { return manufacturer; }
    public int getYear() { return year; }
    public String getRegistDate() { return registDate; }
    
    // Setter 메서드들 - "정보 수정 창구"
    // 사고의 흐름: "외부에서 자동차 정보를 수정할 수 있게 setter 메서드들을 만들자"
    public void setCarName(String carName) { this.carName = carName; }
    public void setManufacturer(String manufacturer) { this.manufacturer = manufacturer; }
    public void setYear(int year) { this.year = year; }
    public void setRegistDate(String registDate) { this.registDate = registDate; }
}
