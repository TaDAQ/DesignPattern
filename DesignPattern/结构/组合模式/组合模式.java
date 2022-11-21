package 结构.组合模式;

import java.util.ArrayList;
import java.util.List;

abstract class Component
{
    String name;
    public Component(String name)
    {
        this.name = name;
    }
    public abstract void add(Component component);
    public abstract void remove(Component component);
    public abstract void display(int depth);
}
class Leaf extends Component
{

    public Leaf(String name) {
        super(name);
    }

    @Override
    public void add(Component component) {
        System.out.println("cannot add a leaf");
    }

    @Override
    public void remove(Component component) {
        System.out.println("cannot remove from a leaf");
    }

    @Override
    public void display(int depth) {
        System.out.println(depth+name);
    }
}
class  Composite extends Component
{
    List<Component>  children = new ArrayList<Component>();
    public Composite(String name) {
        super(name);
    }

    @Override
    public void add(Component component) {
        children.add(component);
    }

    @Override
    public void remove(Component component) {
        children.remove(component);
    }

    @Override
    public void display(int depth) {
        System.out.println(depth + name);
        for(Component component:children)
        {
            component.display(depth + 2);
        }
    }


}
public class 组合模式 {
    public static  void main(String[] args)
    {
        Composite root = new Composite("root");
        root.add(new Leaf("Leaf A"));
        root.display(2);
    }
}
