package 结构.桥接模式;

interface Operator
{
    void operate();
}
class Model
{
    Operator operator;
    public void setOperator(Operator operator)
    {
        this.operator = operator;
    }
    public void show()
    {
        System.out.println("开始操作拉");
        operator.operate();
    }
}
class  ConcreteOperator implements  Operator
{

    @Override
    public void operate() {
        System.out.println("A步骤开始实施");
    }
}
class  ConcreteOperator1 implements  Operator
{

    @Override
    public void operate() {
        System.out.println("B步骤开始实施");
    }
}
public class 桥接模式 {
    public static void main(String[] args){
        Model model = new Model();
        model.setOperator(new ConcreteOperator());
        model.show();
        model.setOperator(new ConcreteOperator1());
        model.show();
    }
}
