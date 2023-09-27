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

public class VerificationSystem {
	ArrayList<String> UID = new ArrayList<String>(); 
	ArrayList<String> HashPassword = new ArrayList<String>();
	
	public void SetUID() throws IOException{ //store UIDs in arraylist
		UID.add("001");
		UID.add("002");
		UID.add("003");
		UID.add("004");
		UID.add("005");
		UID.add("006");
		UID.add("007");
		UID.add("008");
		UID.add("009");
		UID.add("010");
	}
	
	public ArrayList<String> getUID(){		//returns the UID arraylist for use in other classes
		return UID;
	}
	 
	public void SetHashPassword() throws IOException{ //store hashes in arraylist
		HashPassword.add("4a1d6f102cd95fac33853e4d72fe1dc5");
		HashPassword.add("e8e7d67256aedc225a072540540d910c");
		HashPassword.add("0c6a7629e1fe2eab887de89dd65072d9");
		HashPassword.add("0e8b4ee66ad464aee37a934d74088613");
		HashPassword.add("6261a6ddd461304eaed4090348d8d117");
		HashPassword.add("cfa0000941daff46ebf0ef1950c86db0");
		HashPassword.add("e09a3a07abbaa5bf3170e6d297dff065");
		HashPassword.add("11dcc98c009eb5b2a9449d05ea8bb381");
		HashPassword.add("dfbcb13e80aa4cfb872f987b17879ec8");
		HashPassword.add("db8a21330a299c4fcae3534cc7f1e01b");
	} 
	 
	public String Hashfunction(String PasswordAndSalt){ //hashes the password and salt
		try{
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(PasswordAndSalt.getBytes(StandardCharsets.UTF_8));
			byte[] hashBytes = md.digest();
			BigInteger no = new BigInteger(1, hashBytes);
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
		}
		 catch (NoSuchAlgorithmException e) {
	            throw new RuntimeException(e);
	        }
	} 
	 
	public boolean Verify(String input1, int location){
		//checks if the hash from the cracker matches with the hash located in a certain position within the arraylist
		
		if(input1.equals(HashPassword.get(location))) {
			return true;
		}
		
		else {
			return false;
		}
	}
}
