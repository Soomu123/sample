package com.cognizant.truyum.dao;
import java.sql.Date;

import java.sql.*;
import java.util.*;

import com.cognizant.truyum.model.MenuItem;

public class MenuItemDaoSqlImpl implements MenuItemDao {
	
	
	public ArrayList<MenuItem> getMenuItemListAdmin()
	{
	    ArrayList<MenuItem> menuItemList = new ArrayList<MenuItem>();
		final String QUERY = "select * from menu_item";
		Connection con = ConnectionHandler.getConnection();
		try 
		{ 
			PreparedStatement stmt = con.prepareStatement(QUERY);
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
			{
				long id = rs.getLong("menu_item_id");
				String name  = rs.getString("menu_name");
				float price = rs.getFloat("menu_price");
				String active = rs.getString("menu_active");
				Date date1 = rs.getDate("menu_dateOfLaunch");
				String category = rs.getString("menu_category");
				String free_delivery = rs.getString("menu_freeDelivery");
				boolean act = false;
				if(active.equalsIgnoreCase("yes"))
				{
					act = true;
				}
				boolean free=false;
				if(free_delivery.equalsIgnoreCase("yes"))
				{
					free = true;
				}
				MenuItem m1 = new MenuItem(id,name,category,price,act,free,date1);
				menuItemList.add(m1);
			}
		} 
		catch (SQLException e)
		{
		
			e.printStackTrace();
		}
		
		return menuItemList ;
		
	}
	public ArrayList<MenuItem> getMenuItemListCustomer()
	{
		ArrayList<MenuItem> menuItemListCust = new ArrayList<MenuItem>();
		Connection con = ConnectionHandler.getConnection();
		final String Query = "select * from menu_item where menu_active='Yes' AND menu_dateOfLaunch < '2018-12-02'";
		try {
			PreparedStatement stmt = con.prepareStatement(Query);
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
			{
				long id = rs.getLong("menu_item_id");
				String name  = rs.getString("menu_name");
				float price = rs.getFloat("menu_price");
				String active = rs.getString("menu_active");
				Date date1 = rs.getDate("menu_dateOfLaunch");
				String category = rs.getString("menu_category");
				String free_delivery = rs.getString("menu_freeDelivery");
				boolean act = false;
				if(active.equalsIgnoreCase("yes"))
				{
					act = true;
				}
				boolean free=false;
				if(free_delivery.equalsIgnoreCase("yes"))
				{
					free = true;
				}
				MenuItem m1 = new MenuItem(id,name,category,price,act,free,date1);
				menuItemListCust.add(m1);
			}
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		return menuItemListCust;
		
	}
	public MenuItem getMenuItem(long menuItemId)
	{
		Connection con = ConnectionHandler.getConnection();
		MenuItem m1 = null;
		final String query = "select * from menu_item"+"where menu_item_id=?";
		try 
		{
			
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setLong(1, menuItemId);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
			{
				long id = rs.getLong("menu_item_id");
				String name  = rs.getString("menu_name");
				float price = rs.getFloat("menu_price");
				String active = rs.getString("menu_active");
				Date date1 = rs.getDate("menu_dateOfLaunch");
				String category = rs.getString("menu_category");
				String free_delivery = rs.getString("menu_freeDelivery");
				boolean act = false;
				if(active.equalsIgnoreCase("yes"))
				{
					act = true;
				}
				boolean free=false;
				if(free_delivery.equalsIgnoreCase("yes"))
				{
					free = true;
				}
				m1 = new MenuItem(id,name,category,price,act,free,date1);
			}
			
			
		} catch (SQLException e) 
		{
		
			e.printStackTrace();
		}
		return m1;
	}
	
	public void modifyMenuItem(MenuItem menuItem) { {
		Connection con = ConnectionHandler.getConnection();
		long id = menuItem.getId();
		String name = menuItem.getName();
		float price = menuItem.getPrice();
		boolean active = menuItem.isActive();
		
		java.sql.Date d =new Date( menuItem.getDateOfLaunch().getTime());
		String category = menuItem.getCategory();
		boolean free = menuItem.isFreeDelivery();
		String act;
		if(active == true)
		{
			act = "Yes";
		}
		else
		{
			act = "No";
		}
		String fd;
		if(free == true)
		{
			fd = "Yes";
		}
		else
		{
			fd = "No";
		}
		final String query = "update menu_item" + "set menu_name = ?,menu_price = ?,menu_active = ?,menu_dateOfLaunch = ?,menu_category = ?,menu_freeDelivery = ?"+"where menu_item_id = ?";
		try 
		{
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, name);
			stmt.setFloat(2, price);
			stmt.setString(3, act);
			stmt.setDate(4, d);
			stmt.setString(5,category);
			stmt.setString(6, fd);
			stmt.setLong(7, id);
			stmt.executeUpdate();
			
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		
	}
	
	}
}


