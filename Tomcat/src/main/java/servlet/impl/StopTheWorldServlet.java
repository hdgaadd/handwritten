package servlet.impl;

import dto.MyRequest;
import dto.MyResponse;
import servlet.MyServlet;

import java.io.IOException;
/**
 * @author hdgaadd
 * Created on 2022/02/15
 */
public class StopTheWorldServlet extends MyServlet {



    @Override
    public void doGet(MyRequest request, MyResponse response) {
        try {
            response.write("stop get the world");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @Override
    public void doPost(MyRequest request, MyResponse response) {
        try {
            response.write("stop post the world");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
