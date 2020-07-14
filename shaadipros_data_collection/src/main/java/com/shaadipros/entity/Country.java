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


@Entity
@Table(name = "country", schema = "public")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Country implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 383662048920649570L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "country_gen")
	@SequenceGenerator(name = "country_gen", sequenceName = "country_seq", allocationSize = 1)
	@JsonAlias("id")
	private int id;
	
	@Column(name = "C_NAME")
	@JsonAlias("name")
	private String name;
	
	@Column(name = "SLUG")
	@JsonAlias("slug")
	@JsonIgnore
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String slug;
	
	@Column(name = "COUNTRY_CODE")
	@JsonAlias("code")
	private Integer countryCode;
	
	@Column(name = "IS_ACTIVE")
	@JsonAlias("isActive")
	private boolean isActive = true;
	
	@Column(name = "IS_DELETED")
	@JsonIgnore
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private boolean isDeleted = false;
	
	@CreatedDate
	@JsonIgnore
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Date createdDate = new Date();
	
	@CreatedBy
	@JsonIgnore
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String createdBy;
	
	@LastModifiedDate
	@JsonIgnore
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Date modifiedDate;
	
	@Column(name = "MODIFIED_BY")
	@JsonIgnore
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String modifiedBy;
	
	@OneToMany(mappedBy = "countryId", orphanRemoval = true,fetch = FetchType.LAZY)
	private List<State> state;
	
	/*@OneToMany(mappedBy = "countryId", orphanRemoval = true, fetch = FetchType.LAZY)
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

	public Integer getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(Integer countryCode) {
		this.countryCode = countryCode;
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

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
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

	public List<State> getState() {
		return state;
	}

	public void setState(List<State> state) {
		this.state = state;
	}

	/*@Override
	public String toString() {
		return new Gson().toJson(this);
	}*/
	
}
