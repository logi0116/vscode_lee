package ch_05_experiments.random_playground.Hero_management.dao;

import ch_05_experiments.random_playground.Hero_management.dto._10Member;
import java.util.*;
import java.io.*;
import javax.swing.*;

public class _N1OracleMemberDAOImpl implements _9DAO_Interface {
    private List<_10Member> memberList = new ArrayList<>();
    private int nextId = 1;

    @Override
    public List<_10Member> findAll() {
        return new ArrayList<>(memberList);
    }

    @Override
    public _10Member findById(int id) {
        for (_10Member m : memberList)
            if (m.getId() == id)
                return m;
        return null;
    }

    @Override
    public boolean insert(_10Member member) {
        member.setId(nextId++);
        memberList.add(member);
        return true;
    }

    @Override
    public boolean update(_10Member member) {
        for (int i = 0; i < memberList.size(); i++) {
            if (memberList.get(i).getId() == member.getId()) {
                memberList.set(i, member);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        return memberList.removeIf(m -> m.getId() == id);
    }

    @Override
    public List<_10Member> search(String keyword, String type) {
        List<_10Member> result = new ArrayList<>();
        for (_10Member m : memberList) {
            if ("이름".equals(type) && m.getName().contains(keyword))
                result.add(m);
            else if ("이메일".equals(type) && m.getEmail().contains(keyword))
                result.add(m);
            else if ("등급".equals(type) && m.getGrade().contains(keyword))
                result.add(m);
        }
        return result;
    }

    @Override
    public void loadFromSQLFile(String filePath) {
        // 예시: CSV 파일에서 회원 데이터 읽기
        if (filePath == null)
            return;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            memberList.clear();
            String line;
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(",");
                if (arr.length >= 7) {
                    _10Member m = new _10Member(
                            Integer.parseInt(arr[0]), arr[1], arr[2], arr[3], arr[4],
                            Integer.parseInt(arr[5]), arr[6]);
                    memberList.add(m);
                    nextId = Math.max(nextId, m.getId() + 1);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "SQL 파일 로드 실패: " + e.getMessage());
        }
    }
}

// --- 클래스 다이어그램 ---
// _N1OracleMemberDAOImpl : _9DAO_Interface 구현, 메모리/파일 기반
// --- 시퀀스 ---
// UI → Service → DAO → 파일/메모리
// --- 액티비티 ---
// CRUD, 검색, SQL파일로드