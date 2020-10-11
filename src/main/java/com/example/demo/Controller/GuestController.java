package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.GuestModel;
import com.example.demo.repository.GuestRepo;

@Controller
public class GuestController {
	
	@Autowired
	GuestRepo r; 
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
//	   Iterable<GuestModel> result=r.findAll();
		return "login";
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute(name="loginForm") GuestModel loginForm,Model model) {
		System.out.println("login called........");
		String email=loginForm.getName();
		String password=loginForm.getPassword();
		System.out.println("username= "+email +"and "+password);
		Iterable<GuestModel> gm =r.findByEmail(email);
		List<GuestModel> res=(List<GuestModel>)gm;
		if(res.size()>0){
			if(gm.iterator().next().getRole().equals("user") && gm.iterator().next().getPassword().equals(password)) {
//				int id=gm.iterator().next().getId();
				List<GuestModel> emp2 = (List<GuestModel>) r.findByEmail((gm.iterator().next().getEmail()));
				model.addAttribute("message",emp2);
				return "home";
			}
			else if(gm.iterator().next().getRole().equals("admin") && gm.iterator().next().getPassword().equals(password))
				return "AdminHome";
			else
				return "LoginError";
		}else {
			return "LoginError";
		}
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration() {
		return "registration";
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registration(@ModelAttribute(name="regForm") GuestModel regForm) {
		System.out.println("login called........");
		String name=regForm.getName();
		String email=regForm.getEmail();
		String password=regForm.getPassword();
		String mobileNo=regForm.getMobileNo();
		String role="user";
		String address="No";
		String verified="Not Verified";
		System.out.println("username= "+name +" and "+password+" "+mobileNo);
		GuestModel gm=new GuestModel(name,email,password,mobileNo,role,address,verified);
		r.save(gm);
		if(r!=null)
			return "login";
		
		return "registration";
	
	}
	
	 @RequestMapping(value = "/all")
	 public String index(Model model) {
		 List<GuestModel> emp = (List<GuestModel>) r.findAll();
		
		 model.addAttribute("message",emp);
	     return "ShowData";//return to template index.html
	 } 
	 
	 @RequestMapping(value = "/delete", method = RequestMethod.POST)
	 private String deleteGuest(@RequestParam String id,Model model){
	     System.out.println("Student_Id : "+id);
	     int id1=Integer.parseInt(id);
	     r.deleteById(id1);
	     List<GuestModel> emp = (List<GuestModel>) r.findAll();
			
		 model.addAttribute("message",emp);
	     return "ShowData";//return to template index.html
	 }
	 
	 @RequestMapping(value = "/verify", method = RequestMethod.POST)
	 private String verifiedGuest(@RequestParam String id,Model model){
	
	     int id1=Integer.parseInt(id);
	     Optional<GuestModel> gm =r.findById(id1);
	     GuestModel obj=new GuestModel();
	     obj.setId(gm.get().getId());
	     obj.setName(gm.get().getName());
	     obj.setAddress(gm.get().getAddress());
	     obj.setEmail(gm.get().getEmail());
	     obj.setMobileNo(gm.get().getMobileNo());
	     obj.setPassword(gm.get().getPassword());
	     obj.setRole(gm.get().getRole());
	     obj.setVerified("verified");

	     List<GuestModel> emp = (List<GuestModel>) r.findAll();
	     
	     emp.add(obj);
	     
	     r.saveAll(emp);
	     
	     List<GuestModel> emp2 = (List<GuestModel>) r.findAll();
		 model.addAttribute("message",emp2);
	     return "ShowData";//return to template index.html
	 }
	 
	 @RequestMapping(value = "/update", method = RequestMethod.POST)
	 private String updateAddress(@RequestParam String id,@RequestParam String address, Model model){
	 
	     int id1=Integer.parseInt(id);
	     Optional<GuestModel> gm =r.findById(id1);
	     GuestModel obj=new GuestModel();
	     obj.setId(gm.get().getId());
	     obj.setName(gm.get().getName());
	     obj.setAddress(address);
	     obj.setEmail(gm.get().getEmail());
	     obj.setMobileNo(gm.get().getMobileNo());
	     obj.setPassword(gm.get().getPassword());
	     obj.setRole(gm.get().getRole());
	     obj.setVerified(gm.get().getVerified());
	   
	     List<GuestModel> emp = (List<GuestModel>) r.findAll();
	     
	     emp.add(obj);
	     
	     r.saveAll(emp);
	     
	     List<GuestModel> emp2 = (List<GuestModel>) r.findAll();
		 model.addAttribute("message",emp2);
	     return "home";//return to template index.html
	 }
}