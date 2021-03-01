package com.enroll.service.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Data
@EqualsAndHashCode(exclude = "enrollees")
@Entity
@Table(name = "Dependents")
@Getter @Setter
public class Dependents implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "dependentId", updatable = false, nullable = false)
	private long dependentId;

	@Column(name = "dependentName", nullable = false)
	@NotEmpty(message = "Name shold not by empty")
	private String dependentName;

	@Column(name = "dependentBirthDate", nullable = false)
	private Date dependentBirthDate;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "e_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Enrollees enrollees;

	public long getDependentId() {
		return dependentId;
	}

	public void setDependentId(long dependentId) {
		this.dependentId = dependentId;
	}

	public String getDependentName() {
		return dependentName;
	}

	public void setDependentName(String dependentName) {
		this.dependentName = dependentName;
	}

	public Date getDependentBirthDate() {
		return dependentBirthDate;
	}

	public void setDependentBirthDate(Date dependentBirthDate) {
		this.dependentBirthDate = dependentBirthDate;
	}

	public Enrollees getEnrollees() {
		return enrollees;
	}

	public void setEnrollees(Enrollees enrollees) {
		this.enrollees = enrollees;
	}

}
