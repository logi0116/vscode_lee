package ch_05_experiments.random_playground.Hero_management.util;

import java.util.List;
import java.util.Random;

public class RandomUtil {
    public static int weightedRandomPick(List<Integer> weights) {
        int total = 0;
        for (int w : weights)
            total += w;
        int r = new Random().nextInt(total);
        int sum = 0;
        for (int i = 0; i < weights.size(); i++) {
            sum += weights.get(i);
            if (r < sum)
                return i;
        }
        return 0;
    }
}

// --- 클래스 다이어그램 ---
// RandomUtil : 가중치 랜덤
// --- 시퀀스 ---
// Service → RandomUtil
// --- 액티비티 ---
// 추첨, 랜덤