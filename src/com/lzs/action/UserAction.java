package com.lzs.action;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.lzs.model.User;
import com.lzs.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller
public class UserAction extends ActionSupport implements ModelDriven<User> {
	private static final long serialVersionUID = 1L;
	private User user = new User();

	@Autowired
	private UserService userService;

	@Override
	public User getModel() {
		return user;
	}

	@Action("login")
	public String login() {
		if (user.getUsername() != null && user.getPassword() != null) {
			User u = userService.getByUsername(user.getUsername());
			if (u.getPassword().equals(user.getPassword())) {
				Map<String, Object> session = ActionContext.getContext().getSession();
				session.put("user", u);
				return "logintrue";
			}
			return "loginfalse";
		}
		return "loginfalse";

	}

	public String regist() {
		userService.save(user);
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.put("user", user);
		return "regist";
	}

	public String logout() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.remove("user");
		return "logout";
	}
}
