package ch_05_experiments.random_playground.Test001_25050616;

// 필요한 JDBC 관련 클래스들을 불러옵니다.
import java.sql.Connection; // 데이터베이스 연결을 위한 인터페이스
import java.sql.DriverManager; // JDBC 드라이버 로드 및 연결 관리를 위한 클래스
import java.sql.PreparedStatement; // SQL 쿼리 준비 및 실행을 위한 인터페이스 (보안 및 성능에 유리)
import java.sql.SQLException; // SQL 관련 오류 발생 시 예외 처리 클래스
import java.sql.Timestamp; // SQL TIMESTAMP 타입에 매핑되는 자바 클래스

// 날짜/시간 처리를 위한 자바 8+ API 클래스들을 불러옵니다.
import java.time.LocalDateTime; // 날짜와 시간을 표현하는 클래스
import java.time.format.DateTimeFormatter; // 날짜/시간을 특정 형식의 문자열로 변환/파싱하는 클래스
import java.time.format.DateTimeParseException; // 날짜/시간 문자열 파싱 오류 시 예외 처리 클래스

public class _3JDBC_Insert {

    // ====================================================================
    // [1] 데이터베이스 연결 정보 설정 블록
    // - DB 접속에 필요한 핵심 정보들을 필드(멤버 변수)로 선언합니다.
    // - 이 정보들은 프로그램 전체에서 사용될 수 있습니다.
    // ====================================================================
    String url = "jdbc:oracle:thin:@localhost:1521:xe"; // Oracle DB 연결 URL
    String user = "scott"; // DB 사용자 이름
    String password = "tiger"; // DB 사용자 비밀번호

    // ====================================================================
    // [2] 프로그램 진입점 (main 메소드) 블록
    // - 자바 프로그램이 시작될 때 가장 먼저 실행되는 부분입니다.
    // - 여기서 _3JDBC_Insert 객체를 생성하고, 데이터 삽입 메소드를 호출합니다.
    // ====================================================================
    public static void main(String[] args) {
        System.out.println("[메인 시작] _3JDBC_Insert 객체 생성 및 메소드 호출");
        _3JDBC_Insert jdbcInsert = new _3JDBC_Insert(); // 현재 클래스의 인스턴스 생성
        jdbcInsert.executeInsertWithSequence(); // 시퀀스를 사용하여 데이터를 삽입하는 메소드 호출
        System.out.println("[메인 종료] 프로그램 실행 완료");
    }

    // ====================================================================
    // [3] 데이터 삽입 메소드 (시퀀스 자동 순번 사용) 블록
    // - 이 메소드 안에 데이터베이스 연결, SQL 실행, 자원 반납 등 모든 로직이 포함됩니다.
    // ====================================================================
    public void executeInsertWithSequence() {
        // SQL INSERT 문 정의 (PreparedStatement를 위해 VALUES 절에 ? 사용)
        // ID 컬럼에는 데이터베이스 시퀀스(member501_seq)의 다음 값(NEXTVAL)을 직접 사용합니다.
        // 따라서 자바 코드에서 ID 값을 따로 바인딩할 필요가 없습니다.
        String query = "INSERT INTO member501 (id, name, email, password, reg_date) " +
                "VALUES (member501_seq.NEXTVAL, ?, ?, ?, ?)";

        // JDBC 관련 객체들을 선언합니다.
        // 이 객체들은 try-catch-finally 구조에서 안전하게 닫기 위해 try 블록 외부에 선언합니다.
        Connection conn = null; // 데이터베이스 연결 객체
        PreparedStatement pstmt = null; // SQL 쿼리 실행 객체 (INSERT 문 준비)

        // ================================================================
        // [4] 데이터베이스 연결 및 SQL 실행 블록 (try-catch로 예외 처리)
        // - 데이터베이스 작업 중 발생할 수 있는 오류(SQLException)를 처리합니다.
        // ================================================================
        try {
            // 4-1. 데이터베이스 연결 시도
            System.out.println("DEBUG: 1. 데이터베이스 연결 시도 중...");
            conn = DriverManager.getConnection(url, user, password); // 설정된 URL, 사용자, 비밀번호로 DB 연결
            System.out.println("DEBUG: 2. 데이터베이스 연결 성공!");

            // 4-2. PreparedStatement 생성
            // - 정의된 SQL 쿼리 문자열을 DB에 전달하여 미리 준비(Pre-compile)시킵니다.
            System.out.println("DEBUG: 3. PreparedStatement 생성 완료.");
            pstmt = conn.prepareStatement(query);

            // 4-3. ? (Placeholder)에 실제 데이터 값 바인딩
            // - ID는 시퀀스가 자동으로 채우므로, name, email, password, reg_date만 바인딩합니다.
            // - pstmt.setXXX(인덱스, 값)에서 인덱스는 SQL 쿼리 내 ?의 순서(1부터 시작)입니다.
            String newName = "자동순번회원_" + System.currentTimeMillis() % 1000; // 고유한 이름을 위해 타임스탬프 일부 사용
            String newEmail = "auto_" + (System.currentTimeMillis() % 1000) + "@example.com";
            String newPassword = "auto_pass";

            // 현재 날짜와 시간을 가져와서 특정 형식의 문자열로 변환합니다.
            LocalDateTime now = LocalDateTime.now(); // 현재 날짜 및 시간 객체 생성
            DateTimeFormatter dbFormatter = DateTimeFormatter.ofPattern("yyyy년MM월dd일HH시mm분");
            String newRegDateStr = now.format(dbFormatter); // 현재 시간을 "yyyy년MM월dd일HH시mm분" 형식의 문자열로 변환

            // 날짜 문자열을 SQL의 TIMESTAMP 타입에 맞는 Timestamp 객체로 변환합니다.
            Timestamp newRegDate = null;
            try {
                DateTimeFormatter parseFormatter = DateTimeFormatter.ofPattern("yyyy년MM월dd일HH시mm분");
                LocalDateTime localDateTime = LocalDateTime.parse(newRegDateStr, parseFormatter);
                newRegDate = Timestamp.valueOf(localDateTime); // LocalDateTime을 Timestamp로 변환
                System.out.println("DEBUG: 변환된 등록일 Timestamp: " + newRegDate);
            } catch (DateTimeParseException e) {
                // 날짜 문자열 파싱 중 오류 발생 시 예외 처리
                System.err.println("ERROR: 날짜 문자열 변환 오류! 포맷을 확인하세요: " + e.getMessage());
                newRegDate = new Timestamp(System.currentTimeMillis()); // 오류 시 현재 시스템 시간으로 대체
                System.err.println("ERROR: 등록일이 현재 시간으로 대체됨: " + newRegDate);
            }

            // 바인딩 실행 (ID는 시퀀스가 처리하므로 여기서는 1번부터 시작)
            pstmt.setString(1, newName); // 첫 번째 '?'에 newName 바인딩
            pstmt.setString(2, newEmail); // 두 번째 '?'에 newEmail 바인딩
            pstmt.setString(3, newPassword); // 세 번째 '?'에 newPassword 바인딩
            pstmt.setTimestamp(4, newRegDate); // 네 번째 '?'에 newRegDate 바인딩

            System.out.println("DEBUG: 4. 데이터 바인딩 완료. 삽입될 이름: " + newName + ", 등록일: " + newRegDate);

            // 4-4. SQL INSERT 문 실행
            // - executeUpdate() 메소드는 INSERT, UPDATE, DELETE 문을 실행하며,
            // 영향을 받은 행(row)의 개수를 정수(int)로 반환합니다.
            System.out.println("DEBUG: 5. INSERT 쿼리 실행 시도 중...");
            int rowsAffected = pstmt.executeUpdate(); // <-- 이 부분에서 실제 DB 작업이 수행됩니다.
            System.out.println("DEBUG: 6. INSERT 쿼리 실행 완료.");

            // 4-5. 실행 결과 확인
            if (rowsAffected > 0) {
                System.out.println("INFO: " + rowsAffected + "개의 행이 시퀀스를 이용하여 성공적으로 삽입되었습니다!");
                System.out.println("INFO: 삽입된 회원 정보 (이름: " + newName + ", 이메일: " + newEmail + ")");
                // 시퀀스 ID는 직접 알 수 없지만, 삽입 성공을 확인.
            } else {
                System.out.println("WARN: 데이터 삽입에 실패했습니다. (영향받은 행 없음)");
            }

        } catch (SQLException e) {
            // ============================================================
            // [5] 예외 처리 블록 (catch)
            // - 데이터베이스 작업 중 발생한 SQLException을 여기서 잡아서 처리합니다.
            // - 오류 발생 시 사용자에게 친숙한 메시지를 보여주거나, 로깅 시스템에 기록합니다.
            // ============================================================
            System.err.println("CRITICAL ERROR: 데이터베이스 작업 중 심각한 오류 발생!");
            System.err.println("오류 코드: " + e.getErrorCode()); // DB 시스템 고유의 오류 코드
            System.err.println("SQL 상태: " + e.getSQLState()); // SQLState (표준화된 오류 코드)
            e.printStackTrace(); // 개발자 디버깅을 위한 상세 스택 트레이스 출력
        } finally {
            // ============================================================
            // [6] 자원 반납 블록 (finally)
            // - try 블록에서 예외가 발생하든 안 하든, 항상 실행되는 블록입니다.
            // - DB 연결 자원(Connection, PreparedStatement)을 안전하게 닫아줍니다.
            // - 객체 생성 역순으로 닫고, null 체크를 통해 NullPointerException을 방지합니다.
            // ============================================================
            System.out.println("DEBUG: 7. DB 자원 반납 시도 중...");
            try {
                if (pstmt != null) { // PreparedStatement 객체가 생성되었으면 닫기
                    pstmt.close();
                    System.out.println("DEBUG: PreparedStatement 닫힘.");
                }
            } catch (SQLException e) {
                System.err.println("ERROR: PreparedStatement 닫기 오류: " + e.getMessage());
            }

            try {
                if (conn != null) { // Connection 객체가 생성되었으면 닫기
                    conn.close();
                    System.out.println("DEBUG: Connection 닫힘.");
                }
            } catch (SQLException e) {
                System.err.println("ERROR: Connection 닫기 오류: " + e.getMessage());
            }
            System.out.println("DEBUG: 8. 모든 DB 자원이 반납되었습니다.");
        }
    }
}