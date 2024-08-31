package com.BILLING.ENTITY;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="CUSTOMER_SALE")
public class ENTITYCLASS {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
   private String doctor;
	private int phoneno;
	private String product;
	private float gst_perce;
	private String pack;
	private String expire;
	private float qty; 
	private float rate;
	private float amount;
	private float mrp;
	private float gst_value;
	public ENTITYCLASS() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ENTITYCLASS(int id, String doctor, int phoneno, String product, float gst_perce, String pack, String expire,
			float qty, float rate, float amount, float mrp, float gst_value) {
		super();
		this.id = id;
		this.doctor = doctor;
		this.phoneno = phoneno;
		this.product = product;
		this.gst_perce = gst_perce;
		this.pack = pack;
		this.expire = expire;
		this.qty = qty;
		this.rate = rate;
		this.amount = amount;
		this.mrp = mrp;
		this.gst_value = gst_value;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDoctor() {
		return doctor;
	}
	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}
	public int getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(int phoneno) {
		this.phoneno = phoneno;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public float getGst_perce() {
		return gst_perce;
	}
	public void setGst_perce(float gst_perce) {
		this.gst_perce = gst_perce;
	}
	public String getPack() {
		return pack;
	}
	public void setPack(String pack) {
		this.pack = pack;
	}
	public String getExpire() {
		return expire;
	}
	public void setExpire(String expire) {
		this.expire = expire;
	}
	public float getQty() {
		return qty;
	}
	public void setQty(float qty) {
		this.qty = qty;
	}
	public float getRate() {
		return rate;
	}
	public void setRate(float rate) {
		this.rate = rate;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public float getMrp() {
		return mrp;
	}
	public void setMrp(float mrp) {
		this.mrp = mrp;
	}
	public float getGst_value() {
		return gst_value;
	}
	public void setGst_value(float gst_value) {
		this.gst_value = gst_value;
	}
	@Override
	public String toString() {
		return "ENTITYCLASS [id=" + id + ", doctor=" + doctor + ", phoneno=" + phoneno + ", product=" + product
				+ ", gst_perce=" + gst_perce + ", pack=" + pack + ", expire=" + expire + ", qty=" + qty + ", rate="
				+ rate + ", amount=" + amount + ", mrp=" + mrp + ", gst_value=" + gst_value + "]";
	}
	
	
	}
