package controller;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class loginController {
	@RequestMapping("/login")
	public String login(String psd) {
		System.out.println(psd);
		if(psd!=null&&psd.equals(getPSD())){
			return "main";
		}
		return "index.jsp";
	}

	private String getPSD() {
		String psd=new String();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/nature";
			Connection conn;
			conn = DriverManager.getConnection(url,"root","root");
			Statement stmt = conn.createStatement(); 
			
			String sql = "select * from user"; 
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				psd=rs.getString(4);
				}
			rs.close();
			stmt.close();
			conn.close();
		}catch(Exception e1){
			System.out.print("数据库连接失败。");
		}
		return psd;
	}
}
