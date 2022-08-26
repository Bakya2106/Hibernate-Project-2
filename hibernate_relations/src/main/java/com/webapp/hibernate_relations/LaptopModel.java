package com.webapp.hibernate_relations;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "laptop")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class LaptopModel {

	@Id
	private int lapId;
	private String name;
	
	@ManyToOne
	private StudentModel st;
	
	
	public StudentModel getSt() {
		return st;
	}

	public void setSt(StudentModel st) {
		this.st = st;
	}

	public int getLapId() {
		return lapId;
	}
	
	public void setLapId(int lapId) {
		this.lapId = lapId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "LaptopModel [lapId=" + lapId + ", name=" + name + "]";
	}
	
}
