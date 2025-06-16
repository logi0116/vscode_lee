// MemberService.java (새로운 파일!)
// 이 파일은 회원 데이터의 핵심 로직(파일 입출력, 데이터 목록 관리)을 담당합니다.

import java.io.*;
import java.util.ArrayList; // ArrayList를 사용하기 위해 import

    // 파일 이름 상수: 회원 정보가 저장될 텍스트 파일의 이름입니다.

// ====================================================================
// 1. MemberService 클래스
//    - 회원 정보의 저장, 로드, 관리 등 핵심 '서비스' 기능을 제공합니다.
//    - `SignUp.java`는 이제 이 MemberService를 통해 회원 데이터를 다룹니다.
// ====================================================================
public class MemberService { // public으로 선언하여 다른 파일(SignUp.java)에서 접근 가능하게 함

    // === 이동점 시작: 기존 SignUp.java에서 이곳으로 이동! ===

    // 1-1. 전역 상수: 회원 데이터 파일 이름
    // 설명: 회원 데이터가 저장될 파일의 이름을 정의합니다.
    //       이 상수는 이제 MemberService의 책임 아래에 있습니다.
    private static final String FILE_NAME = "members.txt";

    // 1-2. 전역 멤버 데이터 저장소: 모든 회원 정보를 담을 리스트
    // 설명: 실제 회원 데이터(Member 객체들)를 관리하는 ArrayList입니다.
    //       이 리스트는 이제 MemberService가 직접 소유하고 관리합니다.
    //       SignUp은 이 리스트에 직접 접근하지 않고, MemberService가 제공하는 메서드를 통해 간접적으로 접근합니다.
    private ArrayList<Member> members = new ArrayList<>();

    // === 이동점 끝 ===


    // 1-3. MemberService 클래스의 생성자
    // 설명: MemberService 객체가 만들어질 때(생성될 때) 자동으로 실행되는 부분입니다.
    //       여기서 파일에서 회원 목록을 불러와 `members` 리스트를 초기화합니다.
    public MemberService() {
        loadMembersFromFile(); // MemberService가 생성될 때 데이터를 로드
    }

    // === 이동점 시작: 기존 SignUp.java의 loadMembersFromFile() 메서드 이동! ===
    // 1-4. CSV 파일에서 회원 목록 불러오기 (loadMembersFromFile)
    // 설명: `members.txt` 파일에서 회원 정보를 읽어와 `members` 리스트에 채웁니다.
    //       파일이 없으면 새로 생성하는 기능도 포함합니다.
    // **핵심: 파일 입출력 로직이 이제 MemberService의 책임이 됩니다.**
    private void loadMembersFromFile() {
        members.clear(); // 기존 `members` 리스트 비우기 (데이터 중복 로드 방지)
        File file = new File(FILE_NAME); // 파일 객체 생성

        // 파일이 존재하지 않으면 새로 생성 시도
        if (!file.exists()) {
            try {
                if (file.createNewFile()) {
                    System.out.println("[MemberService] 새로운 members.txt 파일이 생성되었습니다.");
                }
            } catch (IOException e) {
                // MemberService는 GUI가 없으므로 JOptionPane 대신 콘솔에 출력 (또는 예외를 다시 던질 수 있음)
                System.err.println("[MemberService] 파일 생성 오류: " + e.getMessage());
                return;
            }
        }

        // 파일에서 데이터 읽기 (UTF-8 인코딩 명시)
        try (BufferedReader br = new BufferedReader(
                                new InputStreamReader(
                                new FileInputStream(FILE_NAME), "UTF-8"))) {
            String line;
            while ((line = br.readLine()) != null) {
                Member member = Member.fromCSV(line); // Member 클래스의 정적 메서드 사용
                if (member != null) {
                    members.add(member);
                }
            }
        } catch (IOException e) {
            System.err.println("[MemberService] 파일 읽기 오류: " + e.getMessage());
        }
    }
    // === 이동점 끝 ===

    // === 이동점 시작: 기존 SignUp.java의 saveMembersToFile() 메서드 이동! ===
    // 1-5. 회원 목록을 CSV 파일에 저장하기 (saveMembersToFile)
    // 설명: `members` 리스트의 현재 내용을 `members.txt` 파일에 저장합니다.
    //       데이터가 변경될 때마다 이 메서드를 호출하여 파일에 반영합니다.
    // **핵심: 파일 저장 로직도 MemberService의 책임이 됩니다.**
    private void saveMembersToFile() {
        // 파일에 데이터 쓰기 (UTF-8 인코딩 명시)
        try (BufferedWriter bw = new BufferedWriter(
                                new OutputStreamWriter(
                                new FileOutputStream(FILE_NAME), "UTF-8"))) {
            for (Member member : members) {
                bw.write(member.toCSV()); // Member 객체를 CSV 문자열로 변환하여 쓰기
                bw.newLine(); // 다음 줄로 이동
            }
        } catch (IOException e) {
            System.err.println("[MemberService] 파일 저장 오류: " + e.getMessage());
        }
    }
    // === 이동점 끝 ===


    // 1-6. 외부(SignUp.java)에서 회원 목록을 가져갈 수 있도록 Getter 메서드 추가
    // 설명: `members` 리스트는 `private`으로 선언되어 MemberService 내부에서만 직접 접근 가능합니다.
    //       SignUp과 같은 외부 클래스가 이 데이터를 사용하려면, MemberService가 제공하는
    //       공개(public) 메서드를 통해서만 접근해야 합니다.
    // 반환: 현재 `members` 리스트의 복사본 (직접 수정 방지를 위해) 또는 읽기 전용 뷰를 반환하는 것이 좋지만,
    //       여기서는 학습 편의상 `ArrayList<Member>` 자체를 반환합니다.
    public ArrayList<Member> getMembers() {
        return new ArrayList<>(members); // 외부에서 원본 리스트를 직접 수정하지 못하도록 '복사본'을 반환하는 것이 좋습니다.
                                         // 이렇게 하면 SignUp에서 리스트를 마음대로 추가/삭제하는 것을 막고,
                                         // MemberService의 책임(add/delete/update 메서드)을 강화할 수 있습니다.
    }

    // 1-7. 회원 데이터 변경 후 저장하도록 외부에서 호출할 수 있는 메서드 추가
    // 설명: `SignUp` 클래스에서 회원 정보를 추가/수정/삭제한 후에,
    //       MemberService에게 "데이터가 변경되었으니 파일에 저장해 달라"고 요청할 때 사용하는 메서드입니다.
    public void saveChanges() {
        saveMembersToFile(); // 내부의 `private saveMembersToFile()` 메서드를 호출하여 실제 저장 작업을 수행
    }





 

// ====================================================================
    // ✨ 새로운 기능: 회원 추가 메서드 (addMember) ✨
    // 설명: 외부(SignUp)에서 새로운 Member 객체를 전달받아,
    //       MemberService 내부의 `members` 리스트에 추가하고,
    //       자동으로 변경 사항을 파일에 저장하는 역할을 합니다.
    //       이제 SignUp은 `members` 리스트에 직접 add() 하지 않고,
    //       이 `addMember()` 메서드를 호출하게 됩니다.
    // ====================================================================
    public void addMember(Member newMember) {
        if (newMember != null) { // null 값이 아닌 유효한 Member 객체인지 확인
            this.members.add(newMember); // MemberService가 직접 자신의 `members` 리스트에 추가
            saveChanges();               // 변경 사항을 파일에 저장 (내부 메서드 호출)
            System.out.println("[MemberService] 새로운 회원 '" + newMember.getName() + "' 추가 및 저장 완료."); // 콘솔 로그
        }
    }

  

    
    // 설명: `SignUp`에서 새로운 `Member` 객체를 받아 `members` 리스트에 추가하고 저장하는 메서드.
    // public void addMember(Member newMember) {
    //     if (newMember != null) {
    //         this.members.add(newMember);
    //         saveChanges(); // 추가 후 바로 파일에 저장
    //     }
    // }

    // 1-9. (추가될 예정) 회원 삭제 메서드
    // 설명: 특정 인덱스의 회원을 `members` 리스트에서 삭제하고 저장하는 메서드.
    public void deleteMember(int index) {
        if (index >= 0 && index < members.size()) {
            members.remove(index);
            saveChanges(); // 삭제 후 바로 파일에 저장
        }
    }

    // 1-10. (추가될 예정) 회원 수정 메서드
    // 설명: 특정 인덱스의 회원을 새로운 Member 객체로 교체하고 저장하는 메서드.
    public void updateMember(int index, Member updatedMember) {
        if (index >= 0 && index < members.size() && updatedMember != null) {
            members.set(index, updatedMember);
            saveChanges(); // 수정 후 바로 파일에 저장
        }
    }

    // 1-11. (추가될 예정) 회원 검색 메서드
    // 설명: 검색 쿼리를 받아 `members` 리스트에서 해당 회원을 찾아 반환하는 메서드.
    public ArrayList<Member> searchMembers(String query) {
        ArrayList<Member> results = new ArrayList<>();
        String lowerCaseQuery = query.toLowerCase();
        for (Member member : this.members) {
            if (member.getName().toLowerCase().contains(lowerCaseQuery) ||
                member.getEmail().toLowerCase().contains(lowerCaseQuery)) {
                results.add(member);
            }
        }
        return results;
    }
}