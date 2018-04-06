package com.lzs.action;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.lzs.service.MovieService;
import com.opensymphony.xwork2.ActionContext;

@Controller
public class MovieAction {
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
	private String classification;
	private int pageNum;
	private int pageSize;
	private int flag;

	@Autowired
	private MovieService movieService;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isUnkown() {
		return unkown;
	}

	public void setUnkown(boolean unkown) {
		this.unkown = unkown;
	}

	public boolean isAction() {
		return action;
	}

	public void setAction(boolean action) {
		this.action = action;
	}

	public boolean isAdventure() {
		return adventure;
	}

	public void setAdventure(boolean adventure) {
		this.adventure = adventure;
	}

	public boolean isAnimation() {
		return animation;
	}

	public void setAnimation(boolean animation) {
		this.animation = animation;
	}

	public boolean isChildren() {
		return children;
	}

	public void setChildren(boolean children) {
		this.children = children;
	}

	public boolean isComedy() {
		return comedy;
	}

	public void setComedy(boolean comedy) {
		this.comedy = comedy;
	}

	public boolean isCrime() {
		return crime;
	}

	public void setCrime(boolean crime) {
		this.crime = crime;
	}

	public boolean isDocumentary() {
		return documentary;
	}

	public void setDocumentary(boolean documentary) {
		this.documentary = documentary;
	}

	public boolean isDrama() {
		return drama;
	}

	public void setDrama(boolean drama) {
		this.drama = drama;
	}

	public boolean isFantasy() {
		return fantasy;
	}

	public void setFantasy(boolean fantasy) {
		this.fantasy = fantasy;
	}

	public boolean isFilmnoir() {
		return filmnoir;
	}

	public void setFilmnoir(boolean filmnoir) {
		this.filmnoir = filmnoir;
	}

	public boolean isHorror() {
		return horror;
	}

	public void setHorror(boolean horror) {
		this.horror = horror;
	}

	public boolean isMusical() {
		return musical;
	}

	public void setMusical(boolean musical) {
		this.musical = musical;
	}

	public boolean isMystery() {
		return mystery;
	}

	public void setMystery(boolean mystery) {
		this.mystery = mystery;
	}

	public boolean isRomance() {
		return romance;
	}

	public void setRomance(boolean romance) {
		this.romance = romance;
	}

	public boolean isScifi() {
		return scifi;
	}

	public void setScifi(boolean scifi) {
		this.scifi = scifi;
	}

	public boolean isThriller() {
		return thriller;
	}

	public void setThriller(boolean thriller) {
		this.thriller = thriller;
	}

	public boolean isWar() {
		return war;
	}

	public void setWar(boolean war) {
		this.war = war;
	}

	public boolean isWestern() {
		return western;
	}

	public void setWestern(boolean western) {
		this.western = western;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public String classification() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		System.out.println(classification);
		System.out.println(pageNum);
		System.out.println(pageSize);
		session.put("flag", flag);
		session.put("movieList", movieService.getMoviesByClassification(classification, pageNum, pageSize));
		session.put("classification", classification);
		session.put("pageNum", pageNum);
		session.put("pageSize", pageSize);
		return "classification";
	}
}
