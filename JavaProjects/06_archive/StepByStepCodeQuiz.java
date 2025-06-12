import java.util.*;

public class StepByStepCodeQuiz {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 정답 순서대로 구성된 구문 조각
        String[] correctOrder = {
            "if (",
            "x > 0",
            ")",
            "{",
            "System.out.println(\"양수\");",
            "}"
        };

        // 보기 조각들을 섞기
        List<String> quizList = new ArrayList<>(Arrays.asList(correctOrder));
        Collections.shuffle(quizList);

        // 번호 매기기
        Map<Integer, String> optionMap = new HashMap<>();
        System.out.println("🧩 다음 보기에서 하나씩 번호를 입력해 구문을 완성하세요:");
        for (int i = 0; i < quizList.size(); i++) {
            optionMap.put(i + 1, quizList.get(i));
            System.out.println((i + 1) + ") " + quizList.get(i));
        }

        // 사용자 진행 상황 저장
        List<String> currentCode = new ArrayList<>();
        int currentStep = 0;

        while (currentStep < correctOrder.length) {
            System.out.print("\n👉 " + (currentStep + 1) + "번째 조각 번호 입력: ");
            int inputNum;

            // 숫자 입력 예외 처리
            try {
                inputNum = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("⚠️ 숫자를 입력하세요!");
                continue;
            }

            String selectedPart = optionMap.get(inputNum);

            if (selectedPart == null) {
                System.out.println("❌ 유효하지 않은 번호입니다.");
                continue;
            }

            // 정답 비교
            if (selectedPart.equals(correctOrder[currentStep])) {
                System.out.println("✅ 정답입니다!");
                currentCode.add(selectedPart); // 코드 진척
                currentStep++;

                // 현재까지 완성된 코드 보여주기
                System.out.println("🧩 현재까지 완성된 코드:");
                for (String part : currentCode) {
                    System.out.print(part + " ");
                }
                System.out.println();
            } else {
                System.out.println("❌ 오답입니다. 다시 시도하세요.");
            }
        }

        // 최종 결과
        System.out.println("\n🎉 모든 조각을 올바르게 선택했습니다!");
        System.out.print("✔ 최종 완성된 코드: ");
        for (String part : correctOrder) {
            System.out.print(part + " ");
        }

        scanner.close();
    }
}
