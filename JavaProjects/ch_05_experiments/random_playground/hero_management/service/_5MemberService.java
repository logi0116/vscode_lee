package ch_05_experiments.random_playground.hero_management.service;

import ch_05_experiments.random_playground.hero_management.dao._9DAO_Interface;
import ch_05_experiments.random_playground.hero_management.dao._N1OracleMemberDAOImpl;
import ch_05_experiments.random_playground.hero_management.dto._10Member;
import ch_05_experiments.random_playground.hero_management.util.RandomUtil;
import java.util.*;
import java.io.*;

public class _5MemberService {
    private _9DAO_Interface dao = new _N1OracleMemberDAOImpl();
    private static final String FILE_NAME = "members.txt";

    public void addMemberDB(_10Member m) {
        dao.insert(m); // 메모리/리스트에 추가
        saveToFile(); // 파일에 저장
    }

    public void loadMembersFromDB() {
        loadFromFile(); // 파일에서 읽어와 리스트 갱신
    }

    public List<_10Member> getAllMembers() {
        return dao.findAll();
    }

    public boolean addMember(_10Member m) {
        return dao.insert(m);
    }

    public boolean updateMember(_10Member m) {
        return dao.update(m);
    }

    public boolean deleteMember(int id) {
        return dao.delete(id);
    }

    public List<_10Member> search(String keyword, String type) {
        return dao.search(keyword, type);
    }

    public void addDummyData() {
        dao.insert(new _10Member(0, "홍길동", "hong@hero.com", "1234", "2025-06-17", 10, "A"));
        dao.insert(new _10Member(0, "이순신", "lee@hero.com", "5678", "2025-06-17", 20, "S"));
    }

    public _10Member pickHunterOfTheMonth() {
        List<_10Member> list = dao.findAll();
        if (list.isEmpty())
            return null;
        List<Integer> weights = new ArrayList<>();
        for (_10Member m : list)
            weights.add(Math.max(1, m.getHuntCount()));
        int idx = RandomUtil.weightedRandomPick(weights);
        return list.get(idx);
    }

    public void loadFromCSVFile(String filePath) {
        dao.loadFromCSVFile(filePath);
    }

    public void saveToFile() {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(FILE_NAME), "UTF-8"))) {
            for (_10Member m : dao.findAll()) {
                bw.write(m.toCSV());
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("[Service] 파일 저장 오류: " + e.getMessage());
        }
    }

    public void loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
            }
        }
        dao.clearAll(); // 리스트 비우기
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(FILE_NAME), "UTF-8"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty())
                    continue;
                String[] arr = line.split(",", -1);
                if (arr.length >= 7) {
                    _10Member m = new _10Member(
                            Integer.parseInt(arr[0]), arr[1], arr[2], arr[3], arr[4],
                            Integer.parseInt(arr[5]), arr[6]);
                    dao.insert(m);
                }
            }
        } catch (IOException e) {
            System.err.println("[Service] 파일 읽기 오류: " + e.getMessage());
        }
    }
}

// --- 클래스 다이어그램 ---
// _5MemberService : DAO 의존, 비즈니스 로직
// --- 시퀀스 ---
// UI → Service → DAO
// --- 액티비티 ---
// 회원관리, 더미, 추첨, 파일로드