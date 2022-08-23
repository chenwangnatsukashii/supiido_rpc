package com.example.dubbosimulate.framework.protocol.http;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DispatcherServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) {
        new HttpServerHandler().handler(req, res);
    }
}
