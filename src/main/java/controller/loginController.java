package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class loginController {
	@RequestMapping("/login")
	public String login(String psd) {
		System.out.println(psd);
		if(psd!=null&&psd.equals("2053")){
			return "main";
		}
		return "index.jsp";
	}
}
