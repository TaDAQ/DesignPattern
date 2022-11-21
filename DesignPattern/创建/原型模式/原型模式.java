package 创建.原型模式;

class Person implements Cloneable {
    private String name;
    private String sex;
    private Integer age;
    public Person friend;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public Object clone() {
        Person person= null;
        try {
            person = (Person) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return person;
    }
}

public class 原型模式 {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("www");

        Person newPerson = (Person) person.clone();
        System.out.println("newPerson name = " + newPerson.getName());
    }
}
