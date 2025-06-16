package ch_05_experiments.random_playground.Test001_25050612;
// SignUp.java (단일 파일 버전 - UTF-8 인코딩 적용 완료!)

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

// ====================================================================
// 3. SignUp 클래스 (메인 GUI 클래스)
//    - 회원 관리 프로그램의 메인 사용자 인터페이스(UI)를 구성하고,
//    - 모든 회원 관리 기능(등록, 수정, 삭제, 검색, 파일 입출력)을 직접 처리합니다.
// ====================================================================
public class SignUp extends JFrame { // 메인 클래스는 반드시 public이어야 하며, JFrame을 상속받아 창 역할을 합니다.

    // === 3-1. 전역 상수 및 변수 선언 ===

    private MemberService memberService = new MemberService();

    // Swing 컴포넌트들: 프로그램의 UI를 구성하는 요소들입니다.
    private DefaultTableModel tableModel; // JTable(테이블)의 데이터를 관리하는 모델
    private JTable memberTable; // 회원 목록을 표 형태로 보여줄 테이블
    private JTextField searchField; // 회원을 검색할 검색어를 입력하는 텍스트 필드
    private JButton searchBtn; // 검색 실행 버튼
    private JButton resetBtn; // 검색 결과를 초기화하는 버튼
    private JButton addBtn; // 새로운 회원을 가입시키는 버튼
    private JButton updateBtn; // 선택된 회원의 정보를 수정하는 버튼
    private JButton deleteBtn; // 선택된 회원을 삭제하는 버튼

    // === 3-2. SignUp 클래스의 생성자 ===
    // 프로그램이 시작될 때 가장 먼저 호출되어, UI를 초기화하고 데이터를 불러옵니다.
    public SignUp() {
        setTitle("회원 관리 프로그램"); // 창 제목 설정
        setSize(800, 600); // 창 크기 설정 (너비, 높이)
        setLocationRelativeTo(null); // 창을 화면 중앙에 배치
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창 닫기 버튼(X) 클릭 시 프로그램 종료

        initUI(); // UI 컴포넌트들을 설정하고 배치하는 메서드 호출
        refreshTable(); // 불러온 데이터로 테이블을 새로고침하여 화면에 표시
        setVisible(true); // GUI 창을 화면에 보이도록 설정
    }

    // === 3-3. UI 컴포넌트 초기화 및 레이아웃 설정 메서드 (initUI) ===
    // 프로그램의 모든 버튼, 필드, 테이블 등을 생성하고 화면에 적절히 배치합니다.
    private void initUI() {
        // 테이블 설정: 테이블 헤더(컬럼명)를 정의하고, 데이터를 편집할 수 없게 설정합니다.
        String[] cols = { "이름", "이메일", "비밀번호", "가입일" }; // 테이블의 각 열(컬럼) 이름
        tableModel = new DefaultTableModel(cols, 0) { // DefaultTableModel 생성 (0은 초기 행 개수)
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // 테이블의 셀(칸)을 사용자가 직접 편집할 수 없도록 설정
            }
        };
        memberTable = new JTable(tableModel); // 위에서 만든 tableModel을 JTable에 연결
        JScrollPane scrollPane = new JScrollPane(memberTable); // 테이블에 스크롤 기능 추가 (테이블이 커질 때 유용)

        // 버튼 패널 설정: 여러 버튼들을 담을 패널을 만들고 버튼들을 추가합니다.
        JPanel btnPanel = new JPanel(); // 버튼들을 담을 JPanel 생성
        addBtn = new JButton("회원가입"); // '회원가입' 버튼 생성
        updateBtn = new JButton("수정"); // '수정' 버튼 생성
        deleteBtn = new JButton("삭제"); // '삭제' 버튼 생성
        JButton reloadBtn = new JButton("새로고침"); // 파일에서 데이터를 다시 불러오는 '새로고침' 버튼

        btnPanel.add(addBtn); // 버튼 패널에 회원가입 버튼 추가
        btnPanel.add(updateBtn); // 버튼 패널에 수정 버튼 추가
        btnPanel.add(deleteBtn); // 버튼 패널에 삭제 버튼 추가
        btnPanel.add(reloadBtn); // 버튼 패널에 새로고침 버튼 추가

        // 검색 패널 설정: 검색 입력 필드와 검색/초기화 버튼을 담을 패널을 만듭니다.
        JPanel searchPanel = new JPanel(); // 검색 관련 컴포넌트들을 담을 JPanel 생성
        searchField = new JTextField(20); // 20칸 정도의 너비를 가진 검색어 입력 필드
        searchBtn = new JButton("검색"); // '검색' 버튼 생성
        resetBtn = new JButton("검색 초기화"); // '검색 초기화' 버튼 생성

        searchPanel.add(new JLabel("이름 또는 이메일 검색 : ")); // 검색 필드 앞에 표시할 라벨
        searchPanel.add(searchField); // 검색 필드 추가
        searchPanel.add(searchBtn); // 검색 버튼 추가
        searchPanel.add(resetBtn); // 검색 초기화 버튼 추가

        // 메인 레이아웃 설정: JFrame에 BorderLayout을 적용하여 컴포넌트들을 배치합니다.
        // BorderLayout은 NORTH(상단), SOUTH(하단), EAST(우측), WEST(좌측), CENTER(중앙)의 5개 영역을
        // 가집니다.
        setLayout(new BorderLayout());
        add(searchPanel, BorderLayout.NORTH); // 검색 패널을 창의 상단에 배치
        add(scrollPane, BorderLayout.CENTER); // 스크롤 가능한 테이블을 창의 중앙에 배치
        add(btnPanel, BorderLayout.SOUTH); // 버튼 패널을 창의 하단에 배치

        // 이벤트 리스너 연결: 각 버튼이 클릭되었을 때 어떤 메서드를 실행할지 정의합니다.
        addBtn.addActionListener(e -> showAddDialog()); // 회원가입 버튼 클릭 시 showAddDialog() 호출
        updateBtn.addActionListener(e -> showUpdateDialog()); // 수정 버튼 클릭 시 showUpdateDialog() 호출
        deleteBtn.addActionListener(e -> deleteSelectedMember()); // 삭제 버튼 클릭 시 deleteSelectedMember() 호출
        searchBtn.addActionListener(e -> searchMembers()); // 검색 버튼 클릭 시 searchMembers() 호출
        resetBtn.addActionListener(e -> { // 검색 초기화 버튼 클릭 시
            searchField.setText(""); // 검색 필드 비우기
            refreshTable(); // 테이블 전체 목록으로 새로고침
        });
        searchField.addActionListener(e -> searchMembers()); // 검색 필드에서 Enter 키 입력 시 searchMembers() 호출
        reloadBtn.addActionListener(e -> refreshTable()); // 새로고침 버튼 클릭 시 파일에서 데이터 다시 로드
    }

    // === 3-4. 핵심 기능 메서드들 ===

    // 3. JTable에 회원 데이터 반영 (새로고침) (refreshTable)
    // 역할: `members` ArrayList의 현재 데이터를 `memberTable`에 표시하여 UI를 최신 상태로 업데이트합니다.
    private void refreshTable() {
        tableModel.setRowCount(0); // 테이블의 모든 기존 행을 삭제하여 테이블을 깨끗하게 비웁니다.

        // ====================================================================
        // ✨ 핵심 변경점: 'members' 리스트 대신 'memberService.getMembers()' 사용! ✨
        // 설명: 이제 회원 목록의 원본은 MemberService가 가지고 있으므로,
        // SignUp은 MemberService에게 "회원 목록 줘!"라고 요청해야 합니다.
        // `memberService.getMembers()`가 그 역할을 합니다.
        // ====================================================================
        for (Member member : memberService.getMembers()) { // ✨ 이렇게 변경!
            Object[] rowData = { // 테이블 한 행에 표시될 데이터 배열
                    member.getName(),
                    member.getEmail(),
                    member.getPassword(),
                    member.getRegistrationDate()
            };
            tableModel.addRow(rowData); // `DefaultTableModel`에 새 행 추가
        }
    }

    // 4. 회원 검색 기능 (searchMembers)
    // 역할: 검색 필드에 입력된 키워드로 `members` 리스트를 검색하여,
    // 이름이나 이메일에 키워드가 포함된 회원을 찾아 테이블에 표시합니다.
    private void searchMembers() {
        // 검색어 가져오기: 앞뒤 공백 제거, 소문자로 변환 (대소문자 구분 없이 검색하기 위함)
        String query = searchField.getText().trim().toLowerCase();

        if (query.isEmpty()) { // 검색어가 비어있으면
            refreshTable(); // 전체 회원 목록을 다시 표시합니다.
            return;
        }

        ArrayList<Member> resultsList = new ArrayList<>(); // 검색 결과를 담을 새 리스트

        // `members` 리스트의 각 회원에 대해 검색어 포함 여부 확인
        for (Member member : memberService.getMembers()) {
            if (member.getName().toLowerCase().contains(query) || // 이름에 검색어가 포함되거나
                    member.getEmail().toLowerCase().contains(query)) { // 이메일에 검색어가 포함되면
                resultsList.add(member); // 결과 리스트에 추가
            }
        }

        showSearchResults(resultsList); // 검색 결과를 테이블에 표시하는 메서드 호출

        if (resultsList.isEmpty()) { // 검색 결과가 없을 경우
            JOptionPane.showMessageDialog(this, "검색 결과가 없습니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // 5. 검색 결과를 테이블에 반영 (showSearchResults)
    // 역할: `refreshTable()`과 유사하게, 특정 `ArrayList<Member>` (여기서는 검색 결과)를
    // 받아 테이블에 표시합니다.
    private void showSearchResults(ArrayList<Member> results) {
        tableModel.setRowCount(0); // 테이블을 비웁니다.

        // 검색 결과 리스트의 각 Member 객체를 테이블에 추가합니다.
        for (Member member : results) {
            Object[] rowData = {
                    member.getName(),
                    member.getEmail(),
                    member.getPassword(),
                    member.getRegistrationDate()
            };
            tableModel.addRow(rowData);
        }
    }

    // 6. 회원 가입 입력 폼 다이얼로그 (showAddDialog)
    // 역할: 새로운 회원 정보를 입력받는 팝업 창을 띄우고, 입력된 정보를 유효성 검사 후
    // 새로운 Member 객체로 만들어 `members` 리스트에 추가하고 파일에 저장합니다.
    private void showAddDialog() {
        // 입력 필드 생성
        JTextField nameField = new JTextField(10);
        JTextField emailField = new JTextField(15);
        JPasswordField passwordField = new JPasswordField(10); // 비밀번호 입력용 필드 (문자 마스킹)

        // 입력 필드들을 담을 패널 생성 (GridLayout: 0행 2열로 자동 배치)
        JPanel panel = new JPanel(new GridLayout(0, 2));
        panel.add(new JLabel("이름 :"));
        panel.add(nameField);
        panel.add(new JLabel("이메일 :"));
        panel.add(emailField);
        panel.add(new JLabel("비밀번호 :"));
        panel.add(passwordField);

        // '회원 가입' 다이얼로그 띄우기 (확인/취소 버튼 포함)
        int result = JOptionPane.showConfirmDialog(
                this, // 부모 컴포넌트 (SignUp 창)
                panel, // 다이얼로그에 표시할 내용 (입력 필드 패널)
                "회원 가입", // 다이얼로그 제목
                JOptionPane.OK_CANCEL_OPTION, // '확인'/'취소' 버튼 표시
                JOptionPane.PLAIN_MESSAGE // 아이콘 없음
        );

        if (result == JOptionPane.OK_OPTION) { // 사용자가 '확인' 버튼을 클릭했을 경우
            // 입력된 값 가져오기 (공백 제거)
            String name = nameField.getText().trim();
            String email = emailField.getText().trim();
            String password = new String(passwordField.getPassword()).trim(); // JPasswordField의 비밀번호 가져오기
            String regDate = DateUtil.getCurrentDateTime(); // 현재 날짜/시간을 가입일로 설정

            // 유효성 검사: 필수 항목(이름, 이메일, 비밀번호)이 비어있는지 확인
            if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "모든 항목을 입력해주세요.", "경고", JOptionPane.WARNING_MESSAGE);
                return; // 메서드 종료
            }

            // 새로운 Member 객체 생성
            Member newMember = new Member(name, email, password, regDate);
            memberService.addMember(newMember); // ✨ 이렇게 변경! (MemberService에게 위임)
            // saveMembersToFile(); // 변경된 `members` 리스트를 파일에 저장
            refreshTable(); // 테이블 새로고침하여 새 회원 정보 표시

            JOptionPane.showMessageDialog(this, "회원가입이 완료되었습니다!", "알림", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // 7. 회원 수정 입력 폼 다이얼로그 (showUpdateDialog)
    // 역할: 선택된 회원의 정보를 입력받아 수정하는 팝업 창을 띄우고,
    // 수정된 정보를 `members` 리스트에 반영하고 파일에 저장합니다.
    private void showUpdateDialog() {
        int selectedRow = memberTable.getSelectedRow(); // 테이블에서 선택된 행의 인덱스 가져오기

        if (selectedRow == -1) { // 선택된 행이 없을 경우 (-1은 아무것도 선택되지 않았음을 의미)
            JOptionPane.showMessageDialog(this, "수정할 회원을 선택해주세요.", "알림", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        // `members` 리스트에서 선택된 행에 해당하는 Member 객체를 가져옵니다.
        Member oldMember = memberService.getMembers().get(selectedRow);

        // 입력 필드 생성 및 기존 정보로 필드 초기화
        JTextField nameField = new JTextField(oldMember.getName(), 10);
        JTextField emailField = new JTextField(oldMember.getEmail(), 15);
        // 보안상 JPasswordField에 기존 비밀번호를 직접 설정하는 것은 권장되지 않으나, 학습 목적으로는 가능.
        // 실제 서비스에서는 비밀번호 필드를 비워두고, 사용자가 새 비밀번호를 입력하게 합니다.
        JPasswordField passwordField = new JPasswordField(oldMember.getPassword(), 10);

        // 입력 필드들을 담을 패널 생성
        JPanel panel = new JPanel(new GridLayout(0, 2));
        panel.add(new JLabel("이름 :"));
        panel.add(nameField);
        panel.add(new JLabel("이메일 :"));
        panel.add(emailField);
        panel.add(new JLabel("비밀번호 :"));
        panel.add(passwordField);

        // '회원 정보 수정' 다이얼로그 띄우기
        int result = JOptionPane.showConfirmDialog(
                this, panel, "회원 정보 수정", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) { // 사용자가 '확인' 버튼을 클릭했을 경우
            // 수정된 값 가져오기
            String updatedName = nameField.getText().trim();
            String updatedEmail = emailField.getText().trim();
            String updatedPassword = new String(passwordField.getPassword()).trim();

            // 유효성 검사: 모든 항목이 채워져 있는지 확인
            if (updatedName.isEmpty() || updatedEmail.isEmpty() || updatedPassword.isEmpty()) {
                JOptionPane.showMessageDialog(this, "모든 항목을 입력해주세요.", "경고", JOptionPane.WARNING_MESSAGE);
                return;
            }

            Member updatedMember = new Member(updatedName, updatedEmail, updatedPassword,
                    oldMember.getRegistrationDate()); // 새 Member 객체 생성 (가입일은 유지)
            memberService.updateMember(selectedRow, updatedMember); // MemberService에 위임 // 변경된 `members` 리스트를 파일에 저장
            refreshTable(); // 테이블 새로고침하여 수정된 정보 표시

            JOptionPane.showMessageDialog(this, "회원 정보가 성공적으로 수정되었습니다!", "알림", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // 8. 회원 삭제 기능 (deleteSelectedMember)
    // 역할: 테이블에서 선택된 회원을 `members` 리스트에서 제거하고 파일에 저장합니다.
    private void deleteSelectedMember() {
        int selectedRow = memberTable.getSelectedRow(); // 테이블에서 선택된 행의 인덱스 가져오기

        if (selectedRow == -1) { // 선택된 행이 없을 경우
            JOptionPane.showMessageDialog(this, "삭제할 회원을 선택하세요.", "알림", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        // `members` 리스트에서 삭제할 `Member` 객체를 가져옵니다.
        Member memberToDelete = memberService.getMembers().get(selectedRow);
        String memberName = memberToDelete.getName(); // 확인 메시지에 사용할 회원 이름

        // 삭제 확인 다이얼로그 띄우기 (사용자에게 정말 삭제할 것인지 물어봅니다)
        int confirmResult = JOptionPane.showConfirmDialog(
                this, // 부모 컴포넌트 (SignUp 창)
                memberName + " 회원을 정말 삭제하시겠습니까?", // 질문 메시지
                "회원 삭제 확인", // 다이얼로그 제목
                JOptionPane.YES_NO_OPTION, // '예'/'아니오' 버튼 표시
                JOptionPane.WARNING_MESSAGE // 경고 아이콘 표시
        );

        if (confirmResult == JOptionPane.YES_OPTION) { // 사용자가 '예' 버튼을 클릭했을 경우
            memberService.deleteMember(selectedRow);// `members` 리스트에서 해당 `Member` 객체 제거
            memberService.saveChanges(); // 변경된 회원 목록을 파일에 저장
            refreshTable(); // 테이블 새로고침하여 삭제된 회원 정보 반영

            JOptionPane.showMessageDialog(this, memberName + " 회원이 성공적으로 삭제되었습니다.", "알림",
                    JOptionPane.INFORMATION_MESSAGE);
        } else { // 사용자가 '아니오' 버튼을 클릭했거나 다이얼로그를 닫았을 경우
            JOptionPane.showMessageDialog(this, "회원 삭제를 취소했습니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // === 3-5. 메인 메서드 ===
    // 자바 애플리케이션의 시작점입니다.
    public static void main(String[] args) {
        // Swing 애플리케이션은 Event Dispatch Thread (EDT)에서 실행되는 것이 안전합니다.
        // `SwingUtilities.invokeLater()`는 GUI 관련 작업을 EDT에서 수행하도록 예약합니다.
        SwingUtilities.invokeLater(() -> {
            new SignUp().setVisible(true); // SignUp 창을 생성하고 화면에 표시합니다.
        });
    }
}