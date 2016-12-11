package controller;

import java.io.IOException;
<<<<<<< HEAD
=======
import java.util.List;
>>>>>>> 5d031482e1b8adaf9bead50a126f51124512905d

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

<<<<<<< HEAD
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
=======
import beans.Comment;
import beans.User;
import beans.UserMessage;
import service.CommentService;
import service.MessageService;
@WebServlet(urlPatterns = { "/index.jsp" })
//indexから始まるパラメータを指定
public class TopServlet extends HttpServlet{
	//サーブレットクラスを継承
	private static final long serialVersionUID = 1L;
	//
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {

		User user = (User) request.getSession().getAttribute("loginUser");


		List<UserMessage> messages = new MessageService().getMessage();

		request.setAttribute("messages", messages);

		List<Comment> comments = new CommentService().getComment();

		request.setAttribute("comments", comments);
		request.getRequestDispatcher("/top.jsp").forward(request, response);
		//top.jspへrequestされた内容、responseする内容の処理を移す

//		List<UserMessages> messages = new MessageService().getUser();


	}
>>>>>>> 5d031482e1b8adaf9bead50a126f51124512905d

}
