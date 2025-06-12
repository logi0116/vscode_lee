package my;

import java.util.Scanner;

/**
 * 자동차 관리 시스템 실행 클래스 - "시스템 총 지휘관"
 * 사고의 흐름: "전체 프로그램 흐름을 제어하는 중앙 관리자가 필요해"
 */
public class CarMain {
    
    // 사고의 흐름: "이 객체들을 계속 사용해야 하니까 멤버 변수로 저장해두자"
    private CarService carService;      // 자동차 관리 서비스
    private Scanner scanner;            // 입력 도구
    
    /**
     * 생성자 - "시스템 초기화 담당자"
     * 사고의 흐름: "프로그램이 시작될 때 필요한 객체들을 미리 만들어두자"
     */
    public CarMain() {
        this.carService = new CarService();
        this.scanner = new Scanner(System.in);
    }
    
    /**
     * 프로그램 시작점 - "시스템 전원 버튼"
     * 사고의 흐름: "프로그램이 시작되면 CarMain 객체를 만들고 실행하자"
     */
    public static void main(String[] args) {
        CarMain carMain = new CarMain();
        carMain.run();
    }
    
    /**
     * 메인 실행 메서드 - "시스템 가동"
     * 사고의 흐름: "인사말을 하고 메뉴를 보여주자"
     */
    public void run() {
        System.out.println("자동차 관리 시스템을 시작합니다!");
        System.out.println("테스트를 위해 더미 데이터를 추가하시겠습니까? (y/n)");
        System.out.print("선택: ");
        
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("yes")) {
            carService.addDummyData();
        }
        
        showMainMenu();
    }


     /**
     * 메인 메뉴 표시 및 실행 - "중앙 제어실"
     * 사고의 흐름: "사용자가 원하는 기능을 선택할 수 있게 메뉴를 계속 보여주자"
     */
    private void showMainMenu() {
        while (true) {
            System.out.println("\n" + "=".repeat(50));
            System.out.println(" 자동차 관리 시스템 ");
            System.out.println("=".repeat(50));
            System.out.println("현재 등록된 자동차: " + carService.getCarCount() + "대");
            System.out.println();
            System.out.println("1. 자동차 추가 (등록)");
            System.out.println("2. 전체 자동차 조회");
            System.out.println("3. 자동차 수정");
            System.out.println("4. 자동차 삭제");
            System.out.println("5. 자동차 검색");
    
            System.out.println("6. 더미 데이터 추가");
            System.out.println("0. 프로그램 종료");
            System.out.println("=".repeat(50));
            System.out.print("원하는 기능을 선택하세요: ");
            
            int choice = getIntInput();
            executeMenu(choice);
        }
    }
    
    /**
     * 메뉴 실행 - "업무 배정 담당자"
     * 사고의 흐름: "사용자가 선택한 번호에 따라 해당 기능을 실행하자"
     */
    private void executeMenu(int choice) {
        switch (choice) {
            case 1:
                // 사고의 흐름: "새 자동차 등록 업무를 CarService에게 맡기자"
                carService.addCar();
                break;
                
            case 2:
                // 사고의 흐름: "전체 자동차 조회 업무를 CarService에게 맡기자"
                carService.viewAllCars();
                break;
                
            case 3:
                // 사고의 흐름: "자동차 수정 업무를 CarService에게 맡기자"
                carService.updateCar();
                break;
                
            case 4:
                // 사고의 흐름: "자동차 삭제 업무를 CarService에게 맡기자"
                carService.deleteCar();
                break;
                
            case 5:
                // 사고의 흐름: "자동차 검색 업무를 CarService에게 맡기자"
                carService.searchCar();
                break;
                
            case 6:
                // 사고의 흐름: "더미 데이터 추가 업무를 CarService에게 맡기자"
                carService.addDummyData();
                break;
                
            case 0:
                // 사고의 흐름: "프로그램을 깔끔하게 종료하자"
                exitProgram();
                break;
                
            default:
                System.out.println("잘못된 선택입니다. 0~7 사이의 숫자를 입력해주세요.");
        }
        
        // 사고의 흐름: "작업이 끝나면 잠깐 멈춰서 결과를 확인할 수 있게 하자"
        if (choice != 0) {
            System.out.println("\n계속하려면 Enter를 눌러주세요...");
            scanner.nextLine();
        }
    }
    
    /**
     * 정수 입력 받기 - "숫자 입력 검증관"
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
     * 프로그램 종료 - "시스템 종료 담당자"
     * 사고의 흐름: "프로그램을 종료할 때 인사말을 하고 깔끔하게 종료하자"
     */
    private void exitProgram() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("자동차 관리 시스템을 종료합니다");
        System.out.println("이용해 주셔서 감사합니다!");
        System.out.println("=".repeat(50));
        scanner.close();
        System.exit(0);
    }
}