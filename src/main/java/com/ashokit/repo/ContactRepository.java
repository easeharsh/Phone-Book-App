package com.ashokit.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.entity.ContactDetailsEntity;

public interface ContactRepository extends JpaRepository<ContactDetailsEntity, Serializable> {

}
