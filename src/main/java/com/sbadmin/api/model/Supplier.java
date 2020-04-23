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
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author sunny
 *
 */
@Document(collection = "suppliers")
public class Supplier {
	  @Id
	    private String id;
	  
	  private String name;
	  private String organization;
	  private String gstinno;
	  private String city;
	  private int prevdues;
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

		/**
		 * @return the id
		 */
		public String getId() {
			return id;
		}

		/**
		 * @param id the id to set
		 */
		public void setId(String id) {
			this.id = id;
		}

		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		/**
		 * @param name the name to set
		 */
		public void setName(String name) {
			this.name = name;
		}

		/**
		 * @return the organization
		 */
		public String getOrganization() {
			return organization;
		}

		/**
		 * @param organization the organization to set
		 */
		public void setOrganization(String organization) {
			this.organization = organization;
		}

		/**
		 * @return the gstinno
		 */
		public String getGstinno() {
			return gstinno;
		}

		/**
		 * @param gstinno the gstinno to set
		 */
		public void setGstinno(String gstinno) {
			this.gstinno = gstinno;
		}

		/**
		 * @return the city
		 */
		public String getCity() {
			return city;
		}

		/**
		 * @param city the city to set
		 */
		public void setCity(String city) {
			this.city = city;
		}

		/**
		 * @return the contacts
		 */
		public Contacts[] getContacts() {
			return contacts;
		}

		/**
		 * @param contacts the contacts to set
		 */
		public void setContacts(Contacts[] contacts) {
			this.contacts = contacts;
		}

		/**
		 * @return the financelist
		 */
		public Finance[] getFinancelist() {
			return financelist;
		}

		/**
		 * @param financelist the financelist to set
		 */
		public void setFinancelist(Finance[] financelist) {
			this.financelist = financelist;
		}

		/**
		 * @return the createdBy
		 */
		public String getCreatedBy() {
			return createdBy;
		}

		/**
		 * @param createdBy the createdBy to set
		 */
		public void setCreatedBy(String createdBy) {
			this.createdBy = createdBy;
		}

		/**
		 * @return the createdDate
		 */
		public Date getCreatedDate() {
			return createdDate;
		}

		/**
		 * @param createdDate the createdDate to set
		 */
		public void setCreatedDate(Date createdDate) {
			this.createdDate = createdDate;
		}

		/**
		 * @return the updatedBy
		 */
		public String getUpdatedBy() {
			return updatedBy;
		}

		/**
		 * @param updatedBy the updatedBy to set
		 */
		public void setUpdatedBy(String updatedBy) {
			this.updatedBy = updatedBy;
		}

		/**
		 * @return the updatedDate
		 */
		public Date getUpdatedDate() {
			return updatedDate;
		}

		/**
		 * @param updatedDate the updatedDate to set
		 */
		public void setUpdatedDate(Date updatedDate) {
			this.updatedDate = updatedDate;
		}

		/**
		 * @return the prevdues
		 */
		public int getPrevdues() {
			return prevdues;
		}

		/**
		 * @param prevdues the prevdues to set
		 */
		public void setPrevdues(int prevdues) {
			this.prevdues = prevdues;
		}

	  

}
 