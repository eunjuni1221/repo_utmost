package com.utmost.module.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping(value = "/xdm/indexXdmView")
	public String mainHof() {
		return "xdm/index/indexXdmView"; 
	}

}
