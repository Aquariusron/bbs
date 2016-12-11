package utils;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import exception.IORuntimeException;
import exception.SQLRuntimeException;

public class CloseableUtil {

	public static void close(Closeable closeable) {

<<<<<<< HEAD
		if (closeable == null)
			return;
=======
		if (closeable == null) {
			return;
		}
>>>>>>> 5d031482e1b8adaf9bead50a126f51124512905d

		try {
			closeable.close();
		} catch (IOException e) {
			throw new IORuntimeException(e);
		}
	}

	public static void close(Connection connection) {
<<<<<<< HEAD
		if (connection == null)
			return;
=======
		if (connection == null) {
			return;
		}
>>>>>>> 5d031482e1b8adaf9bead50a126f51124512905d
		try {
			connection.close();
		} catch (SQLException e) {
			throw new SQLRuntimeException(e);
		}
	}

	public static void close(Statement statement) {
<<<<<<< HEAD
		if (statement == null)
			return;
=======
		if (statement == null) {
			return;
		}
>>>>>>> 5d031482e1b8adaf9bead50a126f51124512905d
		try {
			statement.close();
		} catch (SQLException e) {
			throw new SQLRuntimeException(e);
		}
	}

	public static void close(ResultSet rs) {
<<<<<<< HEAD
		if (rs == null)
			return;
=======
		if (rs == null) {
			return;
		}
>>>>>>> 5d031482e1b8adaf9bead50a126f51124512905d
		try {
			rs.close();
		} catch (SQLException e) {
			throw new SQLRuntimeException(e);
		}
	}
}
