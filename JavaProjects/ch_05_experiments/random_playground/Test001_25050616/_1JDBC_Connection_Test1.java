
package ch_05_experiments.random_playground.Test001_25050616;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

// 자바, 오라클 디비 서버 연결 설정 확인 테스트, 
// 준비물
// 1) 오라클 연결 드라이버, lib -> ojdbc8_g.jar 
// 2) vscode 특성상, 해당 라이브러리 경로 지정, 
// .vscode -> settings.json 파일 생성, 경로 지정
// 3) 드라이버 연결 테스트 
// 4) 오라클 디비 서버의 기본 정보 및 서버 켜기 
// 유저 : scott, password : tiger 
// 디비서버 주소 : localhost, port : 1521 
// 서비스 : xe
public class _1JDBC_Connection_Test1 {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 디비 서버 아이피, 포트, 서비스 이름
        String user = "scott"; // 접속할 유저
        String password = "tiger"; // 패스워드

        // 디비 서버에 네트워크 연결 요청을 해서, try ~ catch, try ~ resource 구문을 이용하기.
        try (Connection conn = DriverManager.getConnection(url, user, password);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("select sysdate from dual")) {
            if (rs.next()) {
                System.out.println("현재 시간 : " + rs.getTimestamp(1));
            }

        } catch (Exception e) {
            // TODO: handle exception
        }

    }
}
