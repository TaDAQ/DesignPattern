package 创建.单例模式;

class Singleton {
    private static Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public void printLog() {

    }
}

public class 单例模式 {
    public static void main(String[] args) {
        Singleton.getInstance().printLog();
    }
}