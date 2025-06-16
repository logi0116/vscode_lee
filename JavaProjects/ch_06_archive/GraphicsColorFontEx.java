import javax.swing.*; // 스윙 라이브러리 임포트 (GUI 구성 요소)
import java.awt.*; // AWT 라이브러리 임포트 (그래픽 관련 기능)

public class GraphicsColorFontEx extends JFrame { // JFrame을 확장하여 GUI 창 생성
    public GraphicsColorFontEx() { // 생성자
        setTitle("문자열, Color, Font 사용 예제"); // 윈도우 제목 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 닫기 버튼 클릭 시 프로그램 종료
        setContentPane(new MyPanel()); // JPanel을 이용하여 화면 구성
        setSize(300, 300); // 창 크기 설정
        setVisible(true); // 창을 화면에 표시
    }

    // 📌 커스텀 JPanel 생성 (그래픽 출력)
    class MyPanel extends JPanel {
        public void paintComponent(Graphics g) { // 그래픽을 그리는 메서드 오버라이드
            super.paintComponent(g); // 기본적인 페인트 메서드 호출

            g.setColor(Color.BLUE); // 색상을 파란색으로 설정
            g.drawString("문자열 출력", 30, 30); // 문자열을 (30, 30) 위치에 출력

            g.setColor(new Color(255, 0, 0)); // 색상을 빨간색으로 설정 (RGB 값 사용)
            g.setFont(new Font("고딕체", Font.CENTER_BASELINE, 30)); // 글꼴을 Arial, 이탤릭체, 크기 30으로 설정
            g.drawString("얼마면 돼?", 30, 70); // 문자열을 (30, 70) 위치에 출력

            g.setColor(new Color(0x8F00FF)); // 색상을 보라색으로 설정 (16진수 코드 사용)

            // 반복문을 사용하여 다양한 크기의 폰트로 문자열 출력
            for (int i = 1; i <= 4; i++) {
                g.setFont(new Font("Jokerman", Font.ITALIC, i * 10)); // 글꼴을 Jokerman, 이탤릭체, 크기 증가
                g.drawString("얼마면 돼!!", 30, 60 + i * 40); // 문자열 위치 조정하면서 출력
            }
        }
    }

    public static void main(String[] args) { // 프로그램 실행 메서드
        new GraphicsColorFontEx(); // 인스턴스를 생성하여 창을 띄움
    }
}
