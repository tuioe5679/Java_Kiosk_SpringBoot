package com.example.demo.Mapper;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.PatchMapping;

import com.example.demo.model.KioskMembers;
import com.example.demo.model.KioskOrders;
import com.example.demo.model.KioskProduct;

@Mapper
public interface KioskMapper {
	//유저정보
	@Select("select * from members where id=#{id} and pwd=#{pwd}")
	KioskMembers getMembers(@Param("id") String id,@Param("pwd") String pwd);
	
	@Insert("insert into members values(#{id},#{pwd},#{name},#{totalmoney})")
	int putmember(@Param("id") String id,@Param("pwd") String pwd,@Param("name") String name,@Param("totalmoney") String totalmoney);
	
	@Delete("delete from members where id=#{id}")
	int deleteMember(@Param("id") String id);
	
	//상품정보
	@Select("select * from product")
	List<KioskProduct> getProduct();
	
	@Insert("insert into product values(#{id},#{name},#{price},#{image})")
	int putProduct(@Param("id") String id,@Param("name") String name,@Param("price") String price,@Param("image") String image);
	
	@Delete("delete from product where id=#{id}")
	int deleteProduct(@Param("ids") String id);
	
	//주문정보 
	@Select("select * from orders")
	List<KioskOrders> getOrders();

	@Insert("insert into orders values(#{ordernum},#{name},#{price},#{count})")
	int putOrders(@Param("ordernum") String ordernum,@Param("name") String name,@Param("price") String price,@Param("count") String count);
	
	@Delete("delete from orders where ordernum=#{ordernum}")
	int delectOrders(@Param("ordernum") String ordernum);
}
        