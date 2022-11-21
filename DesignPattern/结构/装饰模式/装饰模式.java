package 结构.装饰模式;

interface IThirdParty {
    String sayMsg();
}
class ThirdParty implements IThirdParty {
    public String sayMsg() {
        return "hello";
    }
}
class Decorator1 implements IThirdParty {
    private IThirdParty thirdParty;
    public Decorator1(IThirdParty thirdParty){
        this.thirdParty= thirdParty;
    }
    public String sayMsg(){
        return "##1"+ thirdParty.sayMsg() + "##1";
    }
}
class Decorator2 implements IThirdParty {
    private IThirdParty thirdParty;
    public Decorator2(IThirdParty thirdParty){
        this.thirdParty= thirdParty;
    }
    public String sayMsg(){
        return "##2"+ thirdParty.sayMsg() + "##2";
    }
}
public class 装饰模式 {
    public static void main(String[] args)
    {
        IThirdParty thirdPartyOne =new ThirdParty();
        IThirdParty decorator1 =new Decorator1(thirdPartyOne);
        IThirdParty decorator2 =new Decorator2(decorator1);
        System.out.println(decorator2.sayMsg());
    }
}
