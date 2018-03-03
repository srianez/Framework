package com.framework.cupomfiscal;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class GeraHash 
{
    public String hash(){
        
		String s="aula_29scj_sabadao_da_alegria";
		try {
		    MessageDigest m = MessageDigest.getInstance("MD5");
		 
		    m.update( s.getBytes(), 0 , s.length() );
		             
		    byte[] digest = m.digest();
		         
		    String hexa = new BigInteger(1,digest).toString(16);
		             
		    System.out.println("MD5: " + hexa);
		    return hexa;
		} 
		catch ( NoSuchAlgorithmException e ) 
		{
		    e.printStackTrace();
		}
		return "Deu erro no hash";    	
    	
    }

}