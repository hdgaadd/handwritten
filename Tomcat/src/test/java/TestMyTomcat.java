import bootstrap.MyTomcat;
/**
 * @author hdgaadd
 * Created on 2022/02/15
 */
public class TestMyTomcat {

    public static void main(String[] args) { // access : http://localhost:8081/HelloWorld
        MyTomcat myTomcat = new MyTomcat(8081);
        myTomcat.start();
    }
}
