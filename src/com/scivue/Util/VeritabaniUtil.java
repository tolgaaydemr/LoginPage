package com.scivue.Util;
import java.sql.*;

public class VeritabaniUtil {
	
	static Connection conn = null;
	public static Connection Baglan() {
	try {
		conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/kullanicilar?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey","root","mysql");
		return conn;
	} catch (Exception e) {
		System.out.println(e.getMessage().toString());
		return null;
	}
}

}
