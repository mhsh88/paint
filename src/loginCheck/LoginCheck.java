package loginCheck;

import dataBase.Sql;

public class LoginCheck {

	private String userName;
	private String passWord;
	private boolean athorized;

	public boolean isAthorized() {
		return athorized;
	}
	
	
	private void setAthorized(boolean bool) {
		this.athorized = bool;
		
	}



	public String getUserName() {
		return userName;
	}



	public LoginCheck(String userName, String passWord) {
		this.userName = userName;
		this.passWord = passWord;
		checkUserAndPass(this.userName, this.passWord);

	}

	private void checkUserAndPass(String userName, String pass) {
		
		if (Sql.getUser(userName, pass)) {
			setAthorized(true);
		}
		else setAthorized(false);

	}

}
