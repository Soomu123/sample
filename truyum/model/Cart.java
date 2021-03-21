package com.cognizant.truyum.model;

import java.util.ArrayList;

public class Cart {

	private ArrayList<MenuItem> menuItemList;
	private double total;

	public Cart() {

	}

	public Cart(double total, ArrayList<MenuItem> menuItemList) {
		super();
		this.menuItemList = menuItemList;
		this.total = total;
	}

	public ArrayList<MenuItem> getMenuItemList() {
		return menuItemList;
	}

	public void setMenuItemList(ArrayList<MenuItem> menuItemList) {
		this.menuItemList = menuItemList;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

}
