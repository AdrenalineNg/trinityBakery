package com.trinityBakery.trinityBakery.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="deliveryform2")
public class tihuo {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="tihuo_id")
    private String tihuo_id;
	@Column(name="accountant")
    private String accountant;
    @Column(name="totalprice")
    private float totalprice;
    @Column(name="address")
    private String address;
	@Column(name="tihuo")
    private String tihuo;
	public String getTihuo_id() {
		return tihuo_id;
	}
	public void setTihuo_id(String tihuo_id) {
		this.tihuo_id = tihuo_id;
	}
	public String getAccountant() {
		return accountant;
	}
	public void setAccountant(String accountant) {
		this.accountant = accountant;
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
	public String getTihuo() {
		return tihuo;
	}
	public void setTihuo(String tihuo) {
		this.tihuo = tihuo;
	}
	
}
