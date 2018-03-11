package com.contact;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.contact.dao.ContactRepositoryDao;
import com.contact.models.Contact;

@SpringBootApplication
public class ContactManagerApplication implements CommandLineRunner {

	@Autowired
	ContactRepositoryDao contactRepositoryDao;
	
	public static void main(String[] args) {
		SpringApplication.run(ContactManagerApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		contactRepositoryDao.save(new Contact("Yassine", "Ouedki", "Yassine@gmail.com", "12345", df.parse("05/08/1985"), "yassine.jpg"));
		contactRepositoryDao.save(new Contact("Hassan", "Rochdi", "hassan@gmail.com", "22223", df.parse("15/04/1975"), "hassan.jpg"));
		contactRepositoryDao.save(new Contact("Amine", "Oussou", "amine@gmail.com", "445643", df.parse("12/12/1988"), "amine.jpg"));
		contactRepositoryDao.save(new Contact("Aiden", "Richards", "aiden@gmail.com", "88787788", df.parse("21/07/1999"), "aiden.jpg"));
		contactRepositoryDao.save(new Contact("Yassine", "Ouedki", "Yassine@gmail.com", "12345", df.parse("05/08/1985"), "yassine.jpg"));
		contactRepositoryDao.save(new Contact("Hassan", "Rochdi", "hassan@gmail.com", "22223", df.parse("15/04/1975"), "hassan.jpg"));
		contactRepositoryDao.save(new Contact("Amine", "Oussou", "amine@gmail.com", "445643", df.parse("12/12/1988"), "amine.jpg"));
		contactRepositoryDao.save(new Contact("Aiden", "Richards", "aiden@gmail.com", "88787788", df.parse("21/07/1999"), "aiden.jpg"));
		contactRepositoryDao.save(new Contact("Yassine", "Ouedki", "Yassine@gmail.com", "12345", df.parse("05/08/1985"), "yassine.jpg"));
		contactRepositoryDao.save(new Contact("Hassan", "Rochdi", "hassan@gmail.com", "22223", df.parse("15/04/1975"), "hassan.jpg"));
		contactRepositoryDao.save(new Contact("Amine", "Oussou", "amine@gmail.com", "445643", df.parse("12/12/1988"), "amine.jpg"));
		contactRepositoryDao.save(new Contact("Aiden", "Richards", "aiden@gmail.com", "88787788", df.parse("21/07/1999"), "aiden.jpg"));
		
		contactRepositoryDao.findAll().forEach(c-> System.out.println(c.getFirstName()));

		
	}
}
