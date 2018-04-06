package com.lzs.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="user")
public class User {
	private long id;
	private String username;
	private String password;
	private int age;
	private int gender;
	private String occupation;
	private Set<Rating> ratings;

	public static int MALE = 0;
	public static int FEMALE = 1;

	public User() {
		super();
		ratings = new HashSet<>();
	}

	public void addRating(Rating rating) {
		ratings.add(rating);
	}

	public User(long id, String username, String password, int age, int gender, String occupation) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.age = age;
		this.gender = gender;
		this.occupation = occupation;
	}

//	@GenericGenerator(name = "idGenerator", strategy = "assigned")
//	@GeneratedValue(generator = "idGenerator")
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "username")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "age")
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Column(name = "gender")
	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	@Column(name = "occupation")
	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	@OneToMany(mappedBy = "user")
	@LazyCollection(LazyCollectionOption.EXTRA)
	public Set<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(Set<Rating> ratings) {
		this.ratings = ratings;
	}

}
