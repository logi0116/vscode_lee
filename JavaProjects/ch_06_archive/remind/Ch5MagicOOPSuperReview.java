package remind;

import java.util.Scanner;

/**
 * ch5 마법사 학교 - 상속, 오버라이딩, 다형성, 추상클래스, 인터페이스
 * - 각 개념별 세부 사고 과정, 목적, 규칙, 해설, 마법사 대사, 실전 예제, 퀴즈, 연습 포함
 * - 초보자가 직접 값/구조를 바꿔가며 실습할 수 있도록 안내
 */
public class Ch5MagicOOPSuperReview {

    // 1. [상속] 마법사의 가문 계승
    // 핵심 규칙: 자식 클래스는 부모의 모든 public/protected 멤버(변수, 메서드)를 물려받는다.
    // 목적: 코드 재사용, 계층적 구조, 기능 확장
    // 문제해결: 중복 제거, 공통 기능은 부모에, 특화 기능은 자식에!
    static class Animal {
        protected String name;

        public Animal(String name) {
            this.name = name;
        }

        // 부모의 마법 주문
        public void speak() {
            System.out.println(name + ": (동물 소리)");
        }

        // 부모만의 기능
        public void eat() {
            System.out.println(name + "가 음식을 먹는다!");
        }
    }

    // 자식 클래스: Dog
    static class Dog extends Animal {
        public Dog(String name) {
            super(name); // 부모의 생성자 호출
        }

        // 오버라이딩: 부모의 주문을 내 스타일로 바꿈!
        @Override
        public void speak() {
            System.out.println(name + ": 멍멍!");
        }

        // Dog만의 기능
        public void wagTail() {
            System.out.println(name + "가 꼬리를 흔든다!");
        }
    }

    // 자식 클래스: Cat
    static class Cat extends Animal {
        public Cat(String name) {
            super(name);
        }

        @Override
        public void speak() {
            System.out.println(name + ": 야옹~");
        }

        // Cat만의 기능
        public void scratch() {
            System.out.println(name + "가 발톱을 세운다!");
        }
    }

    // 2. [오버라이딩] 부모의 주문을 내 스타일로 바꾸기
    // 규칙: 메서드 이름, 매개변수, 반환형 모두 같아야 함. @Override 꼭 붙이기!
    // 목적: 부모의 기본 기능을 자식이 상황에 맞게 재정의
    // 문제해결: 같은 이름의 메서드라도 자식마다 다르게 동작하게!
    static void overridingPractice() {
        System.out.println("\n[오버라이딩 연습]");
        Dog dog = new Dog("댕댕이");
        Cat cat = new Cat("냥냥이");
        dog.speak(); // "댕댕이: 멍멍!"
        cat.speak(); // "냥냥이: 야옹~"
        // 부모의 기능도 그대로 사용 가능
        dog.eat();
        cat.eat();
    }

    // 3. [업캐스팅/다운캐스팅, 다형성] 마법 도구의 변신술
    // 규칙: 부모 타입 변수로 자식 객체를 참조할 수 있다(업캐스팅)
    // 목적: 여러 자식 객체를 한 배열/리스트로 관리, 코드 유연성
    // 문제해결: 다양한 객체를 한 번에 다루고, 필요할 때만 자식 기능 사용(다운캐스팅)
    static void polymorphismPractice() {
        System.out.println("\n[다형성/업캐스팅/다운캐스팅 연습]");
        Animal[] animals = new Animal[4];
        animals[0] = new Dog("해리의 강아지");
        animals[1] = new Cat("헤르미온느의 고양이");
        animals[2] = new Dog("멍멍이");
        animals[3] = new Cat("야옹이");

        // 부모 타입으로 자식 객체를 다룸(업캐스팅)
        for (Animal a : animals) {
            a.speak(); // 실제로는 각 자식의 speak() 실행(다형성)
        }

        // 자식만의 기능은 다운캐스팅해서 사용
        for (Animal a : animals) {
            if (a instanceof Dog) {
                Dog d = (Dog) a;
                d.wagTail();
            } else if (a instanceof Cat) {
                Cat c = (Cat) a;
                c.scratch();
            }
        }
    }

    // 4. [추상 클래스] 마법사의 규약서
    // 규칙: 추상 메서드는 반드시 자식이 구현해야 함. 객체 생성 불가!
    // 목적: "이런 기능은 꼭 만들어라!"라는 강제 규칙
    // 문제해결: 공통 규약 제공, 실수 방지
    static abstract class Shape {
        String kind;

        public Shape(String kind) {
            this.kind = kind;
        }

        // 추상 메서드: 반드시 자식이 구현해야 함!
        public abstract void draw();

        public void showInfo() {
            System.out.println("도형 종류: " + kind);
        }
    }

    static class Circle extends Shape {
        public Circle() {
            super("원");
        }

        @Override
        public void draw() {
            System.out.println("원을 그린다!");
        }
    }

    static class Rectangle extends Shape {
        public Rectangle() {
            super("사각형");
        }

        @Override
        public void draw() {
            System.out.println("사각형을 그린다!");
        }
    }

    // 5. [인터페이스] 마법사의 의무 계약서
    // 규칙: 모든 메서드는 public abstract(생략 가능), 다중 구현 가능
    // 목적: "이런 기능을 반드시 만들어라!"라는 계약
    // 문제해결: 다양한 클래스에 동일한 기능 강제, 다중 구현
    interface Flyable {
        void fly(); // 반드시 구현해야 하는 추상 메서드
    }

    static class Bird implements Flyable {
        @Override
        public void fly() {
            System.out.println("새가 훨훨 난다!");
        }
    }

    static class Airplane implements Flyable {
        @Override
        public void fly() {
            System.out.println("비행기가 하늘을 난다!");
        }
    }

    // 6. [실전 퀴즈1] 동물 가문/오버라이딩/다형성/업다운캐스팅
    static void animalQuiz(Scanner scanner) {
        System.out.println("\n[퀴즈1] 동물 가문 만들기/오버라이딩/다형성/업다운캐스팅");
        System.out.print("동물의 수를 입력하세요(예: 3): ");
        int n = scanner.nextInt();
        scanner.nextLine();
        Animal[] animals = new Animal[n];

        // 동물 종류와 이름을 입력받아 배열에 저장
        for (int i = 0; i < n; i++) {
            System.out.print((i+1) + "번째 동물 종류 입력(dog/cat): ");
            String type = scanner.nextLine();
            System.out.print("이름 입력: ");
            String name = scanner.nextLine();
            if (type.equalsIgnoreCase("dog")) {
                animals[i] = new Dog(name);
            } else {
                animals[i] = new Cat(name);
            }
        }

        // speak() 호출(다형성)
        for (Animal a : animals) {
            a.speak();
        }

        // 자식만의 기능 사용(다운캐스팅)
        for (Animal a : animals) {
            if (a instanceof Dog) {
                ((Dog)a).wagTail();
            } else if (a instanceof Cat) {
                ((Cat)a).scratch();
            }
        }
        // 값을 바꿔보고 싶으면 n, type, name 입력값을 다양하게 바꿔보세요!
    }

    // 7. [실전 퀴즈2] 추상 클래스/인터페이스/다형성
    static void shapeFlyableQuiz() {
        System.out.println("\n[퀴즈2] 추상 클래스/인터페이스/다형성 연습");
        Shape[] shapes = { new Circle(), new Rectangle() };
        for (Shape s : shapes) {
            s.showInfo();
            s.draw();
        }

        Flyable[] flyers = { new Bird(), new Airplane() };
        for (Flyable f : flyers) {
            f.fly();
        }
        // 직접 Circle, Rectangle, Bird, Airplane 클래스를 수정하거나 추가해보세요!
    }

    // 8. [실전 퀴즈3] 마법 동물원(상속+다형성+추상+인터페이스)
    static abstract class MagicAnimal {
        String name;
        public MagicAnimal(String name) { this.name = name; }
        public abstract void magicSound();
        public void showInfo() { System.out.println("마법 동물 이름: " + name); }
    }
    interface Swimmable { void swim(); }
    interface FireBreathable { void fireBreath(); }

    static class Dragon extends MagicAnimal implements Flyable, FireBreathable {
        public Dragon(String name) { super(name); }
        @Override public void magicSound() { System.out.println(name + ": 쿠와앙!"); }
        @Override public void fly() { System.out.println(name + "이(가) 하늘을 난다!"); }
        @Override public void fireBreath() { System.out.println(name + "이(가) 불을 뿜는다!"); }
    }
    static class Mermaid extends MagicAnimal implements Swimmable {
        public Mermaid(String name) { super(name); }
        @Override public void magicSound() { System.out.println(name + ": 라라라~"); }
        @Override public void swim() { System.out.println(name + "이(가) 바다를 헤엄친다!"); }
    }
    static class Phoenix extends MagicAnimal implements Flyable, FireBreathable {
        public Phoenix(String name) { super(name); }
        @Override public void magicSound() { System.out.println(name + ": 피닉스의 울음소리!"); }
        @Override public void fly() { System.out.println(name + "이(가) 불꽃과 함께 난다!"); }
        @Override public void fireBreath() { System.out.println(name + "이(가) 불을 뿜는다!"); }
    }

    static void magicZooQuiz() {
        System.out.println("\n[퀴즈3] 마법 동물원(상속+다형성+추상+인터페이스)");
        MagicAnimal[] zoo = {
            new Dragon("드라고"),
            new Mermaid("아리엘"),
            new Phoenix("피닉스")
        };
        for (MagicAnimal m : zoo) {
            m.showInfo();
            m.magicSound();
            // 다형성+인터페이스 활용
            if (m instanceof Flyable) ((Flyable)m).fly();
            if (m instanceof Swimmable) ((Swimmable)m).swim();
            if (m instanceof FireBreathable) ((FireBreathable)m).fireBreath();
            System.out.println();
        }
        // 직접 zoo 배열에 동물을 추가/삭제/순서변경 해보세요!
    }

    // 9. [핵심 규칙/원리/비유/해설]
    static void magicSummary() {
        System.out.println("\n=== ch5 마법사 학교 핵심 규칙/비유/해설 ===");
        System.out.println("1. 상속(extends): 부모의 마법을 자식이 물려받는다. (코드 재사용, 계층 구조)");
        System.out.println("2. 오버라이딩(@Override): 부모의 주문을 내 스타일로 바꾼다. (동일 시그니처, 내용만 다름)");
        System.out.println("3. 업캐스팅: 자식은 부모 타입으로 변신할 수 있다. (다형성, 배열/리스트 관리)");
        System.out.println("4. 다운캐스팅: 부모 타입을 자식 타입으로 되돌릴 수 있다. (자식만의 기능 사용)");
        System.out.println("5. 추상 클래스(abstract): '이런 기능은 꼭 만들어라!'라는 규약서. (객체 생성 불가)");
        System.out.println("6. 인터페이스(interface): '이런 기능을 반드시 만들어라!'라는 계약서. (다중 구현 가능)");
        System.out.println("7. 다형성: 여러 마법 도구(객체)를 한 번에 다루는 마법!");
        System.out.println("8. instanceof: 실제 타입을 확인하는 마법의 감별 주문!");
        System.out.println("9. 값을 바꿔보고 싶으면, 동물/도형/마법동물의 종류, 이름, 배열 크기 등을 다양하게 수정해보세요!");
    }

    // 10. [실행 메인]
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== ch5 마법사 학교 상속/다형성/추상/인터페이스 복습 ===");

        // 1. 상속/오버라이딩 연습
        overridingPractice();

        // 2. 업캐스팅/다운캐스팅/다형성 연습
        polymorphismPractice();

        // 3. 추상 클래스/인터페이스 연습
        Shape circle = new Circle();
        Shape rectangle = new Rectangle();
        circle.showInfo();
        circle.draw();
        rectangle.showInfo();
        rectangle.draw();

        Flyable bird = new Bird();
        Flyable airplane = new Airplane();
        bird.fly();
        airplane.fly();

        // 4. 퀴즈1: 동물 가문/오버라이딩/다형성/업다운캐스팅
        animalQuiz(scanner);

        // 5. 퀴즈2: 추상 클래스/인터페이스/다형성
        shapeFlyableQuiz();

        // 6. 퀴즈3: 마법 동물원(상속+다형성+추상+인터페이스)
        magicZooQuiz();

        // 7. 핵심 규칙/비유/해설
        magicSummary();

        scanner.close();
        System.out.println("\n=== ch5 복습 마법 끝! ===");
    }
}