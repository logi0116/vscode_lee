package ch_05_experiments.random_playground.Test001_25050612;

import javax.swing.JFrame; // 창을 만드는 데 필요한 도구 [ V ] (이 도구는 항상 필요해요!)
import javax.swing.JLabel; // 글자를 표시하는 데 필요한 도구 [ V ] (글자를 넣으려면 필요해요!)
// 여기에 나중에 다른 도구들도 추가할 거예요!

public class DarkForest extends JFrame {

    public DarkForest() { // (이 부분이 창이 만들어질 때 실행되는 특별한 곳이에요! 생성자)
        setTitle("어둠의 숲 탐험기"); // [P] 리터럴 (값) 변경 가능 - 숲의 이름을 정하는 마법!
        setSize(600, 400); // [P] 파라미터(값) 변경 가능 - 숲의 크기를 정하는 마법 (가로 600, 세로 400 픽셀)!
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // (창을 닫으면 프로그램도 함께 종료되게 하는 마법! 지금은 이대로!)
        // 여기는 나중에 숲의 내용물들을 추가할 공간이에요!

        setVisible(true); // 이 마법 주문이 없으면 숲이 보이지 않아요!-
    }

    // --- 여기에 새로운 코드를 붙여넣으세요! ---
    public static void main(String[] args) { // 이 부분이 바로 프로그램의 시작점이에요!
        // 숲을 안전하게 만들고 보여주는 마법 주문!
        javax.swing.SwingUtilities.invokeLater(DarkForest::new); // [P] DarkForest::new 부분을 다른 클래스명으로 변경 가능 (예:
                                                                 // MyWebnovelWindow::new)
    }

}
