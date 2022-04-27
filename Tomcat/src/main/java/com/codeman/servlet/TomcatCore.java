package com.codeman.servlet;

import com.codeman.http.XCServlet;

import java.net.ServerSocket;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author hdgaadd
 * Created on 2022/04/27
 */
public class TomcatCore {

    private int port = 8080;

    private ServerSocket serverSocket;

    private Properties webxml = new Properties();

    private Map<String, XCServlet> servletMapping = new HashMap<>();


    public static void main(String[] args) {

    }
}
