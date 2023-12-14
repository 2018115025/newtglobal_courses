public class Program2 extends Demo{
    @Override
    public int mul(int a,int b) {
        return a+b;
    }
    public static void main(String[] args) {
        Demo p=new Program2();
        int ans=p.mul(1,2);
        System.out.println(ans);
    }
}
