package com.codeman.servlet;

import com.codeman.http.Request;
import com.codeman.http.Response;

/**
 * @author hdgaadd
 * Created on 2022/04/27
 */
public class FirstServlet extends Servlet {
    @Override
    public void doGet(Request xcRequest, Response xcResponse) throws Exception {
        this.doPost(xcRequest, xcResponse);
    }

    @Override
    public void doPost(Request xcRequest, Response xcResponse) throws Exception {
        xcResponse.write("this is the first servlet from nio");
    }
}
