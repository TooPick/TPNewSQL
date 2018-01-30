package team.groot.TestDeNuoDB.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	@Autowired
	HttpSession httpSession;
	
	@GetMapping("/")
	public String index() {
		return "homepage";
	}

}
