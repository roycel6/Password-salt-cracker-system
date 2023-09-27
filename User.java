package cybersecurity_hw2;

/* This program gets a User ID and finds its corresponding hash value within an array list. It then runs through
 various password and salt combinations, hashes them, and compares that hash value to the one in the array list. It
 prints the User ID, password, and salt if a match is found.
*/

public class User {
	public static void main(String[] args) {	//check for 10 different uids
		CrackerSystem users = new CrackerSystem(); 
		users.UserCheck("001");
		users.UserCheck("002");
		users.UserCheck("003");
		users.UserCheck("004");
		users.UserCheck("005");
		users.UserCheck("006");
		users.UserCheck("007");
		users.UserCheck("008");
		users.UserCheck("009");
		users.UserCheck("010");
	}

}
