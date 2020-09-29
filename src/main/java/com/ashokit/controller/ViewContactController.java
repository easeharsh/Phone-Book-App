package com.ashokit.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ashokit.dto.Contact;
import com.ashokit.service.ContactService;

@Controller
public class ViewContactController {
	
	Logger logger = LoggerFactory.getLogger(ViewContactController.class);
			
		@Autowired
		private ContactService contactService;
		
		@GetMapping("/viewAllContact")
		public String viewAllContacts(Model model)
		{
			logger.debug("*** viewAllContacts() method started ***");
			List<Contact> allContacts = contactService.getAllContacts();
			model.addAttribute("contact", allContacts);
			logger.debug("*** viewAllContacts() method ended ***");
			logger.info("*** viewAllContacts() method exe successfully ***");
			return "viewContacts";
			
		}
		@GetMapping("/editContact")
		public String editContact(@RequestParam("cid")Integer cid, Model model)	
		{
			Contact contact = contactService.getContactById(cid);
			model.addAttribute("contact", contact);
			return "index";
			
		}
		
		@GetMapping("/deleteContact")
		public String deleteContact(@RequestParam("cid")Integer cid, RedirectAttributes attribute)
		{
			contactService.deleteById(cid);
			attribute.addFlashAttribute("delsuccess", "Contact Deleted Successfully");
			return "redirect:viewAllContact";
			
		}
}
