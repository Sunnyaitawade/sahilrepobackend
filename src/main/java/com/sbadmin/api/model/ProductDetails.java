package com.sbadmin.api.model;

public class ProductDetails {
	private Product product;
	private int qty;
	private String price_per_unit;
	private String total_gst;
	private String total_pruchase_pr_product_price;
	private String cost_pr_unit;
	private String sale_price;
	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}
	@Override
	public String toString() {
		return "ProductDetails [product=" + product + ", qty=" + qty + ", price_per_unit=" + price_per_unit
				+ ", total_gst=" + total_gst + ", total_pruchase_pr_product_price=" + total_pruchase_pr_product_price
				+ ", cost_pr_unit=" + cost_pr_unit + ", sale_price=" + sale_price + "]";
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
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}
	 
	/**
	 * @return the qty
	 */
	public int getQty() {
		return qty;
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
}
