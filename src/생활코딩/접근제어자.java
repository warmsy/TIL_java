package 생활코딩;
/**
 * 접근 제어자
 * : 클래스의 멤버(변수, 메소드)들의 접근 권한을 지정하는 것
 * private > default > protect > public 순으로 오픈마인드
 * private :
 * default :
 * protected :
 * public
 * */
class A{    // 이거슨 클래스
    public String y(){  // 이거슨 메소드
        return "public void y()";
    }
    private String z(){
        return "private void z()";
    }
    public String x(){
        System.out.println("this is X i'll call x()");
        return z();
    }
}
public class 접근제어자 {
    public static void main(String[] args) {    // main 메소드, 프로그램의 시작점, 하나의 클래스엔 하나의 메인만을 가짐
        A a = new A();
        System.out.println(a.y());
        // 아래는 에러 발생 > private에 접근했기 때문.
//        System.out.println(a.z());
        System.out.println(a.x());
    }
}
