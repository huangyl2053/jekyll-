package controller;

import java.io.Reader;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import entity.loginInfo;
import mybatis.IloginMapper;
@Controller
public class loginController {
	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;
	
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
//			Class.forName("com.mysql.jdbc.Driver");
//			String url="jdbc:mysql://localhost:3306/nature";
//			Connection conn;
//			conn = DriverManager.getConnection(url,"root","");
//			Statement stmt = conn.createStatement(); 
//			
//			String sql = "select * from user"; 
//			ResultSet rs = stmt.executeQuery(sql);
//			if(rs.next()){
//				psd=rs.getString(4);
//				}
//			rs.close();
//			stmt.close();
//			conn.close();

            reader    = Resources.getResourceAsReader("Configuration.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession session = sqlSessionFactory.openSession();
            IloginMapper iloginMapper=session.getMapper(IloginMapper.class);
//            loginInfo Info = (loginInfo) session.selectOne("mybatis.mapper.selectLoginInfoByID", "huangyl2053");
            loginInfo Info = iloginMapper.selectLoginInfoByID("huangyl2053");
            String s=Info.getPassword();
            
		}catch(Exception e1){
			System.out.print("数据库连接失败。");
		}
		return psd;
	}
}
