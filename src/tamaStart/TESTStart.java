package tamaStart;

import tamaDB.MySQLEngine;

public class TESTStart {

	public static void main(String[] args) {
		MySQLEngine mSQL = new MySQLEngine();
		mSQL.getMySQLDB("infogetter", "tamaproj");
		

	}
}
