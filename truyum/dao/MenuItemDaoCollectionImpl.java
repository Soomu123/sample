package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.Date;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoCollectionImpl implements MenuItemDao {

	private static ArrayList<MenuItem> menuItemList;

	MenuItemDaoCollectionImpl() {
		super();
		if (menuItemList == null || menuItemList.isEmpty()) {
			menuItemList = new ArrayList<MenuItem>();
			menuItemList.add(new MenuItem((long) 01, "Sandwich", "Main Course", (float) 99.0, true, true,
					DateUtil.convertToDate("15/03/2017")));

			menuItemList.add(new MenuItem((long) 02, "Burger", "Main Course", (float) 129.0, true, false,
					DateUtil.convertToDate("23/12/2017")));

			menuItemList.add(new MenuItem((long) 03, "Pizza", "Main Course", (float) 149.0, true, false,
					DateUtil.convertToDate("21/08/2018")));

			menuItemList.add(new MenuItem((long) 04, "French Fries", "Starters", (float) 57.0, false, true,
					DateUtil.convertToDate("02/07/2017")));

			menuItemList.add(new MenuItem((long) 05, "Chocolate Brownie", "Dessert", (float) 32.0, true, true,
					DateUtil.convertToDate("02/11/2022")));

		}
	}

	@Override
	public ArrayList<MenuItem> getMenuItemListAdmin() {

		return menuItemList;
	}

	@Override
	public ArrayList<MenuItem> getMenuItemListCustomer() {
		
		ArrayList<MenuItem> list = new ArrayList<MenuItem>();
		for(MenuItem x: menuItemList) {
			Date d = x.getDateOfLaunch();
			String today = "19/08/2019";
			Date tdate = DateUtil.convertToDate(today);
			if(d.before(tdate)||d.equals(tdate)) {
				if(x.isActive()) {
					list.add(x);
				}
			}
		}
		return list;
	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		
		for(MenuItem item:menuItemList)
		{
			if(item.equals(menuItem))
			{
				item.setName(menuItem.getName());
				item.setActive(menuItem.isActive());
				item.setCategory(menuItem.getCategory());
				item.setDateOfLaunch(menuItem.getDateOfLaunch());
				item.setCategory(menuItem.getCategory());
				item.setFreeDelivery(menuItem.isFreeDelivery());
				
			}
		}
	}

	@Override
	public MenuItem getMenuItem(long menuItemId) {
		
		for(MenuItem item:menuItemList) {
			if(item.getId() == menuItemId) {
				return item;
			}
		}
		return null;
	}

}
