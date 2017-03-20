package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class editController {
	@RequestMapping("/edit")
	public String edit() {
		return "WEB-INF/edit.jsp";
	}
}
