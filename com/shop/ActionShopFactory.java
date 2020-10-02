package com.shop;

import com.commons.*;

public class ActionShopFactory {
	private static ActionShopFactory instance = null;
	private ActionShopFactory() {}
	
	public static ActionShopFactory getInstance() {
		if(instance == null) {
			instance = new ActionShopFactory();
		}
		return instance;
	}
	
	public Action getAction(String cmd) {
		Action action = null;
		if(cmd.equals("shop_list")) {
			action = new ShopListAction();
		}else if(cmd.equals("shop_salelist")) {
			action = new ShopSaleListAction();
		}else if(cmd.equals("shop_bestlist")) {
			action = new ShopBestListAction();
		}else if(cmd.equals("product_view")) {
			action = new productViewAction();
		}
		return action;
	}

}
