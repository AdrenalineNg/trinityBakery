package com.trinityBakery.trinityBakery.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="_admin")
public class admin {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="a_id")
    private String a_id;
    @Column(name="a_name")
    private String a_name;
    @Column(name="a_department")
    private String a_department;
    @Column(name="a_tel")
    private String a_tel;
    @Column(name="a_email")
    private String a_email;
	public String getA_name() {
		return a_name;
	}
	public void setA_name(String a_name) {
		this.a_name = a_name;
	}
	public String getA_id() {
		return a_id;
	}
	public void setA_id(String a_id) {
		this.a_id = a_id;
	}
	public String getA_department() {
		return a_department;
	}
	public void setA_department(String a_department) {
		this.a_department = a_department;
	}
	public String getA_tel() {
		return a_tel;
	}
	public void setA_tel(String a_tel) {
		this.a_tel = a_tel;
	}
	public String getA_email() {
		return a_email;
	}
	public void setA_email(String a_email) {
		this.a_email = a_email;
	}

}

