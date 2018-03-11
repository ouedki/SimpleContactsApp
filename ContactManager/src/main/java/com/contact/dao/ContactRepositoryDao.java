package com.contact.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.contact.models.Contact;

public interface ContactRepositoryDao extends CrudRepository<Contact, Long>{
	@Query("select c from Contact c where c.firstName like:x")
	Page<Contact> searchByKeyWord(@Param("x") String keyWord, Pageable pageable);
}
