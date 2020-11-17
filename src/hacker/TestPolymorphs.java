package hacker;

public class TestPolymorphs {
public static void main(String args[]) {
    B b = new B();
    b.m1();b.callM();b.superM();
    A a = new B();
    a.m1();a.callM();
    A a1 = new A();
    a1.m1();a.callM();
}
}

interface I1 {
    default void m1(){
        System.out.print("I1 ");
    }
        }

interface I2 extends I1{
    default void m1(){
        System.out.print("I2 ");
    }
}

class A implements I1{
    public void callM(){
        m1();
    }
}
class B extends A implements I2{
    public void superM(){
        super.m1();
    }
}