package ch_05_experiments.random_playground.Hero_management.service;

import java.util.ArrayList;
import java.util.List;

import ch_05_experiments.random_playground.Hero_management.dao._9DAO_Interface;
import ch_05_experiments.random_playground.Hero_management.dao._N1OracleMemberDAOImpl;
import ch_05_experiments.random_playground.Hero_management.dto._10Member;
import ch_05_experiments.random_playground.Hero_management.util.RandomUtil;

public class _5MemberService {
    private _9DAO_Interface dao = new _N1OracleMemberDAOImpl();

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
        dao.insert(new _10Member(0, "동길홍", "hong@hero.com", "1234", "2025-06-17", 10, "A"));
        dao.insert(new _10Member(0, "신순리", "lee@hero.com", "5678", "2025-06-17", 20, "S"));
        dao.insert(new _10Member(0, "웅영김", "kim@hero.com", "9999", "2025-06-17", 5, "B"));
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

    public void loadFromSQLFile(String filePath) {
        dao.loadFromSQLFile(filePath);
    }
}

// --- 클래스 다이어그램 ---
// _5MemberService : DAO 의존, 비즈니스 로직
// --- 시퀀스 ---
// UI → Service → DAO
// --- 액티비티 ---
// 회원관리, 더미, 추첨, 파일로드