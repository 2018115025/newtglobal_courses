public class Program2 extends Demo{
    @Override
    public int mul(int a,int b) {
        return a+b;
    }
    public static int div(int a,int b) throws ArithmeticException{
        if(b==0){
            throw new ArithmeticException("error");
        }
        else{
            return a/b;
        }
    }
    public static void main(String[] args) {

        try {
            Demo p = new Program2();
            int ans = p.mul(1, 2);
            System.out.println(ans);
            div(1,0);
            int x=1/0;
            System.out.println(ans+1);
        }catch (ArithmeticException a){
            System.out.println("exception occurs");
        }
        finally {
            System.out.println("code ended here");
        }
    }
}
