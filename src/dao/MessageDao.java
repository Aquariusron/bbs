<<<<<<< HEAD

=======
>>>>>>> 5d031482e1b8adaf9bead50a126f51124512905d
package dao;

import static utils.CloseableUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import beans.Message;
import exception.SQLRuntimeException;

public class MessageDao {

<<<<<<< HEAD
    public void insert(Connection connection, Message message) {

        PreparedStatement ps = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO message ( ");
            sql.append(" user_id");
            sql.append(", text");
            sql.append(", insert_date");
            sql.append(", update_date");
            sql.append(") VALUES (");
            sql.append(" ?"); // user_id
            sql.append(", ?"); // text]
            sql.append(", CURRENT_TIMESTAMP"); // insert_date
            sql.append(", CURRENT_TIMESTAMP"); // update_date
            sql.append(")");

            ps = connection.prepareStatement(sql.toString());

            ps.setInt(1, message.getUserId());
            ps.setString(2, message.getText());


            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLRuntimeException(e);
        } finally {
            close(ps);
        }
    }

}
=======
	public void insert(Connection connection, Message message) {

		PreparedStatement ps = null;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO messages ( ");


			sql.append(" subject");
			sql.append(", category");
			sql.append(", text");
			sql.append(", insert_at");
//			sql.append(", update_at");
			sql.append(") VALUES (");
			sql.append(" ?"); // subject
			sql.append(", ?"); // category
			sql.append(", ?");// text
			sql.append(", ?");// user_id
			sql.append(", CURRENT_TIMESTAMP"); // insert_date
//			sql.append(", CURRENT_TIMESTAMP"); // update_date
			sql.append(")");

			ps = connection.prepareStatement(sql.toString());

			ps.setInt(1, message.getUserId());
			ps.setString(2, message.getSubject());
			ps.setString(3, message.getCategory());
			ps.setString(4, message.getText());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new SQLRuntimeException(e);
		} finally {
			close(ps);
		}
	}

}
>>>>>>> 5d031482e1b8adaf9bead50a126f51124512905d
