package com.webapp.hibernate_relations;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class StudentModel {

	@Id
	private int rollno;
	private String name;
	
	@OneToMany(mappedBy = "st")// ,fetch= FetchType.EAGER) //by default it is LAZY, EAGER -> gets the data of related table also - outerjoin) //this avoids (3rd) mapping table- student_laptop -> use the variable name linked with mapping
	private List<LaptopModel> lp=new ArrayList<LaptopModel>();
	
	public List<LaptopModel> getLp() {
		return lp;
	}
	public void setLp(List<LaptopModel> lp) {
		this.lp = lp;
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "StudentModel [rollno=" + rollno + ", name=" + name + ", lp=" + lp + "]";
	}
	
}
