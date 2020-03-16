package com.trinityBakery.trinityBakery.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="good")
public class good {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="g_id")
    private String g_id;
	@Column(name="g_name")
    private String g_name;
    @Column(name="g_price")
    private float g_price;
    @Column(name="g_img")
    private String g_img;
    @Column(name="g_weight")
    private String g_weight;
    
    public String getG_weight() {
		return g_weight;
	}
	public void setG_weight(String g_weight) {
		this.g_weight = g_weight;
	}
	public String getG_id() {
		return g_id;
	}
	public void setG_id(String g_id) {
		this.g_id = g_id;
	}
	public String getG_name() {
		return g_name;
	}
	public void setG_name(String g_name) {
		this.g_name = g_name;
	}
	public float getG_price() {
		return g_price;
	}
	public void setG_price(float g_price) {
		this.g_price = g_price;
	}
	public String getG_img() {
		return g_img;
	}
	public void setG_img(String g_img) {
		this.g_img = g_img;
	}

}
