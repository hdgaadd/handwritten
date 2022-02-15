package servlet.impl;

import dto.MyRequest;
import dto.MyResponse;
import servlet.MyServlet;

import java.io.IOException;
/**
 * @author hdgaadd
 * Created on 2022/02/15
 */
public class HelloWorldServlet extends MyServlet {


    @Override
    public void doGet(MyRequest request, MyResponse response) {
        try {
            response.write("get the world");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @Override
    public void doPost(MyRequest request, MyResponse response) {
        try {
            response.write("post the world");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
