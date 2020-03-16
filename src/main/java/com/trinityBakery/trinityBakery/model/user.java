package com.trinityBakery.trinityBakery.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="_user")
public class user {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="u_id")
    private String u_id;
    @Column(name="u_name")
    private String u_name;
    @Column(name="contact_name")
    private String contact_name;
    @Column(name="u_type")
    private String u_type;
    @Column(name="u_level")
    private String u_level;
    @Column(name="phone")
    private String phone;
    @Column(name="qq")
    private String qq;
    @Column(name="email")
    private String email;
    @Column(name="address")
    private String address;
    
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getContact_name() {
		return contact_name;
	}
	public void setContact_name(String contact_name) {
		this.contact_name = contact_name;
	}
	public String getU_type() {
		return u_type;
	}
	public void setU_type(String u_type) {
		this.u_type = u_type;
	}
	public String getU_level() {
		return u_level;
	}
	public void setU_level(String u_level) {
		this.u_level = u_level;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
    
}
