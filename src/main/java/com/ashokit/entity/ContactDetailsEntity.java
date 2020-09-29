package com.ashokit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="CONTACT_DETAILS_ENTITY")
public class ContactDetailsEntity {
	
	@Id
	@GeneratedValue
	@Column(name="CONTACT_ID")
	private Integer cid;
	@Column(name="CONTACT_NAME")
	private String cname;
	@Column(name="CONTACT_EMAIL")
	private String email;
	@Column(name="CONTACT_NUM")
	private Long cnum;
}
