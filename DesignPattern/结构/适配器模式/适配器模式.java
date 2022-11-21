package 结构.适配器模式;

class Target
{
    public void request()
    {
        System.out.println("普通请求");
    }
}
class Adaptee
{
    public void specificRequest()
    {
        System.out.println("特殊请求");
    }
}
class  Adapter extends Target
{
    Adaptee adaptee = new Adaptee();
    public void request()
    {
        adaptee.specificRequest();
    }
}
public class 适配器模式 {
    public static void main(String[] args){
        Target target = new Adapter();
        target.request();
    }
}
