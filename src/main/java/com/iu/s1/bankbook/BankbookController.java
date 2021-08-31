package com.iu.s1.bankbook;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/bankbook/*")
public class BankbookController {	
	//pojo (plain old java object) 
	
	@RequestMapping(value="bankbookList.do", method=RequestMethod.GET)
	public ModelAndView list(Integer [] num) {
		for(Integer i : num) {
			System.out.println(i);
		}
		System.out.println("bankbook list");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bankbook/bankbookList");
		return mv;
	}
	
	@RequestMapping("bankbookSelect.do")
	public String select(@RequestParam(defaultValue = "1",value="n") Integer num, String name) {
		System.out.println("Value: "+num);
		System.out.println("Name: "+name);
		return "bankbook/bankbookSelect";
	}
	
	@RequestMapping("bankbookInsert.do")
	public void insert(BankBookDTO bankBookDTO) {
		System.out.println(bankBookDTO.getBookName());	
		System.out.println("insert");
		return "redirect:../";
	}
	
	
	
	
	
	
}
