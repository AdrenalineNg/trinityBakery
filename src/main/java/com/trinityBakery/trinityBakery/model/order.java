package com.trinityBakery.trinityBakery.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="orderform")
public class order {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="order_id")
    private String order_id;
	@Column(name="salesperson")
    private String salesperson;
    @Column(name="totalprice")
    private float totalprice;
    @Column(name="address")
    private String address;
	@Column(name="chuku_fahuo")
    private String chuku_fahuo;
    @Column(name="is_confirm")
    private String is_confirm;
    @Column(name="is_paid")
    private String is_paid;
    @Column(name="tihuo")
    private String tihuo;
    
	public String getTihuo() {
		return tihuo;
	}
	public void setTihuo(String tihuo) {
		this.tihuo = tihuo;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public String getSalesperson() {
		return salesperson;
	}
	public void setSalesperson(String salesperson) {
		this.salesperson = salesperson;
	}
	public float getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(float totalprice) {
		this.totalprice = totalprice;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getChuku_fahuo() {
		return chuku_fahuo;
	}
	public void setChuku_fahuo(String chuku_fahuo) {
		this.chuku_fahuo = chuku_fahuo;
	}
	public String getIs_confirm() {
		return is_confirm;
	}
	public void setIs_confirm(String is_confirm) {
		this.is_confirm = is_confirm;
	}
	public String getIs_paid() {
		return is_paid;
	}
	public void setIs_paid(String is_paid) {
		this.is_paid = is_paid;
	}
	

}