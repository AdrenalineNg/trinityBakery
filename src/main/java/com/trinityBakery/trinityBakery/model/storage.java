package com.trinityBakery.trinityBakery.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="storage")
public class storage {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="sfid")
    private String sfid;
	@Column(name="p_name")
    private String p_name;
    @Column(name="sto_date")
    private String sto_date;
    @Column(name="p_img")
    private String p_img;
    @Column(name="quantity")
    private int quantity;
    @Column(name="exp")
    private String exp;
	public String getSfid() {
		return sfid;
	}
	public void setSfid(String sfid) {
		this.sfid = sfid;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public String getSto_date() {
		return sto_date;
	}
	public void setSto_date(String sto_date) {
		this.sto_date = sto_date;
	}
	public String getP_img() {
		return p_img;
	}
	public void setP_img(String p_img) {
		this.p_img = p_img;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getExp() {
		return exp;
	}
	public void setExp(String exp) {
		this.exp = exp;
	}
    
}
