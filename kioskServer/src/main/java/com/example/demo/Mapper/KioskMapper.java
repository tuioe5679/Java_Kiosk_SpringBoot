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
	
	@Select("select * from members where id=#{id} and pwd=#{pwd}")
	KioskMembers getMembers(@Param("id") String id,@Param("pwd") String pwd);
	
	@Select("select * from product")
	List<KioskProduct> getProduct();
	
	@Insert("insert into orders values(#{ordernum},#{name},#{price},#{count})")
	int putOrders(@Param("ordernum") String ordernum,@Param("name") String name,@Param("price") String price,@Param("count") String count);
	
	@Select("select * from orders")
	List<KioskOrders> getOrders();
	
	@Delete("delete from orders where ordernum=#{ordernum}")
	int delectOrders(@Param("ordernum") String ordernum);
}
