package server.dummy.helper;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashHelper {

	public static String getMd5(String s){
		MessageDigest md;
		String hash=null;
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(s.getBytes());
			hash =new BigInteger(1,md.digest()).toString(16);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return hash;
	}
}
