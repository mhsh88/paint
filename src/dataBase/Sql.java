package dataBase;

import java.sql.SQLException;

public class Sql {

	private String[] objectString;
	private String sql;
	private DB db = new DB();

	public Sql(String[] objectString) {
		this.objectString = objectString;
		addObjectToDatabase();
	}

	private void addObjectToDatabase() {
//		INSERT INTO `paintdb`.`object` (`id`, `type`, `color`, `fill`, `x1`, `y1`, `x2`, `y2`, `order`, `user_id`) VALUES ('1', 'line', '1', 'true', '1', '1', '1', '1', '1', '1');
		String temp = "(select id from user where username = '" +  this.objectString[8] +   "')";
		sql = "insert into paintdb.object (type, color, fill, x1, y1, x2, y2, `order`, `user_id`)\n values('"
				+ this.objectString[0] + "'," + this.objectString[1] + "," + this.objectString[2] + ","
				+ this.objectString[3] + "," + this.objectString[4] + "," + this.objectString[5] + ","
				+ this.objectString[6] + "," + this.objectString[7] + "," + temp + ");";
		System.out.println(sql);
		try {
			db.doExcute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void clear() {
		String sql = "DELETE FROM `paintdb`.`object` WHERE `id`='34' and`user_id`='1';";
	}

}
