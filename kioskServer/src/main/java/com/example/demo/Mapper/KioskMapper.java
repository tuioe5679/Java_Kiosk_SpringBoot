package com.example.demo.Mapper;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import com.example.demo.model.KioskMembers;
import com.example.demo.model.KioskOrders;
import com.example.demo.model.KioskProduct;

@Mapper
public interface KioskMapper {
	//유저정보
	@Select("select * from members where id=#{id} and pwd=#{pwd}")
	KioskMembers getMembers(@Param("id") String id,@Param("pwd") String pwd);
	
	@Insert("insert into members values(#{kioskmembers.id},#{kioskmembers.pwd},#{kioskmembers.name},#{kioskmembers.totalmoney})")
	int postmember(@Param("kioskmembers") KioskMembers kioskmembers);
	
	@Delete("delete from members where id=#{id}")
	int deleteMember(@Param("id") String id);
	
	//상품정보
	@Select("select * from product")
	List<KioskProduct> getProduct();
	
	@Insert("insert into product(id,name,price,image) "
	      + "values(#{kioskproduct.id},#{kioskproduct.name},#{kioskproduct.price},#{kioskproduct.image})")
	int postProduct(@Param("kioskproduct") KioskProduct kioskproduct);
	
	@Delete("delete from product where id=#{id}")
	int deleteProduct(@Param("id") String id);
	
	//주문정보 
	@Select("select * from orders")
	List<KioskOrders> getOrders();

	@Insert("insert into orders(ordernum,name,price,count) "
		  + "values(#{kioskorders.ordernum},#{kioskorders.name},#{kioskorders.price},#{kioskorders.count})")
	int postOrders(@Param("kioskorders") KioskOrders kioskorders);
	
	@Delete("delete from orders where ordernum=#{ordernum}")
	int delectOrders(@Param("ordernum") String ordernum);
}
        