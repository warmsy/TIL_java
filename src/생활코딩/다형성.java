package 생활코딩;

class AX {
    public String x() {
        return "this is A class";
    }
}
class BXY1 extends AX {
    public String x() {
        return "this it x from class BXY";
    }
    public String y1() {
        return "this is y from class BXY";
    }
}

class BXY2 extends AX {
    public String x() {
        return "this it x from class BXY2";
    }
    public String y2() {
        return "this is y from class BXY2";
    }
}

public class 다형성 {
    public static void main(String[] args) {
        AX obj1 = new BXY1();
        AX obj2 = new BXY2();

        System.out.println(obj1.x());
        System.out.println(obj2.x());

        System.out.println(((BXY1)obj1).y1());
        System.out.println(((BXY2)obj2).y2());
    }
}
