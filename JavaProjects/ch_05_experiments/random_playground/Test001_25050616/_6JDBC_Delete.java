package ch_05_experiments.random_playground.Test001_25050616;

// 필요한 JDBC 관련 클래스들을 불러옵니다.
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * _6JDBC_Delete 클래스:
 * 데이터베이스의 member501 테이블에서 기존 회원 정보를 삭제(DELETE)하는 기능을 구현합니다.
 * _4DBConnectionManager를 사용하여 Connection을 얻고 자원을 해제합니다.
 * 삭제할 대상 데이터는 코드 내에서 하드코딩하여 사용합니다.
 */
public class _6JDBC_Delete {

    // ====================================================================
    // [1] 프로그램 진입점 (main 메소드) 블록
    // - 자바 프로그램이 시작될 때 가장 먼저 실행되는 부분입니다.
    // ====================================================================
    public static void main(String[] args) {
        System.out.println("[메인 시작] _6JDBC_Delete 프로그램 시작");

        // 1-1. 삭제할 회원의 ID 설정 (하드코딩)
        // **주의: 이 ID는 실제 DB에 존재하는 회원 ID여야 하며, 삭제될 데이터입니다.**
        // 삭제 전 _2JDBC_Select.java를 실행하여 삭제될 데이터를 확인하는 것이 좋습니다.
        int memberIdToDelete = 1; // <<-- 중요: 실제 DB에 존재하는 ID로 변경 필수!

        // 1-2. 데이터 삭제 메소드 호출 (static 메소드로 바로 호출)
        deleteMemberById(memberIdToDelete);

        System.out.println("[메인 종료] _6JDBC_Delete 프로그램 완료");
    }

    // ====================================================================
    // [2] 회원 정보 삭제 메소드 블록
    // - 특정 ID의 회원 정보를 삭제하는 로직을 담습니다.
    // - _4DBConnectionManager를 사용하여 DB 연결을 관리합니다.
    // - 이 메소드는 static으로 선언하여 main에서 객체 생성 없이 바로 호출 가능합니다.
    // ====================================================================
    /**
     * 특정 ID를 가진 회원을 데이터베이스에서 삭제합니다.
     * 이 메소드는 _4DBConnectionManager를 통해 DB 연결을 얻고 자원을 반납합니다.
     * 
     * @param id 삭제할 회원의 ID
     */
    public static void deleteMemberById(int id) { // static으로 변경
        // SQL DELETE 문 정의
        // WHERE 절을 사용하여 특정 ID의 회원만 삭제하도록 합니다.
        // WHERE 절이 없으면 모든 데이터가 삭제되므로 매우 주의해야 합니다.
        String query = "DELETE FROM member501 WHERE id = ?"; // <<-- DELETE 쿼리 작성!

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // 2-1. 데이터베이스 연결 얻기 (_4DBConnectionManager의 static 메소드 사용)
            System.out.println("DEBUG: 1. _4DBConnectionManager를 통해 Connection 얻기 시도 중...");
            conn = _4DBConnectionManager.getConnection();
            System.out.println("DEBUG: 2. Connection 객체 얻기 성공!");

            // 2-2. PreparedStatement 생성
            System.out.println("DEBUG: 3. PreparedStatement 생성 완료.");
            pstmt = conn.prepareStatement(query);

            // 2-3. ? (Placeholder)에 실제 데이터 값 바인딩
            // - WHERE 절의 조건을 바인딩합니다.
            pstmt.setInt(1, id); // 첫 번째 '?' (WHERE id)

            System.out.println("DEBUG: 4. 데이터 바인딩 완료. 삭제 대상 ID: " + id);

            // 2-4. SQL DELETE 문 실행
            // - executeUpdate() 메소드는 INSERT, UPDATE, DELETE 문을 실행하며,
            // 영향을 받은 행(row)의 개수를 정수(int)로 반환합니다.
            System.out.println("DEBUG: 5. DELETE 쿼리 실행 시도 중...");
            int rowsAffected = pstmt.executeUpdate(); // 이 부분에서 실제 DB 삭제 작업이 수행됩니다.
            System.out.println("DEBUG: 6. DELETE 쿼리 실행 완료.");

            // 2-5. 실행 결과 확인
            if (rowsAffected > 0) {
                System.out.println("INFO: " + rowsAffected + "개의 행이 성공적으로 삭제되었습니다! (ID: " + id + ")");
            } else {
                System.out.println("WARN: 데이터 삭제에 실패했거나 해당 ID의 회원이 없습니다. (영향받은 행 없음)");
            }

        } catch (SQLException e) {
            // ============================================================
            // [3] 예외 처리 블록 (catch)
            // - 데이터베이스 작업 중 심각한 오류 발생 시 처리합니다.
            // ============================================================
            System.err.println("CRITICAL ERROR: 데이터베이스 작업 중 심각한 오류 발생!");
            System.err.println("오류 코드: " + e.getErrorCode());
            System.err.println("SQL 상태: " + e.getSQLState());
            e.printStackTrace(); // 로기님 요청대로 스택 트레이스 출력
        } finally {
            // ============================================================
            // [4] 자원 반납 블록 (finally)
            // - _4DBConnectionManager를 사용하여 JDBC 자원(PreparedStatement, Connection)을 안전하게
            // 닫습니다.
            // - ResultSet이 없으므로 closeResources(PreparedStatement, Connection) 오버로드 메소드를
            // 사용합니다.
            // ============================================================
            System.out.println("DEBUG: 7. _4DBConnectionManager를 통해 JDBC 자원 반납 시도 중...");
            // 로기님 요청대로 간결하게 한 줄로! rs는 null이므로 pstmt, conn만 전달
            _4DBConnectionManager.closeResources(pstmt, conn);
            System.out.println("DEBUG: 8. 모든 JDBC 자원 반납 완료.");
        }
    }
}