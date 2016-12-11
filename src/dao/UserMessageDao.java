package dao;

import static utils.CloseableUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import beans.UserMessage;
import exception.SQLRuntimeException;

public class UserMessageDao {

<<<<<<< HEAD
	public List<UserMessage> getUserMessages(Connection connection,
			Integer userId, int num) {
=======
	public List<UserMessage> getUserMessages(Connection connection, int num) {
>>>>>>> 5d031482e1b8adaf9bead50a126f51124512905d

		PreparedStatement ps = null;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM user_message ");
<<<<<<< HEAD
			if (userId != null) {
				sql.append("WHERE user_id = ?");
			}
			sql.append("ORDER BY insert_date DESC limit " + num);

			ps = connection.prepareStatement(sql.toString());

			if (userId != null) {
				ps.setInt(1, userId);
			}

=======
			sql.append("ORDER BY insert_at DESC limit " + num);

			ps = connection.prepareStatement(sql.toString());

>>>>>>> 5d031482e1b8adaf9bead50a126f51124512905d
			ResultSet rs = ps.executeQuery();
			List<UserMessage> ret = toUserMessageList(rs);
			return ret;
		} catch (SQLException e) {
			throw new SQLRuntimeException(e);
		} finally {
			close(ps);
		}
	}

<<<<<<< HEAD
=======
	public List<UserMessage> getUserComments(Connection connection, int num) {

		PreparedStatement ps = null;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM user_comment ");
			sql.append("ORDER BY insert_dt DESC limit " + num);

			ps = connection.prepareStatement(sql.toString());

			ResultSet rs = ps.executeQuery();
			List<UserMessage> ret = toUserCommentList(rs);
			return ret;
		} catch (SQLException e) {
			throw new SQLRuntimeException(e);
		} finally {
			close(ps);
		}
	}

>>>>>>> 5d031482e1b8adaf9bead50a126f51124512905d
	private List<UserMessage> toUserMessageList(ResultSet rs)
			throws SQLException {

		List<UserMessage> ret = new ArrayList<UserMessage>();
		try {
			while (rs.next()) {
<<<<<<< HEAD
				String account = rs.getString("account");
				String name = rs.getString("name");
				int id = rs.getInt("id");
				int userId = rs.getInt("user_id");
				String text = rs.getString("text");
				Timestamp insertDate = rs.getTimestamp("insert_date");

				UserMessage message = new UserMessage();
				message.setAccount(account);
				message.setName(name);
				message.setId(id);
				message.setUserId(userId);
				message.setText(text);
=======
				String subject = rs.getString("subject");
				String text = rs.getString("text");
				String category = rs.getString("category");
				Timestamp insertDate = rs.getTimestamp("insert_at");

				UserMessage message = new UserMessage();
				message.setSubject(subject);
				message.setText(text);
				message.setCategory(category);
>>>>>>> 5d031482e1b8adaf9bead50a126f51124512905d
				message.setInsertDate(insertDate);

				ret.add(message);
			}
<<<<<<< HEAD
=======

>>>>>>> 5d031482e1b8adaf9bead50a126f51124512905d
			return ret;
		} finally {
			close(rs);
		}
	}

<<<<<<< HEAD
=======

	private List<UserMessage> toUserCommentList(ResultSet rs)
			throws SQLException {

		List<UserMessage> ret = new ArrayList<UserMessage>();
		try {
			while (rs.next()) {
				String text = rs.getString("text");
				Timestamp insertDate = rs.getTimestamp("insert_dt");
				String name = rs.getString("name");

				UserMessage message = new UserMessage();
				message.setText(text);
				message.setInsertDate(insertDate);
				message.setName(name);

				ret.add(message);
			}

			return ret;
		} finally {
			close(rs);
		}
	}
>>>>>>> 5d031482e1b8adaf9bead50a126f51124512905d
}
