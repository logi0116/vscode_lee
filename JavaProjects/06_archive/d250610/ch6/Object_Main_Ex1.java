package d250610.ch6;

class Object_Main_Ex1 {
    public static void main(String[] args) {
        Object_Ex1 obj = new Object_Ex1("lsy");
        // Object 부모 클래스의 기본 기능 확인, 별 쓸모 없음. 우리 입장에서는,
        // 2번째, 재정의 후, 다시 실행시 비교해보기, 메모리 위치 주솟값 형태 인지,
        // 아니면, 우리가 필요로한 데이터 모 양인지, 무엇을 필요로 할까요? 정답, 우리가 정의한 데이터 모양
        String result = obj.toString();
        System.out.println("부모 클래스의 기본 기능 toString() 확인 결과 : " + result);
    }

}