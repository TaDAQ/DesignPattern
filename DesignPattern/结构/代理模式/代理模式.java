package 结构.代理模式;

interface Subject
{
    public void request();
}
class RealSubject implements  Subject
{
    @Override
    public void request() {
        System.out.println("真實請求");
    }
}
class Proxy implements Subject
{
    Subject subject;
    @Override
    public void request() {
        if(subject == null)
        {
            subject = new RealSubject();
        }
        subject.request();
    }

}

public class 代理模式 {
    public  static void main(String args[])
    {
        Proxy proxy = new Proxy();
        proxy.request();
    }
}
