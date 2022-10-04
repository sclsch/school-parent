package work.hdjava.shcoolweb.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/aaa")
public class RouterController {
	@RequestMapping(value = "/bbb")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Home");
		return mv;
	}
}
