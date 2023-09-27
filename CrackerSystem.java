package cybersecurity_hw2;

import java.io.BufferedReader; 
import java.io.File; 
import java.io.FileInputStream; 
import java.io.FileNotFoundException; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.io.UnsupportedEncodingException; 
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException; 
import java.util.ArrayList; 
import java.util.Arrays;
import java.util.Scanner;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.math.BigInteger;

public class CrackerSystem {
	VerificationSystem verify = new VerificationSystem();
	
	public void UserCheck(String user){ /*checks if user exists in the arraylist, and finds the location of its corresponding 
		hash value*/
		
		try {
			verify.SetUID();
			verify.SetHashPassword();
			}
			catch(IOException e){
				throw new RuntimeException(e);
			}
			
			ArrayList<String> UserList = verify.getUID();
			int location = -1;
			
			for (int i = 0; i < UserList.size(); i++) {
				if (user == UserList.get(i)) {
					location = i;
					PasswordCrack(user, location);
					break;
					
				}
			}
			
		if (location == -1) {
			System.out.println("User does not exist");
		}
		
	} 
	
	public void PasswordCrack(String user, int location) {
		/*hashes various passwords and salts and verifies that it matches with a hash
		 value already stored in an arraylist. If a match is found, the UID, password, and salt are printed*/
		
		
		boolean verifyResult = false;
		
		for(int pass = 0; pass <= 1000; pass++) {
			for (int s = 0; s <= 100; s++) {
				String password = String.format("%04d", pass);
				String salt = String.format("%03d", s);
				String passSalt = password + salt;
				
				String hashResult = verify.Hashfunction(passSalt);
				verifyResult = verify.Verify(hashResult, location);
				
				if (verifyResult == true) {
					System.out.println("UID: " + user + "\nPassword: " + password + "\nSalt: " + salt + "\n");
					return;
					
				}
			}
		}
		
		if (verifyResult == false) {
			System.out.println("Cannot find password and salt");
		}
		
	}


}
