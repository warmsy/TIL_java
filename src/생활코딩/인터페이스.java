package 생활코딩;
interface I2{
    public String A();
}
interface I3{
    public String B();
}
class D implements I2,I3{
    @Override
    public String A() {
        return "A from class D";
    }
    @Override
    public String B() {
        return "B from class D";
    }
}
public class 인터페이스 {
    public static void main(String[] args) {
        D obj1 = new D();
        I2 obj2 = new D();
        I3 obj3 = new D();

        System.out.println("Data Type : D "+obj1.A());
        System.out.println("Data Type : D "+obj1.B());

        System.out.println("Data Type : I2 "+obj2.A());
//        System.out.println(obj2.B());
//        System.out.println(obj3.A());
        System.out.println("Data Type : I3 "+obj3.B());
    }
}
