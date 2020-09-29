package com.ashokit.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ashokit.dto.Contact;
import com.ashokit.service.ContactService;

@Controller
public class ContactInfoController {
	
	private static final Logger logger = LoggerFactory.getLogger(ContactInfoController.class);
	
	@Autowired
	private ContactService contactService;
	
	@GetMapping("/")
	public String loadContactForm(Model model)
	{
		logger.debug("*** loadContactForm() method exe started ***");
		Contact contactObj = new Contact();
		model.addAttribute("contact", contactObj);
		logger.debug("*** loadContactForm() method exe ended ***");
		logger.info("** loadContactForm() method Form loaded Successfully **");
		return "index";
		
	}
	
	@RequestMapping(value="/saveContact", method = RequestMethod.POST)
	public String saveContactForm(@ModelAttribute("contact")Contact contact, RedirectAttributes attribute)
	{
		logger.debug("*** saveContactForm() method started ***");
		boolean savedContact = contactService.save(contact);
		if(savedContact)
		{
			if(contact.getCid()!=null)
			{
				attribute.addFlashAttribute("success", "Contact Updated Successfully"); 
				logger.info("*** Contact Updated Successfully ***");
			}
			else
			{
				attribute.addFlashAttribute("success", "Contact Saved Successfully");
				logger.info("*** Contact Saved Successfully ***");
			}
			
		}
		else
		{
			//model.addAttribute("failure", "Contact Not Saved");
			attribute.addFlashAttribute("failure", "Contact Not Saved");
		}
		logger.debug("*** saveContactForm() method ended ***");
		return "redirect:/submitContact";
		
	}
	
	@GetMapping("/submitContact")
	public String submitContact(Model model)
	{
		model.addAttribute("contact", new Contact());
		return "index";
	}
	
}
