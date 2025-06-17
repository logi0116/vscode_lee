package ch_05_experiments.random_playground.hero_management.ui;

import ch_05_experiments.random_playground.hero_management.service._5MemberService;
import ch_05_experiments.random_playground.hero_management.dto._10Member;
import ch_05_experiments.random_playground.hero_management.util.DateUtil;
import ch_05_experiments.random_playground.hero_management.util.MessageUtil;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class _4SignupFrame extends JFrame {
    private _5MemberService service = new _5MemberService();
    private DefaultTableModel tableModel;
    private JTable table;
    private JTextField searchField;
    private JComboBox<String> searchTypeBox;

    public _4SignupFrame() {
        setTitle("히어로 회원관리");
        setSize(900, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        String[] cols = { "ID", "이름", "이메일", "비밀번호", "가입일", "이달의 실적", "등급" };
        tableModel = new DefaultTableModel(cols, 0) {
            public boolean isCellEditable(int r, int c) {
                return false;
            }
        };
        table = new JTable(tableModel);

        JPanel topPanel = new JPanel();
        searchTypeBox = new JComboBox<>(new String[] { "이름", "이메일", "등급" });
        searchField = new JTextField(15);
        JButton searchBtn = new JButton("검색");
        JButton resetBtn = new JButton("검색초기화");
        topPanel.add(searchTypeBox);
        topPanel.add(searchField);
        topPanel.add(searchBtn);
        topPanel.add(resetBtn);

        JPanel btnPanel = new JPanel();
        JButton addBtn = new JButton("회원가입");
        JButton updateBtn = new JButton("수정");
        JButton deleteBtn = new JButton("삭제");
        JButton refreshBtn = new JButton("새로고침");
        JButton dummyBtn = new JButton("더미데이터 추가");
        JButton hunterBtn = new JButton("이달의 헌터 추첨");
        JButton csvBtn = new JButton("CSV파일선택");
        btnPanel.add(addBtn);
        btnPanel.add(updateBtn);
        btnPanel.add(deleteBtn);
        btnPanel.add(refreshBtn);
        btnPanel.add(dummyBtn);
        btnPanel.add(hunterBtn);
        btnPanel.add(csvBtn);

        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);
        add(btnPanel, BorderLayout.SOUTH);

        refreshTable();

        searchBtn.addActionListener(e -> search());
        resetBtn.addActionListener(e -> {
            searchField.setText("");
            refreshTable();
        });
        refreshBtn.addActionListener(e -> refreshTable());
        // ...existing code...
        addBtn.addActionListener(e -> {
            _4SignupDialog dialog = new _4SignupDialog(this, null);
            dialog.setVisible(true);
            if (dialog.isConfirmed()) {
                _10Member member = dialog.getMember(0, DateUtil.getCurrentDateTime());
                service.addMemberDB(member); // 2. DB에 추가 및 파일 저장
                service.loadMembersFromDB(); // 3. 파일에서 다시 로드
                refreshTable(); // 4. 테이블 갱신
            }
        });
        // ...existing code...
        updateBtn.addActionListener(e -> updateMember());
        deleteBtn.addActionListener(e -> deleteMember());
        dummyBtn.addActionListener(e -> {
            service.addDummyData();
            refreshTable();
        });
        hunterBtn.addActionListener(e -> pickHunter());
        csvBtn.addActionListener(e -> {
            String path = _4SQLFileChooser.chooseCSVFile(this);
            if (path != null) {
                service.loadFromCSVFile(path);
                refreshTable();
            }
        });

        setVisible(true);
    }

  private void refreshTable() {
    tableModel.setRowCount(0);
    for (_10Member m : service.getAllMembers()) {
        tableModel.addRow(new Object[]{
            m.getId(), m.getName(), m.getEmail(), m.getPassword(),
            m.getRegDate(), m.getHuntCount(), m.getGrade()
        });
    }
}

    private void search() {
        String keyword = searchField.getText();
        String type = (String) searchTypeBox.getSelectedItem();
        List<_10Member> result = service.search(keyword, type);
        tableModel.setRowCount(0);
        for (_10Member m : result) {
            tableModel.addRow(new Object[] {
                    m.getId(), m.getName(), m.getEmail(), m.getPassword(),
                    m.getRegDate(), m.getHuntCount(), m.getGrade()
            });
        }
    }

    private void addMember() {
        _4SignupDialog dialog = new _4SignupDialog(this, null);
        dialog.setVisible(true);
        if (dialog.isConfirmed()) {
            _10Member m = dialog.getMember(0, DateUtil.getCurrentDateTime());
            service.addMember(m);
            refreshTable();
        }
    }

    private void updateMember() {
        int row = table.getSelectedRow();
        if (row == -1) {
            MessageUtil.showInfo("수정할 회원을 선택하세요.");
            return;
        }
        int id = (int) tableModel.getValueAt(row, 0);
        _10Member old = null;
        for (_10Member m : service.getAllMembers())
            if (m.getId() == id)
                old = m;
        if (old == null)
            return;
        _4SignupDialog dialog = new _4SignupDialog(this, old);
        dialog.setVisible(true);
        if (dialog.isConfirmed()) {
            _10Member m = dialog.getMember(id, old.getRegDate());
            service.updateMember(m);
            refreshTable();
        }
    }

    private void deleteMember() {
        int row = table.getSelectedRow();
        if (row == -1) {
            MessageUtil.showInfo("삭제할 회원을 선택하세요.");
            return;
        }
        int id = (int) tableModel.getValueAt(row, 0);
        int res = JOptionPane.showConfirmDialog(this, "정말 삭제하시겠습니까?", "확인", JOptionPane.YES_NO_OPTION);
        if (res == JOptionPane.YES_OPTION) {
            service.deleteMember(id);
            refreshTable();
        }
    }

    private void pickHunter() {
        _10Member m = service.pickHunterOfTheMonth();
        if (m == null)
            MessageUtil.showInfo("회원이 없습니다.");
        else
            MessageUtil.showInfo("이달의 헌터: " + m.getName() + " (실적: " + m.getHuntCount() + ")");
    }
}

// --- 클래스 다이어그램 ---
// _4SignupFrame : JFrame, 회원관리 UI
// --- 시퀀스 ---
// MainFrame → SignupFrame → Service → DAO
// --- 액티비티 ---
// CRUD, 검색, 더미, 추첨, 파일선택
