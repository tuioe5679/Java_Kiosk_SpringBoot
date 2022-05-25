package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.example.demo.model.UserProfile;

@Mapper //mapper 어노테이션
public interface UserProfileMapper {
	//id의 정보검색
	@Select("select * from userProfile where id=#{id}")
	UserProfile getUserProfile(@Param("id") String id); //@Param 매개변수를 SQL문에 매핑
	
	//테이블의 모든 정보 검색 
	@Select("select * from userProfile") 
	List<UserProfile> getUserProfileList();
	
	//int 영향을 받은 레코드의 수를 반환 
	
	//정보 입력
	@Insert("insert into userProfile values(#{id}, #{name}, #{phone}, #{address})")
	int insertUserProfile(@Param("id")String id,@Param("name") String name,@Param("phone") String phone,@Param("address") String address);
	
	//정보 수정
	@Update("update userProfile set name=#{name}, phone=#{phone}, address=#{address} where id=#{id}")
	int updateUserProfile(@Param("id")String id,@Param("name") String name,@Param("phone") String phone,@Param("address") String address);
	
	//정보 삭제
	@Delete("delete from userProfile where id=#{id}")
	int deletUserProfile(@Param("id") String id);
}
