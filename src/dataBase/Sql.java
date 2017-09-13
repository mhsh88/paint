package dataBase;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Sql {

	private String[] objectString;
	private String sql;
	private static DB db = new DB();

	// public Sql() {
	//
	// }

	public void addObjectToDatabase(String[] objectString) {
		this.objectString = objectString;
		addObjectToDatabase();
	}

	private void addObjectToDatabase() {
		// INSERT INTO `paintdb`.`object` (`id`, `type`, `color`, `fill`, `x1`, `y1`,
		// `x2`, `y2`, `order`, `user_id`) VALUES ('1', 'line', '1', 'true', '1', '1',
		// '1', '1', '1', '1');
		String temp = "(select id from user where username = '" + this.objectString[8] + "')";
		sql = "insert into paintdb.object (type, color, fill, x1, y1, x2, y2, `order`, `user_id`)\n values('"
				+ this.objectString[0] + "'," + this.objectString[1] + "," + this.objectString[2] + ","
				+ this.objectString[3] + "," + this.objectString[4] + "," + this.objectString[5] + ","
				+ this.objectString[6] + "," + this.objectString[7] + "," + temp + ");";
		try {
			db.doExcute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void clear(String userName) {
		String sql = "DELETE FROM `paintdb`.`object` WHERE `user_id`=(SELECT id from `user` where username = '"
				+ userName + "' );";
		// System.out.println(sql);
		try {
			db.doExcute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static boolean getUser(String userName, String passWord) {
		String sql = "select id from `paintdb`.`user` where username = '" + userName + "' and password = '" + passWord + "' ";
		System.out.println(sql);
		boolean result = false;
		try {
			ResultSet rs = db.doQuery(sql);
			while(rs.next()) {
				result = true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
