package controller;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import entity.BlogInfo;
import mybatis.IBlogMapper;

@Controller
public class saveController {
	
	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;
	
	@RequestMapping("/save")
	public String save(BlogInfo blogInfo) {
		System.out.println(blogInfo.getTitle());
		blogInfo.setUpdatetime("20170425");
		blogInfo.setUpdateuser("Mr_Huangyl");
		blogInfo.setUser("Mr_Huangyl");
		try{
            reader    = Resources.getResourceAsReader("Configuration.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession session = sqlSessionFactory.openSession();
            IBlogMapper iBlogMapper=session.getMapper(IBlogMapper.class);
            int i=iBlogMapper.saveBlog(blogInfo);
            int s=i;
            session.commit();
		}catch(Exception e1){
			System.out.print("数据库连接失败。");
		}
        return "redirect:main";
	}

}
