
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

import org.apache.commons.lang.StringUtils;

import beans.Branch;
import beans.Position;
import beans.User;
import service.BranchService;
import service.PositionService;
import service.UserService;

@WebServlet(urlPatterns = { "/signup" })
public class SignUpServlet extends HttpServlet {
        //サーブレットクラスを継承
        private static final long serialVersionUID = 1L;
        //

        /**
         *
         * doGetメソッドでリクエストされた値を格納するrequest,
         * レスポンスの際に返却するための値responseを宣言
         * doGetはIOExceptionを起こす可能性がある
         */
        @Override
        //値を取得する際
        protected void doGet(HttpServletRequest request,
                HttpServletResponse response) throws IOException,ServletException {


            List<Branch> branches = new BranchService().getBranches();
            request.setAttribute("branch", branches);

            List<Position> positions = new PositionService().getPositions();
            request.setAttribute("position", positions);

            request.getRequestDispatcher("/signup.jsp").forward(request, response);
        }//top.jspへrequestされた内容、responseする内容の処理を移す

        @Override
        //投稿する際
        protected void doPost(HttpServletRequest request,
                HttpServletResponse response) throws IOException, ServletException {
            List messages = new ArrayList<String>();
            //このmessagesにはエラー文を入れる？
            List branches = new ArrayList<String>();
            //branch,position用のリスト

            HttpSession session = request.getSession();
            //セッションの開始
            if(isValid(request, messages) == true){
            //自作メソッド。
            //入力の内容が正しければ以下をユーザークラスに保持する？
                User user = new User();//ユーザークラスのインスタンスを宣言
                user.setName(request.getParameter("name"));
                user.setLoginId(request.getParameter("loginId"));
                user.setPassword(request.getParameter("password"));
//                user.setEmail(request.getParameter("email"));

                String hoge = request.getParameter("branchId");
                int fuga = Integer.parseInt(hoge);
                user.setBranchId(fuga);
                user.setPostId(Integer.parseInt(request.getParameter("positionId")));
                //ユーザーがリクエスト(入力)した名前の値などを保持する。

                new UserService().register(user);
                //？？

                response.sendRedirect("./");
                //./で書かれたパスのurlをレスポンスする？
            } else {
                session.setAttribute("errorMessages", messages);
                //もし値が確かでなければエラーメッセージをセッションに設定する
                session.setAttribute("branch", branches);
                //追加12.01 支店名の取得用リスト
                User user = new User();//ユーザークラスのインスタンスを宣言
                user.setName(request.getParameter("name"));
                user.setLoginId(request.getParameter("loginid"));
                user.setPassword(request.getParameter("password"));

                //追記：バリデーションして、値がDBと一致せずともフォームに保持できるようにしたい。
                //getParameter内の値が使えるように、else内にUserクラスに取ってきた値をセットするプログラムを書く。
                //今やりたいのはjspに表示させるようにどんな記述をするか。
                request.getRequestDispatcher("/signup.jsp").forward(request, response);
                //response.sendRedirect("signup");
                //signupページに遷移するようレスポンスする

            }

        }

        private boolean isValid(HttpServletRequest request,
                List<String> messages) {
            //ログイン時値を比較する
            String loginId = request.getParameter("loginId");
            //リクエストパラメータの取得
            //loginidにユーザーが最初に入力した値を送り込む
            String password = request.getParameter("password");
            //passwordにユーザーが最初に入力した値を送り込む

            if(StringUtils.isEmpty(loginId) == true) {
                messages.add("アカウントIDを入力してください");
                //入力フォームに何も打ち込まれていなかったら
                //配列に文を追加
            }
            if(StringUtils.isEmpty(password) == true) {
                messages.add("パスワードを入力してください");
                //入力フォームに何も打ち込まれていなかったら
                //配列に文を追加
            }

            if(messages.size() == 0){
            //入力抜けがなければ処理を抜ける
                return true;
            } else {
                return false;
            //入力抜けがあったらfalseを返す
            }
        }



    }