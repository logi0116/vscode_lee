package ch_05_experiments.random_playground.Test001_25050616;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class _2JDBC_Select {

    String url = "jdbc:oracle:thin:@localhost:1521:xe";
    String user = "scott";
    String password = "tiger";

    public static void main(String[] args) {
        _2JDBC_Select jdbcSelect = new _2JDBC_Select();
        jdbcSelect.executeSelect();
    }

    public void executeSelect() {
        String query = "SELECT id, name, email, password, reg_date FROM member501";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(url, user, password);
            pstmt = conn.prepareStatement(query);
            rs = pstmt.executeQuery();

            System.out.println("--- member501 테이블 조회 결과 ---");
            System.out.println("ID\tNAME\tEMAIL\t\tPASSWORD\tREG_DATE");
            System.out.println("---------------------------------------------------------");

            boolean hasData = false;

            while (rs.next()) {
                hasData = true;

                int id = rs.getInt("ID");
                String name = rs.getString("NAME");
                String email = rs.getString("EMAIL");
                String password = rs.getString("PASSWORD"); // 컬럼명이 PASSWORD인지 PASSWORD2인지 다시 한번 확인!

                String regDateStr = rs.getString("REG_DATE"); // 문자열로 가져옴

                Timestamp regDate = null;

                try {
                    // **** 여기가 핵심 수정 부분 ****
                    // 로기님의 실제 날짜 문자열 형식 '2025년06월16일12시09분'에 맞는 패턴으로 변경!
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년MM월dd일HH시mm분");
                    LocalDateTime localDateTime = LocalDateTime.parse(regDateStr, formatter);
                    regDate = Timestamp.valueOf(localDateTime);

                } catch (DateTimeParseException parseE) {
                    System.err.println(
                            "경고: REG_DATE 문자열 '" + regDateStr + "'을 날짜/시간으로 변환할 수 없습니다. " + parseE.getMessage());
                    regDate = null; // 변환 실패 시 null 처리
                } catch (NullPointerException e) {
                    System.err.println("REG_DATE 값이 null입니다.");
                    regDate = null;
                }

                System.out.printf("%d\t%s\t%s\t%s\t%s%n", id, name, email, password, regDate);
            }

            if (!hasData) {
                System.out.println("member501 테이블에 조회된 데이터가 없습니다.");
            }
            System.out.println("---------------------------------------------------------");

        } catch (SQLException e) {
            System.err.println("데이터베이스 작업 중 오류 발생!");
            System.err.println("오류 코드: " + e.getErrorCode());
            System.err.println("SQL 상태: " + e.getSQLState());
            e.printStackTrace();

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                System.err.println("ResultSet 닫기 오류: " + e.getMessage());
            }

            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException e) {
                System.err.println("PreparedStatement 닫기 오류: " + e.getMessage());
            }

            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.err.println("Connection 닫기 오류: " + e.getMessage());
            }
            System.out.println("모든 DB 자원이 반납되었습니다.");
        }
    }
}