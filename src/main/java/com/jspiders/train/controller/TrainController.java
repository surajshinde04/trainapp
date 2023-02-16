package com.jspiders.train.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.jspiders.train.pojo.TrainPOJO;
import com.jspiders.train.service.TrainService;

@Controller
public class TrainController {
	
	@Autowired
	private TrainService service;
	

	// Home controller
		@GetMapping("/home")
		public String home(@SessionAttribute(name = "login", required = false) TrainPOJO login, ModelMap map) {
			if (login != null) {
				return "Welcome";
			}
			map.addAttribute("msg", "Login to proceed..!!");
			return "Login";
		}
	
	// Login Form Controller
		@GetMapping("/login")
		public String login() {
			return "Login";
		}
		
		
		
		// Login controller
		@PostMapping("/login")
		public String loginData(HttpServletRequest request, @RequestParam String username, @RequestParam String password,
				ModelMap map) {
			TrainPOJO train = service.login(username, password);
			if (train != null) {
				HttpSession session = request.getSession();
				session.setAttribute("login", train);
				session.setMaxInactiveInterval(120);
				return "Welcome";
			}
			map.addAttribute("msg", "Invalid username or password..!!");
			return "Login";
		}
	
	//Add Controller
	@GetMapping("/add")
	public String add(@SessionAttribute(name = "login", required = false) TrainPOJO login, ModelMap map) {
		if (login != null) {
			return "Add";
		}
		map.addAttribute("msg", "Login to proceed..!!");
		return "Login";
	}
	
	//Add Response Controller
	@PostMapping("/add")
	public String  addTrain(@SessionAttribute(name = "login", required = false) TrainPOJO login,@RequestParam int train_number ,@RequestParam String train_name,@RequestParam String from,@RequestParam String to,@RequestParam double total_kms,@RequestParam String depart_time,@RequestParam String arrival_time,@RequestParam String total_travelling_hours, String username, String password,ModelMap map) {
		if (login != null) {
			TrainPOJO train = service.add(train_number,train_name,from,to,total_kms,depart_time,arrival_time,total_travelling_hours,username, password);
			if (train != null) {
				map.addAttribute("train", train);
				map.addAttribute("msg", "Train added successfully..!!");
			} else {
				map.addAttribute("msg", "Train not added..!!");
			}
			return "Add";
		}
		map.addAttribute("msg", "Login to proceed..!!");
		return "Login";
	}
	
	//Search Form Controller
	
	@GetMapping("/search")
	public String search(@SessionAttribute(name = "login", required = false) TrainPOJO login, ModelMap map) {
		if (login != null) {
			return "Search";
		}
		map.addAttribute("msg", "Login to proceed..!!");
		return "Login";
	}
	
	
	//Search Response Controller
	@PostMapping("/search")
	public String searchData(@SessionAttribute(name = "login", required = false) TrainPOJO login,
			@RequestParam int train_number, ModelMap map) {
		if (login != null) {
			TrainPOJO train = service.search(train_number);
			if (train != null) {
				// success
				map.addAttribute("train", train);
				return "Search";
			}
			// failure
			map.addAttribute("msg", "Train data does not exist..!!");
			return "Search";
		}
		map.addAttribute("msg", "Login to proceed..!!");
		return "Login";

	}
	
	// Remove form controller
		@GetMapping("/remove")
		public String remove(@SessionAttribute(name = "login", required = false) TrainPOJO login, ModelMap map) {
			if (login != null) {
				List<TrainPOJO> trains = service.searchAll();
				map.addAttribute("trains", trains);
				return "Remove";
			}
			map.addAttribute("msg", "Login to proceed..!!");
			return "Login";

		}

		// Remove response controller
		@PostMapping("/remove")
		public String removeData(@SessionAttribute(name = "login", required = false) TrainPOJO login,
				@RequestParam int train_number, ModelMap map) {
			if (login != null) {
				TrainPOJO train = service.remove(train_number);
				if (train != null) {
					// success
					List<TrainPOJO> trains = service.searchAll();
					map.addAttribute("trains", trains);
					map.addAttribute("msg", "Train removed successfully..!!");
					return "Remove";
				}
				// failure
				List<TrainPOJO> trains = service.searchAll();
				map.addAttribute("trains", trains);
				map.addAttribute("msg", "Train data does not exist..!!");
				return "Remove";
			}
			map.addAttribute("msg", "Login to proceed..!!");
			return "Login";

		}

		// Update page controller
		@GetMapping("/update")
		public String update(@SessionAttribute(name = "login", required = false) TrainPOJO login, ModelMap map) {
			if (login != null) {
				List<TrainPOJO> trains = service.searchAll();
				map.addAttribute("trains", trains);
				return "Update";
			}
			map.addAttribute("msg", "Login to proceed..!!");
			return "Login";

		}

		// Update form controller
		@PostMapping("/update")
		public String updateForm(@SessionAttribute(name = "login", required = false) TrainPOJO login,
				@RequestParam int train_number, ModelMap map) {
			if (login != null) {
				TrainPOJO train = service.search(train_number);
				if (train != null) {
					// success
					map.addAttribute("train", train);
				}
				// failure
				List<TrainPOJO> trains = service.searchAll();
				map.addAttribute("trains", trains);
				map.addAttribute("msg", "Train data does not exist..!!");
				return "Update";
			}
			map.addAttribute("msg", "Login to proceed..!!");
			return "Login";

		}

		// Update Data controller
		@PostMapping("/updateData")
		public String updateData(@SessionAttribute(name = "login", required = false)TrainPOJO login,
				@RequestParam int train_number,@RequestParam String train_name,@RequestParam String from,@RequestParam String to,@RequestParam double total_kms,@RequestParam String depart_time,@RequestParam String arrival_time,@RequestParam String total_travelling_hours,ModelMap map) {
			if (login != null) {
				TrainPOJO train = service.update( train_number,train_name,from,to,total_kms,depart_time,arrival_time,total_travelling_hours);			
				if (train != null) {
					// success
					map.addAttribute("msg", "Train data updated successfully..!!");
					List<TrainPOJO> trains = service.searchAll();
					map.addAttribute("trains", trains);
					return "Update";
				}
				// failure
				map.addAttribute("msg", "Train not updated..!!");
				List<TrainPOJO> trains = service.searchAll();
				map.addAttribute("trains", trains);
				return "Update";
			}
			map.addAttribute("msg", "Login to proceed..!!");
			return "Login";

		}

		// logout controller
		@GetMapping("/logout")
		public String logout(HttpSession session, ModelMap map) {
			session.invalidate();
			map.addAttribute("msg", "Logged out successfully..!!");
			return "First";
		}
	
	
	
		//First Controller
		
		@GetMapping("/staff")
		public String staff() {
			return "Login";
		}
		
		@GetMapping("/passanger")
		public String passanger() {
			return "Passanger";
		}
	
		//SearchTrain Response Controller
		@PostMapping("/searchtrain")
		public String searchTrainData(@RequestParam int train_number, ModelMap map) {
		
				TrainPOJO train = service.search(train_number);
				if (train != null) {
					// success
					map.addAttribute("train", train);
					return "Passanger";
				}
				// failure
				map.addAttribute("msg", "Train data does not exist..!!");
				return "Passanger";
		}	    
	
	
	
	
	
	
	
	
	
	
	
	
}
