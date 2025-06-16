package ch_05_experiments.random_playground.Test001_25050612;

import javax.swing.JFrame; // 창을 만드는 데 필요한 도구
import javax.swing.JLabel; // 글자를 표시하는 데 필요한 도구
// 여기에 나중에 다른 도구들도 추가할 거예요!

public class MyWebnovelWindow extends JFrame {
    // 여기에 창의 내용물이 들어갈 거예요!
    public MyWebnovelWindow() { // 이 부분이 창이 만들어질 때 실행되는 특별한 곳이에요!
        setTitle("오직 나만이 웹소설 창을 열 수 있다"); // 창의 제목을 정하는 마법!
        setSize(880, 800); // 창의 크기를 정하는 마법 (가로 400, 세로 200 픽셀)!
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창을 닫으면 프로그램도 함께 종료되게 하는 마법!
        // 여기는 나중에 내용물들을 추가할 공간이에요!

        // --- 여기에 새로운 코드를 붙여넣으세요! ---
        JLabel titleLabel = new JLabel("웹소설 제목: GUI 그래픽 창은 생각보다 깔끔하다"); // 웹소설 제목을 표시할 표지판
        JLabel authorLabel = new JLabel("코딩 마법"); // 작가 이름을 표시할 표지판

        add(titleLabel); // 제목 표지판을 창에 추가하는 마법!
        add(authorLabel); // 작가 표지판을 창에 추가하는 마법!
        // ------------------------------------

        setVisible(true); // 이 마법 주문이 없으면 창이 보이지 않아요!
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(MyWebnovelWindow::new);

    }

}