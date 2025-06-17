package ch_05_experiments.random_playground.hero_management.dao;

import ch_05_experiments.random_playground.hero_management.dto._10Member;
import java.util.List;

public interface _9DAO_Interface {
    List<_10Member> findAll();

    _10Member findById(int id);

    boolean insert(_10Member member);

    boolean update(_10Member member);

    boolean delete(int id);

    List<_10Member> search(String keyword, String type); // 이름/이메일/등급

    void loadFromCSVFile(String filePath);
}

// --- 클래스 다이어그램 ---
// 인터페이스: CRUD, 검색, SQL파일로드
// --- 시퀀스 ---
// Service → DAO → 파일/DB
// --- 액티비티 ---
// 데이터 입출력, 검색, 파일로드