package 结构.外观模式;

class SystemOne
{
    public void methodA()
    {
        System.out.println("System One Work");
    }
}
class SystemTwo
{
    public void methodB()
    {
        System.out.println("System Two Work");
    }
}
class Facade
{
    SystemOne systemOne;
    SystemTwo systemTwo;
    public Facade(){
        systemOne = new SystemOne();
        systemTwo = new SystemTwo();
    }
    public void methodA()
    {
        System.out.println("A系统开始工作");
        systemOne.methodA();
    }
    public void methodB()
    {
        System.out.println("A系统开始工作");
        systemTwo.methodB();
    }

}
public class 外观模式 {
    public static void main(String[] args)
    {
        Facade facade = new Facade();
        facade.methodA();
    }

}

