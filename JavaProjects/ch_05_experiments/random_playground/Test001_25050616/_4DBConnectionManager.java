package ch_05_experiments.random_playground.Test001_25050616;

// 필요한 JDBC 관련 클래스들을 불러옵니다.
import java.sql.Connection; // 데이터베이스 연결을 위한 인터페이스
import java.sql.DriverManager; // JDBC 드라이버 로드 및 연결 관리를 위한 클래스
import java.sql.PreparedStatement; // SQL 쿼리 준비 및 실행을 위한 인터페이스
import java.sql.ResultSet; // SQL 쿼리 결과 집합 인터페이스
import java.sql.SQLException; // SQL 관련 오류 발생 시 예외 처리 클래스
import java.sql.Statement; // 일반적인 SQL 문 실행을 위한 인터페이스 (PreparedStatement의 상위)

/**
 * _4DBConnectionManager 클래스:
 * 데이터베이스 연결 및 자원 해제와 관련된 반복적인 작업을 관리하는 유틸리티 클래스입니다.
 * 이 클래스는 모든 메소드가 'static'으로 선언되어 있어,
 * _4DBConnectionManager.getConnection() 처럼 객체 생성 없이 바로 사용할 수 있습니다.
 * JDBC 드라이버 로딩은 클래스가 메모리에 로드될 때 단 한 번만 수행됩니다.
 * 클래스명에 "_4"가 붙어 학습 순서를 명확히 합니다.
 */
public class _4DBConnectionManager { // 클래스명 변경 완료!

    // ====================================================================
    // [1] 데이터베이스 연결 정보 상수 선언
    // - DB 접속에 필요한 핵심 정보들을 상수로 선언합니다.
    // - 'private static final'로 선언하여 외부에서 접근 불가하고, 변경 불가하며,
    // 메모리에 한 번만 로드되도록 합니다.
    // ====================================================================
    private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String DB_USER = "scott";
    private static final String DB_PASSWORD = "tiger";

    // ====================================================================
    // [2] JDBC 드라이버 로딩 블록 (static 초기화 블록)
    // - 이 'static {}' 블록은 _4DBConnectionManager 클래스가 JVM에 의해 메모리에
    // 로드될 때 단 한 번만 자동으로 실행됩니다.
    // - JDBC 드라이버 로딩처럼 한 번만 필요한 초기화 작업에 적합합니다.
    // ====================================================================
    static {
        System.out.println("DEBUG: _4DBConnectionManager - Static 블록 실행: JDBC 드라이버 로딩 시도 중...");
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver"); // Oracle JDBC 드라이버 로드
            System.out.println("DEBUG: _4DBConnectionManager - JDBC 드라이버 로딩 성공!");
        } catch (ClassNotFoundException e) {
            // 드라이버 클래스를 찾을 수 없을 때 발생하는 예외 처리
            System.err.println("CRITICAL ERROR: _4DBConnectionManager - JDBC 드라이버를 찾을 수 없습니다! CLASSPATH를 확인하세요.");
            System.err.println("오류 상세: " + e.getMessage());
            e.printStackTrace(); // 개발자 디버깅을 위한 스택 트레이스 출력
            // 드라이버 없이는 DB 연결 자체가 불가능하므로, 프로그램 강제 종료를 고려할 수 있습니다.
            // System.exit(1);
        }
    }

    // ====================================================================
    // [3] 데이터베이스 연결 객체 (Connection) 얻기 메소드
    // - 'public static'으로 선언하여 _4DBConnectionManager.getConnection()처럼
    // 클래스 이름으로 바로 호출할 수 있습니다.
    // - DB 연결 정보를 상수로 사용합니다.
    // ====================================================================
    /**
     * 데이터베이스 연결을 생성하고 반환합니다.
     * 
     * @return 성공적으로 연결된 Connection 객체
     * @throws SQLException 데이터베이스 연결 중 오류 발생 시, 호출자에게 예외를 위임합니다.
     */
    public static Connection getConnection() throws SQLException {
        System.out.println("DEBUG: _4DBConnectionManager - Connection 객체 얻기 시도 중...");
        Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        System.out.println("DEBUG: _4DBConnectionManager - Connection 객체 얻기 성공!");
        return conn;
    }

    // ====================================================================
    // [4] JDBC 자원 해제 메소드 (오버로드)
    // - 사용한 JDBC 자원(ResultSet, PreparedStatement, Statement, Connection)을
    // 안전하게 닫는 메소드들입니다.
    // - 'public static'으로 선언하여 객체 생성 없이 바로 호출 가능합니다.
    // - 객체 생성의 역순으로 닫는 것이 안전합니다 (ResultSet -> PreparedStatement/Statement ->
    // Connection).
    // - 각 자원이 null이 아닌지 확인 후 닫아 NullPointerException을 방지합니다.
    // ====================================================================

    /**
     * ResultSet, PreparedStatement, Connection 자원을 닫습니다.
     * 가장 포괄적인 자원 해제 메소드입니다.
     */
    public static void closeResources(ResultSet rs, PreparedStatement pstmt, Connection conn) {
        System.out.println("DEBUG: _4DBConnectionManager - JDBC 자원 해제 (RS, P_STMT, CONN) 시도 중...");
        try {
            if (rs != null) { // ResultSet이 존재하면 닫기
                rs.close();
                System.out.println("DEBUG: _4DBConnectionManager - ResultSet 닫힘.");
            }
        } catch (SQLException e) {
            System.err.println("ERROR: _4DBConnectionManager - ResultSet 닫기 오류: " + e.getMessage());
            e.printStackTrace();
        }
        try {
            if (pstmt != null) { // PreparedStatement가 존재하면 닫기
                pstmt.close();
                System.out.println("DEBUG: _4DBConnectionManager - PreparedStatement 닫힘.");
            }
        } catch (SQLException e) {
            System.err.println("ERROR: _4DBConnectionManager - PreparedStatement 닫기 오류: " + e.getMessage());
            e.printStackTrace();
        }
        try {
            if (conn != null) { // Connection이 존재하면 닫기
                conn.close();
                System.out.println("DEBUG: _4DBConnectionManager - Connection 닫힘.");
            }
        } catch (SQLException e) {
            System.err.println("ERROR: _4DBConnectionManager - Connection 닫기 오류: " + e.getMessage());
            e.printStackTrace();
        }
        System.out.println("DEBUG: _4DBConnectionManager - 모든 JDBC 자원 해제 완료 (RS, P_STMT, CONN).");
    }

    /**
     * PreparedStatement, Connection 자원을 닫습니다. (ResultSet이 없는 경우)
     */
    public static void closeResources(PreparedStatement pstmt, Connection conn) {
        // 내부적으로 ResultSet이 null인 상태로 위의 더 포괄적인 메소드를 호출합니다.
        closeResources(null, pstmt, conn);
    }

    /**
     * Statement, Connection 자원을 닫습니다. (PreparedStatement 대신 Statement 사용 시)
     * Statement는 PreparedStatement와는 별개이므로 오버로드합니다.
     */
    public static void closeResources(Statement stmt, Connection conn) {
        System.out.println("DEBUG: _4DBConnectionManager - JDBC 자원 해제 (STMT, CONN) 시도 중...");
        try {
            if (stmt != null) {
                stmt.close();
                System.out.println("DEBUG: _4DBConnectionManager - Statement 닫힘.");
            }
        } catch (SQLException e) {
            System.err.println("ERROR: _4DBConnectionManager - Statement 닫기 오류: " + e.getMessage());
            e.printStackTrace();
        }
        try {
            if (conn != null) {
                conn.close();
                System.out.println("DEBUG: _4DBConnectionManager - Connection 닫힘.");
            }
        } catch (SQLException e) {
            System.err.println("ERROR: _4DBConnectionManager - Connection 닫기 오류: " + e.getMessage());
            e.printStackTrace();
        }
        System.out.println("DEBUG: _4DBConnectionManager - 모든 JDBC 자원 해제 완료 (STMT, CONN).");
    }
}