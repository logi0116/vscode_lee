package ch_05_experiments.random_playground.Test001_25050612;

import java.awt.*;
import java.util.ArrayList;
import java.awt.event.*;
import javax.swing.*;

public class MagicGallery extends JFrame {
    private ArrayList<ImageIcon> images;
    private ArrayList<String> titles;
    private int currentIndex = 0;

    private JLabel titleLabel;
    private JLabel imageLabel;
    private JPanel thumbnailPanel;

    public MagicGallery(ArrayList<ImageIcon> images, ArrayList<String> titles) {
        this.images = images;
        this.titles = titles;

        setTitle("이미지 갤러리 예시");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLayout(new BorderLayout());

        // 제목 라벨 (폰트: 맑은 고딕)
        titleLabel = new JLabel("", SwingConstants.CENTER);
        titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        add(titleLabel, BorderLayout.NORTH);

        // 이미지 라벨
        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(imageLabel, BorderLayout.CENTER);

        // ...existing code...

        // ...existing code...

        // 네비게이션, 버튼 + 썸네일 패널을 하나의 southPanel에 담기
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new BorderLayout());

        // 네비게이션 패널 (이전/다음 버튼)
        JPanel navPanel = new JPanel();
        JButton preBtn = new JButton("이전");
        JButton nextBtn = new JButton("다음");
        navPanel.add(preBtn);
        navPanel.add(nextBtn);
        southPanel.add(navPanel, BorderLayout.NORTH);

        // 썸네일 패널
        thumbnailPanel = new JPanel();
        thumbnailPanel.setLayout(new FlowLayout());
        southPanel.add(thumbnailPanel, BorderLayout.CENTER);

        // southPanel을 프레임의 SOUTH에 추가
        add(southPanel, BorderLayout.SOUTH);

        // ...이후 코드는 동일...

        // 버튼 이벤트
        preBtn.addActionListener(e -> showImage(currentIndex - 1));
        nextBtn.addActionListener(e -> showImage(currentIndex + 1));

        loadThumbnails();
        showImage(0);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void showImage(int index) {
        if (index < 0 || index >= images.size())
            return;
        currentIndex = index;

        // 라벨 크기에 맞게 이미지 리사이즈
        ImageIcon originalIcon = images.get(currentIndex);
        int labelWidth = imageLabel.getWidth();
        int labelHeight = imageLabel.getHeight();

        // 라벨이 아직 화면에 표시되기 전이면 크기가 0일 수 있으니, 기본값 지정
        if (labelWidth <= 0)
            labelWidth = 500;
        if (labelHeight <= 0)
            labelHeight = 350;

        Image scaledImage = originalIcon.getImage().getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(scaledImage));
        titleLabel.setText(titles.get(currentIndex));
    }

    private void loadThumbnails() {
        thumbnailPanel.removeAll();
        for (int i = 0; i < images.size(); i++) {
            ImageIcon thumbIcon = new ImageIcon(
                    images.get(i).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
            JLabel thumLabel = new JLabel(thumbIcon);
            int idx = i;
            thumLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
            thumLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            thumLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    showImage(idx);
                }
            });
            thumbnailPanel.add(thumLabel);
        }
        thumbnailPanel.revalidate();
        thumbnailPanel.repaint();
    }

    public static void main(String[] args) {
        ArrayList<ImageIcon> imageList = new ArrayList<>();
        ArrayList<String> titleList = new ArrayList<>();
        imageList.add(new ImageIcon("test (1).jpg"));
        imageList.add(new ImageIcon("test (2).jpg"));
        imageList.add(new ImageIcon("test (3).jpg"));
        imageList.add(new ImageIcon("test (4).jpg"));
        titleList.add("첫 번째 이미지");
        titleList.add("두 번째 이미지");
        titleList.add("세 번째 이미지");
        titleList.add("네 번째 이미지");
        SwingUtilities.invokeLater(() -> new MagicGallery(imageList, titleList));
    }
}