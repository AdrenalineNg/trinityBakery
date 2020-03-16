package com.trinityBakery.trinityBakery.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="produceplan")
public class produceplan {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="p_id")
    private String p_id;
	@Column(name="p_name")
    private String p_name;
    @Column(name="quantity")
    private int quantity;
	@Column(name="p_date")
    private String p_date;
	public String getP_id() {
		return p_id;
	}
	public void setP_id(String p_id) {
		this.p_id = p_id;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getP_date() {
		return p_date;
	}
	public void setP_date(String p_date) {
		this.p_date = p_date;
	}
	
}
