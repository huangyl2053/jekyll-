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
		if (psd != null && psd.equals(getPSD())) {
			return "main";
		}
		return "WEB-INF/main.jsp";
	}

	// 获取密码
	private String getPSD() {
		String psd = new String();
		try {
			reader = Resources.getResourceAsReader("Configuration.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			SqlSession session = sqlSessionFactory.openSession();
			IloginMapper iloginMapper = session.getMapper(IloginMapper.class);
			// loginInfo Info = (loginInfo)
			// session.selectOne("mybatis.mapper.selectLoginInfoByID",
			// "huangyl2053");
			loginInfo Info = iloginMapper.selectLoginInfoByID("huangyl2053");
			psd = Info.getPassword();

		} catch (Exception e1) {
			System.out.print("数据库连接失败。");
		}
		return psd;
	}
}
