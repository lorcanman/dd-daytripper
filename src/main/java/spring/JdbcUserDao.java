package spring;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class JdbcUserDao extends JdbcDaoSupport implements UserDao {

	private RowMapper<User> userRowMapper = new RowMapper<User>() {
		@Override
		public User mapRow(ResultSet rs, int rowCount) throws SQLException {
			return new User(rs.getString("id"),
							rs.getString("level_of_Authentication"),
							rs.getString("email"),
							rs.getString("password"),
							rs.getInt("days_off"));
		}
	};

	
	@Override
	public void create(User user) {
		getJdbcTemplate().update("INSERT INTO users VALUES(?, ?, ?, ?, ?)",
								 user.getId(), user.getLevelOfAuthentication(), user.getEmail(),
								 user.getPassword(), user.getDaysOff(), user.getIsOnHoliday());
	}

	@Override
	public List<User> allUsers() {
		return getJdbcTemplate().query("SELECT * FROM users", userRowMapper);
	}

}
