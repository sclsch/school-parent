package work.hdjava.shcoolweb.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RouterController {
	@RequestMapping(value = "/schools")
	public ModelAndView schools() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Home");
		return mv;
	}
}
