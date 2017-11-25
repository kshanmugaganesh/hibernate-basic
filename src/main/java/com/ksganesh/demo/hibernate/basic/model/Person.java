/**
 * 
 */
package com.ksganesh.demo.hibernate.basic.model;

import java.util.Date;

/**
 * @author ksganesh
 *
 */
public class Person {
	
	public Person() {}
	
	private int id;
	
	private String name;
	private Date birthDate;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public Person(String name, Date birthDate) {
		super();
		this.name = name;
		this.birthDate = birthDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	

}
