package d250610.ch5_2;

public class Cat_Ex1 extends Animal_Ex1 implements Moveable_Ex1, Outable_Ex1 {

    @Override
    void sound() {
        System.out.println("야옹야옹으로 재정의 필수로 했어요");
    }

    @Override
    public void out() {
        System.out.println("야옹이는 앉아서 응가함");
    }

    @Override
    public void move() {
        System.out.println("날렵하게 점프 약 1미터 가능 ");
    }

}
