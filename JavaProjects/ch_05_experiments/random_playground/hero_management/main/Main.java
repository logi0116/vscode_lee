package ch_05_experiments.random_playground.Hero_management.main;

import ch_05_experiments.random_playground.Hero_management.ui._2IntroFrame;

public class Main {
    public static void main(String[] args) {
        new _2IntroFrame();
    }
}

// --- 클래스 다이어그램 ---
// Main : 진입점
// --- 시퀀스 ---
// Main → IntroFrame → MainFrame → SignupFrame
// --- 액티비티 ---
// 실행, 화면전환// ...existing code...
private void loadMembersFromFile() {
    members.clear();
    File file = new File(FILE_NAME);

    if (!file.exists()) {
        try {
            if (file.createNewFile()) {
                System.out.println("[MemberService] 새로운 members.txt 파일이 생성되었습니다.");
            }
        } catch (IOException e) {
            System.err.println("[MemberService] 파일 생성 오류: " + e.getMessage());
            return;
        }
    }

    try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"))) {
        String headerLine = br.readLine();
        if (headerLine == null) return; // 파일이 비어있으면 종료

        String[] headers = headerLine.split(",");
        Map<String, Integer> colIdx = new HashMap<>();
        for (int i = 0; i < headers.length; i++) {
            colIdx.put(headers[i].trim().toLowerCase(), i);
        }

        String line;
        while ((line = br.readLine()) != null) {
            if (line.trim().isEmpty()) continue;
            String[] arr = line.split(",", -1);

            // 컬럼명에 따라 값 추출 (없으면 기본값)
            String name = arr[colIdx.getOrDefault("name", -1)];
            String email = arr[colIdx.getOrDefault("email", -1)];
            String password = arr[colIdx.getOrDefault("password", -1)];
            String regDate = colIdx.containsKey("regdate") ? arr[colIdx.get("regdate")] : "";
            int huntCount = colIdx.containsKey("huntcount") && !arr[colIdx.get("huntcount")].isEmpty() ? Integer.parseInt(arr[colIdx.get("huntcount")]) : 0;
            String grade = colIdx.containsKey("grade") ? arr[colIdx.get("grade")] : "";
            // id는 선택적으로 처리
            int id = colIdx.containsKey("id") && !arr[colIdx.get("id")].isEmpty() ? Integer.parseInt(arr[colIdx.get("id")]) : members.size() + 1;

            members.add(new Member(name, email, password, regDate, huntCount, grade, id));
        }
    } catch (Exception e) {
        System.err.println("[MemberService] 파일 읽기 오류: " + e.getMessage());
    }
}
// ...existing code...// ...existing code...
private void loadMembersFromFile() {
    members.clear();
    File file = new File(FILE_NAME);

    if (!file.exists()) {
        try {
            if (file.createNewFile()) {
                System.out.println("[MemberService] 새로운 members.txt 파일이 생성되었습니다.");
            }
        } catch (IOException e) {
            System.err.println("[MemberService] 파일 생성 오류: " + e.getMessage());
            return;
        }
    }

    try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"))) {
        String headerLine = br.readLine();
        if (headerLine == null) return; // 파일이 비어있으면 종료

        String[] headers = headerLine.split(",");
        Map<String, Integer> colIdx = new HashMap<>();
        for (int i = 0; i < headers.length; i++) {
            colIdx.put(headers[i].trim().toLowerCase(), i);
        }

        String line;
        while ((line = br.readLine()) != null) {
            if (line.trim().isEmpty()) continue;
            String[] arr = line.split(",", -1);

            // 컬럼명에 따라 값 추출 (없으면 기본값)
            String name = arr[colIdx.getOrDefault("name", -1)];
            String email = arr[colIdx.getOrDefault("email", -1)];
            String password = arr[colIdx.getOrDefault("password", -1)];
            String regDate = colIdx.containsKey("regdate") ? arr[colIdx.get("regdate")] : "";
            int huntCount = colIdx.containsKey("huntcount") && !arr[colIdx.get("huntcount")].isEmpty() ? Integer.parseInt(arr[colIdx.get("huntcount")]) : 0;
            String grade = colIdx.containsKey("grade") ? arr[colIdx.get("grade")] : "";
            // id는 선택적으로 처리
            int id = colIdx.containsKey("id") && !arr[colIdx.get("id")].isEmpty() ? Integer.parseInt(arr[colIdx.get("id")]) : members.size() + 1;

            members.add(new Member(name, email, password, regDate, huntCount, grade, id));
        }
    } catch (Exception e) {
        System.err.println("[MemberService] 파일 읽기 오류: " + e.getMessage());
    }
}
// ...existing code...// ...existing code...
private void loadMembersFromFile() {
    members.clear();
    File file = new File(FILE_NAME);

    if (!file.exists()) {
        try {
            if (file.createNewFile()) {
                System.out.println("[MemberService] 새로운 members.txt 파일이 생성되었습니다.");
            }
        } catch (IOException e) {
            System.err.println("[MemberService] 파일 생성 오류: " + e.getMessage());
            return;
        }
    }

    try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"))) {
        String headerLine = br.readLine();
        if (headerLine == null) return; // 파일이 비어있으면 종료

        String[] headers = headerLine.split(",");
        Map<String, Integer> colIdx = new HashMap<>();
        for (int i = 0; i < headers.length; i++) {
            colIdx.put(headers[i].trim().toLowerCase(), i);
        }

        String line;
        while ((line = br.readLine()) != null) {
            if (line.trim().isEmpty()) continue;
            String[] arr = line.split(",", -1);

            // 컬럼명에 따라 값 추출 (없으면 기본값)
            String name = arr[colIdx.getOrDefault("name", -1)];
            String email = arr[colIdx.getOrDefault("email", -1)];
            String password = arr[colIdx.getOrDefault("password", -1)];
            String regDate = colIdx.containsKey("regdate") ? arr[colIdx.get("regdate")] : "";
            int huntCount = colIdx.containsKey("huntcount") && !arr[colIdx.get("huntcount")].isEmpty() ? Integer.parseInt(arr[colIdx.get("huntcount")]) : 0;
            String grade = colIdx.containsKey("grade") ? arr[colIdx.get("grade")] : "";
            // id는 선택적으로 처리
            int id = colIdx.containsKey("id") && !arr[colIdx.get("id")].isEmpty() ? Integer.parseInt(arr[colIdx.get("id")]) : members.size() + 1;

            members.add(new Member(name, email, password, regDate, huntCount, grade, id));
        }
    } catch (Exception e) {
        System.err.println("[MemberService] 파일 읽기 오류: " + e.getMessage());
    }
}
// ...existing code...// ...existing code...
private void loadMembersFromFile() {
    members.clear();
    File file = new File(FILE_NAME);

    if (!file.exists()) {
        try {
            if (file.createNewFile()) {
                System.out.println("[MemberService] 새로운 members.txt 파일이 생성되었습니다.");
            }
        } catch (IOException e) {
            System.err.println("[MemberService] 파일 생성 오류: " + e.getMessage());
            return;
        }
    }

    try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"))) {
        String headerLine = br.readLine();
        if (headerLine == null) return; // 파일이 비어있으면 종료

        String[] headers = headerLine.split(",");
        Map<String, Integer> colIdx = new HashMap<>();
        for (int i = 0; i < headers.length; i++) {
            colIdx.put(headers[i].trim().toLowerCase(), i);
        }

        String line;
        while ((line = br.readLine()) != null) {
            if (line.trim().isEmpty()) continue;
            String[] arr = line.split(",", -1);

            // 컬럼명에 따라 값 추출 (없으면 기본값)
            String name = arr[colIdx.getOrDefault("name", -1)];
            String email = arr[colIdx.getOrDefault("email", -1)];
            String password = arr[colIdx.getOrDefault("password", -1)];
            String regDate = colIdx.containsKey("regdate") ? arr[colIdx.get("regdate")] : "";
            int huntCount = colIdx.containsKey("huntcount") && !arr[colIdx.get("huntcount")].isEmpty() ? Integer.parseInt(arr[colIdx.get("huntcount")]) : 0;
            String grade = colIdx.containsKey("grade") ? arr[colIdx.get("grade")] : "";
            // id는 선택적으로 처리
            int id = colIdx.containsKey("id") && !arr[colIdx.get("id")].isEmpty() ? Integer.parseInt(arr[colIdx.get("id")]) : members.size() + 1;

            members.add(new Member(name, email, password, regDate, huntCount, grade, id));
        }
    } catch (Exception e) {
        System.err.println("[MemberService] 파일 읽기 오류: " + e.getMessage());
    }
}
// ...existing code...// ...existing code...
private void loadMembersFromFile() {
    members.clear();
    File file = new File(FILE_NAME);

    if (!file.exists()) {
        try {
            if (file.createNewFile()) {
                System.out.println("[MemberService] 새로운 members.txt 파일이 생성되었습니다.");
            }
        } catch (IOException e) {
            System.err.println("[MemberService] 파일 생성 오류: " + e.getMessage());
            return;
        }
    }

    try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"))) {
        String headerLine = br.readLine();
        if (headerLine == null) return; // 파일이 비어있으면 종료

        String[] headers = headerLine.split(",");
        Map<String, Integer> colIdx = new HashMap<>();
        for (int i = 0; i < headers.length; i++) {
            colIdx.put(headers[i].trim().toLowerCase(), i);
        }

        String line;
        while ((line = br.readLine()) != null) {
            if (line.trim().isEmpty()) continue;
            String[] arr = line.split(",", -1);

            // 컬럼명에 따라 값 추출 (없으면 기본값)
            String name = arr[colIdx.getOrDefault("name", -1)];
            String email = arr[colIdx.getOrDefault("email", -1)];
            String password = arr[colIdx.getOrDefault("password", -1)];
            String regDate = colIdx.containsKey("regdate") ? arr[colIdx.get("regdate")] : "";
            int huntCount = colIdx.containsKey("huntcount") && !arr[colIdx.get("huntcount")].isEmpty() ? Integer.parseInt(arr[colIdx.get("huntcount")]) : 0;
            String grade = colIdx.containsKey("grade") ? arr[colIdx.get("grade")] : "";
            // id는 선택적으로 처리
            int id = colIdx.containsKey("id") && !arr[colIdx.get("id")].isEmpty() ? Integer.parseInt(arr[colIdx.get("id")]) : members.size() + 1;

            members.add(new Member(name, email, password, regDate, huntCount, grade, id));
        }
    } catch (Exception e) {
        System.err.println("[MemberService] 파일 읽기 오류: " + e.getMessage());
    }
}
// ...existing code...// ...existing code...
private void loadMembersFromFile() {
    members.clear();
    File file = new File(FILE_NAME);

    if (!file.exists()) {
        try {
            if (file.createNewFile()) {
                System.out.println("[MemberService] 새로운 members.txt 파일이 생성되었습니다.");
            }
        } catch (IOException e) {
            System.err.println("[MemberService] 파일 생성 오류: " + e.getMessage());
            return;
        }
    }

    try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"))) {
        String headerLine = br.readLine();
        if (headerLine == null) return; // 파일이 비어있으면 종료

        String[] headers = headerLine.split(",");
        Map<String, Integer> colIdx = new HashMap<>();
        for (int i = 0; i < headers.length; i++) {
            colIdx.put(headers[i].trim().toLowerCase(), i);
        }

        String line;
        while ((line = br.readLine()) != null) {
            if (line.trim().isEmpty()) continue;
            String[] arr = line.split(",", -1);

            // 컬럼명에 따라 값 추출 (없으면 기본값)
            String name = arr[colIdx.getOrDefault("name", -1)];
            String email = arr[colIdx.getOrDefault("email", -1)];
            String password = arr[colIdx.getOrDefault("password", -1)];
            String regDate = colIdx.containsKey("regdate") ? arr[colIdx.get("regdate")] : "";
            int huntCount = colIdx.containsKey("huntcount") && !arr[colIdx.get("huntcount")].isEmpty() ? Integer.parseInt(arr[colIdx.get("huntcount")]) : 0;
            String grade = colIdx.containsKey("grade") ? arr[colIdx.get("grade")] : "";
            // id는 선택적으로 처리
            int id = colIdx.containsKey("id") && !arr[colIdx.get("id")].isEmpty() ? Integer.parseInt(arr[colIdx.get("id")]) : members.size() + 1;

            members.add(new Member(name, email, password, regDate, huntCount, grade, id));
        }
    } catch (Exception e) {
        System.err.println("[MemberService] 파일 읽기 오류: " + e.getMessage());
    }
}
// ...existing code...