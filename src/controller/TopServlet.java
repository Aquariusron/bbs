package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/index.jsp" })
//indexから始まるパラメータを指定
public class TopServlet extends HttpServlet{
    //サーブレットクラスを継承
    private static final long serialVersionUID = 1L;
    //
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        //top.jspへrequestされた内容、responseする内容の処理を移す
        request.getRequestDispatcher("/top.jsp").forward(request, response);
    }

}
