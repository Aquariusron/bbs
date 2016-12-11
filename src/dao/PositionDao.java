<<<<<<< HEAD

=======
>>>>>>> 5d031482e1b8adaf9bead50a126f51124512905d
package dao;

import static utils.CloseableUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Position;
import exception.SQLRuntimeException;

public class PositionDao {

<<<<<<< HEAD
    public List<Position> getPositions(Connection connection) {

        PreparedStatement ps = null;
        try {
            String sql = "SELECT * FROM positions";

            ps = connection.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            List<Position> positionList = toPositionList(rs);

            if (positionList.isEmpty() == true) {
                return null;
            } else {
                return positionList;
            }
        } catch (SQLException e) {
            throw new SQLRuntimeException(e);
        } finally {
            close(ps);
        }
    }

    private List<Position> toPositionList(ResultSet rs) throws SQLException {

        List<Position> ret = new ArrayList<Position>();
        try {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");

                Position position = new Position();
                position.setId(id);
                position.setName(name);
                ret.add(position);
            }
            return ret;
        } finally {
            close(rs);
        }
    }
}
=======
	public List<Position> getPositions(Connection connection) {

		PreparedStatement ps = null;
		try {
			String sql = "SELECT * FROM positions";

			ps = connection.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			List<Position> positionList = toPositionList(rs);

			if (positionList.isEmpty() == true) {
				return null;
			} else {
				return positionList;
			}
		} catch (SQLException e) {
			throw new SQLRuntimeException(e);
		} finally {
			close(ps);
		}
	}

	private List<Position> toPositionList(ResultSet rs) throws SQLException {

		List<Position> ret = new ArrayList<Position>();
		try {
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");

				Position position = new Position();
				position.setId(id);
				position.setName(name);
				ret.add(position);
			}
			return ret;
		} finally {
			close(rs);
		}
	}
}
>>>>>>> 5d031482e1b8adaf9bead50a126f51124512905d
