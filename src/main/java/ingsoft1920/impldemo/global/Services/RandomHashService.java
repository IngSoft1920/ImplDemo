package ingsoft1920.impldemo.global.Services;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RandomHashService {
	final static Logger logger = LogManager.getLogger(RandomHashService.class.getName());
	/*
	 * @param length Longitud de la cadena aleatoria deseada
	 * 
	 * @return Cadena alfanumerica (0-9a-zA-Z) aleatoria de longitud lenght
	 */
	public static String randomString(int lenght) {
		String generated="";
		
		Random r = new Random();
		int total=0;
		while(total<lenght) {
			int i=r.nextInt(123);
			if((47<i && i<58) || (64<i && i<91) || (96<i && i<123)) {
				generated+=(char) i;
				total++;
			}
		}
		return generated;
	}
	
	
	public static String hashSHA256(String input) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");		  
	        byte[] messageDigest = md.digest(input.getBytes()); 
	        BigInteger no = new BigInteger(1, messageDigest); 
	        return no.toString(16);
		}catch(Exception ex) {
			logger.info(ex);
			return null;
		}
	}
}
