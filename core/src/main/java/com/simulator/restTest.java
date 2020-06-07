package com.simulator;

import com.backendchannel.dummy.DummyResponse;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class restTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(response());
        request.getParameter("accNo");
        try (PrintWriter out = response.getWriter()) {
            out.print(response());

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(response());
        try (PrintWriter out = response.getWriter()) {
            out.print(response());

        }
    }

    protected String response(){
        DummyResponse response = new DummyResponse();
        Long randNum = 10000000 + (long) (Math.random() * (999999999 - 10000000));
        response.setBlnc(randNum+"");

        Gson gson = new Gson();

       return gson.toJson(response);

    }
}
