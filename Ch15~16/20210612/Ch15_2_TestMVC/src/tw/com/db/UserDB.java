package tw.com.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import tw.com.bean.User;

public class UserDB {
	
	public static boolean login(String account,String password,User user) {
		boolean loginPass = false;
		try(Connection con = DbTools.getConnection();
			Statement stm = con.createStatement();){
			ResultSet resultSet = 
					stm.executeQuery("SELECT * FROM my_user WHERE user_name='"+account+"'");
			if (resultSet.next()) {
				
				int id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				String qPassword = resultSet.getString(3);
				
				user.setId(id);
				user.setAccount(name);
				user.setPassword(qPassword);
				
				if (password.equals(qPassword)) {
					loginPass = true;
				}
				
			}
			
			
		}catch(SQLException ex) {
			 System.out.println("regisrter:"+ex);
			 return false;
		}
		return loginPass;
	}
		public static boolean 
		regisrter(String account,String password)  {
			boolean regisrterCompelet = true;
				
			 try(Connection con = DbTools.getConnection();
					 Statement stm =  con.createStatement();){
				 	
				 //account ¤£¥i­«½Æ
				 stm.executeUpdate("INSERT INTO my_user (user_name,user_password) "
				 		+ "VALUES ('"+account+"','"+password+"');");				 
			 }catch(SQLException ex) {
				 System.out.println("regisrter:"+ex);
				 return false;
			 }
			
			return regisrterCompelet;
			
		}
}
