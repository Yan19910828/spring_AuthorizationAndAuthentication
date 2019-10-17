package com.marlabs.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.marlabs.domain.User;
import com.marlabs.domain.UserForm;
import com.marlabs.service.UserService;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;

	@GetMapping("/login")
	public String loginPage() {
		return "/login";
	}

	@GetMapping("/signup")
	public String signUpPage() {
		return "signup";
	}

	@PostMapping("/signup")
	public String signUp(@Valid UserForm userForm, BindingResult result) {
		boolean boo = true;

		if (!userForm.getPassword().equals(userForm.getConfirmPassword())) {
			result.rejectValue("confrimPassword", "Unmatched", "confrimError");
			boo = false;
		}
		if (result.hasErrors()) {

			List<FieldError> fieldError = result.getFieldErrors();
			for (FieldError error : fieldError) {
				System.out.println(error.getField() + ":" + error.getDefaultMessage() + ":" + error.getCode());
			}
			boo = false;
		}
		if (!boo) {
			return "signup";
		}
		User user = userForm.convertToUser(userForm);
		userService.save(user);
		return "redirect:/login";
	}

}
