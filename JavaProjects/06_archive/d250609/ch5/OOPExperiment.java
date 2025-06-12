package d250609.ch5;

// Animal 클래스는 모든 동물의 공통 속성과 동작을 정의하는 '추상 클래스'입니다.
// 추상 클래스는 직접 객체를 만들 수 없고, 반드시 상속해서 사용해야 합니다.
abstract class Animal {
    String name; // 동물의 이름을 저장하는 변수

    // 생성자: 객체가 만들어질 때 이름을 받아서 저장합니다.
    Animal(String name) { this.name = name; }

    // 추상 메서드: 소리내기. 자식 클래스에서 반드시 구현해야 합니다.
    abstract void sound();

    // 모든 동물이 공통적으로 먹이를 먹는 동작을 정의합니다.
    void eat() { 
        System.out.println(name + "가(이) 먹이를 먹는다. [3][상속/공통메서드]");
    }
}

// Runnable 인터페이스: '달릴 수 있다'는 기능을 명세합니다.
// 인터페이스는 다중 구현이 가능하며, 반드시 메서드를 구현해야 합니다.
interface Runnable { void run(); }

// Jumpable 인터페이스: '점프할 수 있다'는 기능을 명세합니다.
interface Jumpable { void jump(); }

// Dog 클래스는 Animal을 상속받고, Runnable과 Jumpable 인터페이스를 구현합니다.
// 즉, Dog는 동물이고, 달릴 수 있고, 점프할 수 있습니다.
class Dog extends Animal implements Runnable, Jumpable {
    Dog(String name) { super(name); }

    // sound() 메서드를 오버라이딩(재정의)합니다.
    // Animal 타입으로 참조해도 실제 객체가 Dog라면 이 메서드가 실행됩니다.
    @Override
    void sound() { 
        System.out.println(name + ": 멍멍! [1][오버라이딩/다형성]");
    }

    // run() 메서드는 Runnable 인터페이스의 구현입니다.
    @Override
    public void run() { 
        System.out.println(name + "가(이) 달린다! [5][인터페이스/다형성]");
    }

    // jump() 메서드는 Jumpable 인터페이스의 구현입니다.
    @Override
    public void jump() { 
        System.out.println(name + "가(이) 점프한다! [7][인터페이스/instanceof]");
    }

    // sound(int repeat): 같은 이름이지만 매개변수가 다르므로 '오버로딩'입니다.
    void sound(int repeat) {
        for (int i = 0; i < repeat; i++) System.out.print("멍! ");
        System.out.println("[6][오버로딩]");
    }
}

// Cat 클래스는 Animal을 상속받고, Runnable만 구현합니다.
// Cat은 점프 기능이 없으므로 Jumpable을 구현하지 않습니다.
class Cat extends Animal implements Runnable {
    Cat(String name) { super(name); }

    // sound() 메서드를 오버라이딩(재정의)합니다.
    @Override
    void sound() { 
        System.out.println(name + ": 야옹~ [2][오버라이딩/다형성]");
    }

    // run() 메서드는 Runnable 인터페이스의 구현입니다.
    @Override
    public void run() { 
        System.out.println(name + "가(이) 우아하게 달린다! [참고: Cat의 run()]");
    }
}

public class OOPExperiment {
    public static void main(String[] args) {
        // Animal 타입으로 Dog와 Cat 객체를 참조합니다.
        // 이렇게 하면 부모 타입으로 여러 자식 객체를 다룰 수 있습니다(다형성).
        Animal dog = new Dog("초코");
        Animal cat = new Cat("나비");

        // [1] Dog의 sound()가 실행됨 (오버라이딩/다형성)
        dog.sound(); // 초코: 멍멍! [1][오버라이딩/다형성]

        // [2] Cat의 sound()가 실행됨 (오버라이딩/다형성)
        cat.sound(); // 나비: 야옹~ [2][오버라이딩/다형성]

        // [3] Animal의 eat()가 실행됨 (상속/공통메서드)
        dog.eat();   // 초코가(이) 먹이를 먹는다. [3][상속/공통메서드]
        cat.eat();   // 나비가(이) 먹이를 먹는다. [3][상속/공통메서드]

        // Runnable 타입으로 Dog 객체를 참조합니다.
        // 인터페이스 타입으로도 객체를 다룰 수 있습니다.
        Runnable runner = new Dog("바둑이");
        // [5] Dog의 run()이 실행됨 (인터페이스/다형성)
        runner.run(); // 바둑이가(이) 달린다! [5][인터페이스/다형성]

        // Dog 타입으로 sound(int) 오버로딩 메서드 사용
        Dog d = new Dog("뽀삐");
        // [6] Dog의 sound(int) 오버로딩이 실행됨
        d.sound(3); // 멍! 멍! 멍! [6][오버로딩]

        // instanceof로 dog가 Jumpable을 구현했는지 확인 후 jump() 실행
        if (dog instanceof Jumpable) {
            // [7] Dog의 jump()가 실행됨 (인터페이스/instanceof)
            ((Jumpable) dog).jump(); // 초코가(이) 점프한다! [7][인터페이스/instanceof]
        }

        // Animal 배열에 Dog, Cat 객체를 넣고 sound() 호출
        Animal[] animals = { new Dog("콩이"), new Cat("루비") };
        for (Animal a : animals) {
            // [8] 각 객체의 sound()가 실행됨 (배열/다형성)
            a.sound(); // 콩이: 멍멍! [1][오버라이딩/다형성], 루비: 야옹~ [2][오버라이딩/다형성]
        }

        // --- 해설 출력 ---
        System.out.println("\n--- 해설 ---");
        System.out.println("[1] 오버라이딩/다형성: Animal 타입 dog에 실제 Dog 객체가 들어가 있으므로 Dog의 sound()가 실행됨");
        System.out.println("    → Animal dog = new Dog(\"초코\"); dog.sound(); 실행 시, Dog에서 오버라이딩한 sound()가 호출됨");
        System.out.println("[2] 오버라이딩/다형성: Animal 타입 cat에 실제 Cat 객체가 들어가 있으므로 Cat의 sound()가 실행됨");
        System.out.println("    → Animal cat = new Cat(\"나비\"); cat.sound(); 실행 시, Cat에서 오버라이딩한 sound()가 호출됨");
        System.out.println("[3] 상속/공통메서드: Animal의 eat() 메서드는 오버라이딩 없이 모든 자식이 공통적으로 사용");
        System.out.println("    → Animal의 eat()는 Dog, Cat 모두에서 별도 구현 없이 그대로 사용됨");
        System.out.println("[5] 인터페이스/다형성: Runnable 타입으로 Dog 객체를 참조, Dog의 run()이 실행됨");
        System.out.println("    → Runnable runner = new Dog(\"바둑이\"); runner.run(); 실행 시, Dog에서 구현한 run()이 호출됨");
        System.out.println("[6] 오버로딩: Dog의 sound(int repeat) 메서드, 같은 이름이지만 매개변수로 동작이 다름");
        System.out.println("    → Dog d = new Dog(\"뽀삐\"); d.sound(3); 실행 시, 3번 반복해서 \"멍!\" 출력");
        System.out.println("[7] 인터페이스/instanceof: dog가 Jumpable을 구현했는지 검사 후 jump() 실행");
        System.out.println("    → if (dog instanceof Jumpable) 조건이 true이므로, Dog의 jump() 실행");
        System.out.println("[8] 배열/다형성: Animal 배열에 Dog, Cat 객체를 넣고 sound() 호출 시 각 타입의 오버라이딩된 메서드가 실행됨");
        System.out.println("    → Animal[] animals = {new Dog(\"콩이\"), new Cat(\"루비\")}; for문에서 각 객체의 sound()가 호출됨");
    }
}