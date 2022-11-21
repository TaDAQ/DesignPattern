package 行为.备忘录模式;
class  Memento
{
    private int state;
    public Memento(int state)
    {
        this.state = state;
    }
    public int getState()
    {
        return  this.state;
    }
}
class Originator
{
    public void setState(int state) {
        this.state = state;
    }

    private  int state;
    public Originator(int state)
    {
        this.state = state;
    }
    public Memento createMemento()
    {
       return new Memento(state);
    }
    public void setMemento(Memento memento)
    {
        state = memento.getState();
    }
    public void show()
    {
        System.out.println("State="+state);
    }
}
class  Caretaker
{
    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
    private  Memento memento;

}
public class 备忘录模式 {
   public static void main(String[] args)
   {
       Originator originator = new Originator(100);
       originator.show();
       Caretaker caretaker = new Caretaker();
       caretaker.setMemento(originator.createMemento());
       originator.setState(1000);
       originator.show();
       originator.setMemento(caretaker.getMemento());
       originator.show();
   }
}
