package com.contact.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.contact.dao.ContactRepositoryDao;
import com.contact.models.Contact;

@RestController
@CrossOrigin("*")
public class ContactRestService {
	
	@Autowired
	ContactRepositoryDao contactRepositoryDao;
	
	@RequestMapping("/contacts")
	public List<Contact> getContacts(){
		return (List<Contact>) contactRepositoryDao.findAll();
	}
	
	@RequestMapping("/contacts/{id}")
	public Contact getContact(@PathVariable Long id) {
		return contactRepositoryDao.findOne(id);
	}
	
	@RequestMapping(value="/contacts", method=RequestMethod.POST)
	public Contact saveContact(@RequestBody Contact c) {
		return contactRepositoryDao.save(c);
	}
	
	@RequestMapping(value="/contacts/{id}", method=RequestMethod.DELETE)
	public void deleteContact(@PathVariable Long id) {
		 contactRepositoryDao.delete(id);
	}
	
	@RequestMapping(value="/contacts/{id}", method=RequestMethod.PUT)
	public Contact editContact(@PathVariable Long id, @RequestBody Contact c) {
		c.setId(id);
		return contactRepositoryDao.save(c);
	}
	
	@RequestMapping("/search")
	public Page<Contact> search(@RequestParam(name="keyWord",defaultValue="") String keyWord, 
			@RequestParam(name="page",defaultValue="0") int page,
			@RequestParam(name="size",defaultValue="5") int size) {
		return contactRepositoryDao.searchByKeyWord("%"+keyWord+"%", new PageRequest(page, size));
	}
}
