public class Program1 {
    public int fun(int a,int b){
        return a+b;
    }
    public int fun(int a,int b,int c){
        return a+b+c;
    }

    public static void main(String[] args) {
        Program1 p=new Program1();
        int ans1=p.fun(1,2);
        int ans2=p.fun(1,2,3);
        System.out.println(ans1+"\n"+ans2);
    }
}
