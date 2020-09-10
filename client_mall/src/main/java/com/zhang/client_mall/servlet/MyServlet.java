package com.zhang.client_mall.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zhang
 * @date 2020-09-01
 * @descript
 */
@WebServlet(urlPatterns = "/my/servlet")
public class MyServlet extends HttpServlet {
//    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        resp.getWriter().print("Hellow world!");
    }
}
