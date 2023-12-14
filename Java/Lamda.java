interface Intr1{
    void fun1();
}
interface Intr2{
    int fun2(int a,int b);
}
public class Lamda {
    public static void main(String[] args) {
        Intr1 i1=new Intr1() {
            @Override
            public void fun1() {
                System.out.println("this is anonymous innerclass implementaion");
            }
        };
        Intr2 i2= (a,b)->a+b;

    }
}
