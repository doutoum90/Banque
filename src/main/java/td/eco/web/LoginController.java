package td.eco.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	@RequestMapping(value="/login")
	public String login(){
		return "login";
	}
	@RequestMapping(value="/")
	public String home(){
		return "redirect:/comptes";
	}
	
	@RequestMapping(value="/403")
	public String AccessDenied(){
		return "403";
	}

}
