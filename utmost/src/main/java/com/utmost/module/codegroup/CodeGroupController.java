package com.utmost.module.codegroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.utmost.module.base.BaseController;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/xdm/codegroup/")
public class CodeGroupController extends BaseController{

	
	@Autowired
	CodeGroupService service;
	
	@RequestMapping(value = "CodeGroupXdmList")
	public String codegroupXdmList(Model model, CodeGroupVo vo, CodeGroupDto dto,
			HttpSession httpSession) throws Exception{
		setSearch(vo);
		
		System.out.println(vo.getThisPage());
		vo.setParamsPaging(service.selectOneCount(vo));
	
		if (vo.getTotalRows() > 0) {
		model.addAttribute("list", service.selectList(vo));
		}
		
		model.addAttribute("vo", vo);
	return "xdm/codegroup/CodeGroupXdmList"; 
	}
	
	@RequestMapping(value = "CodeGroupXdmForm")
	public String codegroupXdmForm(Model model, CodeGroupVo vo, CodeGroupDto dto,
			HttpSession httpSession) throws Exception{
		
		if (vo.getCgSeq().equals("0") || vo.getCgSeq().equals("")) {
//			insert mode
		} else {
//			update mode
			 model.addAttribute("item", service.selectOne(dto));
		}
	return "xdm/codegroup/CodeGroupXdmForm"; 
	}
	
	@RequestMapping(value = "CodeGroupXdmInst")
	public String codegroupXdmInst(CodeGroupDto dto) {
		
		service.insert(dto);
		
	return "redirect:CodeGroupXdmList"; 
	}
	
	@RequestMapping(value = "CodeGroupXdmUpdt")
	public String codeGroupXdmUpdt(CodeGroupDto dto) {
		
		service.update(dto);
		
	return "redirect:CodeGroupXdmList"; 
	}
	
}
