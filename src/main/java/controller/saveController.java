package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import entity.editInfo;

@Controller
public class saveController {
	@RequestMapping("/save")
	public String save(editInfo info) {
		System.out.println(info.getTitle());
		return "index.jsp";
	}

}
