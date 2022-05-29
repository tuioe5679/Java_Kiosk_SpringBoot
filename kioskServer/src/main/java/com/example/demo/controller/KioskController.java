package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Mapper.KioskMapper;
import com.example.demo.model.KioskMembers;
import com.example.demo.model.KioskOrders;
import com.example.demo.model.KioskProduct;

//클래스를 컨트롤러로 인식후 인스턴스를 생성 
@RestController 
public class KioskController {
	
	private KioskMapper mapper;
	
	public KioskController(KioskMapper mapper) {
		this.mapper = mapper;
	}
	
	@GetMapping("/member/{id},{pwd}")
	public KioskMembers getmembers(@PathVariable("id") String id, @PathVariable("pwd") String pwd) {
		return mapper.getMembers(id,pwd);
	}
	
	@GetMapping("/product/all")
	public List<KioskProduct> product() {
		return mapper.getProduct();
	}
	
	@GetMapping("/orders/all")
	public List<KioskOrders> Orders() {
		return mapper.getOrders();
	}
	
	@PutMapping("/orders/{ordernum}")
	public void putProduct(@PathVariable("ordernum") String ordernum,@RequestParam("name") String name,@RequestParam("price") String price,@RequestParam("count") String count) {
		mapper.putOrders(ordernum, name, price, count);
	}
	
	@DeleteMapping("/orders/{ordernum}")
	public void deleteOrder(@PathVariable("ordernum") String ordernum) {
		mapper.delectOrders(ordernum);
	}
	
	
}
