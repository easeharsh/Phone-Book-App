package com.ashokit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashokit.dto.Contact;
import com.ashokit.entity.ContactDetailsEntity;
import com.ashokit.repo.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactrepository;

	@Override
	public boolean save(Contact contact) {
		ContactDetailsEntity contactObj = new ContactDetailsEntity();
		BeanUtils.copyProperties(contact, contactObj);
		ContactDetailsEntity savedEntity = contactrepository.save(contactObj);
		return savedEntity.getCid() != null;
	}

	@Override
	public List<Contact> getAllContacts() {
		List<Contact> contactList = new ArrayList<Contact>();
		List<ContactDetailsEntity> entitiesList = contactrepository.findAll();
		entitiesList.forEach(entity ->
		{
			Contact contact = new Contact();
			BeanUtils.copyProperties(entity, contact);
			contactList.add(contact);
		});
		return contactList;
	}

	@Override
	public Contact getContactById(Integer cid) {
		Optional<ContactDetailsEntity> optional = contactrepository.findById(cid);
		if(optional.isPresent())
		{
			ContactDetailsEntity entity = optional.get();
			Contact contact = new Contact();
			BeanUtils.copyProperties(entity, contact);
			return contact;
		}
		return null;
	}

	@Override
	public boolean deleteById(Integer cid) {
		contactrepository.deleteById(cid);
		return true;
	}
	

}
