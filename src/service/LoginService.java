<<<<<<< HEAD

=======
>>>>>>> 5d031482e1b8adaf9bead50a126f51124512905d
package service;

import static utils.CloseableUtil.*;
import static utils.DBUtil.*;

import java.sql.Connection;

import beans.User;
import dao.UserDao;
import utils.CipherUtil;

public class LoginService {

<<<<<<< HEAD
    public User login(String loginId, String password) {

        Connection connection = null;
        try {
            connection = getConnection();

            UserDao userDao = new UserDao();
            String encPassword = CipherUtil.encrypt(password);
            User user = userDao
                    .getUser(connection, loginId, encPassword);

            commit(connection);

            return user;
        } catch (RuntimeException e) {
            rollback(connection);
            throw e;
        } catch (Error e) {
            rollback(connection);
            throw e;
        } finally {
            close(connection);
        }
    }

}
=======
	public User login(String loginId, String password) {

		Connection connection = null;
		try {
			connection = getConnection();

			UserDao userDao = new UserDao();
			String encPassword = CipherUtil.encrypt(password);
			User user = userDao
					.getUser(connection, loginId, encPassword);

			commit(connection);

			return user;
		} catch (RuntimeException e) {
			rollback(connection);
			throw e;
		} catch (Error e) {
			rollback(connection);
			throw e;
		} finally {
			close(connection);
		}
	}

}
>>>>>>> 5d031482e1b8adaf9bead50a126f51124512905d
