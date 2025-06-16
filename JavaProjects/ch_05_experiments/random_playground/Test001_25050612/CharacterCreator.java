// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.*;
// import java.util.HashMap;
// import java.util.Map;
// import java.util.Random;

// public class CharacterCreator extends JFrame {
//     private JComboBox<String> classBox;
//     private JTextField strField, dexField, intField, wisField, luckField;
//     private JLabel imageLabel, flavorTextLabel, totalStatLabel, remainingStatLabel;
//     private static final int MIN_STAT = 1;
//     private static final int MAX_STAT = 20;
//     private static final int MAX_TOTAL_STAT = 30;

//     private Map<String, int[]> classStats = new HashMap<>();
//     private Map<String, String> classFlavor = new HashMap<>();

//     public CharacterCreator() {
//         setTitle("RPG 캐릭터 생성기");
//         setSize(600, 700);
//         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         setLayout(new BorderLayout());

//         initClassStats();
//         add(buildMainPanel(), BorderLayout.CENTER);
//         setVisible(true);
//     }

//     private void initClassStats() {
//         classStats.put("전사", new int[]{10, 8, 3, 3, 3});
//         classStats.put("마법사", new int[]{3, 3, 10, 8, 3});
//         classStats.put("궁수", new int[]{6, 10, 5, 3, 3});
//         classStats.put("성직자", new int[]{3, 5, 6, 10, 3});
//         classStats.put("도적", new int[]{4, 9, 4, 3, 5});
//         classStats.put("기사", new int[]{9, 5, 4, 4, 3});
//         classStats.put("사냥꾼", new int[]{6, 8, 4, 3, 4});
//         classStats.put("흑마법사", new int[]{3, 3, 12, 6, 3});
//         classStats.put("수도승", new int[]{5, 6, 5, 7, 3});
//         classStats.put("연금술사", new int[]{4, 4, 7, 8, 3});

//         classFlavor.put("전사", "\"난 언제나 최전선에서 싸운다!\"");
//         classFlavor.put("마법사", "\"지식은 가장 강한 무기다.\"");
//         classFlavor.put("궁수", "\"멀리서 조용히 끝내주는 게 내 방식이지.\"");
//         classFlavor.put("성직자", "\"신의 뜻을 전하리라.\"");
//         classFlavor.put("도적", "\"조용히, 그리고 치명적으로.\"");
//         classFlavor.put("기사", "\"명예를 위하여!\"");
//         classFlavor.put("사냥꾼", "\"자연은 나의 동료다.\"");
//         classFlavor.put("흑마법사", "\"어둠이여, 나에게 힘을!\"");
//         classFlavor.put("수도승", "\"몸과 마음의 수련이 곧 힘이다.\"");
//         classFlavor.put("연금술사", "\"변화는 손끝에서 일어난다.\"");
//     }

//     private JPanel buildMainPanel() {
//         JPanel panel = new JPanel();
//         panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

//         JPanel classPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
//         classBox = new JComboBox<>(classStats.keySet().toArray(new String[0]));
//         JButton applyClassBtn = new JButton("직업 적용");
//         applyClassBtn.addActionListener(e -> applyClassStats());
//         flavorTextLabel = new JLabel("\"클래스를 선택해주세요.\"");
//         classPanel.add(new JLabel("직업 선택:"));
//         classPanel.add(classBox);
//         classPanel.add(applyClassBtn);

//         JPanel statsPanel = new JPanel(new GridLayout(5, 4, 5, 5));
//         strField = new JTextField();
//         dexField = new JTextField();
//         intField = new JTextField();
//         wisField = new JTextField();
//         luckField = new JTextField();

//         JButton strRandBtn = new JButton("🎲");
//         strRandBtn.addActionListener(e -> showRollingDialog(strField));

//         JButton dexRandBtn = new JButton("🎲");
//         dexRandBtn.addActionListener(e -> showRollingDialog(dexField));

//         JButton intRandBtn = new JButton("🎲");
//         intRandBtn.addActionListener(e -> showRollingDialog(intField));

//         JButton wisRandBtn = new JButton("🎲");
//         wisRandBtn.addActionListener(e -> showRollingDialog(wisField));

//         JButton luckRandBtn = new JButton("🎲");
//         luckRandBtn.addActionListener(e -> showRollingDialog(luckField));

//         statsPanel.add(new JLabel("힘 (STR):")); statsPanel.add(strField); statsPanel.add(strRandBtn);
//         statsPanel.add(new JLabel("민첩 (DEX):")); statsPanel.add(dexField); statsPanel.add(dexRandBtn);
//         statsPanel.add(new JLabel("지능 (INT):")); statsPanel.add(intField); statsPanel.add(intRandBtn);
//         statsPanel.add(new JLabel("지혜 (WIS):")); statsPanel.add(wisField); statsPanel.add(wisRandBtn);
//         statsPanel.add(new JLabel("운 (LUCK):")); statsPanel.add(luckField); statsPanel.add(luckRandBtn);

//         JPanel controlPanel = new JPanel(new FlowLayout());
//         JButton randomBtn = new JButton("전체 랜덤 배정");
//         randomBtn.addActionListener(e -> rollAllStats());

//         JButton imageBtn = new JButton("캐릭터 이미지 선택");
//         imageBtn.addActionListener(e -> selectImage());

//         totalStatLabel = new JLabel("총합: 0");
//         remainingStatLabel = new JLabel("남은 포인트: " + MAX_TOTAL_STAT);

//         controlPanel.add(randomBtn);
//         controlPanel.add(imageBtn);
//         controlPanel.add(totalStatLabel);
//         controlPanel.add(remainingStatLabel);

//         imageLabel = new JLabel("이미지 미지정", JLabel.CENTER);

//         panel.add(classPanel);
//         panel.add(flavorTextLabel);
//         panel.add(statsPanel);
//         panel.add(controlPanel);
//         panel.add(imageLabel);

//         return panel;
//     }

//     private void applyClassStats() {
//         String selected = (String) classBox.getSelectedItem();
//         int[] stats = classStats.get(selected);
//         flavorTextLabel.setText(classFlavor.getOrDefault(selected, ""));

//         strField.setText(String.valueOf(stats[0]));
//         dexField.setText(String.valueOf(stats[1]));
//         intField.setText(String.valueOf(stats[2]));
//         wisField.setText(String.valueOf(stats[3]));
//         luckField.setText(String.valueOf(stats[4]));

//         updateStatSum();
//     }

//     private void rollAllStats() {
//         strField.setText(String.valueOf(randomStat()));
//         dexField.setText(String.valueOf(randomStat()));
//         intField.setText(String.valueOf(randomStat()));
//         wisField.setText(String.valueOf(randomStat()));
//         luckField.setText(String.valueOf(randomStat()));
//         updateStatSum();
//     }

//     private int randomStat() {
//         return new Random().nextInt(MAX_STAT - MIN_STAT + 1) + MIN_STAT;
//     }

//     private void selectImage() {
//         JFileChooser chooser = new JFileChooser();
//         int result = chooser.showOpenDialog(this);
//         if (result == JFileChooser.APPROVE_OPTION) {
//             ImageIcon icon = new ImageIcon(chooser.getSelectedFile().getPath());
//             imageLabel.setIcon(new ImageIcon(icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
//             imageLabel.setText("");
//         }
//     }

//     private void showRollingDialog(JTextField targetField) {
//         JDialog dialog = new JDialog(this, "주사위 굴리는 중", true);
//         dialog.setSize(200, 100);
//         dialog.setLocationRelativeTo(this);
//         JLabel rollingLabel = new JLabel("", JLabel.CENTER);
//         dialog.add(rollingLabel);

//         new Thread(() -> {
//             Random rand = new Random();
//             for (int i = 0; i < 20; i++) {
//                 int roll = randomStat();
//                 rollingLabel.setText("🎲 " + roll);
//                 try {
//                     Thread.sleep(50 + i * 5);
//                 } catch (InterruptedException e) {
//                     e.printStackTrace();
//                 }
//             }
//             int finalValue = randomStat();
//             rollingLabel.setText("결과: " + finalValue);
//             targetField.setText(String.valueOf(finalValue));

//             try {
//                 Thread.sleep(500);
//             } catch (InterruptedException e) {
//                 e.printStackTrace();
//             }
//             dialog.dispose();
//             updateStatSum();
//         }).start();

//         dialog.setVisible(true);
//     }

//     private void updateStatSum() {
//         try {
//             int total = Integer.parseInt(strField.getText()) + Integer.parseInt(dexField.getText()) +
//                         Integer.parseInt(intField.getText()) + Integer.parseInt(wisField.getText()) +
//                         Integer.parseInt(luckField.getText());
//             totalStatLabel.setText("총합: " + total);
//             int remaining = MAX_TOTAL_STAT - total;
//             remainingStatLabel.setText("남은 포인트: " + remaining);
//             if (total > MAX_TOTAL_STAT) {
//                 JOptionPane.showMessageDialog(this, "스탯 총합이 " + MAX_TOTAL_STAT + "을 초과했습니다!", "오류", JOptionPane.ERROR_MESSAGE);
//             }
//         } catch (NumberFormatException e) {
//             totalStatLabel.setText("총합: 오류");
//             remainingStatLabel.setText("남은 포인트: 오류");
//         }
//     }

//     public static void main(String[] args) {
//         SwingUtilities.invokeLater(CharacterCreator::new);
//     }
// }
