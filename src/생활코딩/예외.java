package 생활코딩;

public class 예외 {
    public static void main(String[] args) {
        SimpleCalculator sc = new SimpleCalculator();
        sc.setOprands(10, 0);
        try {
            sc.divide();
        }
        catch (ArithmeticException e){  // 만약 예외가 Arithmetic 이면,
            System.out.println("ArithmeticException");  // 이 줄을 실행해라
        } catch (Exception e){  // 그외에 포괄적인 에러 발생시
            System.out.println("Exception");   // 이 줄 실행
        }
        finally {
            System.out.println("finally! 작업의 뒷처리 담당" );
        }

//        catch (Exception e){
//            System.out.println("\n e.getMessage()"+ e.getMessage());
//            System.out.println("\n e.toString()"+ e.toString());
//            System.out.println("\n e.printStackTrace()"); //  리턴타입 없음
//            e.printStackTrace();
//        }
    }
}
