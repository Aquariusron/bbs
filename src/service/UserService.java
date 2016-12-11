package service;

import static utils.CloseableUtil.*;
import static utils.DBUtil.*;

import java.sql.Connection;
<<<<<<< HEAD
=======
import java.util.List;

import org.apache.commons.lang.StringUtils;
>>>>>>> 5d031482e1b8adaf9bead50a126f51124512905d

import beans.User;
import dao.UserDao;
import utils.CipherUtil;
<<<<<<< HEAD

public class UserService {

    public void register(User user) {

        Connection connection = null;
        try {
            connection = getConnection();

            String encPassword = CipherUtil.encrypt(user.getPassword());
            user.setPassword(encPassword);

//            setDefaultIcon(user);

            UserDao userDao = new UserDao();
            userDao.insert(connection, user);

            commit(connection);
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


    public void update(User user) {

        Connection connection = null;
        try {
            connection = getConnection();

            String encPassword = CipherUtil.encrypt(user.getPassword());
            user.setPassword(encPassword);

            UserDao userDao = new UserDao();
            userDao.update(connection, user);

            commit(connection);
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

    public User getUser(int userId) {

        Connection connection = null;
        try {
            connection = getConnection();

            UserDao userDao = new UserDao();
            User user = userDao.getUser(connection, userId);

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
public class UserService {

	public void register(User user) {

		Connection connection = null;
		try {
			connection = getConnection();

			String encPassword = CipherUtil.encrypt(user.getPassword());
			user.setPassword(encPassword);

			UserDao userDao = new UserDao();
			userDao.insert(connection, user);

			commit(connection);
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


	public void update(User user) {

		Connection connection = null;
		try {
			connection = getConnection();

			//空だったら以下の処理をしないif..入ってたら以下の処理をする
			if(!(StringUtils.isEmpty(user.getPassword()) == true)){
				String encPassword = CipherUtil.encrypt(user.getPassword());
				user.setPassword(encPassword);
			}

			UserDao userDao = new UserDao();
			userDao.update(connection, user);

			commit(connection);
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

	public void activeUpdate(User user) {

		Connection connection = null;
		try {
			connection = getConnection();

			UserDao userDao = new UserDao();
			userDao.activeUpdate(connection, user);

			commit(connection);
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

	public User getUser(int userId) {

		Connection connection = null;
		try {
			connection = getConnection();

			UserDao userDao = new UserDao();
			User user = userDao.getUser(connection, userId);

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

	public List<User> getUsers() {

		Connection connection = null;
		try {
			connection = getConnection();

			UserDao userDao = new UserDao();
			List<User> ret = userDao.getUsers(connection);

			commit(connection);

			return ret;
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
