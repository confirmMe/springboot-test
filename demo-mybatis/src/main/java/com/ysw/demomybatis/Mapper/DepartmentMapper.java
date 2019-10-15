package com.ysw.demomybatis.Mapper;

import com.ysw.demomybatis.Bean.Department;
import org.apache.ibatis.annotations.*;


public interface DepartmentMapper {
    @Select("select * from department where id=#{id}")
    public Department selectById(String id);

    @Delete("delete from department where id =#{id}")
    public int deleteById(String id);

    //    @Options(useGeneratedKeys = true,keyProperty = "id")
    //如果数据表的主键是自增长的，插入新数据时需要返回主键，则需要使用options指定主键字段
    @Insert("insert into department(id,departmentName) values(#{id},#{departmentName})")
    public int insert(Department department);

    @Update("update department set departmentName=#{departmentName} where id =#{id}")
    public int uodate(Department department);
}
