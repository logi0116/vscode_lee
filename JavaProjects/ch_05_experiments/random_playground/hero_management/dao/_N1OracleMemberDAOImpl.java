package ch_05_experiments.random_playground.hero_management.dao;

import ch_05_experiments.random_playground.hero_management.dto._10Member;
import java.util.*;
import java.io.*;

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
    public void loadFromCSVFile(String filePath) {
        if (filePath == null)
            return;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8"))) {
            String headerLine = br.readLine();
            if (headerLine == null)
                return;
            String[] headers = headerLine.split(",");
            Map<String, Integer> colIdx = new HashMap<>();
            for (int i = 0; i < headers.length; i++)
                colIdx.put(headers[i].trim().toLowerCase(), i);

            memberList.clear();
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty())
                    continue;
                String[] arr = line.split(",", -1);
                int id = colIdx.containsKey("id") && !arr[colIdx.get("id")].isEmpty()
                        ? Integer.parseInt(arr[colIdx.get("id")])
                        : nextId++;
                String name = arr[colIdx.getOrDefault("name", -1)];
                String email = arr[colIdx.getOrDefault("email", -1)];
                String password = arr[colIdx.getOrDefault("password", -1)];
                String regDate = colIdx.containsKey("regdate") ? arr[colIdx.get("regdate")] : "";
                int huntCount = colIdx.containsKey("huntcount") && !arr[colIdx.get("huntcount")].isEmpty()
                        ? Integer.parseInt(arr[colIdx.get("huntcount")])
                        : 0;
                String grade = colIdx.containsKey("grade") ? arr[colIdx.get("grade")] : "";
                memberList.add(new _10Member(id, name, email, password, regDate, huntCount, grade));
                nextId = Math.max(nextId, id + 1);
            }
        } catch (Exception e) {
            System.err.println("[DAO] CSV 파일 로드 오류: " + e.getMessage());
        }
    }

    public void clearAll() {
    memberList.clear();
}
}

// --- 클래스 다이어그램 ---
// _N1OracleMemberDAOImpl : _9DAO_Interface 구현, 메모리/파일 기반
// --- 시퀀스 ---
// UI → Service → DAO → 파일/메모리
// --- 액티비티 ---
// CRUD, 검색, SQL파일로드