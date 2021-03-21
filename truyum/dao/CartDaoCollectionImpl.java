package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImpl implements CartDao {

	private static Map<Long, Cart> userCarts;

	CartDaoCollectionImpl() {
		super();
		if (userCarts == null || userCarts.isEmpty()) {
			userCarts = new HashMap<Long, Cart>();

		}
	}

	@Override
	public void addCartItem(long userId, long menuItemId) {
		try {
			MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
			MenuItem menuItem = menuItemDao.getMenuItem(menuItemId);
			if (userCarts.containsKey(userId)) {
				ArrayList<MenuItem> cartItems = userCarts.get(userId).getMenuItemList();
				cartItems.add(menuItem);

			} else {
				ArrayList<MenuItem> cartMenu = new ArrayList<MenuItem>();
				cartMenu.add(menuItem);
				Cart newCart = new Cart(0, cartMenu);
				userCarts.put(userId, newCart);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public ArrayList<MenuItem> getAllCartItems(long userId) throws CartEmptyException {
		ArrayList <MenuItem> getAll = userCarts.get(userId).getMenuItemList();
		if(getAll.isEmpty())
		{
			throw new CartEmptyException();
			
		}
		else
		{
			float value =0.00f;
			for(MenuItem x : getAll)
			{
				value = value + x.getPrice();
			}
			userCarts.get(userId).setTotal(value);
		}
		return getAll;
		
	}

	@Override
	public void removeCartItem(long userId, long menuItemId) {
		ArrayList <MenuItem> removeList = userCarts.get(userId).getMenuItemList();
		for(MenuItem x: removeList)
		{
			if(x.getId() == menuItemId)
			{
				removeList.remove(removeList.indexOf(x));
				break;
			}
		}
		userCarts.get(userId).setMenuItemList(removeList);
		
	}
	
}


