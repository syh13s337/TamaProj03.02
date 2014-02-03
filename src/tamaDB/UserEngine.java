package tamaDB;

import java.sql.ResultSetMetaData;


/*USER CLASS
 * THIS CLASS WORKS WITH USER/PASSWORD
 * 
 * 1, LOG IN CHECKER.
 * 2, CREATE NEW USER
 * 3, GRANTS NEW USER.
 * 
 * 
 *CHANGE LATER:
 * tamaadmin GRANT privilage, so it dont get used in a bad way.
 * 
 * 
 * ACCOUNT FOR ADMIN: STRING
 * tamaadmin
 * java13
 * 
 * ACCOUNT FOR INFOGETTER: STRING
 * infogetter
 * tamaproj
 * 
 */
public class UserEngine extends MySQLEngine {

	public UserEngine(){
	}

	//CHANGE THE PASSWORD SYSTEM SO IT DONT SHOW...
	public void createUsers(String userName, String userPassword){
		connectionMethod("tamaadmin", "java13");
		statementMethod();



		//THE INJECTION STRING
		System.out.println(createUserId() +  " " + userName + userPassword);
	}

	//CHECK IF THE USER IS ALREADY CREATED.
	//DO A STATMENT METHOD
	public void userChecker(String user){
		String logInChecker = "SELECT * FROM user WHERE username = ? ;";
		ps.setString(1, user);

		System.out.println(user);


	}

	//checks MySQL if there is more if this user.
	//IF there is, can't create one.
	private void checkUserToDb(){
	}

	//GET INT# COUNT BY WHILE LOOP IN SUPER CLASS
	//MAYBE ANOTHER WAY TO DO IT???
	private int createUserId(){
		selectMethod("SELECT userid FROM user; ");
		int createUserId = rowCount + 1;
		return createUserId;

	}

}
