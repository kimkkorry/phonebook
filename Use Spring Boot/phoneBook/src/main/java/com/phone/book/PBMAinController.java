package com.phone.book;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class PBMAinController {

	private final PhoneBookService phoneBookService;
	
	@GetMapping("/PhoneBook")
	    public String list(Model model) {
		List<Usersinfo> usersinfosList = this.phoneBookService.getList();
		model.addAttribute("usersinfosList", usersinfosList);
		
	        return "Usersinfo_list";
}
	@GetMapping(value = "/PhoneBook/detail/{id}")
	private String detail(Model model, @PathVariable("id") Integer id) {
		Usersinfo usersinfo = this.phoneBookService.getUsersinfo(id);
		model.addAttribute("usersinfo", usersinfo);
		return "Usersinfo_detail";

	}
	
}
