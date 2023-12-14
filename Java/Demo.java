public class Demo {
    int a;
    public static int add(int a,int b){
        return a+b;
    }
    public int mul(int a,int b){
        return a*b;
    }

    public static void main(String[] args) {
        Demo d=new Demo();
        add(1,2);
        d.mul(2,3);
    }
}
