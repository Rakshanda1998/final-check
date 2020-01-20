package com.cognizant.moviecruiser.model;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MovieItem {
	public MovieItem() {
		super();
	}

	private long id;
	private String title;
	private long gross;
	private boolean active;
	private Date dateOfLaunch;
	private String genre;
	private boolean hasTeaser;

	public MovieItem(long id, String title, long gross, boolean active, Date dateOfLaunch, String genre,
			boolean hasTeaser) {
		super();
		this.id = id;
		this.title = title;
		this.gross = gross;
		this.active = active;
		this.dateOfLaunch = dateOfLaunch;
		this.genre = genre;
		this.hasTeaser = hasTeaser;

	}

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

	public long getGross() {
		return gross;
	}

	public void setGross(long f) {
		this.gross = f;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Date getDateOfLaunch() {
		return dateOfLaunch;
	}

	public void setDateOfLaunch(Date dateOfLaunch) {
		this.dateOfLaunch = dateOfLaunch;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public boolean isHasTeaser() {
		return hasTeaser;
	}

	public void setHasTeaser(boolean hasTeaser) {
		this.hasTeaser = hasTeaser;
	}

	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		NumberFormat numFormat = NumberFormat.getInstance();
		numFormat.setGroupingUsed(true);
		
		return String.format("%-20s $%-7s %-5s %-10s %-15s %-5s Edit", title, numFormat.format(gross), active ? "Yes" : "No",
				sdf.format(dateOfLaunch), genre, hasTeaser ? "Yes" : "No");

	}

}
