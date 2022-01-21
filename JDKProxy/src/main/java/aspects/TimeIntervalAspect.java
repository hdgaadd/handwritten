package aspects;

public class TimeIntervalAspect extends SimpleAspect {
    public void before(){
        System.out.println("------befre方法------");
    }
    public void after(){
        System.out.println("------after方法------");
    }
}
