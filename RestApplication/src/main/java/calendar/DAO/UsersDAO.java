package calendar.DAO;

import java.util.List;
import org.hibernate.Session;
import calendar.models.User;

public class UsersDAO {

	public int getUserIdByCredentials(String username, String password, Session session) {
		String userQuery = "from users where password = " + password;
		List<User> userList = session.createQuery(userQuery).getResultList();

		// When no match found for username and password
		if (userList.size() == 0) {
			return -1;
		}

		int userId = userList.get(0).getUserId();
		return userId;
	}

}
