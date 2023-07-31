package 생활코딩;

abstract class Calculator {
    int right, left;

    public void setOprands(int left, int right) {
        this.left = left;
        this.right = right;
    }
    int _sum(){
        return this.left + this.right;
    }
    // 추상메소드
    public abstract void sum();
    public abstract void avg();
    public void run() { // sum, avg 호출하는 역할
        sum();
        avg();
    }
}

class CalculatorDecoPlus extends Calculator {
    @Override
    public void sum() {
        System.out.println("++ sum" + (this.left + this.right));
    }

    @Override
    public void avg() {
        System.out.println("++ avg" + (this.left + this.right) / 2);
    }
}

class CalculatorDecoMinus extends Calculator {
    @Override
    public void sum() {
        System.out.println("-- sum" + (this.left + this.right));
    }

    @Override
    public void avg() {
        System.out.println("-- avg" + (this.left + this.right) / 2);
    }
}

public class 추상화 {
    public static void execute(Calculator cal){
        System.out.println("실행결과");
        cal.run();
    }

    public static void main(String[] args) {
        Calculator c1 = new CalculatorDecoPlus();   // c1과 c2는 다르게 동작하지만 같은 데이터 타입을 가진다.
        c1.setOprands(15, 25);

        Calculator c2 = new CalculatorDecoMinus();
        c2.setOprands(16, 14);

        execute(c1);
        execute(c2);
    }
}