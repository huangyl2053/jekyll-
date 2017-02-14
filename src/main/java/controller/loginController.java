package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import entity.loginInfo;
@Controller
@RequestMapping("/loginController")
public class loginController {
	@RequestMapping("/login")
	public String login() {
		System.out.println("sys");
		return "1";
	}
}
