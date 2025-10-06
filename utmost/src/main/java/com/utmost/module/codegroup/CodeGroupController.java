package com.utmost.module.codegroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.utmost.module.base.BaseController;

import jakarta.servlet.http.HttpSession;

@Controller
public class CodeGroupController extends BaseController{

	
	@Autowired
	CodeGroupService service;
	
	@RequestMapping(value = "/xdm/codegroup/CodeGroupXdmList")
	public String codegroupXdmList(Model model, CodeGroupVo vo, CodeGroupDto dto,
			HttpSession httpSession) throws Exception{
		setSearch(vo);
//			
//		if(httpSession.getAttribute("sessXdmSeq") == null) {
//			return "redirect:/login/Login"; 
//		}
//		
		System.out.println(vo.getThisPage());
		vo.setParamsPaging(service.selectOneCount(vo));
	
		if (vo.getTotalRows() > 0) {
		model.addAttribute("list", service.selectList(vo));
		}
		
		model.addAttribute("vo", vo);
	return "xdm/codegroup/CodeGroupXdmList"; 
	}
	
	@RequestMapping(value = "/xdm/codegroup/CodeGroupXdmForm")
	public String codegroupXdmForm(Model model, CodeGroupVo vo, CodeGroupDto dto,
			HttpSession httpSession) throws Exception{
		
		if (vo.getCgSeq().equals("0") || vo.getCgSeq().equals("")) {
//			insert mode
		} else {
//			update mode
			// model.addAttribute("item", service.selectOne(codeGroupDto));
		}
	return "xdm/codegroup/CodeGroupXdmForm"; 
	}
	
	@RequestMapping(value = "/xdm/codegroup/CodeGroupXdmInst")
	public String codegroupXdmInst(CodeGroupDto dto) {
		
		service.insert(dto);
		
	return "redirect:CodeGroupXdmList"; 
	}
	
}
