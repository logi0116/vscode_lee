package util.random;

public class RandomUtilMain {

    public static void main(String[] args) {
        System.out.println("매스 함수를 이용해 난수 생성: " + RandomUtil.generateRandom());
        System.out.println("1이상 45이하 사이의 랜덤 정수: " + RandomUtil.generateRandomInRange(1, 45));

        System.out.println("로또 번호 생성기 출력: ");
        RandomUtil.generateLottoNumbers();
    }
}
// 퀴즈 랜덤한 숫자를 생성하는 기능을 구현했다. 이제 퀴즈를 내겠다.
//퀴즈1. 로또 번호를 생성하는 기능을 만들어보세요. 
//아직 배열을 안 배웠으니 각각 랜덤의 숫자를 6자리 따로 받아서, 출력만 한번에 생성하는 기능을 만들어보세요.
//한마디로 정적 메소드를 만들어서 출력 문장에서 랜덤 숫자 6개 보여주기 형식으로 하면 됨.
//출력문 모양은 이상록의 자동 로또 번호 생성기 사용한 번호 : 1, 20, 30, 11, 17, 45
//조건문을 활용해서 중복도 발생되지 않게 해보기. (배열을 쓰지 않고 무식하게 해보기)





