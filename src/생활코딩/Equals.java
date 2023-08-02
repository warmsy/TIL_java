package 생활코딩;

class Student {
    String name;

    Student(String name) {
        this.name = name;
    }

    // 두 객체 내의 이름이같으면 같은 객체라 하고 싶을 떄 equals 오버라이딩
    public boolean equals(Object obj) {
        Student s = (Student) obj;
        return this.name == s.name;
        // equals 구현시 hashCode도 함께 구현해야 함.
        // 생활코딩에선 알려주지 않았지만 꼭.. 꼭 낟중엔 꼭 구현할 수 있을 정도로
        // 성장한 개발자가 되고싶다.
    }
}

public class Equals {
    public static void main(String[] args) {
        Student s1 = new Student("egoing");
        Student s2 = new Student("egoing");
        System.out.println(s1 == s2);   //
        System.out.println(s1.equals(s2));

    }
}
