package ch_05_experiments.random_playground.Test001_25050616;

// 필요한 JDBC 관련 클래스들을 불러옵니다.
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
// 날짜/시간 처리를 위한 자바 8+ API 클래스들을 불러옵니다.
// 현재 UPDATE에서는 직접 Timestamp를 사용하지 않으므로 주석 처리
// import java.sql.Timestamp; 
// import java.time.LocalDateTime;
// import java.time.format.DateTimeFormatter;
// import java.time.format.DateTimeParseException;

/**
 * _5JDBC_Update 클래스:
 * 데이터베이스의 member501 테이블에 저장된 기존 회원 정보를 수정(UPDATE)하는 기능을 구현합니다.
 * _4DBConnectionManager를 사용하여 Connection을 얻고 자원을 해제합니다.
 * 수정할 데이터 자체는 코드 내에서 하드코딩하여 사용합니다.
 */
public class _5JDBC_Update {

    // ====================================================================
    // [1] 프로그램 진입점 (main 메소드) 블록
    // - 자바 프로그램이 시작될 때 가장 먼저 실행되는 부분입니다.
    // ====================================================================
    public static void main(String[] args) {
        System.out.println("[메인 시작] _5JDBC_Update 프로그램 시작");

        // 1-1. 수정할 회원 정보 설정 (하드코딩)
        // **주의: 이 ID는 실제 DB에 존재하는 회원 ID여야 합니다.**
        // _2JDBC_Select.java를 실행하여 현재 테이블에 어떤 ID들이 있는지 확인 후 적절히 변경하세요.
        int memberIdToUpdate = 1; // <<-- 중요: 실제 DB에 존재하는 ID로 변경 필수!
        String newName = "수정_이순신";
        String newPassword = "new_password_1234";
        String newEmail = "new.leesunsin@example.com";
        // DateUtil.getCurrentDateTime()과 같은 유틸리티 사용도 가능 (필요시 import 후 사용)
        // String newRegDate = DateUtil.getCurrentDateTime();

        // 1-2. 데이터 수정 메소드 호출 (static 메소드로 바로 호출)
        // _5JDBC_Update updateInstance = new _5JDBC_Update(); // 인스턴스 생성 불필요 (main에서 직접
        // 호출)
        updateMemberInfo(memberIdToUpdate, newName, newPassword, newEmail);

        System.out.println("[메인 종료] _5JDBC_Update 프로그램 완료");
    }

    // ====================================================================
    // [2] 회원 정보 수정 메소드 블록
    // - 특정 ID의 회원 정보를 수정하는 로직을 담습니다.
    // - _4DBConnectionManager를 사용하여 DB 연결을 관리합니다.
    // - 이 메소드는 static으로 선언하여 main에서 객체 생성 없이 바로 호출 가능합니다.
    // ====================================================================
    /**
     * 특정 ID를 가진 회원의 이름, 비밀번호, 이메일을 수정합니다.
     * 이 메소드는 _4DBConnectionManager를 통해 DB 연결을 얻고 자원을 반납합니다.
     * 
     * @param id       수정할 회원의 ID
     * @param name     새 이름
     * @param password 새 비밀번호
     * @param email    새 이메일
     */
    public static void updateMemberInfo(int id, String name, String password, String email) { // static으로 변경
        // SQL UPDATE 문 정의
        // SET 절에 변경할 컬럼과 값을 지정하고, WHERE 절로 수정 대상을 제한합니다.
        String query = "UPDATE member501 SET name = ?, password = ?, email = ? WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // 2-1. 데이터베이스 연결 얻기 (_4DBConnectionManager의 static 메소드 사용)
            System.out.println("DEBUG: 1. _4DBConnectionManager를 통해 Connection 얻기 시도 중...");
            conn = _4DBConnectionManager.getConnection(); // 객체 생성 없이 클래스명으로 바로 호출!
            System.out.println("DEBUG: 2. Connection 객체 얻기 성공!");

            // 2-2. PreparedStatement 생성
            System.out.println("DEBUG: 3. PreparedStatement 생성 완료.");
            pstmt = conn.prepareStatement(query);

            // 2-3. ? (Placeholder)에 실제 데이터 값 바인딩
            // - SET 절의 순서대로 바인딩하고, 마지막으로 WHERE 절의 조건을 바인딩합니다.
            pstmt.setString(1, name); // 첫 번째 '?' (name)
            pstmt.setString(2, password); // 두 번째 '?' (password)
            pstmt.setString(3, email); // 세 번째 '?' (email)
            pstmt.setInt(4, id); // 네 번째 '?' (WHERE id)

            System.out.println("DEBUG: 4. 데이터 바인딩 완료. 수정 대상 ID: " + id + ", 새 이름: " + name);

            // 2-4. SQL UPDATE 문 실행
            // - executeUpdate() 메소드는 INSERT, UPDATE, DELETE 문을 실행하며,
            // 영향을 받은 행(row)의 개수를 정수(int)로 반환합니다.
            System.out.println("DEBUG: 5. UPDATE 쿼리 실행 시도 중...");
            int rowsAffected = pstmt.executeUpdate(); // 이 부분에서 실제 DB 수정 작업이 수행됩니다.
            System.out.println("DEBUG: 6. UPDATE 쿼리 실행 완료.");

            // 2-5. 실행 결과 확인
            if (rowsAffected > 0) {
                System.out.println("INFO: " + rowsAffected + "개의 행이 성공적으로 업데이트되었습니다!");
                System.out.println("INFO: 수정된 회원 정보 (ID: " + id + ", 새 이름: " + name + ", 새 이메일: " + email + ")");
            } else {
                System.out.println("WARN: 데이터 업데이트에 실패했거나 해당 ID의 회원이 없습니다. (영향받은 행 없음)");
            }

        } catch (SQLException e) {
            // ============================================================
            // [3] 예외 처리 블록 (catch)
            // - 데이터베이스 작업 중 심각한 오류 발생 시 처리합니다.
            // ============================================================
            System.err.println("CRITICAL ERROR: 데이터베이스 작업 중 심각한 오류 발생!");
            System.err.println("오류 코드: " + e.getErrorCode());
            System.err.println("SQL 상태: " + e.getSQLState());
            e.printStackTrace();
        } finally {
            // ============================================================
            // [4] 자원 반납 블록 (finally)
            // - _4DBConnectionManager를 사용하여 JDBC 자원(PreparedStatement, Connection)을 안전하게
            // 닫습니다.
            // - ResultSet이 없으므로 closeResources(PreparedStatement, Connection) 오버로드 메소드를
            // 사용합니다.
            // ============================================================
            System.out.println("DEBUG: 7. _4DBConnectionManager를 통해 JDBC 자원 반납 시도 중...");
            _4DBConnectionManager.closeResources(pstmt, conn); // 객체 생성 없이 클래스명으로 바로 호출!
            System.out.println("DEBUG: 8. 모든 JDBC 자원 반납 완료.");
        }
    }
}