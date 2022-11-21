package 创建.抽象工厂模式;

interface Computer {
    void powerOn();

    void powerOff();
}

interface Phone {
    void call();
}

class HuaweiComputer implements Computer {
    @Override
    public void powerOn() {
        System.out.println("HuaweiDesktopComputer power on");
    }

    @Override
    public void powerOff() {
        System.out.println("HuaweiDesktopComputer power off");
    }
}

class HuaweiPhone implements Phone {
    @Override
    public void call() {
        System.out.println("使用华为手机打电话");
    }

}

class XiaomiPhone implements Phone {
    @Override
    public void call() {
        System.out.println("使用小米手机打电话");
    }

}

class XiaomiComputer implements Computer {
    @Override
    public void powerOn() {
        System.out.println("XMDesktopComputer power on");
    }

    @Override
    public void powerOff() {
        System.out.println("XMDesktopComputer power off");
    }
}

abstract class Factory {

    public abstract Computer createComputer();

    public abstract Phone createPhone();

}

class HuaweiFactory extends Factory {

    @Override
    public Computer createComputer() {
        return new HuaweiComputer();
    }

    @Override
    public Phone createPhone() {
        return new HuaweiPhone();
    }

}

class XiaomiFactory extends Factory {

    @Override
    public Computer createComputer() {
        return new XiaomiComputer();
    }

    @Override
    public Phone createPhone() {
        return new XiaomiPhone();
    }

}

class Client {
    public static void main(String[] args) {
        Factory factory = new HuaweiFactory();
        Computer computer = factory.createComputer();
        computer.powerOn();
        computer.powerOff();
        Phone phone = factory.createPhone();
        phone.call();
    }
}