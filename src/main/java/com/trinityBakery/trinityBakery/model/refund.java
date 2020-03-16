package com.trinityBakery.trinityBakery.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="refundform")
public class refund {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="refund_id")
    private String refund_id;
	@Column(name="salesperson")
    private String salesperson;
    @Column(name="totalprice")
    private float totalprice;
    @Column(name="order_id")
    private String order_id;
    @Column(name="is_confirm")
    private String is_confirm;
    @Column(name="is_paid")
    private String is_paid;
	public String getRefund_id() {
		return refund_id;
	}
	public void setRefund_id(String refund_id) {
		this.refund_id = refund_id;
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
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
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
