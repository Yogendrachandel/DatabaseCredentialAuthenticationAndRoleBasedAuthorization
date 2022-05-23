package com.learn;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncryptor {

	public static void main(String[] args) {
		
		
		String[] array= {"nilesh","mahesh","suresh","ramesh","admin"};
		for(String pass:array) {
			System.out.println( pass+" Password is: "+new BCryptPasswordEncoder(10).encode(pass));
		}

	}

}
