package com.ashokit.service;

import java.util.List;

import com.ashokit.dto.Contact;

public interface ContactService {

	public boolean save(Contact contact);
	
	public List<Contact> getAllContacts();
	
	public Contact getContactById(Integer cid);
	
	public boolean deleteById(Integer cid);
}
