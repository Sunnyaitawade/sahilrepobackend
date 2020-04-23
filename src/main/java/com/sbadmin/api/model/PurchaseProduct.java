/**
 * 
 */
package com.sbadmin.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author sunny
 *
 */
@Document(collection = "purchases")
public class PurchaseProduct {
	   @Id
	    private String id;	 
	   private Supplier supplier;
	   private String mobileno;
	   private String prevdues;
	   private String invoicedate;
	   private String  invoiceno;
	   private String  total_amount;
	   private String discount;
	   private String  total_discount;
	   private String net_amount;
	   private String payment_mode;
	   private String paid_amount;
	   private int dues;
	   private String payment_remark;
	   private ProductDetails purchaseitmes[];
	   
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
	 * @return the supplier
	 */
	public Supplier getSupplier() {
		return supplier;
	}
	/**
	 * @param supplier the supplier to set
	 */
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	/**
	 * @return the mobileno
	 */
	public String getMobileno() {
		return mobileno;
	}
	/**
	 * @param mobileno the mobileno to set
	 */
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	/**
	 * @return the prevdues
	 */
	public String getPrevdues() {
		return prevdues;
	}
	/**
	 * @param prevdues the prevdues to set
	 */
	public void setPrevdues(String prevdues) {
		this.prevdues = prevdues;
	}
	/**
	 * @return the invoicedate
	 */
	public String getInvoicedate() {
		return invoicedate;
	}
	/**
	 * @param invoicedate the invoicedate to set
	 */
	public void setInvoicedate(String invoicedate) {
		this.invoicedate = invoicedate;
	}
	/**
	 * @return the invoiceno
	 */
	public String getInvoiceno() {
		return invoiceno;
	}
	/**
	 * @param invoiceno the invoiceno to set
	 */
	public void setInvoiceno(String invoiceno) {
		this.invoiceno = invoiceno;
	}
	/**
	 * @return the total_amount
	 */
	public String getTotal_amount() {
		return total_amount;
	}
	/**
	 * @param total_amount the total_amount to set
	 */
	public void setTotal_amount(String total_amount) {
		this.total_amount = total_amount;
	}
	/**
	 * @return the discount
	 */
	public String getDiscount() {
		return discount;
	}
	/**
	 * @param discount the discount to set
	 */
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	/**
	 * @return the total_discount
	 */
	public String getTotal_discount() {
		return total_discount;
	}
	/**
	 * @param total_discount the total_discount to set
	 */
	public void setTotal_discount(String total_discount) {
		this.total_discount = total_discount;
	}
	/**
	 * @return the net_amount
	 */
	public String getNet_amount() {
		return net_amount;
	}
	/**
	 * @param net_amount the net_amount to set
	 */
	public void setNet_amount(String net_amount) {
		this.net_amount = net_amount;
	}
	/**
	 * @return the payment_mode
	 */
	public String getPayment_mode() {
		return payment_mode;
	}
	/**
	 * @param payment_mode the payment_mode to set
	 */
	public void setPayment_mode(String payment_mode) {
		this.payment_mode = payment_mode;
	}
	/**
	 * @return the paid_amount
	 */
	public String getPaid_amount() {
		return paid_amount;
	}
	/**
	 * @param paid_amount the paid_amount to set
	 */
	public void setPaid_amount(String paid_amount) {
		this.paid_amount = paid_amount;
	}
	 
	/**
	 * @return the dues
	 */
	public int getDues() {
		return dues;
	}
	/**
	 * @param dues the dues to set
	 */
	public void setDues(int dues) {
		this.dues = dues;
	}
	/**
	 * @return the payment_remark
	 */
	public String getPayment_remark() {
		return payment_remark;
	}
	/**
	 * @param payment_remark the payment_remark to set
	 */
	public void setPayment_remark(String payment_remark) {
		this.payment_remark = payment_remark;
	}
	/**
	 * @return the purchaseitmes
	 */
	public ProductDetails[] getPurchaseitmes() {
		return purchaseitmes;
	}
	/**
	 * @param purchaseitmes the purchaseitmes to set
	 */
	public void setPurchaseitmes(ProductDetails[] purchaseitmes) {
		this.purchaseitmes = purchaseitmes;
	}
	 
	 
	 
	 
	    
	    
	   
}
 