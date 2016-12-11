package service;

import static utils.CloseableUtil.*;
import static utils.DBUtil.*;

import java.sql.Connection;
import java.util.List;

import beans.Message;
import beans.UserMessage;
import dao.MessageDao;
import dao.UserMessageDao;

public class MessageService {

<<<<<<< HEAD
	private static final int LIMIT_NUM = 1000;

=======
>>>>>>> 5d031482e1b8adaf9bead50a126f51124512905d
	public void register(Message message) {

		Connection connection = null;
		try {
			connection = getConnection();

			MessageDao messageDao = new MessageDao();
			messageDao.insert(connection, message);

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

<<<<<<< HEAD
	public List<UserMessage> getMessage(Integer userId) {
=======

	private static final int LIMIT_NUM = 1000;

	public List<UserMessage> getMessage() {
>>>>>>> 5d031482e1b8adaf9bead50a126f51124512905d

		Connection connection = null;
		try {
			connection = getConnection();

			UserMessageDao messageDao = new UserMessageDao();
<<<<<<< HEAD
			List<UserMessage> ret = messageDao.getUserMessages(connection,
					userId, LIMIT_NUM);
=======
			List<UserMessage> ret = messageDao.getUserMessages(connection, LIMIT_NUM);
>>>>>>> 5d031482e1b8adaf9bead50a126f51124512905d

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

<<<<<<< HEAD
=======
	public List<UserMessage> getComment() {

		Connection connection = null;
		try {
			connection = getConnection();

			UserMessageDao messageDao = new UserMessageDao();
			List<UserMessage> ret = messageDao.getUserMessages(connection, LIMIT_NUM);

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
>>>>>>> 5d031482e1b8adaf9bead50a126f51124512905d
}
