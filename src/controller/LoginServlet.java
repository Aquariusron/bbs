<<<<<<< HEAD

=======
>>>>>>> 5d031482e1b8adaf9bead50a126f51124512905d
package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.User;
import service.LoginService;
@WebServlet(urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
<<<<<<< HEAD
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        String loginId = request.getParameter("loginId");
        String password = request.getParameter("password");

        LoginService loginService = new LoginService();
        User user = loginService.login(loginId, password);

        HttpSession session = request.getSession();
        if (user != null) {

            session.setAttribute("loginService", user);
            response.sendRedirect("./");
        } else {

            List<String> messages = new ArrayList<String>();
            messages.add("ログインに失敗しました。");
            session.setAttribute("errorMessages", messages);
            response.sendRedirect("login");
        }
    }

}
=======
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {

		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {

		String loginId = request.getParameter("loginId");
		String password = request.getParameter("password");

		LoginService loginService = new LoginService();
		User user = loginService.login(loginId, password);

		HttpSession session = request.getSession();

		if (user != null && user.getStop()) {

			session.setAttribute("loginUser", user);
			response.sendRedirect("./");
		} else {

			List<String> messages = new ArrayList<String>();
			messages.add("ログインに失敗しました。");
			session.setAttribute("errorMessages", messages);
			response.sendRedirect("login");
		}

	}

}
>>>>>>> 5d031482e1b8adaf9bead50a126f51124512905d
