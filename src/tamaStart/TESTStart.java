package tamaStart;

import tamaDB.MySQLEngine;
import tamaDB.UserEngine;

public class TESTStart {

	public static void main(String[] args) {
		MySQLEngine mSQL = new MySQLEngine();
		UserEngine userE = new UserEngine();
		
		userE.createUsers("Name ",  "pass ");
		//		mSQL.getMySQLDB("infogetter", "tamaproj");



	}
}
