package 行为.解释器模式;

class Context
{
    String name;
    int age;
    public  Context(String name,int age)
    {
        this.name = name;
        this.age = age;
    }
}
interface Expression
{
    void expect(Context context);
}
class AdultExpression implements  Expression
{
    @Override
    public void expect(Context context) {
        if(context.age >= 16)
        {
            System.out.println(context.name+"是一个成年人");
        }
    }
}
class  MinorExpression implements  Expression
{
    @Override
    public void expect(Context context) {
        if(context.age < 16)
        {
            System.out.println(context.name+"是一个未成年人");
        }
    }
}
public class 解释器模式 {
    public static  void main(String[] args)
    {
        Context context = new Context("张三",10);
        AdultExpression adultExpression = new AdultExpression();
        MinorExpression minorExpression = new MinorExpression();
        minorExpression.expect(context);
        adultExpression.expect(context);
    }
}
