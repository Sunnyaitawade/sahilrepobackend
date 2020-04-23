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
@Document(collection = "supplierpayment")
public class SupplierPayment {
	  @Id
	    private String id;
	  private Supplier supplier;
	  private String mobileno;
	  private String payment_remark;
	  private String payment_mode;
	  private int prevdues;
	  private int paid_amount;
	  private int dues;
	  private String paymentdate;
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @return the supplier
	 */
	public Supplier getSupplier() {
		return supplier;
	}
	/**
	 * @return the mobileno
	 */
	public String getMobileno() {
		return mobileno;
	}
	/**
	 * @return the payment_remark
	 */
	public String getPayment_remark() {
		return payment_remark;
	}
	/**
	 * @return the payment_mode
	 */
	public String getPayment_mode() {
		return payment_mode;
	}
	/**
	 * @return the prevdues
	 */
	public int getPrevdues() {
		return prevdues;
	}
	/**
	 * @return the paid_amount
	 */
	public int getPaid_amount() {
		return paid_amount;
	}
	/**
	 * @return the dues
	 */
	public int getDues() {
		return dues;
	}
	/**
	 * @return the paymentdate
	 */
	public String getPaymentdate() {
		return paymentdate;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @param supplier the supplier to set
	 */
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	/**
	 * @param mobileno the mobileno to set
	 */
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	/**
	 * @param payment_remark the payment_remark to set
	 */
	public void setPayment_remark(String payment_remark) {
		this.payment_remark = payment_remark;
	}
	/**
	 * @param payment_mode the payment_mode to set
	 */
	public void setPayment_mode(String payment_mode) {
		this.payment_mode = payment_mode;
	}
	/**
	 * @param prevdues the prevdues to set
	 */
	public void setPrevdues(int prevdues) {
		this.prevdues = prevdues;
	}
	/**
	 * @param paid_amount the paid_amount to set
	 */
	public void setPaid_amount(int paid_amount) {
		this.paid_amount = paid_amount;
	}
	/**
	 * @param dues the dues to set
	 */
	public void setDues(int dues) {
		this.dues = dues;
	}
	/**
	 * @param paymentdate the paymentdate to set
	 */
	public void setPaymentdate(String paymentdate) {
		this.paymentdate = paymentdate;
	}
}
  