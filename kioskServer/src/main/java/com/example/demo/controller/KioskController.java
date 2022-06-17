package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping("/members/{id},{pwd}")
	public List<KioskMembers> getmembers(@PathVariable("id") String id, @PathVariable("pwd") String pwd) {
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
	
	@PostMapping("/product/post")
	public int putProduct(@RequestBody KioskProduct kioskproduct) {
		return mapper.postProduct(kioskproduct);
	}
	
	@PostMapping("/orders/post")
	public int putOrders(@RequestBody KioskOrders kioskorders) {
		return mapper.postOrders(kioskorders);
	}
	
	@PostMapping("/members/post")
	public int putmember(@RequestBody KioskMembers kioskmembers) {
		return mapper.postmember(kioskmembers);
	}
	
	@DeleteMapping("/members/delete/{id}")
	public void deleteMember(@PathVariable("id") String id) {
		mapper.deleteMember(id);
	}
	
	@DeleteMapping("/product/delete/{id}")
	public void deleteProduct(@PathVariable("id") String id) {
		mapper.deleteProduct(id);
	}
	
	@DeleteMapping("/orders/delete/{ordernum}")
	public void deleteOrder(@PathVariable("ordernum") String ordernum) {
		mapper.delectOrders(ordernum);
	}
}
