package tamaDB;

import java.sql.SQLException;

import tamaGUI.TamaGUILogIn;

import com.mysql.jdbc.PreparedStatement;


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

	private String userName;
	private TamaGUILogIn tgli;

	public UserEngine(TamaGUILogIn tgli){
		this.tgli = tgli;
	}
	
	public UserEngine(){
	}

	//CHANGE THE PASSWORD SYSTEM SO IT DONT SHOW...
	public void createUsers(String userName, String userPassword){
		this.userName=userName;
		connectionMethod("tamaadmin", "java13");
		statementMethod();
		userChecker(userName);


		//THE INJECTION STRING
		//	System.out.println(getGameValue());
		//	System.out.println(createUserId() +  " " + userName + userPassword);
	}

	//CHECK IF THE USER IS ALREADY CREATED.
	//Make it say something of it is in use.
	private void userChecker(String userName){
		String logInChecker = "SELECT * FROM user;";
		selectMethodSingle(logInChecker);

		for (int i = 1; i < getSelectMethodSingle().size(); i++) {
			if (getSelectMethodSingle().get(i).equals(userName)){
				tgli.popUpMessage("This name in use");
				System.out.println("NAME IN USE");
				break;
			}
		}
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
