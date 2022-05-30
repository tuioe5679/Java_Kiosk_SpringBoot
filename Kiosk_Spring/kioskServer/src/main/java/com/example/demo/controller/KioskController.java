package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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
	
	@PutMapping("/product/{id}")
	public void putProduct(@PathVariable("id") String id,@RequestParam("name") String name,@RequestParam("price") String price,@RequestParam("image") String image) {
		mapper.putProduct(id, name, price, image);
	}
	
	@PutMapping("/orders/{ordernum}")
	public void putOrders(@PathVariable("ordernum") String ordernum,@RequestParam("name") String name,@RequestParam("price") String price,@RequestParam("count") String count) {
		mapper.putOrders(ordernum, name, price, count);
	}
	
	@PutMapping("/member/{id}")
	public void putmember(@PathVariable("id") String id,@RequestParam("pwd") String pwd,@RequestParam("name") String name,@RequestParam("totalmoney") String totalmoney) {
		mapper.putmember(id, pwd, name, totalmoney);
	}
	
	@DeleteMapping("/member/{id}")
	public void deleteMember(@PathVariable("id") String id) {
		mapper.deleteMember(id);
	}
	
	@DeleteMapping("/product/{id}")
	public void deleteProduct(@PathVariable("id") String id) {
		mapper.deleteProduct(id);
	}
	
	@DeleteMapping("/orders/{ordernum}")
	public void deleteOrder(@PathVariable("ordernum") String ordernum) {
		mapper.delectOrders(ordernum);
	}
}
