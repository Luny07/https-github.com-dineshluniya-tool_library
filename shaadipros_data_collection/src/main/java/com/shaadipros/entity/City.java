package com.shaadipros.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;


@Entity
@Table(name = "city", schema = "public")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class City  implements Serializable{
	
	private static final long serialVersionUID = 8361614201689795318L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "city_gen")
	@SequenceGenerator(name = "city_gen", sequenceName = "city_seq", allocationSize = 1)
	@JsonAlias("id")
	private int id;
	
	@Column(name = "C_NAME")
	@JsonAlias("name")
	private String name;
	
	@Column(name = "SLUG")
	@JsonAlias("slug")
	private String slug;
	
	/*public List<UserAddress> getUseraddress() {
		return useraddress;
	}

	public void setUseraddress(List<UserAddress> useraddress) {
		this.useraddress = useraddress;
	}*/

	@JoinColumn(name = "S_ID")
    @ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	@JsonProperty(access = Access.WRITE_ONLY)
	private State stateId;
	
/*	@OneToMany(mappedBy = "cityId", orphanRemoval = true, fetch = FetchType.LAZY)
	private List<UserAddress> useraddress;*/
	
	@Column(name = "IS_ACTIVE")
	@JsonAlias("isActive")
	private boolean isActive;
	
	@Column(name = "IS_DELETED")
	@JsonIgnore
	@JsonProperty(access = Access.WRITE_ONLY)
	private boolean isDeleted;
	
	@CreatedDate
	@JsonIgnore
	@JsonProperty(access = Access.WRITE_ONLY)
	private Date createdDate;
	
	@LastModifiedDate
	@JsonIgnore
	@JsonProperty(access = Access.WRITE_ONLY)
	private Date modifiedDate;
	
	@CreatedBy
	@JsonIgnore
	@JsonProperty(access = Access.WRITE_ONLY)
	private String createdBy;
	
	@Column(name = "MODIFIED_BY")
	@JsonIgnore
	@JsonProperty(access = Access.WRITE_ONLY)
	private String modifiedBy;
	
	@OneToMany(mappedBy = "cityId", orphanRemoval = true, fetch = FetchType.LAZY)
	private List<StateZipCode> postcode;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public State getState() {
		return stateId;
	}

	public void setState(State stateId) {
		this.stateId = stateId;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public State getStateId() {
		return stateId;
	}

	public void setStateId(State stateId) {
		this.stateId = stateId;
	}

	public List<StateZipCode> getPostcode() {
		return postcode;
	}

	public void setPostcode(List<StateZipCode> postcode) {
		this.postcode = postcode;
	}

	/*@Override
	public String toString() {
		return new Gson().toJson(this);
	}*/
}
