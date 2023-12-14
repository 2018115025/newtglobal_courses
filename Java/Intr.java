public interface Intr {
    int sum(int a,int b);
    int mul(int a,int b);
}
enum Days{
    SUNDAY,MONDAY
}

class Sample implements Intr{
    public static void main(String[] args) {
        Days s=Days.MONDAY;
        System.out.println(s);
        Sample sample=new Sample();
        int a1=sample.sum(2,3);
        int a2=sample.mul(2,3);
        System.out.println(a1+"\n"+a2);
    }

    @Override
    public int sum(int a, int b) {
        return a+b;
    }

    @Override
    public int mul(int a, int b) {
        return a*b;
    }
}

