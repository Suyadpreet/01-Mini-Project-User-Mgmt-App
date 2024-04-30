package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.entities.UserAccount;
import com.example.service.UserAccountService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class UserAccountController
{
	@Autowired
	private UserAccountService service;
	
	@GetMapping("/")
	public String firstpage(RedirectAttributes redirectAttributes,Model model)
	{
		redirectAttributes.addAttribute("msg", "");
		return "redirect:/indx";
	}
	
	@GetMapping("/indx")
	public String index(@RequestParam("msg")String msg,Model model)
	{
		model.addAttribute("msg", msg);
		model.addAttribute("user",new UserAccount());
		return "index";
	}
	@PostMapping("/save-user")
	public String handleSubmitBtn(@ModelAttribute("user") UserAccount user,RedirectAttributes redirectAttributes,Model model)
	{
		System.out.println("user id = "+user.getUserId());
		String msg = service.saveOrUpdateUserAcc(user);
		model.addAttribute("msg", msg);
		//model.addAttribute("user",new UserAccount());
		redirectAttributes.addAttribute("msg", msg);
		return "redirect:/indx";
	}
	@GetMapping("/users")
	public String getUsers(Model model)
	{
		List<UserAccount> userList = service.getAllUserAccounts();
		model.addAttribute("users", userList);
		System.out.println("Nam = "+model.getAttribute("nam"));
		return "view-user";
	}
	@GetMapping("/edit")
	public String editUser(@RequestParam("id") Integer id,Model model)
	{
		System.out.println("id = "+id);
		UserAccount userAcc = service.getUserAcc(id);
		model.addAttribute("user",userAcc);
		return "index";
	}
	
	@GetMapping("/delete")
	public String deleteUser(@RequestParam("id") Integer uid,Model model)
	{
		System.out.println("id = "+uid);
		boolean deleteUserAcc = service.deleteUserAcc(uid);
		
		model.addAttribute("msg", "User record Deleted");
		return "forward:/users";
	}
	
	@GetMapping("/update")
	public String updateUser(@RequestParam("id") Integer uid,@RequestParam("status")String status,Model model)
	{
		System.out.println("id = "+uid);
		boolean deleteUserAcc = service.updateUserAccStatus(uid, status);
		if("Y".equalsIgnoreCase(status))
		{
			model.addAttribute("msg", "User Account Activated");
		}
		else
		{
			model.addAttribute("msg", "User Account De-Activated");
		}
		return "forward:/users";
	}
}
