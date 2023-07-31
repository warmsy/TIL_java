package 생활코딩;

public class SimpleCalculator {
    private int left, right;

    public void setOprands(int left, int right) {
        this.left = left;
        this.right = right;
    }

    private int sum() {
        return (this.left + this.right);
    }

    private int minus() {
        return (this.left - this.right);
    }

    public void sumDeco() {
        System.out.println("++++++" + sum() + "++++++");
    }

    public void minusDeco() {
        System.out.println("-----" + minus() + "-----");
    }

    public void divide(){
        System.out.println("divide : "+ this.left / this.right);
    }

}




class Main1 {
    public static void main(String[] args) {
        SimpleCalculator c = new SimpleCalculator();
        c.setOprands(20, 30);
        c.minusDeco();
        c.sumDeco();
    }
}
