package my;

import java.util.Scanner;

/**
 * 자동차 관리 기능 클래스 - "자동차 관리 전문가"
 * 사고의 흐름: "자동차 관리에 필요한 모든 기능들을 여기에 모아두자"
 */
public class CarService {
    
    // ===================================================================
    // 1. 데이터 저장소 (Data Storage) - "자동차 주차장"
    // ===================================================================
    
    /** 1-1. 자동차 정보 저장 배열들 - "주차 공간들" */
    // 사고의 흐름: "자동차 정보를 여러 개 저장해야 하니까 배열을 사용하자"
    private Car[] cars = new Car[100];                    // 자동차 보관소
    private int carCount = 0;                             // 현재 등록된 자동차 수
    private Scanner scanner = new Scanner(System.in);     // 입력 도구
    
    // ===================================================================
    // 2. CRUD 기능들 (Create, Read, Update, Delete) - "자동차 관리 업무"
    // ===================================================================
    
    /**
     * 2-1. 자동차 추가 (Create) - "신차 등록 접수원"
     * 사고의 흐름: "새로운 자동차 정보를 입력받아서 시스템에 등록하자"
     */
    public void addCar() {
        System.out.println("\n새 자동차 등록");
        System.out.println("=".repeat(30));
        
        // 사고의 흐름: "배열이 가득 찼는지 먼저 확인하자"
        if (carCount >= cars.length) {
            System.out.println("더 이상 자동차를 등록할 수 없습니다. (주차장 만차)");
            return;
        }
        
        // 사고의 흐름: "사용자에게 친절하게 안내하면서 정보를 하나씩 입력받자"
        System.out.print("자동차명을 입력하세요: ");
        String carName = scanner.nextLine();
        
        System.out.print("제조사를 입력하세요: ");
        String manufacturer = scanner.nextLine();
        
        System.out.print("연식을 입력하세요: ");
        int year = getIntInput();
        
        System.out.print("등록일을 입력하세요 (예: 2024-01-15): ");
        String registDate = scanner.nextLine();
        
        // 사고의 흐름: "입력받은 정보로 Car 객체를 만들고 배열에 저장하자"
        Car newCar = new Car(carName, manufacturer, year, registDate);
        cars[carCount] = newCar;
        carCount++;
        
        System.out.println("자동차 등록이 완료되었습니다!");
        newCar.showInfo();
    }
    
    /**
     * 2-2. 전체 자동차 조회 (Read All) - "주차장 전체 점검"
     * 사고의 흐름: "등록된 모든 자동차의 정보를 한눈에 볼 수 있게 정리해서 보여주자"
     */
    public void viewAllCars() {
        System.out.println("\n전체 자동차 목록 (" + carCount + "대)");
        System.out.println("=".repeat(60));
        
        // 사고의 흐름: "자동차가 없으면 없다고 알려주자"
        if (carCount == 0) {
            System.out.println("등록된 자동차가 없습니다.");
            return;
        }
        
        // 사고의 흐름: "반복문을 사용해서 모든 자동차 정보를 하나씩 출력하자"
        for (int i = 0; i < carCount; i++) {
            System.out.printf("%d. ", (i + 1));
            cars[i].showInfo();   
        }
    }
    
    /**
     * 2-3. 자동차 수정 (Update) - "차량 정보 변경 담당자"
     * 사고의 흐름: "기존 자동차의 정보를 찾아서 새로운 정보로 업데이트하자"
     */
    public void updateCar() {
        System.out.println("\n자동차 정보 수정");
        System.out.println("=".repeat(30));
        
        if (carCount == 0) {
            System.out.println("수정할 자동차가 없습니다.");
            return;
        }
        
        // 사고의 흐름: "자동차명으로 수정할 차량을 찾자"
        System.out.print("수정할 자동차명을 입력하세요: ");
        String targetName = scanner.nextLine();
        
        int carIndex = findCarByName(targetName);
        if (carIndex == -1) {
            System.out.println("해당 자동차를 찾을 수 없습니다.");
            return;
        }
        
        // 사고의 흐름: "수정하기 전에 현재 정보를 보여주자"
        System.out.println("\n현재 자동차 정보:");
        cars[carIndex].showInfo();
        
        showUpdateMenu(carIndex);
    }
    
    /**
     * 2-4. 자동차 삭제 (Delete) - "차량 말소 담당자"
     * 사고의 흐름: "지정된 자동차를 시스템에서 완전히 제거하자"
     */
    public void deleteCar() {
        System.out.println("\n자동차 삭제");
        System.out.println("=".repeat(20));
        
        if (carCount == 0) {
            System.out.println("삭제할 자동차가 없습니다.");
            return;
        }
        
        // 사고의 흐름: "자동차명으로 삭제할 차량을 찾자"
        System.out.print("삭제할 자동차명을 입력하세요: ");
        String targetName = scanner.nextLine();
        
        int carIndex = findCarByName(targetName);
        if (carIndex == -1) {
            System.out.println("해당 자동차를 찾을 수 없습니다.");
            return;
        }
        
        // 사고의 흐름: "삭제하기 전에 어떤 자동차인지 보여주고 정말 삭제할 건지 확인받자"
        System.out.println("\n삭제할 자동차 정보:");
        cars[carIndex].showInfo();
        System.out.print("\n정말로 삭제하시겠습니까? (y/n): ");
        String confirm = scanner.nextLine();
        
        if (confirm.equalsIgnoreCase("y") || confirm.equalsIgnoreCase("yes")) {
            removeCarFromArray(carIndex);
            System.out.println("자동차가 삭제되었습니다.");
        } else {
            System.out.println("삭제를 취소했습니다.");
        }
    }
    
    // ===================================================================
    // 3. 검색 기능들 (Search Functions) - "자동차 수사관"
    // ===================================================================
    
    /**
     * 3-1. 자동차 검색 메뉴 - "수사 본부"
     * 사고의 흐름: "여러 가지 방법으로 검색할 수 있게 하자"
     */
    public void searchCar() {
        System.out.println("\n자동차 검색");
        System.out.println("=".repeat(20));
        System.out.println("1. 자동차명으로 검색");
        System.out.println("2. 제조사로 검색");
        System.out.println("3. 연식으로 검색");
        
        System.out.print("검색 방법을 선택하세요: ");
        int searchType = getIntInput();
        
        // 사고의 흐름: "선택한 검색 방법에 따라 해당 검색 함수를 호출하자"
        switch (searchType) {
            case 1: searchByName(); break;         // 이름 수사관
            case 2: searchByManufacturer(); break; // 제조사 수사관
            case 3: searchByYear(); break;         // 연식 수사관
            default: System.out.println("잘못된 선택입니다.");
        }
    }
    
    /**
     * 3-2. 자동차명으로 검색 - "차명 조회관"
     * 사고의 흐름: "입력받은 자동차명이 포함된 차량들을 모두 찾아서 보여주자"
     */
    private void searchByName() {
        System.out.print("검색할 자동차명을 입력하세요: ");
        String searchName = scanner.nextLine();
        
        boolean found = false;
        System.out.println("\n검색 결과:");
        
        for (int i = 0; i < carCount; i++) {
            if (cars[i].getCarName().contains(searchName)) {
                if (!found) found = true;
                System.out.printf("%d. ", (i + 1));
                cars[i].showInfo();
            }
        }
        
        if (!found) {
            System.out.println("해당 자동차명의 차량을 찾을 수 없습니다.");
        }
    }
    
    /**
     * 3-3. 제조사로 검색 - "브랜드 조회관"
     * 사고의 흐름: "특정 제조사의 모든 차량들을 찾아서 보여주자"
     */
    private void searchByManufacturer() {
        System.out.print("검색할 제조사를 입력하세요: ");
        String searchManufacturer = scanner.nextLine();
        
        boolean found = false;
        System.out.println("\n" + searchManufacturer + " 차량 목록:");
        
        for (int i = 0; i < carCount; i++) {
            if (cars[i].getManufacturer().contains(searchManufacturer)) {
                if (!found) found = true;
                System.out.printf("%d. ", (i + 1));
                cars[i].showInfo();
            }
        }
        
        if (!found) {
            System.out.println("해당 제조사의 차량을 찾을 수 없습니다.");
        }
    }
    
    /**
     * 3-4. 연식으로 검색 - "년도 조회관"
     * 사고의 흐름: "특정 연식의 차량들을 찾아서 보여주자"
     */
    private void searchByYear() {
        System.out.print("검색할 연식을 입력하세요: ");
        int searchYear = getIntInput();
        
        boolean found = false;
        System.out.println("\n" + searchYear + "년식 차량 목록:");
        
        for (int i = 0; i < carCount; i++) {
            if (cars[i].getYear() == searchYear) {
                if (!found) found = true;
                System.out.printf("%d. ", (i + 1));
                cars[i].showInfo();
            }
        }
        
        if (!found) {
            System.out.println("해당 연식의 차량을 찾을 수 없습니다.");
        }
    }
    
    // ===================================================================
    // 4. 더미 데이터 기능 (Sample Data) - "테스트용 차량 등록기"
    // ===================================================================
    
    /**
     * 4-1. 더미 데이터 추가 - "샘플 차량 일괄 등록"
     * 사고의 흐름: "테스트할 수 있게 미리 여러 대의 자동차 정보를 넣어두자"
     */
    public void addDummyData() {
        System.out.println("\n더미 데이터 추가");
        System.out.println("=".repeat(25));
        
        // 사고의 흐름: "다양한 제조사와 연식의 자동차들을 만들어서 모든 기능을 테스트할 수 있게 하자"
        Car[] dummyCars = {
            new Car("소나타", "현대", 2023, "2024-01-15"),
            new Car("아반떼", "현대", 2022, "2024-01-20"),
            new Car("K5", "기아", 2023, "2024-02-10"),
            new Car("스포티지", "기아", 2021, "2024-02-15"),
            new Car("SM6", "삼성", 2022, "2024-03-05"),
            new Car("QM6", "삼성", 2020, "2024-03-10"),
            new Car("코란도", "쌍용", 2021, "2024-04-01"),
            new Car("티볼리", "쌍용", 2023, "2024-04-05"),
            new Car("레이", "기아", 2022, "2024-05-12"),
            new Car("캐스퍼", "현대", 2023, "2024-05-20")
        };
        
        int addedCount = 0;
        // 사고의 흐름: "배열 공간이 있는 만큼만 추가하자"
        for (Car dummyCar : dummyCars) {
            if (carCount < cars.length) {
                cars[carCount] = dummyCar;
                carCount++;
                addedCount++;
            } else {
                break; // 배열이 가득 참
            }
        }
        
        System.out.println("더미 데이터 " + addedCount + "대가 추가되었습니다.");
        System.out.println("현재 총 " + carCount + "대의 자동차가 등록되어 있습니다.");
    }
    
 
    // ===================================================================
    // 6. 내부 도우미 메서드들 (Helper Methods) - "도구 창고"
    // ===================================================================
    
    /**
     * 6-1. 수정 메뉴 표시 - "수정 옵션 안내소"
     * 사고의 흐름: "어떤 정보를 수정할지 선택할 수 있게 메뉴를 보여주자"
     */
    private void showUpdateMenu(int carIndex) {
        System.out.println("\n수정할 항목을 선택하세요:");
        System.out.println("1. 자동차명 수정");
        System.out.println("2. 제조사 수정");
        System.out.println("3. 연식 수정");
        System.out.println("4. 등록일 수정");
        System.out.println("0. 수정 취소");
        
        System.out.print("선택: ");
        int choice = getIntInput();
        
        executeUpdate(carIndex, choice);
    }
    
    /**
     * 6-2. 수정 작업 실행 - "실제 수정 작업자"
     * 사고의 흐름: "선택한 항목에 따라서 해당 정보를 새로 입력받아서 업데이트하자"
     */
    private void executeUpdate(int carIndex, int choice) {
        Car car = cars[carIndex];
        
        switch (choice) {
            case 1: // 자동차명 수정 담당자
                System.out.print("새로운 자동차명을 입력하세요: ");
                car.setCarName(scanner.nextLine());
                System.out.println("자동차명이 수정되었습니다.");
                break;
                
            case 2: // 제조사 수정 담당자
                System.out.print("새로운 제조사를 입력하세요: ");
                car.setManufacturer(scanner.nextLine());
                System.out.println("제조사가 수정되었습니다.");
                break;
                
            case 3: // 연식 수정 담당자
                System.out.print("새로운 연식을 입력하세요: ");
                car.setYear(getIntInput());
                System.out.println("연식이 수정되었습니다.");
                break;
                
            case 4: // 등록일 수정 담당자
                System.out.print("새로운 등록일을 입력하세요 (예: 2024-01-15): ");
                car.setRegistDate(scanner.nextLine());
                System.out.println("등록일이 수정되었습니다.");
                break;
                
            case 0: // 취소 담당자
                System.out.println("수정을 취소했습니다.");
                break;
                
            default:
                System.out.println("잘못된 선택입니다.");
        }
        
        if (choice >= 1 && choice <= 4) {
            System.out.println("\n수정된 자동차 정보:");
            car.showInfo();
        }
    }
    
    /**
     * 6-3. 자동차명으로 찾기 - "차량 검색 도우미"
     * 사고의 흐름: "자동차명으로 차량을 찾는 코드가 여러 곳에서 반복되니까 함수로 만들어서 재사용하자"
     */
    private int findCarByName(String name) {
        for (int i = 0; i < carCount; i++) {
            if (cars[i].getCarName().equals(name)) {
                return i; // 찾은 자동차의 인덱스 반환
            }
        }
        return -1; // 찾지 못했을 때 -1 반환
    }
    
    /**
     * 6-4. 배열에서 자동차 제거 - "주차장 정리 담당자"
     * 사고의 흐름: "삭제된 자동차의 자리를 뒤의 자동차들로 채워서 빈 공간을 없애자"
     */
    private void removeCarFromArray(int index) {
        // 사고의 흐름: "삭제할 위치부터 마지막까지 한 칸씩 앞으로 이동시키자"
        for (int i = index; i < carCount - 1; i++) {
            cars[i] = cars[i + 1];
        }
        cars[carCount - 1] = null; // 마지막 자리 비우기
        carCount--; // 전체 자동차 수 감소
    }
    
    /**
     * 6-5. 정수 입력 받기 - "숫자 입력 검증관"
     * 사고의 흐름: "사용자가 잘못된 형식을 입력할 수 있으니까 안전하게 정수를 입력받는 함수를 만들자"
     */
    private int getIntInput() {
        while (true) {
            try {
                String input = scanner.nextLine();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.print("올바른 숫자를 입력해주세요: ");
            }
        }
    }
    
    /**
     * 6-6. 현재 자동차 수 반환 - "주차장 현황 확인"
     * 사고의 흐름: "외부에서 현재 등록된 자동차 수를 확인할 수 있게 하자"
     */
    public int getCarCount() {
        return carCount;
    }
}