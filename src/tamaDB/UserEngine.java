package tamaDB;


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
	private void createUsers(String UserName, String UserPassword){
		connectionMethod("tamaadmin", "java13");
		statementMethod();
		
		
	}
	
	public void logInChecker(String user, String password){
		System.out.println(user);
		System.out.println(password);
		
	}
	
	//checks MySQL if there is more if this user.
	//IF there is, can't create one.
	private void checkUserToDb(){
	
		
	}
	
}
