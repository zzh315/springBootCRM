package com.itheima.mapper;


import com.itheima.pojo.Emp;
import com.itheima.pojo.User;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
//    @Select("select count(*) from emp;")
//    Long getEmpCount();

//    @Select("select * from emp limit #{startIdx},#{pageSize};")
//    List<Emp> getEmps(Integer startIdx, Integer pageSize);

    //    @Select("select * from emp")
    List<Emp> getEmps(String name, Short gender, LocalDate begin, LocalDate end);


    void deleteEmp(List<Integer> ids);

    @Insert("insert into emp values(null,#{username},default,#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},now(),now())")
    void addEmp(Emp emp);


    @Select("select * from emp where id = #{id}")
    Emp getEmpById(Integer id);


//    @Update("update emp set name=#{name}," +
//            "username =#{username},image=#{image},gender=#{gender},job=#{job}," +
//            "entrydate=#{entrydate},dept_id=dept_id,update_time=now() " +
//            "where id = ${id}")
    void updateEmp(Emp emp);

    @Select("select * from emp where username = #{username} and password = #{password}")
    Emp getByUserNameAndPassword(Emp emp);

    @Delete("delete from emp where dept_id = #{deptId}")
    void deleteByDeptId(Integer deptId);
}
