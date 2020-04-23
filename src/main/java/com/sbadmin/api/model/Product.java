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
@Document(collection = "products")
public class Product {
	    @Id
	    private String id;	  
	    private String name;
	    private Brand brand;
	    private VehicalType vehicaltype;
	    private Category category;
	    private SubType subtype;	    
	    private String cgst;
	    private String sgst;
	    private String hsncode;
		private int qty;
		private String price_per_unit;
		private String total_gst;
		private String total_pruchase_pr_product_price;
		private String cost_pr_unit;
		private String sale_price;
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
		 * @return the brand
		 */
		public Brand getBrand() {
			return brand;
		}
		/**
		 * @param brand the brand to set
		 */
		public void setBrand(Brand brand) {
			this.brand = brand;
		}
		/**
		 * @return the vehicaltype
		 */
		public VehicalType getVehicaltype() {
			return vehicaltype;
		}
		/**
		 * @param vehicaltype the vehicaltype to set
		 */
		public void setVehicaltype(VehicalType vehicaltype) {
			this.vehicaltype = vehicaltype;
		}
		/**
		 * @return the category
		 */
		public Category getCategory() {
			return category;
		}
		/**
		 * @param category the category to set
		 */
		public void setCategory(Category category) {
			this.category = category;
		}
		/**
		 * @return the subtype
		 */
		public SubType getSubtype() {
			return subtype;
		}
		/**
		 * @param subtype the subtype to set
		 */
		public void setSubtype(SubType subtype) {
			this.subtype = subtype;
		}
		/**
		 * @return the cgst
		 */
		public String getCgst() {
			return cgst;
		}
		/**
		 * @param cgst the cgst to set
		 */
		public void setCgst(String cgst) {
			this.cgst = cgst;
		}
		/**
		 * @return the sgst
		 */
		public String getSgst() {
			return sgst;
		}
		/**
		 * @param sgst the sgst to set
		 */
		public void setSgst(String sgst) {
			this.sgst = sgst;
		}
		/**
		 * @return the hsncode
		 */
		public String getHsncode() {
			return hsncode;
		}
		/**
		 * @param hsncode the hsncode to set
		 */
		public void setHsncode(String hsncode) {
			this.hsncode = hsncode;
		}
		/**
		 * @return the qty
		 */
		public int getQty() {
			return qty;
		}
		/**
		 * @return the price_per_unit
		 */
		public String getPrice_per_unit() {
			return price_per_unit;
		}
		/**
		 * @return the total_gst
		 */
		public String getTotal_gst() {
			return total_gst;
		}
		/**
		 * @return the total_pruchase_pr_product_price
		 */
		public String getTotal_pruchase_pr_product_price() {
			return total_pruchase_pr_product_price;
		}
		/**
		 * @return the cost_pr_unit
		 */
		public String getCost_pr_unit() {
			return cost_pr_unit;
		}
		/**
		 * @return the sale_price
		 */
		public String getSale_price() {
			return sale_price;
		}
		/**
		 * @param qty the qty to set
		 */
		public void setQty(int qty) {
			this.qty = qty;
		}
		/**
		 * @param price_per_unit the price_per_unit to set
		 */
		public void setPrice_per_unit(String price_per_unit) {
			this.price_per_unit = price_per_unit;
		}
		/**
		 * @param total_gst the total_gst to set
		 */
		public void setTotal_gst(String total_gst) {
			this.total_gst = total_gst;
		}
		/**
		 * @param total_pruchase_pr_product_price the total_pruchase_pr_product_price to set
		 */
		public void setTotal_pruchase_pr_product_price(String total_pruchase_pr_product_price) {
			this.total_pruchase_pr_product_price = total_pruchase_pr_product_price;
		}
		/**
		 * @param cost_pr_unit the cost_pr_unit to set
		 */
		public void setCost_pr_unit(String cost_pr_unit) {
			this.cost_pr_unit = cost_pr_unit;
		}
		/**
		 * @param sale_price the sale_price to set
		 */
		public void setSale_price(String sale_price) {
			this.sale_price = sale_price;
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
		@Override
		public String toString() {
			return "Product [id=" + id + ", name=" + name + ", brand=" + brand + ", vehicaltype=" + vehicaltype
					+ ", category=" + category + ", subtype=" + subtype + ", cgst=" + cgst + ", sgst=" + sgst
					+ ", hsncode=" + hsncode + ", qty=" + qty + ", price_per_unit=" + price_per_unit + ", total_gst="
					+ total_gst + ", total_pruchase_pr_product_price=" + total_pruchase_pr_product_price
					+ ", cost_pr_unit=" + cost_pr_unit + ", sale_price=" + sale_price + ", createdBy=" + createdBy
					+ ", createdDate=" + createdDate + ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate
					+ "]";
		}
		 
	 
	    
}
