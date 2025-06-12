import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.util.Scanner;

public class LineNumberedFileReader {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- 텍스트 파일의 각 줄 앞에 번호 붙이기 ---");
        System.out.print("읽어올 텍스트 파일의 이름을 입력하세요 (예: my_text_file.txt): ");
        String inputFileName = scanner.nextLine();

        System.out.print("번호가 붙은 결과를 저장할 파일 이름을 입력하세요 (예: numbered_output.txt): ");
        String outputFileName = scanner.nextLine();

        addNumberToEachLine(inputFileName, outputFileName);

        scanner.close();
    }

    /**
     * 텍스트 파일의 각 줄 앞에 001. 002. ... 형식으로 번호를 붙여 새 파일로 저장합니다.
     */
    public static void addNumberToEachLine(String inputFileName, String outputFileName) {
        int lineNumber = 1;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(inputFileName), "UTF-8"));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFileName))) {

            String line;
            while ((line = br.readLine()) != null) {
                bw.write(String.format("%03d. %s", lineNumber++, line));
                bw.newLine();
            }
            System.out.println("'" + outputFileName + "' 파일로 줄별 번호 붙이기 완료!");

        } catch (FileNotFoundException e) {
            System.err.println("오류: '" + inputFileName + "' 파일을 찾을 수 없습니다.");
        } catch (IOException e) {
            System.err.println("파일 처리 중 오류 발생: " + e.getMessage());
        }
    }
}