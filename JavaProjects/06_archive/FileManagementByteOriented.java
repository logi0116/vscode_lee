import java.io.FileInputStream; // 바이트 단위 파일 읽기
import java.io.FileOutputStream; // 바이트 단위 파일 쓰기
import java.io.IOException;      // 입출력 예외 처리
import java.util.InputMismatchException; // 잘못된 입력 처리
import java.util.Scanner;        // 사용자 입력 받기

public class FileManagementByteOriented {

    // 사용할 파일 이름 (상수로 정의)
    private static final String DEFAULT_FILE_NAME = "my_byte_test_file.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // 사용자 입력을 받을 Scanner 객체 생성
        int choice = -1; // 사용자 선택을 저장할 변수

        // 사용자가 '3. 종료'를 선택할 때까지 메뉴를 반복
        while (choice != 3) {
            displayMenu(); // 메뉴 출력
            try {
                System.out.print("선택하세요: ");
                choice = scanner.nextInt(); // 사용자로부터 정수 입력
                scanner.nextLine(); // 버퍼 비우기 (nextInt() 후 남아있는 개행 문자 처리)

                switch (choice) {
                    case 1:
                        System.out.print("파일에 쓸 내용을 입력하세요: ");
                        String contentToWrite = scanner.nextLine(); // 한 줄 전체 입력
                        writeFile(DEFAULT_FILE_NAME, contentToWrite); // 파일 쓰기 메서드 호출
                        break;
                    case 2:
                        readFile(DEFAULT_FILE_NAME); // 파일 읽기 메서드 호출
                        break;
                    case 3:
                        System.out.println("프로그램을 종료합니다.");
                        break;
                    default:
                        System.out.println("잘못된 선택입니다. 1, 2, 3 중에서 선택해주세요.");
                }
            } catch (InputMismatchException e) {
                System.err.println("잘못된 입력입니다. 숫자를 입력해주세요.");
                scanner.nextLine(); // 잘못된 입력을 버퍼에서 제거
                choice = -1; // 다시 메뉴를 보여주기 위해 choice 초기화
            } catch (Exception e) { // 그 외 예상치 못한 모든 예외 처리
                System.err.println("예상치 못한 오류가 발생했습니다: " + e.getMessage());
                e.printStackTrace();
            }
            System.out.println(); // 메뉴 구분 줄
        }
        scanner.close(); // 프로그램 종료 전 Scanner 객체 자원 해제
    }

    /**
     * 메뉴를 콘솔에 출력하는 메서드.
     */
    public static void displayMenu() {
        System.out.println("--- 파일 관리 프로그램 (바이트 스트림) ---");
        System.out.println("1. 파일에 내용 쓰기");
        System.out.println("2. 파일 내용 읽기");
        System.out.println("3. 종료");
        System.out.println("------------------------------------");
    }

    /**
     * 지정된 파일에 내용을 쓰는 메서드. (FileOutputStream 사용)
     * 파일이 없으면 생성하고, 있으면 기존 내용을 덮어씁니다.
     *
     * @param fileName 쓰기 작업을 수행할 파일 이름
     * @param content  파일에 쓸 문자열 내용
     */
    public static void writeFile(String fileName, String content) {
        System.out.println("\n[파일 쓰기 작업]");
        // try-with-resources: FileOutputStream을 사용하여 파일에 바이트 스트림으로 씁니다.
        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            // String을 바이트 배열로 변환하여 씁니다.
            // **주의: 한글이 깨질 수 있으므로, 실제 응용에서는 InputStreamReader/OutputStreamWriter와 인코딩 지정을 권장합니다.**
            fos.write(content.getBytes());
            System.out.println("'" + fileName + "' 파일에 내용이 성공적으로 작성되었습니다.");
        } catch (IOException e) {
            System.err.println("파일 쓰기 중 오류 발생: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * 지정된 파일의 내용을 바이트 단위로 읽어와 콘솔에 출력하는 메서드. (FileInputStream 사용)
     *
     * @param fileName 읽기 작업을 수행할 파일 이름
     */
    public static void readFile(String fileName) {
        System.out.println("\n[파일 읽기 작업]");
        // try-with-resources: FileInputStream을 사용하여 파일에서 바이트 스트림으로 읽습니다.
        try (FileInputStream fis = new FileInputStream(fileName)) {
            int data; // 한 바이트씩 읽어서 임시로 담을 변수 (int 타입으로 읽음)

            System.out.println("\n--- '" + fileName + "' 파일 내용 (바이트 단위) ---");
            // 파일에서 한 바이트씩 읽어옵니다.
            // fis.read()는 읽어온 바이트 값을 반환하고, 파일의 끝(EOF)에 도달하면 -1을 반환합니다.
            boolean hasContent = false;
            while ((data = fis.read()) != -1) {
                System.out.print((char) data); // 읽어온 바이트를 char로 캐스팅하여 출력
                hasContent = true;
            }
            if (!hasContent) {
                System.out.println("파일에 내용이 없습니다.");
            }
            System.out.println("\n------------------------------------");
            System.out.println("'" + fileName + "' 파일 읽기 성공.");

        } catch (IOException e) {
            System.err.println("파일 읽기 중 오류 발생: " + e.getMessage());
            if (e.getMessage().contains("No such file or directory")) {
                System.err.println("파일이 존재하지 않습니다. 먼저 1번 기능을 사용하여 파일을 생성해주세요.");
            }
            e.printStackTrace();
        }
    }
}