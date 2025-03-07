package com.itheima.mapper;

import com.itheima.pojo.Dept;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DeptMapper {
    @Select("select * from dept;")
    List<Dept> list();

    @Delete("delete from dept where id = #{id}")
    void delete(Integer id);

    @Insert("insert into dept values (null,#{name},now(),now())")
    void add(Dept dept);
}
