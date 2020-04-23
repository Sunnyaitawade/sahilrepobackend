/**
 * 
 */
package com.sbadmin.api.model;

import java.util.Date;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

/**
 * @author sunny
 *
 */
public class Customer {
	@Id
	private String id;
	private String name;
	private String organization;
	private String mobileno;
	private String city;
	private Contacts contacts[];
	private Finance financelist[];
	@CreatedBy
	private String createdBy;

	@CreatedDate
	private Date createdDate = new Date();

	@LastModifiedBy
	private String updatedBy;

	@LastModifiedDate
	private Date updatedDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Contacts[] getContacts() {
		return contacts;
	}

	public void setContacts(Contacts[] contacts) {
		this.contacts = contacts;
	}

	public Finance[] getFinancelist() {
		return financelist;
	}

	public void setFinancelist(Finance[] financelist) {
		this.financelist = financelist;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
}
