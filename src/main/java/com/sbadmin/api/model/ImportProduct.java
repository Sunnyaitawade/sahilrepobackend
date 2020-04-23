package com.sbadmin.api.model;

public class ImportProduct {
	private String size;
	private String brand;
	private String subtype;
	private String vehicletype;
    private String csgst;
    private String sgst;
    private String category;
	/**
	 * @return the size
	 */
	public String getSize() {
		return size;
	}
	/**
	 * @param size the size to set
	 */
	public void setSize(String size) {
		this.size = size;
	}
	/**
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}
	/**
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}
	/**
	 * @return the subtype
	 */
	public String getSubtype() {
		return subtype;
	}
	/**
	 * @param subtype the subtype to set
	 */
	public void setSubtype(String subtype) {
		this.subtype = subtype;
	}
	/**
	 * @return the vehicletype
	 */
	public String getVehicletype() {
		return vehicletype;
	}
	/**
	 * @param vehicletype the vehicletype to set
	 */
	public void setVehicletype(String vehicletype) {
		this.vehicletype = vehicletype;
	}
	/**
	 * @return the csgst
	 */
	public String getCsgst() {
		return csgst;
	}
	/**
	 * @param csgst the csgst to set
	 */
	public void setCsgst(String csgst) {
		this.csgst = csgst;
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
	@Override
	public String toString() {
		return "ImportProduct [size=" + size + ", brand=" + brand + ", subtype=" + subtype + ", vehicletype="
				+ vehicletype + ", csgst=" + csgst + ", sgst=" + sgst + "]";
	}
	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	 
}
