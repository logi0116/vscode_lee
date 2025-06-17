package ch_05_experiments.random_playground.Hero_management.ui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import ch_05_experiments.random_playground.Hero_management.dto._10Member;

public class _4SignupDialog extends JDialog {
    private JTextField nameField, emailField, gradeField, huntField;
    private JPasswordField passwordField;
    private boolean confirmed = false;

    public _4SignupDialog(JFrame parent, _10Member member) {
        super(parent, "회원 정보 입력", true);
        setLayout(new GridLayout(0, 2));
        nameField = new JTextField(member != null ? member.getName() : "");
        emailField = new JTextField(member != null ? member.getEmail() : "");
        passwordField = new JPasswordField(member != null ? member.getPassword() : "");
        huntField = new JTextField(member != null ? String.valueOf(member.getHuntCount()) : "0");
        gradeField = new JTextField(member != null ? member.getGrade() : "C");

        add(new JLabel("이름:"));
        add(nameField);
        add(new JLabel("이메일:"));
        add(emailField);
        add(new JLabel("비밀번호:"));
        add(passwordField);
        add(new JLabel("이달의 실적:"));
        add(huntField);
        add(new JLabel("등급:"));
        add(gradeField);

        JButton ok = new JButton("확인");
        JButton cancel = new JButton("취소");
        ok.addActionListener(e -> {
            confirmed = true;
            setVisible(false);
        });
        cancel.addActionListener(e -> {
            setVisible(false);
        });
        add(ok);
        add(cancel);

        pack();
        setLocationRelativeTo(parent);
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public _10Member getMember(int id, String regDate) {
        return new _10Member(
                id,
                nameField.getText(),
                emailField.getText(),
                new String(passwordField.getPassword()),
                regDate,
                Integer.parseInt(huntField.getText()),
                gradeField.getText());
    }
}

// --- 클래스 다이어그램 ---
// _4SignupDialog : JDialog
// --- 시퀀스 ---
// SignupFrame → SignupDialog
// --- 액티비티 ---
// 입력폼, 확인/취소