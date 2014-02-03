package tamaSystem;


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
	private void createUsers(){
		connectionMethod("tamaadmin", "java13");
		
	}
	
	public void logInChecker(String user, String password){
		System.out.println(user);
		System.out.println(password);
		
	}
	
}
