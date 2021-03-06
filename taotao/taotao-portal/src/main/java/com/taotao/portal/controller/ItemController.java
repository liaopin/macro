package com.taotao.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.portal.pojo.Item;
import com.taotao.portal.service.ItemService;

/**
 * 商品详情页展示
 * 商品详情，商品描述，规格参数
 */
@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/item/{itemId}")
	private String getItemById(@PathVariable Long itemId, Model model) {
		Item item = itemService.getItemById(itemId);
		model.addAttribute("item", item);
		return "item";
	}
	
	@RequestMapping(value="/item/desc/{itemId}", produces=MediaType.TEXT_HTML_VALUE+";charset=utf-8")
	@ResponseBody
	private String getItemDesc(@PathVariable Long itemId) {
		String result = itemService.getItemDesc(itemId);
		return result;
	}
	
	@RequestMapping(value="/item/param/{itemId}", produces=MediaType.TEXT_HTML_VALUE+";charset=utf-8")
	@ResponseBody
	private String getItemParam(@PathVariable Long itemId) {
		String result = itemService.getItemParam(itemId);
		return result;
	}
	
}
