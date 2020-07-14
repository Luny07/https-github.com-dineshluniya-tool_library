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
@Table(name = "state_zip_codes", schema = "public")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StateZipCode  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5062240421951045577L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "city_gen")
	@SequenceGenerator(name = "city_gen", sequenceName = "city_seq", allocationSize = 1)
	@JsonAlias("id")
	private int id;
	
	@JoinColumn(name = "c_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private City cityId;
	
	@Column(name = "POSTCODE")
	@JsonAlias("postcode")
	private String postcode;
	
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
	
	/*@OneToMany(mappedBy = "postCodeId", orphanRemoval = true, fetch = FetchType.LAZY)
	private List<UserAddress> useraddress;

	public List<UserAddress> getUseraddress() {
		return useraddress;
	}

	public void setUseraddress(List<UserAddress> useraddress) {
		this.useraddress = useraddress;
	}*/

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public City getCityId() {
		return cityId;
	}

	public void setCityId(City cityId) {
		this.cityId = cityId;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
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
	
	
}
