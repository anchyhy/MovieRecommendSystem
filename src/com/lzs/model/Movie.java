package com.lzs.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "movie")
public class Movie {
	private long id;
	private String title;
	private Date date;
	private boolean unkown;
	private boolean action;
	private boolean adventure;
	private boolean animation;
	private boolean children;
	private boolean comedy;
	private boolean crime;
	private boolean documentary;
	private boolean drama;
	private boolean fantasy;
	private boolean filmnoir;
	private boolean horror;
	private boolean musical;
	private boolean mystery;
	private boolean romance;
	private boolean scifi;
	private boolean thriller;
	private boolean war;
	private boolean western;
	private Set<Rating> ratings;

	public Movie() {
		ratings = new HashSet<>();
	}

	public void addRating(Rating rating) {
		ratings.add(rating);
	}

	@Id
	@GenericGenerator(name = "idGenerator", strategy = "assigned")
	@GeneratedValue(generator = "idGenerator")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name="date")
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name="unknown")
	public boolean isUnkown() {
		return unkown;
	}

	public void setUnkown(boolean unkown) {
		this.unkown = unkown;
	}

	@Column(name="action")
	public boolean isAction() {
		return action;
	}

	public void setAction(boolean action) {
		this.action = action;
	}

	@Column(name="adventure")
	public boolean isAdventure() {
		return adventure;
	}

	public void setAdventure(boolean adventure) {
		this.adventure = adventure;
	}

	@Column(name="animation")
	public boolean isAnimation() {
		return animation;
	}

	public void setAnimation(boolean animation) {
		this.animation = animation;
	}

	@Column(name="children")
	public boolean isChildren() {
		return children;
	}

	public void setChildren(boolean children) {
		this.children = children;
	}

	@Column(name="comedy")
	public boolean isComedy() {
		return comedy;
	}

	public void setComedy(boolean comedy) {
		this.comedy = comedy;
	}

	@Column(name="crime")
	public boolean isCrime() {
		return crime;
	}

	public void setCrime(boolean crime) {
		this.crime = crime;
	}

	@Column(name="documentary")
	public boolean isDocumentary() {
		return documentary;
	}

	public void setDocumentary(boolean documentary) {
		this.documentary = documentary;
	}

	@Column(name="drama")
	public boolean isDrama() {
		return drama;
	}

	public void setDrama(boolean drama) {
		this.drama = drama;
	}

	@Column(name="fantasy")
	public boolean isFantasy() {
		return fantasy;
	}

	public void setFantasy(boolean fantasy) {
		this.fantasy = fantasy;
	}

	@Column(name="filmnoir")
	public boolean isFilmnoir() {
		return filmnoir;
	}

	public void setFilmnoir(boolean filmnoir) {
		this.filmnoir = filmnoir;
	}

	@Column(name="horror")
	public boolean isHorror() {
		return horror;
	}

	public void setHorror(boolean horror) {
		this.horror = horror;
	}

	@Column(name="musical")
	public boolean isMusical() {
		return musical;
	}

	public void setMusical(boolean musical) {
		this.musical = musical;
	}

	@Column(name="mystery")
	public boolean isMystery() {
		return mystery;
	}

	public void setMystery(boolean mystery) {
		this.mystery = mystery;
	}

	@Column(name="romance")
	public boolean isRomance() {
		return romance;
	}

	public void setRomance(boolean romance) {
		this.romance = romance;
	}

	@Column(name="scifi")
	public boolean isScifi() {
		return scifi;
	}

	public void setScifi(boolean scifi) {
		this.scifi = scifi;
	}

	@Column(name="thriller")
	public boolean isThriller() {
		return thriller;
	}

	public void setThriller(boolean thriller) {
		this.thriller = thriller;
	}

	@Column(name="war")
	public boolean isWar() {
		return war;
	}

	public void setWar(boolean war) {
		this.war = war;
	}

	@Column(name="western")
	public boolean isWestern() {
		return western;
	}

	public void setWestern(boolean western) {
		this.western = western;
	}

	@OneToMany(mappedBy="movie")
	@LazyCollection(LazyCollectionOption.EXTRA)
	public Set<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(Set<Rating> ratings) {
		this.ratings = ratings;
	}
}
