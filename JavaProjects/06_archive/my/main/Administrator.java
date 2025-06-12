package my.main;

import java.util.Scanner;

/**
 * 회원 관리 시스템 (Member Management System)
 * 
 * 사고의 흐름: "회원 정보를 체계적으로 관리하고 다양한 기능을 제공하는 시스템을 만들어보자"
 * 학습 목표: 기본 Java 문법, 배열, 메서드, 클래스 활용법 익히기
 */
public class Administrator {
    
    // ===================================================================
    // 1. 데이터 저장소 (Data Storage) - "창고지기"
    // ===================================================================

    /** 1-1. 회원 정보 저장 배열들 - "서류함들" */
    // 사고의 흐름: "회원 정보를 여러 개 저장해야 하니까 배열을 사용하자. 각 정보별로 따로 관리하면 편할 것 같아"
    private static String[] memberNames = new String[100];      // 이름 보관함
    private static int[] memberAges = new int[100];             // 나이 보관함  
    private static boolean[] memberMarried = new boolean[100];   // 결혼상태 보관함
    private static String[] memberVipLevel = new String[100];   // VIP등급 보관함
    private static int[] memberSalary = new int[100];           // 연봉 보관함
    private static String[] memberJoinDate = new String[100];   // 가입날짜 보관함
    
    /** 1-2. 시스템 관리 변수 - "관리자 도구" */
    // 사고의 흐름: "현재 몇 명이 등록되어 있는지 계속 추적해야겠어. 그리고 입력받을 도구도 하나 만들어두자"
    private static int memberCount = 0;                         // 현재 회원 수 카운터
    private static Scanner scanner = new Scanner(System.in);    // 입력 도구
    
    // ===================================================================
    // 2. 회원 정보 모델 클래스 (Member Model) - "회원 정보 설계도"
    // ===================================================================
    
    /**
     * 2-1. 회원 정보를 담는 그릇 - "회원카드 템플릿"
     * 사고의 흐름: "회원 한 명의 모든 정보를 하나로 묶어서 관리하면 편할 것 같아. 클래스로 만들어보자"
     */
    static class Member {
        // 2-2. 회원 속성들 - "신상정보 항목들"
        // 사고의 흐름: "회원에게 필요한 정보들을 변수로 정의해두자"
        String name;        // 이름 - "신분증 이름"
        int age;           // 나이 - "생년월일 계산기"
        boolean isMarried; // 결혼여부 - "혼인신고서 확인"
        String vipLevel;   // VIP등급 - "등급표 스티커"
        int salary;        // 연봉 - "소득증명서"
        String joinDate;   // 가입날짜 - "계약서 날짜"
        
        /**
         * 2-3. 회원 정보 생성자 - "회원카드 제작기"
         * 사고의 흐름: "새로운 회원 정보를 만들 때 모든 정보를 한번에 설정할 수 있게 생성자를 만들자"
         */
        public Member(String name, int age, boolean isMarried, int salary, String joinDate) {
            // 사고의 흐름: "받은 정보들을 내 변수에 저장하고, VIP등급은 연봉을 보고 자동으로 계산해주자"
            this.name = name;
            this.age = age;
            this.isMarried = isMarried;
            this.salary = salary;
            this.joinDate = joinDate;
            this.vipLevel = calculateVipLevel(salary); // VIP등급 자동 계산기
        }
        
        /**
         * 2-4. VIP 등급 계산기 - "등급 심사관"
         * 사고의 흐름: "연봉에 따라 VIP 등급을 자동으로 결정해주는 기능이 있으면 편할 것 같아"
         */
        private String calculateVipLevel(int salary) {
            // 사고의 흐름: "8천만원 이상이면 골드, 5천만원 이상이면 실버, 나머지는 브론즈로 하자"
            if (salary >= 8000) return "GOLD";      // 8천만원 이상 - 골드등급
            else if (salary >= 5000) return "SILVER"; // 5천만원 이상 - 실버등급  
            else return "BRONZE";                    // 그 외 - 브론즈등급
        }
    }
    
    // ===================================================================
    // 3. 메인 시스템 제어부 (Main Controller) - "총 지휘관"
    // ===================================================================
    
    /**
     * 3-1. 프로그램 시작점 - "시스템 전원 버튼"
     * 사고의 흐름: "프로그램이 시작되면 먼저 인사말을 하고, 기본 데이터를 준비한 다음 메뉴를 보여주자"
     */
    public static void main(String[] args) {
        System.out.println("회원 관리 시스템을 시작합니다!");
        
        // 3-2. 샘플 데이터 준비 - "기본 회원 등록기"
        // 사고의 흐름: "테스트할 수 있게 미리 몇 명의 회원 정보를 넣어두자"
        initializeSampleData();
        
        // 3-3. 메인 메뉴 실행 - "조종석 가동"
        // 사고의 흐름: "이제 사용자가 원하는 기능을 선택할 수 있게 메뉴를 보여주자"
        showMainMenu();
    }
    
    // ===================================================================
    // 4. 메뉴 시스템 (Menu System) - "안내데스크"
    // ===================================================================
    
    /**
     * 4-1. 메인 메뉴 표시 및 제어 - "종합 안내소"
     * 사고의 흐름: "사용자가 원하는 기능을 선택할 수 있도록 메뉴를 계속 보여주고, 선택에 따라 해당 기능을 실행하자"
     */
    private static void showMainMenu() {
        // 사고의 흐름: "사용자가 종료를 선택할 때까지 계속 메뉴를 보여줘야겠어"
        while (true) {
            System.out.println("\n" + "=".repeat(50));
            System.out.println("회원 관리 시스템 - 메인 메뉴");
            System.out.println("=".repeat(50));
            System.out.println("1. 전체 회원 조회 (회원 명단 열람)");
            System.out.println("2. 새 회원 추가 (신규 가입 접수)");
            System.out.println("3. 회원 검색 (회원 찾기)");
            System.out.println("4. 회원 정보 수정 (정보 변경)");
            System.out.println("5. 회원 삭제 (탈퇴 처리)");
            System.out.println("6. 회원 통계 (현황 분석)");
            System.out.println("0. 프로그램 종료");
            System.out.println("=".repeat(50));
            
            // 4-2. 사용자 선택 입력받기 - "접수창구"
            // 사고의 흐름: "사용자가 번호를 입력하면 그에 맞는 기능을 실행해주자"
            System.out.print("원하는 기능 번호를 입력하세요: ");
            int choice = getIntInput();
            
            // 4-3. 선택에 따른 기능 실행 - "업무 배정소"
            executeMenuChoice(choice);
        }
    }
    
    /**
     * 4-4. 메뉴 선택 실행기 - "업무 처리 담당자"
     * 사고의 흐름: "입력받은 번호에 따라서 해당하는 기능을 호출해주자"
     */
    private static void executeMenuChoice(int choice) {
        switch (choice) {
            case 1: viewAllMembers(); break;        // 조회 담당자
            case 2: addNewMember(); break;          // 등록 담당자
            case 3: searchMember(); break;          // 검색 담당자
            case 4: updateMember(); break;          // 수정 담당자
            case 5: deleteMember(); break;          // 삭제 담당자
            case 6: showStatistics(); break;       // 통계 담당자
            case 0: exitProgram(); break;           // 종료 담당자
            default: 
                System.out.println("잘못된 번호입니다. 다시 선택해주세요.");
        }
    }
    
    // ===================================================================
    // 5. 회원 조회 기능 (View Functions) - "열람실 사서"
    // ===================================================================
    
    /**
     * 5-1. 전체 회원 목록 표시 - "회원 명부 열람"
     * 사고의 흐름: "등록된 모든 회원의 정보를 한눈에 볼 수 있게 정리해서 보여주자. 표 형태로 만들면 보기 좋을 것 같아"
     */
    private static void viewAllMembers() {
        System.out.println("\n전체 회원 목록 (" + memberCount + "명)");
        System.out.println("=".repeat(80));
        
        // 사고의 흐름: "회원이 없으면 없다고 알려주자"
        if (memberCount == 0) {
            System.out.println("등록된 회원이 없습니다.");
            return;
        }
        
        // 5-2. 회원 정보 테이블 헤더 - "표 제목줄"
        // 사고의 흐름: "표의 제목줄을 먼저 출력하고, 그 다음에 각 회원 정보를 출력하자"
        System.out.printf("%-4s %-10s %-4s %-6s %-8s %-8s %-12s%n", 
            "번호", "이름", "나이", "결혼", "VIP등급", "연봉(만원)", "가입날짜");
        System.out.println("-".repeat(80));
        
        // 5-3. 각 회원 정보 출력 - "명단 읽어주기"
        // 사고의 흐름: "반복문을 사용해서 모든 회원 정보를 하나씩 출력하자"
        for (int i = 0; i < memberCount; i++) {
            String marriedStatus = memberMarried[i] ? "기혼" : "미혼";
            System.out.printf("%-4d %-10s %-4d %-6s %-8s %-8d %-12s%n",
                (i + 1), memberNames[i], memberAges[i], marriedStatus,
                memberVipLevel[i], memberSalary[i], memberJoinDate[i]);
        }
    }
    
    // ===================================================================
    // 6. 회원 추가 기능 (Add Functions) - "신규 가입 접수원"
    // ===================================================================
    
    /**
     * 6-1. 새 회원 등록 - "가입 신청서 작성"
     * 사고의 흐름: "새로운 회원의 정보를 입력받아서 시스템에 등록하자. 단계별로 정보를 받으면 사용자가 편할 것 같아"
     */
    private static void addNewMember() {
        System.out.println("\n새 회원 등록");
        System.out.println("=".repeat(30));
        
        // 6-2. 저장 공간 확인 - "자리 있나 체크"
        // 사고의 흐름: "배열이 가득 찼는지 먼저 확인하자"
        if (memberCount >= memberNames.length) {
            System.out.println("더 이상 회원을 등록할 수 없습니다. (정원 초과)");
            return;
        }
        
        // 6-3. 회원 정보 입력받기 - "신청서 작성 도우미"
        // 사고의 흐름: "사용자에게 친절하게 안내하면서 정보를 하나씩 입력받자"
        System.out.print("이름을 입력하세요: ");
        String name = scanner.nextLine();
        
        System.out.print("나이를 입력하세요: ");
        int age = getIntInput();
        
        System.out.print("결혼 여부 (true: 기혼, false: 미혼): ");
        boolean isMarried = getBooleanInput();
        
        System.out.print("연봉을 입력하세요 (만원 단위): ");
        int salary = getIntInput();
        
        System.out.print("가입날짜를 입력하세요 (예: 2024-01-15): ");
        String joinDate = scanner.nextLine();
        
        // 6-4. 회원 객체 생성 및 저장 - "회원카드 제작 및 보관"
        // 사고의 흐름: "입력받은 정보로 Member 객체를 만들고, 배열에 저장하자"
        Member newMember = new Member(name, age, isMarried, salary, joinDate);
        saveMemberToArrays(newMember, memberCount);
        memberCount++;
        
        System.out.println("회원 등록이 완료되었습니다!");
        System.out.println("VIP 등급: " + newMember.vipLevel);
    }
    
    /**
     * 6-5. 회원 정보를 배열에 저장 - "서류 정리함에 보관"
     * 사고의 흐름: "Member 객체의 정보를 각각의 배열에 나누어서 저장하자"
     */
    private static void saveMemberToArrays(Member member, int index) {
        memberNames[index] = member.name;
        memberAges[index] = member.age;
        memberMarried[index] = member.isMarried;
        memberVipLevel[index] = member.vipLevel;
        memberSalary[index] = member.salary;
        memberJoinDate[index] = member.joinDate;
    }
    
    // ===================================================================
    // 7. 회원 검색 기능 (Search Functions) - "정보 수사관"
    // ===================================================================
    
    /**
     * 7-1. 회원 검색 메뉴 - "수사 본부"
     * 사고의 흐름: "여러 가지 방법으로 검색할 수 있게 하자. 이름, VIP등급, 나이 범위로 검색하면 유용할 것 같아"
     */
    private static void searchMember() {
        System.out.println("\n회원 검색");
        System.out.println("=".repeat(20));
        System.out.println("1. 이름으로 검색");
        System.out.println("2. VIP 등급으로 검색");
        System.out.println("3. 나이 범위로 검색");
        
        System.out.print("검색 방법을 선택하세요: ");
        int searchType = getIntInput();
        
        // 사고의 흐름: "선택한 검색 방법에 따라 해당 검색 함수를 호출하자"
        switch (searchType) {
            case 1: searchByName(); break;      // 이름 수사관
            case 2: searchByVipLevel(); break;  // 등급 수사관
            case 3: searchByAgeRange(); break;  // 나이 수사관
            default: System.out.println("잘못된 선택입니다.");
        }
    }
    
    /**
     * 7-2. 이름으로 검색 - "신원 조회관"
     * 사고의 흐름: "입력받은 이름이 포함된 회원들을 모두 찾아서 보여주자. 완전히 일치하지 않아도 포함되면 찾아주면 편할 것 같아"
     */
    private static void searchByName() {
        System.out.print("검색할 이름을 입력하세요: ");
        String searchName = scanner.nextLine();
        
        boolean found = false;
        // 사고의 흐름: "모든 회원을 하나씩 확인해서 이름에 검색어가 포함되어 있는지 확인하자"
        for (int i = 0; i < memberCount; i++) {
            if (memberNames[i].contains(searchName)) {
                if (!found) {
                    System.out.println("\n검색 결과:");
                    found = true;
                }
                printMemberInfo(i);
            }
        }
        
        if (!found) {
            System.out.println("해당 이름의 회원을 찾을 수 없습니다.");
        }
    }
    
    /**
     * 7-3. VIP 등급으로 검색 - "등급 분류관"
     * 사고의 흐름: "사용자가 원하는 VIP 등급을 선택하게 하고, 해당 등급의 회원들을 모두 찾아서 보여주자"
     */
    private static void searchByVipLevel() {
        System.out.println("VIP 등급을 선택하세요:");
        System.out.println("1. GOLD   2. SILVER   3. BRONZE");
        System.out.print("선택: ");
        int levelChoice = getIntInput();
        
        String targetLevel = "";
        // 사고의 흐름: "입력받은 번호를 실제 등급 문자열로 변환하자"
        switch (levelChoice) {
            case 1: targetLevel = "GOLD"; break;
            case 2: targetLevel = "SILVER"; break;
            case 3: targetLevel = "BRONZE"; break;
            default: 
                System.out.println("잘못된 선택입니다.");
                return;
        }
        
        boolean found = false;
        System.out.println("\n" + targetLevel + " 등급 회원 목록:");
        // 사고의 흐름: "모든 회원을 확인해서 선택한 등급과 일치하는 회원들을 찾자"
        for (int i = 0; i < memberCount; i++) {
            if (memberVipLevel[i].equals(targetLevel)) {
                if (!found) found = true;
                printMemberInfo(i);
            }
        }
        
        if (!found) {
            System.out.println("해당 등급의 회원이 없습니다.");
        }
    }
    
    /**
     * 7-4. 나이 범위로 검색 - "연령대 분석관"
     * 사고의 흐름: "최소 나이와 최대 나이를 입력받아서 그 범위에 해당하는 회원들을 찾아주자"
     */
    private static void searchByAgeRange() {
        System.out.print("최소 나이를 입력하세요: ");
        int minAge = getIntInput();
        System.out.print("최대 나이를 입력하세요: ");
        int maxAge = getIntInput();
        
        boolean found = false;
        System.out.println("\n" + minAge + "세 ~ " + maxAge + "세 회원 목록:");
        // 사고의 흐름: "각 회원의 나이가 입력받은 범위 안에 있는지 확인하자"
        for (int i = 0; i < memberCount; i++) {
            if (memberAges[i] >= minAge && memberAges[i] <= maxAge) {
                if (!found) found = true;
                printMemberInfo(i);
            }
        }
        
        if (!found) {
            System.out.println("해당 나이 범위의 회원이 없습니다.");
        }
    }
    
    /**
     * 7-5. 회원 정보 출력 도우미 - "정보 출력기"
     * 사고의 흐름: "회원 정보를 출력하는 코드가 여러 곳에서 반복되니까 함수로 만들어서 재사용하자"
     */
    private static void printMemberInfo(int index) {
        String marriedStatus = memberMarried[index] ? "기혼" : "미혼";
        System.out.printf("%s (%d세, %s, %s등급, %d만원, %s)%n",
            memberNames[index], memberAges[index], marriedStatus,
            memberVipLevel[index], memberSalary[index], memberJoinDate[index]);
    }
    
    // ===================================================================
    // 8. 회원 수정 기능 (Update Functions) - "정보 수정 담당자"
    // ===================================================================
    
    /**
     * 8-1. 회원 정보 수정 - "개인정보 변경 접수원"
     * 사고의 흐름: "기존 회원의 정보를 찾아서 새로운 정보로 업데이트하자. 먼저 수정할 회원을 찾고, 어떤 정보를 수정할지 선택하게 하자"
     */
    private static void updateMember() {
        System.out.println("\n회원 정보 수정");
        System.out.println("=".repeat(25));
        
        if (memberCount == 0) {
            System.out.println("수정할 회원이 없습니다.");
            return;
        }
        
        // 8-2. 수정할 회원 찾기 - "대상자 검색"
        // 사고의 흐름: "이름으로 회원을 찾는 것이 가장 직관적일 것 같아"
        System.out.print("수정할 회원의 이름을 입력하세요: ");
        String targetName = scanner.nextLine();
        
        int memberIndex = findMemberByName(targetName);
        if (memberIndex == -1) {
            System.out.println("해당 이름의 회원을 찾을 수 없습니다.");
            return;
        }
        
        // 8-3. 현재 정보 표시 - "기존 정보 확인"
        // 사고의 흐름: "수정하기 전에 현재 정보를 보여주면 사용자가 확인할 수 있어서 좋을 것 같아"
        System.out.println("\n현재 회원 정보:");
        printMemberInfo(memberIndex);
        
        // 8-4. 수정할 항목 선택 - "변경 항목 선택기"
        showUpdateMenu(memberIndex);
    }
    
    /**
     * 8-5. 수정 메뉴 표시 - "수정 옵션 안내소"
     * 사고의 흐름: "어떤 정보를 수정할지 선택할 수 있게 메뉴를 보여주자"
     */
    private static void showUpdateMenu(int memberIndex) {
        System.out.println("\n수정할 항목을 선택하세요:");
        System.out.println("1. 나이 수정");
        System.out.println("2. 결혼 상태 수정");
        System.out.println("3. 연봉 수정 (VIP 등급 자동 재계산)");
        System.out.println("4. 가입날짜 수정");
        System.out.println("0. 수정 취소");
        
        System.out.print("선택: ");
        int choice = getIntInput();
        
        // 8-6. 선택된 항목 수정 실행 - "수정 작업 처리기"
        executeUpdate(memberIndex, choice);
    }
    
    /**
     * 8-7. 수정 작업 실행 - "실제 수정 작업자"
     * 사고의 흐름: "선택한 항목에 따라서 해당 정보를 새로 입력받아서 업데이트하자"
     */
    private static void executeUpdate(int memberIndex, int choice) {
        switch (choice) {
            case 1: // 나이 수정 담당자
                // 사고의 흐름: "새로운 나이를 입력받아서 배열에 저장하자"
                System.out.print("새로운 나이를 입력하세요: ");
                memberAges[memberIndex] = getIntInput();
                System.out.println("나이가 수정되었습니다.");
                break;
                
            case 2: // 결혼상태 수정 담당자
                // 사고의 흐름: "결혼 상태를 새로 입력받자"
                System.out.print("결혼 상태 (true: 기혼, false: 미혼): ");
                memberMarried[memberIndex] = getBooleanInput();
                System.out.println("결혼 상태가 수정되었습니다.");
                break;
                
            case 3: // 연봉 및 VIP등급 수정 담당자
                // 사고의 흐름: "연봉을 수정하면 VIP 등급도 자동으로 다시 계산해줘야겠어"
                System.out.print("새로운 연봉을 입력하세요 (만원): ");
                int newSalary = getIntInput();
                memberSalary[memberIndex] = newSalary;
                // VIP 등급 재계산
                memberVipLevel[memberIndex] = calculateVipLevelFromSalary(newSalary);
                System.out.println("연봉이 수정되었습니다.");
                System.out.println("새로운 VIP 등급: " + memberVipLevel[memberIndex]);
                break;
                
            case 4: // 가입날짜 수정 담당자
                // 사고의 흐름: "새로운 가입날짜를 입력받자"
                System.out.print("새로운 가입날짜 (예: 2024-01-15): ");
                memberJoinDate[memberIndex] = scanner.nextLine();
                System.out.println("가입날짜가 수정되었습니다.");
                break;
                
            case 0: // 취소 담당자
                System.out.println("수정을 취소했습니다.");
                break;
                
            default:
                System.out.println("잘못된 선택입니다.");
        }
    }
    
    // ===================================================================
    // 9. 회원 삭제 기능 (Delete Functions) - "탈퇴 처리 담당자"
    // ===================================================================
    
    /**
     * 9-1. 회원 삭제 - "탈퇴 접수원"
     * 사고의 흐름: "지정된 회원을 시스템에서 완전히 제거하자. 실수를 방지하기 위해 확
    /**
     * 9-1. 회원 삭제 - "탈퇴 접수원"
     * 사고의 흐름: "지정된 회원을 시스템에서 완전히 제거하자. 실수를 방지하기 위해 확인 절차를 거치는 게 좋겠어"
     */
    private static void deleteMember() {
        System.out.println("\n회원 삭제");
        System.out.println("=".repeat(20));
        
        if (memberCount == 0) {
            System.out.println("삭제할 회원이 없습니다.");
            return;
        }
        
        // 9-2. 삭제할 회원 찾기 - "탈퇴 대상자 확인"
        // 사고의 흐름: "이름으로 삭제할 회원을 찾자"
        System.out.print("삭제할 회원의 이름을 입력하세요: ");
        String targetName = scanner.nextLine();
        
        int memberIndex = findMemberByName(targetName);
        if (memberIndex == -1) {
            System.out.println("해당 이름의 회원을 찾을 수 없습니다.");
            return;
        }
        
        // 9-3. 삭제 확인 - "탈퇴 의사 재확인"
        // 사고의 흐름: "삭제하기 전에 어떤 회원인지 보여주고 정말 삭제할 건지 확인받자"
        System.out.println("\n삭제할 회원 정보:");
        printMemberInfo(memberIndex);
        System.out.print("\n정말로 삭제하시겠습니까? (y/n): ");
        String confirm = scanner.nextLine();
        
        if (confirm.equalsIgnoreCase("y") || confirm.equalsIgnoreCase("yes")) {
            // 9-4. 실제 삭제 작업 - "서류 폐기 처리"
            removeMemberFromArrays(memberIndex);
            System.out.println("회원이 삭제되었습니다.");
        } else {
            System.out.println("삭제를 취소했습니다.");
        }
    }
    
    /**
     * 9-5. 배열에서 회원 제거 - "서류 정리 담당자"
     * 사고의 흐름: "삭제된 회원의 자리를 뒤의 회원들로 채워서 빈 공간을 없애자. 배열에서 중간 요소를 삭제하는 방법이야"
     */
    private static void removeMemberFromArrays(int index) {
        // 사고의 흐름: "삭제할 위치부터 마지막까지 한 칸씩 앞으로 이동시키자"
        for (int i = index; i < memberCount - 1; i++) {
            memberNames[i] = memberNames[i + 1];
            memberAges[i] = memberAges[i + 1];
            memberMarried[i] = memberMarried[i + 1];
            memberVipLevel[i] = memberVipLevel[i + 1];
            memberSalary[i] = memberSalary[i + 1];
            memberJoinDate[i] = memberJoinDate[i + 1];
        }
        memberCount--; // 전체 회원 수 감소
    }
    
    // ===================================================================
    // 10. 통계 기능 (Statistics Functions) - "데이터 분석관"
    // ===================================================================
    
    /**
     * 10-1. 회원 통계 표시 - "현황 분석 보고서"
     * 사고의 흐름: "등록된 회원들의 다양한 통계 정보를 분석해서 보여주자. 관리자가 현황을 파악하는데 도움이 될 거야"
     */
    private static void showStatistics() {
        System.out.println("\n회원 통계 현황");
        System.out.println("=".repeat(40));
        
        if (memberCount == 0) {
            System.out.println("통계를 표시할 회원이 없습니다.");
            return;
        }
        
        // 10-2. 기본 통계 - "기초 현황 집계관"
        System.out.println("전체 회원 수: " + memberCount + "명");
        
        // 10-3. 결혼 상태 통계 - "혼인 현황 분석관"
        // 사고의 흐름: "기혼자와 미혼자가 각각 몇 명인지 세어보자"
        int marriedCount = 0;
        for (int i = 0; i < memberCount; i++) {
            if (memberMarried[i]) marriedCount++;
        }
        System.out.println("기혼 회원: " + marriedCount + "명");
        System.out.println("미혼 회원: " + (memberCount - marriedCount) + "명");
        
        // 10-4. VIP 등급 통계 - "등급별 현황 분석관"
        // 사고의 흐름: "각 VIP 등급별로 몇 명씩 있는지 세어보자"
        int goldCount = 0, silverCount = 0, bronzeCount = 0;
        for (int i = 0; i < memberCount; i++) {
            switch (memberVipLevel[i]) {
                case "GOLD": goldCount++; break;
                case "SILVER": silverCount++; break;
                case "BRONZE": bronzeCount++; break;
            }
        }
        System.out.println("GOLD 등급: " + goldCount + "명");
        System.out.println("SILVER 등급: " + silverCount + "명");
        System.out.println("BRONZE 등급: " + bronzeCount + "명");
        
        // 10-5. 나이 통계 - "연령 분석관"
        // 사고의 흐름: "평균 나이, 최연소, 최고령을 계산해서 보여주자"
        if (memberCount > 0) {
            int totalAge = 0, minAge = memberAges[0], maxAge = memberAges[0];
            
            for (int i = 0; i < memberCount; i++) {
                totalAge += memberAges[i];
                if (memberAges[i] < minAge) minAge = memberAges[i];
                if (memberAges[i] > maxAge) maxAge = memberAges[i];
            }
            
            double averageAge = (double) totalAge / memberCount;
            System.out.printf("평균 나이: %.1f세%n", averageAge);
            System.out.println("최연소: " + minAge + "세");
            System.out.println("최고령: " + maxAge + "세");
        }
        
        // 10-6. 연봉 통계 - "소득 분석관"
        // 사고의 흐름: "평균 연봉, 최고 연봉, 최저 연봉을 계산해보자"
        if (memberCount > 0) {
            int totalSalary = 0, minSalary = memberSalary[0], maxSalary = memberSalary[0];
            
            for (int i = 0; i < memberCount; i++) {
                totalSalary += memberSalary[i];
                if (memberSalary[i] < minSalary) minSalary = memberSalary[i];
                if (memberSalary[i] > maxSalary) maxSalary = memberSalary[i];
            }
            
            double averageSalary = (double) totalSalary / memberCount;
            System.out.printf("평균 연봉: %.0f만원%n", averageSalary);
            System.out.println("최고 연봉: " + maxSalary + "만원");
            System.out.println("최저 연봉: " + minSalary + "만원");
        }
    }
    
    // ===================================================================
    // 11. 유틸리티 함수들 (Utility Functions) - "도구 창고"
    // ===================================================================
    
    /**
     * 11-1. 이름으로 회원 찾기 - "회원 검색 도우미"
     * 사고의 흐름: "이름으로 회원을 찾는 코드가 여러 곳에서 반복되니까 함수로 만들어서 재사용하자"
     */
    private static int findMemberByName(String name) {
        for (int i = 0; i < memberCount; i++) {
            if (memberNames[i].equals(name)) {
                return i; // 찾은 회원의 인덱스 반환
            }
        }
        return -1; // 찾지 못했을 때 -1 반환
    }
    
    /**
     * 11-2. 연봉으로 VIP 등급 계산 - "등급 계산 도우미"
     * 사고의 흐름: "Member 클래스 밖에서도 VIP 등급을 계산해야 할 때가 있으니까 별도 함수로 만들자"
     */
    private static String calculateVipLevelFromSalary(int salary) {
        if (salary >= 8000) return "GOLD";
        else if (salary >= 5000) return "SILVER";
        else return "BRONZE";
    }
    
    /**
     * 11-3. 정수 입력 받기 - "숫자 입력 검증관"
     * 사고의 흐름: "사용자가 잘못된 형식을 입력할 수 있으니까 안전하게 정수를 입력받는 함수를 만들자"
     */
    private static int getIntInput() {
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
     * 11-4. 불린 입력 받기 - "참/거짓 입력 검증관"
     * 사고의 흐름: "true/false 입력을 안전하게 받을 수 있는 함수를 만들자"
     */
    private static boolean getBooleanInput() {
        while (true) {
            String input = scanner.nextLine().toLowerCase();
            if (input.equals("true") || input.equals("t")) {
                return true;
            } else if (input.equals("false") || input.equals("f")) {
                return false;
            } else {
                System.out.print("true 또는 false를 입력해주세요: ");
            }
        }
    }
    
    /**
     * 11-5. 프로그램 종료 - "시스템 종료 담당자"
     * 사고의 흐름: "프로그램을 종료할 때 인사말을 하고 깔끔하게 종료하자"
     */
    private static void exitProgram() {
        System.out.println("회원 관리 시스템을 종료합니다. 감사합니다!");
        scanner.close();
        System.exit(0);
    }
    
    // ===================================================================
    // 12. 샘플 데이터 초기화 (Sample Data) - "기본 데이터 준비원"
    // ===================================================================
    
    /**
     * 12-1. 샘플 데이터 생성 - "테스트용 회원 등록기"
     * 사고의 흐름: "프로그램을 테스트할 수 있게 미리 몇 명의 회원 정보를 넣어두자"
     */
    private static void initializeSampleData() {
        // 사고의 흐름: "다양한 등급과 상황의 회원들을 만들어서 모든 기능을 테스트할 수 있게 하자"
        
        // 샘플 회원 1 - GOLD 등급
        Member member1 = new Member("김철수", 35, true, 9000, "2023-01-15");
        saveMemberToArrays(member1, memberCount++);
        
        // 샘플 회원 2 - SILVER 등급
        Member member2 = new Member("이영희", 28, false, 6000, "2023-03-20");
        saveMemberToArrays(member2, memberCount++);
        
        // 샘플 회원 3 - BRONZE 등급
        Member member3 = new Member("박민수", 42, true, 4000, "2023-05-10");
        saveMemberToArrays(member3, memberCount++);
        
        // 샘플 회원 4 - GOLD 등급
        Member member4 = new Member("정수진", 31, false, 8500, "2023-07-05");
        saveMemberToArrays(member4, memberCount++);
        
        // 샘플 회원 5 - BRONZE 등급
        Member member5 = new Member("최동현", 25, false, 3500, "2023-09-12");
        saveMemberToArrays(member5, memberCount++);
        
        System.out.println("샘플 데이터 " + memberCount + "명이 등록되었습니다.");
    }
}
